package com.wjy.springcloud.controller;

import com.wjy.springcloud.entities3.Dept;
import com.wjy.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //只返回json串形式的controller
public class DeptContorller {

    @Autowired(required = true)
    private DeptService service;
    //cloud的服务发现策略
    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping(value = "/dept/add", method = RequestMethod.GET)
    public boolean add(@RequestBody Dept dept) {
        return service.add(dept);
    }

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept get(@PathVariable("id") Long id) {
        return service.get(id);
    }

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List<Dept> lists() {
        return service.list();
    }

    @RequestMapping("/dept/descovery")
    public Object findServices() {
        List<ServiceInstance> instances = discoveryClient.getInstances("springcloud-study");
        for (ServiceInstance s :
                instances) {
            System.out.printf(s.getHost() + "==" + s.getServiceId());
        }
        return this.discoveryClient;
    }
}
