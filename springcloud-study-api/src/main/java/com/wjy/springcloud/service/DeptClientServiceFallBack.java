package com.wjy.springcloud.service;

import com.wjy.springcoud.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 使用hystrix进行实现，服务的降级处理
 * 这个步骤将要解决的问题有：
 * 1、解耦合
 * 2、解耦合解的是@HystrixCommand注解绑定的方法的熔断处理，导致的每一个方法的出现的方法膨胀和，过度绑定问题
 *
 * 
 */
@Component //千万不要忘记添加这个注解
public class DeptClientServiceFallBack implements FallbackFactory<DeptClientSercice> {
    @Override
    public DeptClientSercice create(Throwable throwable) {
        return new DeptClientSercice() {
            @Override
            public boolean add(Dept deptEntity) {
                return false;
            }

            @Override
            public Dept findById(Long id) {
                Dept dept = new Dept();
                dept.setDeptNo(00L).setDeptName("微服务出现故障").setDbSource("服务故障数据源读取失败");
                return dept;
            }

            @Override
            public List findAll() {
                return null;
            }
        };
    }
}
