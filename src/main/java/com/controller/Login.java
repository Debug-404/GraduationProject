package com.controller;

import com.annotation.PassToken;
import com.annotation.RequestLog;
import com.model.Student;
import com.model.User;
import com.service.Impl.StudentServiceImpl;
import com.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Login {

    @Resource
    StudentServiceImpl studentService;

    @PassToken
    @RequestLog
    @RequestMapping(value = "/login", produces = "application/json")
    public Result login(@RequestBody User user) {
        System.out.println(user.toString());
        Map<String, String> map = new HashMap<>();
        map.put("token", "hello");
        return Result.success("登录成功", map);
    }

    @PassToken
    @RequestLog
    @RequestMapping("/register")
    public Result register() {
        Map<String, String> map = new HashMap<>();
        map.put("注册", "成功");
        return Result.success("测试", map);
    }
}

