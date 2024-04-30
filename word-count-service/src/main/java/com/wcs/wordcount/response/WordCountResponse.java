package com.wcs.wordcount.response;

/**
 * Word Count Service Response
 */
public class WordCountResponse {
	
	private String name;
	
	private Long count;

	public WordCountResponse(String name, Long count) {
		super();
		this.name = name;
		this.count = count;
	}

	public String getName() {
		return name;
	}

	public Long getCount() {
		return count;
	}
}
