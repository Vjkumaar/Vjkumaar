package com.hs.holiday.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.hs.holiday.dao.HolidayRepository;
import com.hs.holiday.entity.HolidayEntity;
import com.hs.holiday.request.HolidayRequest;
import com.hs.holiday.response.HolidayResponse;

/**
 * Holiday Service
 */
@Service
public class HolidayService {
	
	private HolidayRepository holidayRepository;
	
	private ModelMapper modelMapper;
	
	HolidayService(HolidayRepository holidayRepository,ModelMapper modelMapper)
	{
		this.holidayRepository = holidayRepository;
		this.modelMapper=modelMapper;
	}

	/**
	 * This will get all the holidays detail
	 */
	public List<HolidayResponse> getAllHolidays() {
		List<HolidayEntity> dbResults = holidayRepository.findAll();
		if (CollectionUtils.isEmpty(dbResults)) {
			return Collections.emptyList();
		}
		List<HolidayResponse> response = new ArrayList<>();
		dbResults.forEach(holiday -> {
			HolidayResponse holidayResponse = new HolidayResponse();
			modelMapper.map(holiday, holidayResponse);
			response.add(holidayResponse);
		});
		return response;
	}

	/**
	 * This will get specific holiday details by id
	 * @param holidayId
	 * @return
	 */
	public HolidayResponse getSpecificHolidayById(int holidayId) {
		Optional<HolidayEntity> dbResult = holidayRepository.findById(holidayId);
		HolidayResponse response = null;
		if(!dbResult.isEmpty())
		{
			response = new HolidayResponse();
			modelMapper.map(dbResult.get(), response);
		}
		return response;
	}

	/**
	 * This will add the new holiday details
	 * @param holidayRequest
	 * @return
	 */
	public HolidayResponse addHoliday(HolidayRequest holidayRequest) {
		HolidayEntity holidayEntity = new HolidayEntity();
		HolidayResponse returnResponse = new HolidayResponse();
		modelMapper.map(holidayRequest, holidayEntity);
		HolidayEntity response =  holidayRepository.save(holidayEntity);
		modelMapper.map(response, returnResponse);
		return returnResponse;
	}

	/**
	 * This will update the existing holiday details
	 * @param holidayRequest
	 * @return
	 */
	public int updateHoliday(HolidayRequest holidayRequest) {
		Optional<HolidayEntity> dbResult = holidayRepository.findById(holidayRequest.getId());
		if(dbResult.isEmpty())
		{
			return 0;
			
		}
		HolidayEntity holidayEntity = dbResult.get();
		modelMapper.map(holidayRequest, holidayEntity);
		holidayRepository.save(holidayEntity);
		return 1;
	}

	public void addDefaultHolidays(List<HolidayRequest> holidayRequest) {
		holidayRequest.stream().forEach(holiday->
		{
			HolidayEntity holidayEntity = new HolidayEntity();
			modelMapper.map(holiday, holidayEntity);
			holidayRepository.save(holidayEntity);
		});
	}

}
