package com.jky.learn.web;

import com.jky.learn.enums.ErrorCode;
import com.jky.learn.exception.ListValidException;
import com.jky.learn.vo.ResultVo;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Path;
import javax.validation.ValidationException;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//不写basePackages 就全路径扫描
@RestControllerAdvice(basePackages = "com.jky.learn.controller")
public class CtrlAdvice {
    @ExceptionHandler
    public ResultVo exceptionHandler(MethodArgumentNotValidException e) {
        Map<String, String> collect = e.getBindingResult().getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
        return ResultVo.fail(ErrorCode.PARAM_ERROR, collect);
    }

    @ExceptionHandler
    public ResultVo exceptionHandler(ConstraintViolationException e) {
        Map<Path, String> collect = e.getConstraintViolations().stream()
                .collect(Collectors.toMap(ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage));
        return ResultVo.fail(ErrorCode.PARAM_ERROR, collect);
    }
    @ExceptionHandler
    public ResultVo exceptionHandler(ValidationException e) {
        Map<Integer, Map<Path, String>> ansMap = new HashMap<>();
        ((ListValidException)e.getCause()).getErrors().forEach(((integer, constraintViolations) -> {
            ansMap.put(integer, constraintViolations.stream()
                    .collect(Collectors.toMap(ConstraintViolation::getPropertyPath, ConstraintViolation::getMessage)));
        }));
        return ResultVo.fail(ErrorCode.PARAM_ERROR, ansMap);
    }

    @ExceptionHandler
    public ResultVo exceptionHandler(Exception e) {
        return ResultVo.fail(ErrorCode.SYSTEM_ERROR);
    }
}
