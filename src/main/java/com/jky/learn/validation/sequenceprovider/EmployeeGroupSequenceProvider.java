package com.jky.learn.validation.sequenceprovider;

import com.jky.learn.entity.Employee;
import org.hibernate.validator.spi.group.DefaultGroupSequenceProvider;

import java.util.ArrayList;
import java.util.List;

public class EmployeeGroupSequenceProvider implements DefaultGroupSequenceProvider<Employee> {
    @Override
    public List<Class<?>> getValidationGroups(Employee employee) {
        List<Class<?>> defaultGroupSequence = new ArrayList<>();
        defaultGroupSequence.add(Employee.class); //相当于添加了默认组
        if (employee != null && employee.getAge() != null) {
            int age = employee.getAge();
            if (age > 20 && age <= 25) {
                defaultGroupSequence.add(Employee.TitleJunior.class);
            }else if (age > 25 && age <= 30){
                defaultGroupSequence.add(Employee.TitleMiddle.class);
            }
        }
        return defaultGroupSequence;
    }
}
