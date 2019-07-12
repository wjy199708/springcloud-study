package com.wjy.springcloud.service;

import com.wjy.springcloud.entities3.Dept;

import java.util.List;

public interface DeptService {
    boolean add(Dept dept);

    Dept get(Long id);

    List<Dept> list();
}
