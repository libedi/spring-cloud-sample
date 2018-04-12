package com.libedi.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaClient
@RestController
public class DemoApi02Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoApi02Application.class, args);
	}
	
	@GetMapping("/api02")
	public String getMsg() {
		return "test server 02";
	}
	
}
