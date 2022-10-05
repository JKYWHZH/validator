package com.jky.learn.controller;

import com.jky.learn.entity.Department;
import com.jky.learn.service.DepartmentService;
import com.jky.learn.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@Validated   //对本类中的方法开启功能
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    /**
     * http://127.0.0.1:8080/department
     * 添加部门
     * @param department 部门信息
     * @return 结果
     */
    @PostMapping
    public ResultVo add(@RequestBody /*@Valid*//*校验后面数据*/Department department){
        /**
         * id         必须是 null;
         * parent_id  不能为null，必须大于0；
         * name       不能为空，长度大于0；
         * createTime 不是未来时间
         */
        departmentService.add(department);
        return ResultVo.success();
    }

}
