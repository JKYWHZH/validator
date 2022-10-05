package com.jky.learn.controller;

import com.jky.learn.entity.Job;
import com.jky.learn.vo.ResultVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/job")
@Validated
public class JobController {

    @PostMapping
    public ResultVo add(@RequestBody @Valid Job job){
        return ResultVo.success();
    }
}
