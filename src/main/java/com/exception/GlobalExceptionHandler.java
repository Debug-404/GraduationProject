package com.exception;


import com.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 全局异常处理
     *
     * @param e
     * @return Result
     */
    @ExceptionHandler(Exception.class)
    public Result error(Exception e) {  //可以直接添加形参来获取异常
        log.error("error: " + e.getMessage());
        return Result.error("服务器出现错误，请稍后重试");
    }
}