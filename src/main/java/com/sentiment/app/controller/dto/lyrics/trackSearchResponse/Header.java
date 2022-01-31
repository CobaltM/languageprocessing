package com.sentiment.app.controller.dto.lyrics.trackSearchResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Header {
	@JsonProperty
	public int status_code;
	@JsonProperty
	public double execute_time;
	@JsonProperty
	public int available;
}
