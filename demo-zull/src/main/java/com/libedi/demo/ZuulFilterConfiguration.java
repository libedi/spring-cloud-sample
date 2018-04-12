package com.libedi.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.libedi.demo.filter.SimpleErrorFilter;
import com.libedi.demo.filter.SimplePostFilter;
import com.libedi.demo.filter.SimplePreFilter;

@Configuration
public class ZuulFilterConfiguration {

	@Bean
	public SimplePreFilter simplePreFilter() {
		return new SimplePreFilter();
	}
	
	@Bean
	public SimplePostFilter simplePostFilter() {
		return new SimplePostFilter();
	}
	
	@Bean
	public SimpleErrorFilter simpleErrorFilter() {
		return new SimpleErrorFilter();
	}
}
