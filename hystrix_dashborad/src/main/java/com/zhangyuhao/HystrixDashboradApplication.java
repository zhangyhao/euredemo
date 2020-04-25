package com.zhangyuhao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@EnableTurbine
@EnableHystrixDashboard
@EnableEurekaClient
@SpringBootApplication
public class HystrixDashboradApplication {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashboradApplication.class,args);
    }
}
