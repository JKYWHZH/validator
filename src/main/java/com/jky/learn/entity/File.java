package com.jky.learn.entity;

import com.jky.learn.validation.sequenceprovider.FileNeedRegxOrPathGroupSequenceProvider;
import org.hibernate.validator.group.GroupSequenceProvider;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.groups.Default;

/**
 * 需求
 * 新增文件时id唯一 且后端生成
 * 文件表达式 regx 和 文件路径 path 只能同时存在一个且不能同时都不存在
 */
@GroupSequenceProvider(FileNeedRegxOrPathGroupSequenceProvider.class)
public class File {

    /**
     * 新增文件分组
     */
    public interface Add{}

    /*public interface Upd{}*/

    /**
     * 表达式和路径 只能 同时存在一个且不能同时都不存在
     */
    public interface RegxAndPathIsNull{}
    public interface RegxAndPathNotNull{}

    /**
     * 文件id
     */
    @Null(groups = Add.class, message = "新增时主键必须为空")
    /**
     * add Null
     * upd NotNull
     */
   /* @Null(groups = {Add.class}, message = "aaa")
    @NotNull(groups = {Upd.class}, message = "bbbb")*/
    private Integer id;

    /**
     * 文件表达式
     */
    @NotBlank(groups = {RegxAndPathIsNull.class}, message = "不能同时为空")
    @Null(groups = RegxAndPathNotNull.class, message = "不能同时有值")
    private String regx;

    /**
     * 文件路径
     */
    @NotBlank(groups = {RegxAndPathIsNull.class}, message = "不能同时为空")
    @Null(groups = RegxAndPathNotNull.class, message = "不能同时有值")
    private String path;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRegx() {
        return regx;
    }

    public void setRegx(String regx) {
        this.regx = regx;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
