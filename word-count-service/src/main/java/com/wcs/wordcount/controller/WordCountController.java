package com.wcs.wordcount.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wcs.wordcount.response.WordCountResponse;
import com.wcs.wordcount.service.WordCountService;

/**
 * Word Count Service Controller
 */
@RestController
@RequestMapping("/wordcountservice")
public class WordCountController {

	Logger log = LoggerFactory.getLogger(WordCountController.class);

	private WordCountService wordCountService;

	public WordCountController(WordCountService wordCountService) {
		this.wordCountService = wordCountService;
	}

	/**
	 * This service will return the words count from the given input file
	 */
	@GetMapping("/get-word-count")
	public ResponseEntity<Object> getAllWordsCount() {
		Map<Object, Object> response = new HashMap<>();
		try {
			List<WordCountResponse> wordCountResponse = wordCountService.getAllWordsCount();
			response.put("status", "Success");
			response.put("statusCode", "200");
			response.put("data", wordCountResponse);
			return ResponseEntity.status(HttpStatusCode.valueOf(200)).body(response);
		} catch (Exception e) {
			response.put("status", "Failure");
			response.put("statusCode", "500");
			response.put("message", "Internal Error Occurred...");
			log.error("Exception occurred while getting Words Count.. :: {}", e.getMessage());
			return ResponseEntity.status(HttpStatusCode.valueOf(500)).body(response);
		}
	}
}