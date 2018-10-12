package com.yao.eureka.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Creator: Yao
 * Date:    2018/10/2
 * For:
 * Other:
 */
@FeignClient("portal")
public interface FeignService {

    @RequestMapping("/config")
    String config();
}
