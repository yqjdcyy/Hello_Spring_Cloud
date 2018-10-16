package com.yao.config.controller;

/**
 * Creator: Yao
 * Date:    2018/10/16
 * For:
 * Other:
 */

import com.yao.eureka.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RefreshScope
@RequestMapping("/config")
public class ConfigController {

    @Value("${config.hello:undefined}")
    private String hello;

    @Autowired
    FeignService feignService;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String hello() {
        return String.format("SNS.Hello= %s\nPortal.Hello=%s", hello, feignService.config());
    }
}
