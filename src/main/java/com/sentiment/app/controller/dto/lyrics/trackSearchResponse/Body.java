package com.sentiment.app.controller.dto.lyrics.trackSearchResponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Body {
	@JsonProperty
	public List<TrackList> track_list;
}
