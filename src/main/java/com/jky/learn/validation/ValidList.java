package com.jky.learn.validation;

import com.jky.learn.validation.validator.MultipleOfThreeForInteger;
import com.jky.learn.validation.validator.MultipleOfThreeForList;
import com.jky.learn.validation.validator.ValidListValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.groups.Default;
import java.lang.annotation.*;

/**
 * 支持 list 的分组验证
 */
//注解放置位置
@Target({ElementType.FIELD, ElementType.PARAMETER})
//运行时仍可获取到
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {ValidListValidator.class}
)
public @interface ValidList {
    /**
     * 要验证的分组
     */
    Class<?>[] groupings() default {Default.class};

    boolean quickFail() default false;

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
