package com.jky.learn.controller;

import com.jky.learn.entity.File;
import com.jky.learn.vo.ResultVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@RequestMapping("/file")
public class FileController {

    @PostMapping
    public ResultVo add(@RequestBody @Valid File file){
        //都没有service

        return ResultVo.success();
    }
}
