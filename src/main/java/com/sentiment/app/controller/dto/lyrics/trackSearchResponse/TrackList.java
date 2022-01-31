package com.sentiment.app.controller.dto.lyrics.trackSearchResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TrackList {
	@JsonProperty
	public Track track;
}
