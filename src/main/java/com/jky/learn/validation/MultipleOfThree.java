package com.jky.learn.validation;

import com.jky.learn.validation.validator.MultipleOfThreeForInteger;
import com.jky.learn.validation.validator.MultipleOfThreeForList;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

/**
 * 自定义注解验证
 */

//注解放置位置
@Target({ElementType.FIELD})
//运行时仍可获取到
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {MultipleOfThreeForInteger.class, MultipleOfThreeForList.class}
)
public @interface MultipleOfThree{
    String message() default "必须是3的倍数";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
