package com.yao.eureka.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yao.eureka.service.FeignService;
import org.apache.tomcat.jni.Time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

/**
 * Creator: Yao
 * Date:    2018/9/30
 * For:
 * Other:
 */
@RestController
@RequestMapping("/eureka")
public class EurekaController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/robbin/{application}/{method}", method = RequestMethod.GET)
    public String robbin(@PathVariable String application, @PathVariable String method) {
        return restTemplate.getForObject(String.format("http://%s/%s", application.toUpperCase(), method), String.class);
    }


    @Autowired
    FeignService feignService;

    @RequestMapping(value = "/feign/{method}", method = RequestMethod.GET)
    public String feign(@PathVariable String method) {
        return feignService.config();
    }


    @RequestMapping(value = "/hystrix/{method}", method = RequestMethod.GET)
    @HystrixCommand(
            fallbackMethod = "fallback",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")})
    public String hystrix(
            @RequestParam Boolean error,
            @RequestParam Integer duration) {

        Assert.isTrue(null != error && !error, "Hystrix.Error");
        if(null!= duration && duration> 0){
            Time.sleep(duration);
        }

        return feignService.config();
    }

    public String fallback(Boolean error, Integer duration) {
        return "Hystrix.Fallback";
    }
}