package com.jky.learn.validation.validator;

import com.jky.learn.validation.MultipleOfThree;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MultipleOfThreeForInteger implements ConstraintValidator<MultipleOfThree, Integer> {

    @Override
    public void initialize(MultipleOfThree constraintAnnotation) {

    }

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        if (integer == null) {
            return true;
        }
        return integer % 3 == 0;
    }
}
