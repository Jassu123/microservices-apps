package com.calldetails;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

@EnableDiscoveryClient
public class CalldetailsMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(CalldetailsMicroApplication.class, args);
	}

}
