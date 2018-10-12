package com.yao.eureka.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.yao.eureka.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeoutException;

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
    FeignService feignService;

    @RequestMapping(value = "/hystrix/{method}", method = RequestMethod.GET)
    @HystrixCommand(
            fallbackMethod = "fallback",
            commandProperties = {
                    @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")})
    public String hystrix(
            @RequestParam Boolean error,
            @RequestParam Integer duration) throws TimeoutException {

        Assert.isTrue(null != error && !error, "Hystrix.Error");
        if (null != duration && duration > 0) {
            throw new TimeoutException(String.format("Timeout for %d ms", duration.toString()));
        }

        return feignService.config();
    }

    public String fallback(Boolean error, Integer duration) {
        return "Hystrix.Fallback";
    }
}