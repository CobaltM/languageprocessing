package com.sentiment.app.controller.dto.lyrics.trackLyricsResponse;

import java.util.Date;

import lombok.Data;

@Data
public class Lyrics {
	public int lyrics_id;
    public int explicit;
    public String lyrics_body;
    public String script_tracking_url;
    public String pixel_tracking_url;
    public String lyrics_copyright;
    public Date updated_time;
}
