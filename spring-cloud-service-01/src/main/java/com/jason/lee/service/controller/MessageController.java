package com.jason.lee.service.controller;

import com.jason.lee.service.api.MessageService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author huanli9
 * @description
 * @date 2020/11/2 13:09
 */
@RestController
public class MessageController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MessageService messageService;

    /**
     * Ribbon + RestTemplate
     * @param name
     * @return
     */
    @GetMapping("/show1")
    public String showMessage1(@RequestParam String name) {
        return restTemplate.getForObject("http://producer/get1?name=" + name, String.class);
    }

    /**
     * Feign
     * @param name
     * @return
     */
    @GetMapping("/show2")
    public String showMessage2(@RequestParam String name) {
        return messageService.getMessage1(name);
    }

    /**
     * 模拟调用服务故障
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "Error")
    @GetMapping("/show3")
    public String showMessage3(@RequestParam String name) {
        return messageService.getMessage2(name);
    }

    private String Error(String name){
        return "Hi " + name + ",ERROR!";
    }

    @GetMapping("/show4")
    public String showMessage4() {
        return messageService.getMessage3();
    }

}
