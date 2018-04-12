package com.libedi.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * API service using FeignClient
 * @author Sangjun, Park
 *
 */
@FeignClient("spring-cloud-eureka-client-02")
public interface CallApi02Service {
	
	@GetMapping("/api02")
	String getMsg();
}
