package com.hs.holiday;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hs.holiday.request.HolidayRequest;

@SpringBootTest
@AutoConfigureMockMvc
public class HolidayServiceTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired 
	private ObjectMapper objectMapper;
	
	@Test
	void testGetAllHolidays() throws Exception {
		this.mockMvc.perform(get("/holidayservice/get-all-holidays")).andExpect(status().isOk());
	}
	
	@Test
	void testGetHolidayById() throws Exception {
		this.mockMvc.perform(get("/holidayservice/get-holiday-by-id?holidayId=1")).andExpect(status().isOk());
	}
	
	@Test
	void testAddHoliday() throws Exception {
		HolidayRequest holidayRequest = new HolidayRequest();
		holidayRequest.setCountry("US and CANADA");
		holidayRequest.setHoliday("New Year");
		holidayRequest.setDate(LocalDate.now());
		String requestBody = objectMapper.writeValueAsString(holidayRequest);
		this.mockMvc.perform(post("/holidayservice/add-holiday").contentType(MediaType.APPLICATION_JSON).content(requestBody)).andExpect(status().isOk());
	}
	
	@Test
	void testUpdateHoliday() throws Exception {
		HolidayRequest holidayRequest = new HolidayRequest();
		holidayRequest.setCountry("US and CANADA");
		holidayRequest.setHoliday("New Year");
		holidayRequest.setDate(LocalDate.now());
		String requestBody = objectMapper.writeValueAsString(holidayRequest);
		this.mockMvc.perform(put("/holidayservice/update-holiday").contentType(MediaType.APPLICATION_JSON).content(requestBody)).andExpect(status().isOk());
	}
}