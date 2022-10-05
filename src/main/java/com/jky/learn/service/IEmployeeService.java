package com.jky.learn.service;

import com.jky.learn.entity.Employee;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public interface IEmployeeService {
    void add(@Valid Employee employee);

    @NotNull Employee getById(@NotNull Integer integer);
}

