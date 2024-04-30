package com.wcs.wordcount.service;

/**
 * Word Count Service
 */
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import com.wcs.wordcount.dao.WordCountRepository;
import com.wcs.wordcount.entity.WordCountEntity;
import com.wcs.wordcount.response.WordCountResponse;

@Service
public class WordCountService {

	private WordCountRepository wordcountRepository;

	public WordCountService(WordCountRepository wordcountRepository) {
		this.wordcountRepository = wordcountRepository;
	}

	/**
	 * This service will return the words count from the given input file
	 */
	public List<WordCountResponse> getAllWordsCount() throws IOException {
		List<String> wordsList = Arrays.asList(
				FileUtils.readFileToString(new File("src/main/resources/Datafile.txt"), Charset.defaultCharset())
						.replaceAll("\r\n", "").split(" "));
		Map<String, Long> mapVal = wordsList.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		List<WordCountEntity> wordCountEntityList = mapVal.entrySet().stream()
				.map(e -> new WordCountEntity("Datafile.txt", e.getKey(), e.getValue())).collect(Collectors.toList());
		wordcountRepository.saveAll(wordCountEntityList);
		return mapVal.entrySet().stream().map(e -> new WordCountResponse(e.getKey(), e.getValue()))
				.collect(Collectors.toList());
	}

}