package com.jason.lee.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringCloudService02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudService02Application.class, args);
    }

}
