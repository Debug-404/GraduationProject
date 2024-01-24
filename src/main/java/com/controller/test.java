package com.controller;

import com.annotation.PassToken;
import com.annotation.RequestLog;
import com.service.StudentService;
import com.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class test {

    @Resource
    StudentService studentService;

    @PassToken
    @RequestLog
    @GetMapping("/get")
    public Result selectAll() {
        return Result.success("全部学生的数据", studentService.selectAll());
    }

    @RequestLog
    @GetMapping("/test")
    public String test() {
        if (true) throw new RuntimeException("异常测试");
        return "hello";
    }
}
