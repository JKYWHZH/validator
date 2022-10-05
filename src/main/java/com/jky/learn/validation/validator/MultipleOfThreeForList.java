package com.jky.learn.validation.validator;

import com.jky.learn.validation.MultipleOfThree;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class MultipleOfThreeForList implements ConstraintValidator<MultipleOfThree, List> {
    @Override
    public void initialize(MultipleOfThree constraintAnnotation) {

    }

    @Override
    public boolean isValid(List list, ConstraintValidatorContext constraintValidatorContext) {
        if (list == null) {
            return true;
        }
        return list.size() % 3 == 0;
    }
}
