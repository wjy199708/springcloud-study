package com.wjy.springcloud.service.impl;

import com.wjy.springcloud.dao.DeptMapper;
import com.wjy.springcloud.entities3.Dept;
import com.wjy.springcloud.entities3.DeptExample;
import com.wjy.springcloud.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper mapper;

    @Override
    public boolean add(Dept dept) {

        return mapper.insert(dept) > 0 ? true : false;
    }

    @Override
    public Dept get(Long id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public List<Dept> list() {
        /**
         * 自定义或者是使用注解@Select去写这个查询全部的接口文件
         */
//        return mapper.findAll();
        /**
         * 或者直接使用example但是不给criteria条件，这时候就会默认的查询所有数据
         */
        DeptExample example = new DeptExample();
        DeptExample.Criteria criteria = example.createCriteria();
        return mapper.selectByExample(example);
    }
}
