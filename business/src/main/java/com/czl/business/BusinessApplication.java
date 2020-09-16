package com.czl.business;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@EnableFeignClients
@Configuration
@EnableAutoConfiguration
@ComponentScan ( basePackages = {"com.czl.business"} )
@MapperScan ( "com.czl.business.mapper" )
@EnableDiscoveryClient
public class BusinessApplication {

    public static void main (String[] args) {
        SpringApplication.run(BusinessApplication.class, args);
    }

}
