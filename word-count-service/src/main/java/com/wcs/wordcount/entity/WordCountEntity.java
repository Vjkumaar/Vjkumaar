package com.wcs.wordcount.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Word Count Service Entity
 */
@Entity
@Table(name = "wordcount")
public class WordCountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private int id;

	@Column(name = "fileName", length = 100, nullable = false)
	private String fileName;

	@Column(name = "name", length = 100, nullable = false)
	private String name;

	@Column(name = "count", nullable = false)
	private Long count;

	public WordCountEntity(String fileName, String name, Long count) {
		this.fileName = fileName;
		this.name = name;
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

}