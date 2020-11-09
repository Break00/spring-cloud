package com.jason.lee.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableEurekaClient
@EnableFeignClients
@EnableHystrix
@SpringBootApplication
public class SpringCloudService01Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudService01Application.class, args);
    }

    @LoadBalanced //使用负载均衡机制 (Ribbon + RestTemplate)
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

}
