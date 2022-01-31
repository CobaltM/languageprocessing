package com.sentiment.app.utility;

public class DataCleaner {
	
	public static String cleanLyrics(String input) {
		
		return (input.substring(0,input.indexOf("...\n\n*")));
	}
	
	
}
