package com.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * controller 统一返回包装类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    public static final int Success_CODE = 200; // 请求成功
    public static final int Unauthorized_CODE = 401; // 未经授权
    public static final int Error_CODE = 500; // 请求失败

    private int code;
    private String message;
    private Object data;

    public Result(int code, String msg) {
        this.code = code;
        this.message = msg;
    }

    /**
     * 请求成功并且返回数据
     */
    public static Result success(String message, Object data) {
        return new Result(Success_CODE, message, data);
    }

    public static Result success() {
        return new Result(Success_CODE, "no data");
    }

    public static Result success(String message) {
        return new Result(Success_CODE, message);
    }

    public static Result success(Object data) {
        return new Result(Success_CODE, "成功", data);
    }

    /**
     * 请求失败
     */
    public static Result error(String message) {
        return new Result(Error_CODE, message);
    }

    /**
     * 未经授权
     */
    public static Result unauthorized(String message) {
        return new Result(Unauthorized_CODE, message);
    }
}
