package com.qyx.springbootdemoexceptionhandler.model;

import lombok.Getter;

@Getter
public enum Status {
    OK(0,"操作失败"),
    VISIT_ERROR(-1,"访问出错");

    private  int code;
    private String message;
    Status(int code, String message){
        this.code = code;
        this.message = message;
    }
}
