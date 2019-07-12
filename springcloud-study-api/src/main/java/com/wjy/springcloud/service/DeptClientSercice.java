package com.wjy.springcloud.service;

import com.wjy.springcoud.pojo.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * feign是面向接口的编码的一个实现负载均衡的客户端程序
 * <p>
 * fallBackFactory是hystrix的服务熔断处理，在加上针对于feign客户端负载均衡，从而实现更好的服务熔断处理和服务降级
 */
@FeignClient(value = "SPRINGCLOUD-STUDY-DEPT", fallbackFactory = DeptClientServiceFallBack.class)
public interface DeptClientSercice {
    @RequestMapping(value = "/dept/add", method = RequestMethod.GET)
    public boolean add(Dept deptEntity);

    @RequestMapping(value = "/dept/get/{id}", method = RequestMethod.GET)
    public Dept findById(Long id);

    @RequestMapping(value = "/dept/list", method = RequestMethod.GET)
    public List findAll();

    ;
}
