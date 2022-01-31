package com.sentiment.app.controller.dto.lyrics.trackSearchResponse;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MusicGenre {
	@JsonProperty
	public int music_genre_id;
	@JsonProperty
	public int music_genre_parent_id;
	@JsonProperty
	public String music_genre_name;
	@JsonProperty
	public String music_genre_name_extended;
	@JsonProperty
	public String music_genre_vanity;
}
