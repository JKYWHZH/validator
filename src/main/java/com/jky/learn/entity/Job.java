package com.jky.learn.entity;

import com.jky.learn.validation.MultipleOfThree;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class Job {

    /**
     * 注解一般不会管null的情况（null的情况由notnull去负责）
     * 同一个注解，可以对多种参数类型生效
     */
    /**
     * 加入一个场景
     * 1。 对于integer而言，必须是3的倍数
     * 2。 对于list而言，list中的元属个数，必须是3的倍数
     *
     * 准备写一个注解，去实现"3的倍数"的验证
     * 这个注解支持两种数据类型integer、list
     */
    @MultipleOfThree
    private Integer id;

    @Size(min = 1) //string 不为空时 才进行验证
    private String name;

    @Size(min = 1, max = 10) //list 不为空时 才进行验证
    @NotNull
    @MultipleOfThree
    private List<String> lables;

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

    public List<String> getLables() {
        return lables;
    }

    public void setLables(List<String> lables) {
        this.lables = lables;
    }
}
