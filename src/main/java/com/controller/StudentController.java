package com.controller;

import com.annotation.AopLog;
import com.service.Impl.StudentServiceImpl;
import com.utils.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class StudentController {

    @Resource
    StudentServiceImpl studentService;

    @AopLog
    @GetMapping("/get")
    public Result selectAll() {
        return Result.success("全部学生的数据", studentService.selectAll());
    }

    @AopLog
    @GetMapping("/hello")
    public String hello() {
        if (false) throw new RuntimeException("异常测试");
        return "hello";
    }
}
