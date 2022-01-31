package com.sentiment.app.controller.dto.lyrics.trackSearchResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MusicGenreList {
	@JsonProperty
	public MusicGenre music_genre;
}
