package com.sentiment.app.utility;

import org.junit.Test;

public class DataCleaner {
	
	public static void cleanLyrics(String input) {
		
		System.out.println(input.substring(0,input.indexOf("...\n\n*")));
	}
	
	@Test
	public void test() {
		cleanLyrics("");
	}
	
}
