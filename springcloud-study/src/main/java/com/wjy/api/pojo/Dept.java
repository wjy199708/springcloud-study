package com.wjy.api.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/*微服务下数据需要走向网络，因此对于类的传输，必须实现序列化接口*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Accessors(chain = true)
public class Dept implements Serializable {

    private Long deptno;
    private String dname;
    private String db_source;


    public static void main(String[] args) {
        Dept dept = new Dept();
        dept.setDeptno(11L).setDname("RD").setDb_source("db01");
    }
}
