package com.sentiment.app.controller.dto.lyrics.trackSearchResponse;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class PrimaryGenres {
	@JsonProperty
	public List<MusicGenreList> music_genre_list;
}
