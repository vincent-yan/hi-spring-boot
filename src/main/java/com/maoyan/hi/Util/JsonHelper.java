package com.maoyan.hi.Util;

import com.maoyan.hi.Entity.JsonResult;


public class JsonHelper {

    public static final <T> JsonResult<T> Success(T data) {
        return  Result(true,"",data);
    }

    public static final <T> JsonResult<T> Fail(T data,String msg) {
        return  Result(false,msg,data);
    }


    public static final <T> JsonResult<T> Result(Boolean success,String msg,T data) {
        return new JsonResult(success,msg,data);
    }
}
