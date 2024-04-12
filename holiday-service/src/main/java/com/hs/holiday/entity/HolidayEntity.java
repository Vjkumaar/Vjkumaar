package com.hs.holiday.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Holiday Service Entity
 */
@Entity
@Table(name = "holiday")
public class HolidayEntity {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private int id;
	
	@Column(name = "holiday", length = 100, nullable = false)
	private String holiday;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "date", nullable = false)
	private LocalDate date;
	
	@Column(name = "country", length = 20, nullable = false)
	private String country;

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the holiday
	 */
	public String getHoliday() {
		return holiday;
	}

	/**
	 * @param holiday the holiday to set
	 */
	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	
}
