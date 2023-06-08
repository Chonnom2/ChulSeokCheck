package com.ssafy.chulcheck.response.model;

public class ResponseDto {
    private int code;
    private Object payload;
    private String msg;

    @Override
    public String toString() {
        return "ResponseDto{" +
                "code=" + code +
                ", payload=" + payload +
                ", msg='" + msg + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getPayload() {
        return payload;
    }

    public void setPayload(Object payload) {
        this.payload = payload;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
