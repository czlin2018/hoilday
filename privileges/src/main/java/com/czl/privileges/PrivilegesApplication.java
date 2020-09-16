package com.czl.privileges;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.czl.privileges.mapper")
public class PrivilegesApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrivilegesApplication.class, args);
	}

}
