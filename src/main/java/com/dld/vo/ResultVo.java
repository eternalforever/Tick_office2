package com.dld.vo;

public class ResultVo {

    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public ResultVo(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultVo() {
    }

    public static ResultVo setSuccess(String msg){
        return new ResultVo(1000,msg);
    }
    public static ResultVo setError(String msg){
        return new ResultVo(2000,msg);
    }
}
