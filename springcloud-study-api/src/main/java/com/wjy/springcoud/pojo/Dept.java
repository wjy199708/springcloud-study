package com.wjy.springcoud.pojo;

import lombok.Generated;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.lang.annotation.Documented;

@Accessors(chain = true)
@Generated
@Getter
@Setter
public class Dept {
    private Long deptNo;

    private String deptName;

    private String dbSource;


    @Override
    public String toString() {
        return "Dept{" +
                "deptNo=" + deptNo +
                ", deptName='" + deptName + '\'' +
                ", dbSource='" + dbSource + '\'' +
                '}';
    }
}