package com.maoyan.hi.Entity;

//@Data
public class JsonResult<T> {

    private boolean success;
    private String msg;
    private T data;

    public JsonResult(boolean success, String msg, T data) {
        this.success=success;
        this.msg = msg;
        this.data = data;
        }
}

