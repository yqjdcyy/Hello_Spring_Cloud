package com.yao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Creator: Yao
 * Date:    2018/9/28
 * For:
 * Other:
 */
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableTurbine
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
