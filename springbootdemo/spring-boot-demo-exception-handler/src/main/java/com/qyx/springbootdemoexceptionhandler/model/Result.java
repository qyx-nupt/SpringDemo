package com.qyx.springbootdemoexceptionhandler.model;

public class Result {
    private int code;
    private String message;
    private Object data;

    public Result(){

    }
    public Result(int code, String message, Object data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static Result ofStatus(Status status, Object data){
        return new Result(status.getCode(), status.getMessage(), data);
    }
    public static Result ofStatus(Status status){
        return ofStatus(status, null);
    }

    public static Result success(){
        return ofStatus(Status.OK);
    }
    public static Result success(Object data){
        return ofStatus(Status.OK, data);
    }

    public static Result error(){
        return ofStatus(Status.VISIT_ERROR, null);
    }
    public static Result error(Object data){
        return ofStatus(Status.VISIT_ERROR, data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
