package com.jky.learn.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jky.learn.enums.ErrorCode;

@JsonInclude(JsonInclude.Include.NON_NULL) // 只有非空才会被加入序列化
public class ResultVo {
    /**
     * 后端是否成功
     */
    private boolean success;
    /**
     * 错误码
     */
    private String code;
    /**
     * 错误消息
     */
    private String msg;
    /**
     * 返回数据
     */
    private Object data;

    public static ResultVo success(){
        ResultVo resultVo = new ResultVo();
        resultVo.setSuccess(true);
        return resultVo;
    }

    public static ResultVo fail(ErrorCode errorCode, Object data){
        ResultVo resultVo = new ResultVo();
        resultVo.setSuccess(false);
        resultVo.setMsg(errorCode.getMsg());
        resultVo.setCode(errorCode.getCode());
        resultVo.setData(data);
        return resultVo;
    }

    public static ResultVo fail(ErrorCode errorCode){
        ResultVo resultVo = new ResultVo();
        resultVo.setSuccess(false);
        resultVo.setMsg(errorCode.getMsg());
        resultVo.setCode(errorCode.getCode());
        return resultVo;
    }

    public static ResultVo success(Object data){
        ResultVo resultVo = new ResultVo();
        resultVo.setSuccess(true);
        resultVo.setData(data);
        return resultVo;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
