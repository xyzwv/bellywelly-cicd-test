package com.capston.bellywelly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BellywellyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BellywellyApplication.class, args);
	}

}
