package com.hs.holiday.request;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * Holiday Service Request
 */
public class HolidayRequest {
	
	private int id;
	
	private String holiday;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate date;
	
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
