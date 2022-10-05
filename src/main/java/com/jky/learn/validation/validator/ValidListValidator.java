package com.jky.learn.validation.validator;

import com.jky.learn.exception.ListValidException;
import com.jky.learn.validation.ValidList;
import com.jky.learn.web.ValidatorUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.ConstraintViolation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 自定义验证
 */
/*@Component
@Scope("prototype")*/
public class ValidListValidator implements ConstraintValidator<ValidList, List> {
   /* @Autowired
    Validator validator;*/

    private Class<?>[] groupings;

    private boolean quickFail;

    @Override
    public void initialize(ValidList validList) {
        groupings = validList.groupings();
        quickFail = validList.quickFail();
    }

    @Override
    public boolean isValid(List list, ConstraintValidatorContext constraintValidatorContext) {
        Map<Integer, Set<ConstraintViolation<Object>>> errors = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (quickFail && errors.size() > 0) {
                throw new ListValidException(errors);
            }
            Object o = list.get(i);
            Set<ConstraintViolation<Object>> validate = ValidatorUtils.validator.validate(o, groupings);
            errors.put(i, validate);
        }
        if (errors.size() > 0) {
            throw new ListValidException(errors);
        }
        return true;
    }
}
