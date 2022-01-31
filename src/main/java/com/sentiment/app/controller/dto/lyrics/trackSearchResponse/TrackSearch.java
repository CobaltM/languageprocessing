package com.sentiment.app.controller.dto.lyrics.trackSearchResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TrackSearch {
	@JsonProperty
	public Message message;
}
