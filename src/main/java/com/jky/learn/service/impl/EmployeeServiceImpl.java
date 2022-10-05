package com.jky.learn.service.impl;

import com.jky.learn.entity.Employee;
import com.jky.learn.service.IEmployeeService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotNull;

@Service
@Validated //建议不要写在接口上
public class EmployeeServiceImpl implements IEmployeeService {
    @Override
    public void add(Employee employee) {
        //业务逻辑
        System.out.println("员工添加成功");
    }

    @Override
    public Employee getById(Integer integer) {
        return null;
    }
}
