package com.sentiment.app.service;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sentiment.app.controller.dto.lyrics.trackLyricsResponse.Body;
import com.sentiment.app.controller.dto.lyrics.trackLyricsResponse.Lyrics;
import com.sentiment.app.controller.dto.lyrics.trackLyricsResponse.LyricsResponse;
import com.sentiment.app.controller.dto.lyrics.trackLyricsResponse.Message;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class LyricLookup {
	private WebClient lyricsClient;
	private ObjectMapper objectMapper;
	private static final String trackLyricUri = "track.lyrics.get";
	private String apikey = System.getenv("apikey");

	public LyricLookup(WebClient lyricsClient, ObjectMapper objectMapper) {
		this.lyricsClient = lyricsClient;
		this.objectMapper = objectMapper;
	}

	public String getSongLyrics(Integer songId) {
		Mono<String> plaintextResponse = lyricsClient.get()
				.uri(uriBuilder -> uriBuilder.path(trackLyricUri)
						.queryParam("apikey", apikey)
						.queryParam("track_id", songId)
						.build())
				.accept(MediaType.TEXT_PLAIN).retrieve()

				.bodyToMono(String.class);
		// Api is sending json as plaintext, confusing the audience!

		return plaintextResponse.map(ret -> {
			try {
				LyricsResponse object = objectMapper.readValue(ret, LyricsResponse.class);
				return object;
			} catch (IOException e) {
				log.error("IO Exception!",e);
			}
			return null;
		})
				.map(LyricsResponse::getMessage)
				.map(Message::getBody)
				.map(Body::getLyrics)
				.map(Lyrics::getLyrics_body)
				.block();
	}
}
