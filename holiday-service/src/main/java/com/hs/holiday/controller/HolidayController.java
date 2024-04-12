package com.hs.holiday.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hs.holiday.request.HolidayRequest;
import com.hs.holiday.response.HolidayResponse;
import com.hs.holiday.service.HolidayService;

/**
 * Holiday Service Controller
 */
@RestController
@RequestMapping("/holidayservice")
public class HolidayController {
	
	private HolidayService holidayService;
	
	/**get-all-holidays
	 * This will add some holidays details to the DB in the initialization
	 * @param holidayService
	 * @throws JsonParseException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	HolidayController(HolidayService holidayService) throws JsonParseException, JsonMappingException, IOException 
	{
		this.holidayService = holidayService;
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		List<HolidayRequest> holidayRequest = Arrays.asList(mapper.readValue(new File("src/main/resources/holidays.json"), HolidayRequest[].class));
		holidayService.addDefaultHolidays(holidayRequest);
	}
	
	/**
	 * This will get all the holidays details
	 * @return
	 */
	@GetMapping("/get-all-holidays")
	public Map<Object,Object> getAllHolidays() {
		Map<Object,Object> response = new HashMap<>();
		try
		{
			List<HolidayResponse> holidayResponse = holidayService.getAllHolidays();
			response.put("status", "Success");
			response.put("statusCode", "200");
			response.put("data", holidayResponse);
		}
		catch(Exception e)
		{
			response.put("status", "Failure");
			response.put("statusCode", "500");
			response.put("message", "Internal Error Occurred...");
			e.printStackTrace();
		}
		return response;
	}
	
	/**
	 * This will get specific holiday details by id
	 * @param holidayId
	 * @return
	 */
	@GetMapping("/get-holiday-by-id")
	public Map<Object,Object> getSpecificHolidayById(@RequestParam int holidayId) {
		Map<Object,Object> response = new HashMap<>();
		try
		{
			HolidayResponse holidayResponse = holidayService.getSpecificHolidayById(holidayId);
			if(holidayResponse == null)
			{
				response.put("status", "Not Found");
				response.put("statusCode", "404");
				response.put("data", Collections.emptyList());
			}
			else
			{
				response.put("status", "Success");
				response.put("statusCode", "200");
				List<HolidayResponse> holidayResponseList = new ArrayList<>();
				holidayResponseList.add(holidayResponse);
				response.put("data", holidayResponseList);
			}
			
		}
		catch(Exception e)
		{
			response.put("status", "Failure");
			response.put("statusCode", "500");
			response.put("message", "Internal Error Occurred...");
			e.printStackTrace();
		}
		return response;
	}
	
	/**
	 * This will add the Holiday details to the DB
	 * @param holidayRequest
	 * @return
	 */
	@PostMapping("/add-holiday")
	public Map<Object,Object> addHoliday(@RequestBody HolidayRequest holidayRequest) {
		Map<Object,Object> response = new HashMap<>();
		try
		{
			HolidayResponse serviceResponse = holidayService.addHoliday(holidayRequest);
			List<HolidayResponse> serviceResponseList = new ArrayList<>();
			serviceResponseList.add(serviceResponse);
			response.put("status", "Success");
			response.put("message", "Holiday Has Been added successfully");
			response.put("data", serviceResponseList);
		}
		catch(Exception e)
		{
			response.put("status", "Failure");
			response.put("statusCode", "500");
			response.put("message", "Internal Error Occurred...");
			e.printStackTrace();
		}
		return response;
	}
	
	/**
	 * This will update the existing holiday Details
	 * @param holidayRequest
	 * @return
	 */
	@PutMapping("/update-holiday")
	public Map<Object,Object> updateHoliday(@RequestBody HolidayRequest holidayRequest) {
		Map<Object,Object> response = new HashMap<>();
		try
		{
		int serviceResponse = holidayService.updateHoliday(holidayRequest);
		if(serviceResponse == 0)
		{
			response.put("status", "Not Found");
			response.put("statusCode", "404");
		}
		else
		{
			response.put("status", "Success");
			response.put("statusCode", "200");
			response.put("message", "Holiday Has Been updated successfully");
		}
		
		}
		catch(Exception e)
		{
			response.put("status", "Failure");
			response.put("message", "Internal Error Occurred...");
			e.printStackTrace();
		}
		return response;
	}

}
