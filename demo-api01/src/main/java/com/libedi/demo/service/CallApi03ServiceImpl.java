package com.libedi.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.libedi.demo.Api03Configuration;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

/**
 * API Service using RibbonClient
 * @author Sangjun, Park
 *
 */
@RibbonClient(name = "spring-cloud-eureka-client-03", configuration = Api03Configuration.class)	// Test using LoadBalanced RestTemplate
@Service
public class CallApi03ServiceImpl {
	
	/**
	 * Load Balanced RestTemplate
	 */
	private final RestTemplate restTemplate;
	
	@Autowired
	public CallApi03ServiceImpl(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@HystrixCommand(fallbackMethod = "fallBack")
	public String getMsg() {
		return this.restTemplate.getForObject("http://spring-cloud-eureka-client-03/api03", String.class);
	}
	
	public String fallBack() {
		return "error occur.. this is fallback message.";
	}
}
