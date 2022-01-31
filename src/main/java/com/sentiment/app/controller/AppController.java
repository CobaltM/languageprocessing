package com.sentiment.app.controller;

import java.util.Collections;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sentiment.app.controller.dto.Response;
import com.sentiment.app.controller.dto.lyrics.trackSearchRequest.TrackSearchRequest;
import com.sentiment.app.service.AppService;
import com.sentiment.app.service.LyricLookup;
import com.sentiment.app.service.TrackLookup;

import lombok.extern.slf4j.Slf4j;

/** @author https://github.com/bipinthite */
@RestController
@RequestMapping("/v1/hello")
@Slf4j
public class AppController {

	private AppService appService;
	private TrackLookup trackLookup;
	private LyricLookup lyricLookup;

	public AppController(AppService appService, TrackLookup trackLookup, LyricLookup lyricLookup) {
		this.appService = appService;
		this.trackLookup = trackLookup;
		this.lyricLookup = lyricLookup;
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Response sayHello() {
		try {
			String message = trackLookup.getSongId("heavenly","cigarettes after sex").toString();
			return Response.builder().data(message).build();
		} catch (Exception e) {
			log.error("Error occurred while calling sayHello()", e);
			Response.Error error = Response.Error.builder().message(e.getMessage()).build();
			return Response.builder().errors(Collections.singletonList(error)).build();
		}
	}
	@RequestMapping(value = "/getSongSentiment", method = RequestMethod.POST)
	public Response getSongSentiment(@RequestBody TrackSearchRequest request) {
		try {
			String message = trackLookup.getSongId(request.getTrackName(),request.getArtistName()).toString();
			return Response.builder().data(message).build();
		} catch (Exception e) {
			log.error("Error occurred while calling sayHello()", e);
			Response.Error error = Response.Error.builder().message(e.getMessage()).build();
			return Response.builder().errors(Collections.singletonList(error)).build();
		}
	}
	
	@RequestMapping(value = "/getLyrics", method = RequestMethod.POST)
	public Response getLyrics(@RequestBody TrackSearchRequest request) {
		try {
			String message = lyricLookup.getSongLyrics(trackLookup.getSongId(request.getTrackName(),request.getArtistName()));
			return Response.builder().data(message).build();
		} catch (Exception e) {
			log.error("Error occurred while calling sayHello()", e);
			Response.Error error = Response.Error.builder().message(e.getMessage()).build();
			return Response.builder().errors(Collections.singletonList(error)).build();
		}
	}
}
