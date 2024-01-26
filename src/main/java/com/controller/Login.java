package com.controller;

import com.annotation.PassToken;
import com.annotation.RequestLog;
import com.model.User;
import com.service.Impl.StudentServiceImpl;
import com.utils.JwtUtils;
import com.utils.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class Login {

    @Resource
    StudentServiceImpl studentService;

    @PassToken
    @RequestLog
    @RequestMapping(value = "/login")
    public Result login(@RequestBody User user) {
        if (studentService.selectStudentById(user)) {
            Map<String, String> map = new HashMap<>();
            map.put("id", user.getId());
            String token = JwtUtils.createToken(map);
            map.clear();
            map.put("token", token);
            return Result.success("登录成功", map);
        } else return Result.unauthorized("账号或者密码错误，请重新登录");
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

