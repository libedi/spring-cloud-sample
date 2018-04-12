package com.libedi.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApi03Application {
	
	private final Logger logger = LoggerFactory.getLogger(DemoApi03Application.class);

	public static void main(String[] args) {
		SpringApplication.run(DemoApi03Application.class, args);
	}
	
	@GetMapping("/api03")
	public String getMsg() {
		this.logger.info("api03");
		return "test server 03";
	}
	
	@GetMapping("/")
	public String healthCheckPing() {
		this.logger.info("PING1");
		return "ok";
	}
}
