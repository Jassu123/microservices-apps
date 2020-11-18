package com.friend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication

@EnableDiscoveryClient
public class FriendMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(FriendMicroApplication.class, args);
	}

}
