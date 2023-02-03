package com.com.thai.dang.configure;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigureSpringAll {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
