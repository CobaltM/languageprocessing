package com.sentiment.app.service;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sentiment.app.controller.dto.lyrics.trackSearchResponse.Body;
import com.sentiment.app.controller.dto.lyrics.trackSearchResponse.Message;
import com.sentiment.app.controller.dto.lyrics.trackSearchResponse.Track;
import com.sentiment.app.controller.dto.lyrics.trackSearchResponse.TrackList;
import com.sentiment.app.controller.dto.lyrics.trackSearchResponse.TrackSearch;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/** @author https://github.com/bipinthite */
@Service
@Slf4j
public class TrackLookup {

	private WebClient lyricsClient;
	private ObjectMapper objectMapper;
	private static final String trackSearchUri = "track.search";
	private String apikey = System.getenv("apikey");

	public TrackLookup(WebClient lyricsClient, ObjectMapper objectMapper) {
		this.lyricsClient = lyricsClient;
		this.objectMapper = objectMapper;
	}

	public Integer getSongId(String songName, String artistName) {
		log.info("Starting NON-BLOCKING Controller!");

		Mono<String> plaintextResponse = lyricsClient.get()
				.uri(uriBuilder -> uriBuilder.path(trackSearchUri)
						.queryParam("apikey", apikey)
						.queryParam("q_track", songName)
						.queryParam("q_artist", artistName)
						.build())
				.accept(MediaType.TEXT_PLAIN).retrieve()

				.bodyToMono(String.class);
		// Api is sending json as plaintext, confusing the audience!

		return plaintextResponse.map(ret -> {
			try {
				TrackSearch object = objectMapper.readValue(ret, TrackSearch.class);
				return object;
			} catch (IOException e) {
				log.error("IO Exception!",e);
			}
			return null;
		})

				.map(TrackSearch::getMessage)
				.map(Message::getBody)
				.flatMapIterable(Body::getTrack_list)
				.map(TrackList::getTrack)
				.map(Track::getTrack_id)
				.blockFirst();
	}
}