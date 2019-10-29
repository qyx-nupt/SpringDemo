package com.qyx.springbootdemoexceptionhandler.exception;


import com.qyx.springbootdemoexceptionhandler.model.Status;

public class PageException extends RuntimeException {
    private int code;
    private String message;

    public PageException(int code, String message){
        super(message);
        this.code = code;
        this.message = message;
    }

    public PageException(Status status){
        super(status.getMessage());
        this.code = status.getCode();
        this.message = status.getMessage();
    }

}
