package com.wcs.wordcount.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wcs.wordcount.entity.WordCountEntity;

/**
 * Word Count Repository
 */
@Repository
public interface WordCountRepository extends JpaRepository<WordCountEntity, Integer> {

}
