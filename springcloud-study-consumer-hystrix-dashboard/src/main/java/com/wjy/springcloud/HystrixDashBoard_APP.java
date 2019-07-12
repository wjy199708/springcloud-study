package com.wjy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashBoard_APP {
    public static void main(String[] args) {
        SpringApplication.run(HystrixDashBoard_APP.class, args);
    }
}
