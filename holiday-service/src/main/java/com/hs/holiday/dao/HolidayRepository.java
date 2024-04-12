package com.hs.holiday.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hs.holiday.entity.HolidayEntity;

/**
 * Holiday Service Repository
 */
@Repository
public interface HolidayRepository extends JpaRepository<HolidayEntity, Integer> {

}
