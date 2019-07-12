package com.wjy.springcloud.dept80.controller;

import com.wjy.api.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URL;
import java.util.List;

@RestController
public class DeptController_Consumer {
    //    @Value("${REST_BASE_URL}")
//    private static final String REST_BASE_URL = "http://localhost:8001";


    /**
     * 下面的地址才是真正的使用到微服务的访问地址，通过在eureka服务注册中心注册的服务的名称进行项目的访问，才能达到使用
     * ribbon进行负载均衡的设置
     */
    private static final String REST_BASE_URL = "http://springcloud-study-dept";
    @Autowired
    private RestTemplate restTemplate;   //RestTemplate时springdata设计的一种提供的进行http请求的模板操作类

    @GetMapping("/get/{id}")
    public Dept getDept(@PathVariable("id") String id) {
        Dept dept = restTemplate.getForObject(REST_BASE_URL + "/dept/get/" + id, Dept.class);
        return dept;
    }

    @RequestMapping("/list")
    public List<Dept> lists() {
        return restTemplate.getForObject(REST_BASE_URL + "/dept/list", List.class);
    }
}
