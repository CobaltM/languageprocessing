package com.sentiment.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class SentimentConfiguration {

	@Value("${api.lyrics-path}")
	String lyricsPath;
	@Bean
	public WebClient lyricsClient() {
		return WebClient
				.create(lyricsPath);
	}
	@Bean
	public ObjectMapper objectMapper() {
		return new ObjectMapper();
	}
}
