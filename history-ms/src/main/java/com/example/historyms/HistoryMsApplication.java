package com.example.historyms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HistoryMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HistoryMsApplication.class, args);
	}

}
