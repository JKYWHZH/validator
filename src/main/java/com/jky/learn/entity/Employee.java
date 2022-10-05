package com.jky.learn.entity;

import com.jky.learn.validation.sequenceprovider.EmployeeGroupSequenceProvider;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Pattern;

@GroupSequenceProvider(EmployeeGroupSequenceProvider.class)

public class Employee {

    /**
     * 分组验证
     */

    /**
     * 如果指定了验证组，那么该参数就只属于，指定验证组
     * 如果没有指定验证组，那么该参数属于，默认组
     */

    public interface Add{
    }

    public interface Update{
    }

    @Null(groups = Add.class, message = "添加时id不允许有值")    //在添加时候生效
    @NotNull(groups = {Update.class}) //在修改时生效
    private Integer id;
    @NotEmpty
    private String name;

    /**
     * 1。 员工的 age在20-25之间，title必须以初级开头；
     * 2。 员工的 age在25-30之间，title必须以中级开头；
     * 3。 否则， 不验证。
     */

    public interface TitleJunior{}
    public interface TitleMiddle{}
    @NotNull
    private Integer age;
    @NotEmpty
    @Pattern(regexp = "^\u521d\u7ea7.*", groups = TitleJunior.class)     //初级
    @Pattern(regexp = "^\u4e2d\u7ea7.*", groups = TitleMiddle.class)     //中级
    private String title;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Valid
    private Department department;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
