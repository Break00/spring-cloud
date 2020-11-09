package com.jason.lee.service.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author huanli9
 * @description
 * @date 2020/11/2 14:10
 */
@FeignClient("producer")
public interface MessageService {

    @RequestMapping("/get1")
    String getMessage1(@RequestParam("name")String name);

    @RequestMapping("/get2")
    String getMessage2(@RequestParam("name")String name);

    @RequestMapping("/get3")
    String getMessage3();
}

