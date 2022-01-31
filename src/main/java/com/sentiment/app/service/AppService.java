package com.sentiment.app.service;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/** @author https://github.com/bipinthite */
@Service
@Slf4j
public class AppService {
	@Value("${api.python-script-path}")
	String scriptPath;
	

	public String sayHello() {
		log.trace("Enter: sayHello()");

		return getStringFromPython();
	}

	private String getStringFromPython() {
		ProcessBuilder processBuilder =
				new ProcessBuilder("python", scriptPath);
		processBuilder.redirectErrorStream(true);

		Process process;
		try {
			process = processBuilder.start();
			return new String(
					process
						.getInputStream()
							.readAllBytes(), StandardCharsets.UTF_8);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}
}
