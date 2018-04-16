package com.libedi.demo.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import com.libedi.demo.service.CallApi02Service.CallApi02ServiceFallback;
import com.libedi.demo.service.CallApi02Service.CallApi02ServiceFallbackFactory;

import feign.hystrix.FallbackFactory;

/**
 * API service using FeignClient
 * @author Sangjun, Park
 *
 */
@FeignClient(
		name = "spring-cloud-eureka-client-02"
		, fallback = CallApi02ServiceFallback.class
//		, fallbackFactory = CallApi02ServiceFallbackFactory.class
		)
public interface CallApi02Service {
	
	@GetMapping("/api02")
	String getMsg();
	
	/**
	 * Fallback Class
	 * @author Sangjun, Park
	 *
	 */
	static class CallApi02ServiceFallback implements CallApi02Service {

		@Override
		public String getMsg() {
			return "this is a fallback class.";
		}
		
	}
	
	/**
	 * Fallback Factory Class : 원인을 확인할 경우,
	 * @author Sangjun, Park
	 *
	 */
	@Component
	static class CallApi02ServiceFallbackFactory implements FallbackFactory<CallApi02Service> {

		@Override
		public CallApi02Service create(Throwable cause) {
			return new CallApi02Service() {
				@Override
				public String getMsg() {
					return "this is a fallback factory class.";
				}
				
			};
		}
		
	}
}
