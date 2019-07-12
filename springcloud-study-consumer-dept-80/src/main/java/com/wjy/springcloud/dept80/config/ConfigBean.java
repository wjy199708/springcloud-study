package com.wjy.springcloud.dept80.config;

import com.netflix.loadbalancer.*;
import com.wjy.MyRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration   //这个注解一表述就是表明这个类是一个springboot版的applicationContext.xml配置文件
public class ConfigBean {  //这个配置类就是之前在没有运用springboot进行注解开发时的applicationContext.xml配置文件
    @Bean
    @LoadBalanced    //使用ribbon的负载均衡客户端注解，进行负载均衡，这个LoadBalanced注解标注在什么地方，该处就会默认的调用ribbon 的负载均衡相关的算法
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    //    @Bean   //使用重写IRule进行对ribbon的负载均衡相关的算法的使用，当然系统有已经写好了的负载均衡的算法
//    public IRule myRule() {
//        return new RandomRule();
//    }

    /**
     * 下面使用spring的注解配置类
     *
     * @Bean是自定义的方法的IRule算法
     */
    @Bean
    public IRule myRule() {
//        return new MyRule();
//        return new RandomRule();  //随机通过eureka服务注册中的，注册服务进行调用
        return new RoundRobinRule();  //轮询调用
    }

}
