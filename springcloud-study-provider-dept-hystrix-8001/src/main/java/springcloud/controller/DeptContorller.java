package springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import springcloud.entities3.Dept;
import springcloud.service.DeptService;

import java.util.List;

@RestController  //只返回json串形式的controller
public class DeptContorller {
    @Autowired
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
    @HystrixCommand(fallbackMethod = "hystrix_List")
    public List<Dept> lists() {
        return service.list();
    }

    public Dept hystrix_List() {
        return new Dept(9999L, "nullnull", "null+NUll+未曾查询到，" +
                "此处可能是报错了，进行了熔断处理，防止系统的负载过高！");
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
