package com.jky.learn.entity;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.PastOrPresent;
import java.time.LocalDateTime;
import java.util.List;

/**
 *  String errorPrefix = "添加失败，";
 *         if (department.getId() != null) {
 *             return errorPrefix.concat("实体参数异常");
 *         }
 *         if (department.getParent_id() == null) {
 *             return errorPrefix.concat("父机构异常");
 *         }
 *         if (department.getParent_id() < 0) {
 *             return errorPrefix.concat("父机构不存在");
 *         }
 *         if(department.getName() == null || department.getName().equals("")){
 *             return errorPrefix.concat("名称不能为空");
 *         }
 *         if (department.getCreateTime() == null) {
 *             department.setCreateTime(LocalDateTime.now());
 *         }else{
 *             if (department.getCreateTime().isBefore(LocalDateTime.now())) {
 *                 return errorPrefix.concat("创建时间不能大于当前时间");
 *             }
 *         }
 */
public class Department {
    /**
     * 主键
     */
    @Null(message = "主键不可以有值")
    private Integer id;
    /**
     * 父级id
     */
    @NotNull
    private Integer parent_id;
    /**
     * 部门名称
     */
    @NotBlank
    private String name;
    /**
     * 成立时间
     */
    @PastOrPresent
    @NotNull
    private LocalDateTime createTime;

    @Valid
    private List<Employee> employeeList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParent_id() {
        return parent_id;
    }

    public void setParent_id(Integer parent_id) {
        this.parent_id = parent_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
