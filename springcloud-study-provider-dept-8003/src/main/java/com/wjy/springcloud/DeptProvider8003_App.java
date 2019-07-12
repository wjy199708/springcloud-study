package com.wjy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient   //配置可以使用eureka进行微服务的服务项目构建注解，这个注解会根据yml配置文件进行解析，
                        // 自动寻找到配置的eureka的微服务的服务注册地址进行注册等相关操作
@EnableDiscoveryClient  //注入可实现自动实现服务发现的注解
public class DeptProvider8003_App {
    public static void main(String[] args) {
        SpringApplication.run(DeptProvider8003_App.class, args);
    }
}
