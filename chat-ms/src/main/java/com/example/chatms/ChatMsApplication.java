package com.example.chatms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ChatMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatMsApplication.class, args);
	}

}
