package com.guo.bean;

import org.springframework.web.servlet.DispatcherServlet;

/**
 * @author guo
 * @create 2019-05-21 20:45
 */
public class Department {
    private Integer id;
    private String departmentName;
//    DispatcherServlet
    public void setId(Integer id) {
        this.id = id;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }
}
