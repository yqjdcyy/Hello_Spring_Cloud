package com.yao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin2.server.internal.EnableZipkinServer;

/**
 * Creator: Yao
 * Date:    2018/9/28
 * For:
 * Other:
 */
@EnableEurekaClient
@SpringBootApplication
@EnableZipkinServer
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}