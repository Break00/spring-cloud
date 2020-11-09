package com.jason.lee.service.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huanli9
 * @description
 * @date 2020/11/2 12:59
 */
@RestController
public class MessageController {

    @Value("${server.port}")
    String port;

    @Value("${config.name}")
    String config;

    @GetMapping("/get1")
    public String getMessage1(@RequestParam("name")String name){
        return "Hi " + name + " ,I am from port:" + port;
    }

    @GetMapping("/get2")
    public String getMessage2(@RequestParam("name")String name){
        try {
            //模拟服务故障
            Thread.sleep(6000);
        } catch (InterruptedException e) {}
        return "Hi " + name + " ,I am from port:" + port;
    }

    @GetMapping("/get3")
    public String getMessage3(){
        return "config from git:  " + config;
    }

}
