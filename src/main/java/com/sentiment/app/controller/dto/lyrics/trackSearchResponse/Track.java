package com.sentiment.app.controller.dto.lyrics.trackSearchResponse;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class Track {
	@JsonProperty
	public int track_id;
	@JsonProperty
	public String track_name;
	@JsonProperty
	public List<Object> track_name_translation_list;
	@JsonProperty
	public int track_rating;
	@JsonProperty
	public int commontrack_id;
	@JsonProperty
	public int instrumental;
	@JsonProperty
	public int explicit;
	@JsonProperty
	public int has_lyrics;
	@JsonProperty
	public int has_subtitles;
	@JsonProperty
	public int has_richsync;
	@JsonProperty
	public int num_favourite;
	@JsonProperty
	public int album_id;
	@JsonProperty
	public String album_name;
	@JsonProperty
	public int artist_id;
	@JsonProperty
	public String artist_name;
	@JsonProperty
	public String track_share_url;
	@JsonProperty
	public String track_edit_url;
	@JsonProperty
	public int restricted;
	@JsonProperty
	public Date updated_time;
	@JsonProperty
	public PrimaryGenres primary_genres;
}
