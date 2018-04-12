package com.libedi.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.libedi.demo.service.CallApi02Service;
import com.libedi.demo.service.CallApi03ServiceImpl;

/**
 * REST API Server demo 01
 * @author Sangjun, Park
 *
 */
@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker	// Test Hystrix
@EnableFeignClients	// Test using spring-cloud-feign
//@RibbonClient(name = "spring-cloud-eureka-client-03", configuration = Api03Configuration.class)	// Test using LoadBalanced RestTemplate
@RestController
public class DemoApi01Application {

	public static void main(String[] args) {
		SpringApplication.run(DemoApi01Application.class, args);
	}
	
	@GetMapping("/api01")
	public String getMsg() {
		return "test server 01";
	}
	
	/**
	 * Test to get Service Instance by Application Name
	 */
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping("/service-instances/{applicationName}")
	public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
		return this.discoveryClient.getInstances(applicationName);
	}
	
	/**
	 * Test using spring-cloud-feign
	 */
	@Autowired
	private CallApi02Service callApi02Service;
	
	@GetMapping("/api02")
	public String getMsg02() {
		return this.callApi02Service.getMsg();
	}
	
	/**
	 * Test using LoadBalanced RestTemplate
	 * @return
	 */
	@LoadBalanced
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	@Autowired
	private CallApi03ServiceImpl callApi03Service;
	
	
	@GetMapping("/api03")
	public String getMsg03() {
		return this.callApi03Service.getMsg();
//		return this.restTemplate().getForObject("http://spring-cloud-eureka-client-03/api03", String.class);
	}
}
