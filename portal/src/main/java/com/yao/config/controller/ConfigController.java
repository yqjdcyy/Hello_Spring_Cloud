package com.yao.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Creator: Yao
 * Date:    2018/9/28
 * For:
 * Other:
 */
@RestController
@RequestMapping("/config")
@RefreshScope
public class ConfigController {

    @Value("${config.hello:undefined}")
    private String hello;

    @RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
    public String hello() {
        return hello;
    }
}