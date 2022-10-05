package com.jky.learn.controller;

import com.jky.learn.entity.Employee;
import com.jky.learn.service.impl.EmployeeServiceImpl;
import com.jky.learn.validation.ValidList;
import com.jky.learn.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.groups.Default;
import java.util.List;

@RestController
@Validated   //对本类中的方法开启功能
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping
    public ResultVo add(@RequestBody @Validated({Employee.Add.class, Default.class}) Employee employee){
        //employeeService.add(employee);
        return ResultVo.success();
    }

    @PostMapping("/list")
    public ResultVo addList(@RequestBody @ValidList(groupings = {Employee.Add.class, Default.class}, quickFail = true)
                                        List<Employee> employee){
        //employeeService.add(employee);
        return ResultVo.success();
    }

    @PutMapping
    public ResultVo update(@RequestBody @Valid Employee employee){
        return ResultVo.success();
    }

    @GetMapping
    public ResultVo get(@RequestBody Integer id){
        employeeService.getById(id);
        return ResultVo.success();
    }
}
