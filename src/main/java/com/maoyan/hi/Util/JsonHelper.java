package com.maoyan.hi.Util;

import com.maoyan.hi.Entity.JsonResult;


public class JsonHelper {

    public static final <T> JsonResult<T> RESULT(T data) {
        if (data == null) {
            return Fail("");
        }
        return Success(data);
    }


    public static final <T> JsonResult<T> Operate(Boolean success) {
        if (success) {
            return new JsonResult(success, "", null);
        }
        return new JsonResult(success, "", null);
    }

    public static final <T> JsonResult<T> Success(T data) {
        return Result(true, "", data);
    }


    public static final <T> JsonResult<T> Fail(String msg) {
        return Result(false, msg, null);
    }


    public static final <T> JsonResult<T> Result(Boolean success, String msg, T data) {
        return new JsonResult(success, msg, data);
    }
}
