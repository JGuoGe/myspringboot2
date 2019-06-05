package com.guo.mapper;

import com.guo.bean.Employee;

/**
 * 演示
 * @author guo
 * @create 2019-05-21 20:48
 */
//@Mapper或者@MapperScan将接口扫描装配到容器中
public interface EmployeeMapper {
    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
