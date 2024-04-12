package com.hs.holiday.configuration;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Holiday Service Configuration
 */
@Configuration
public class HolidayConfiguration {
	
	@Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
