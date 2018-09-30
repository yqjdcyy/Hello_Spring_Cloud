package com.yao.eureka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping(value = "/{application}/{method}", method = RequestMethod.GET)
    public String invoke(@PathVariable String application, @PathVariable String method) {
        return restTemplate.getForObject(String.format("http://%s/%s", application.toUpperCase(), method), String.class);
    }
}
