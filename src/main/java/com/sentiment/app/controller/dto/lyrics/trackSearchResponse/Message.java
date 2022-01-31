package com.sentiment.app.controller.dto.lyrics.trackSearchResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Message {
	@JsonProperty
	public Header header;
	@JsonProperty
	public Body body;
}
