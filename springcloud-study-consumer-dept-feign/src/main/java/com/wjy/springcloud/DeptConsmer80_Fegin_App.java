package com.wjy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.wjy.springcloud"})
@ComponentScan("com.wjy.springcloud")
public class DeptConsmer80_Fegin_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptConsmer80_Fegin_App.class, args);
    }
}
