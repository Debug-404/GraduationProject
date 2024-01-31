package com.controller;

import com.annotation.PassToken;
import com.annotation.RequestLog;
import com.model.Student;
import com.model.User;
import com.service.StudentService;
import com.utils.JwtUtils;
import com.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentAction {

    @Resource
    StudentService studentService;

    @PassToken
    @RequestLog
    @RequestMapping(value = "/login")
    public Result login(@RequestBody User user) {
        if (studentService.selectPassword(user)) {
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
    public Result register(@RequestBody Map<String, Object> map) {
        System.out.println(map.toString());
        return Result.success("注册成功");
    }


    @RequestLog
    @PostMapping("/getStudent")
    public Result getStudent(@RequestBody Map<String, String> map) {
        Student student = studentService.selectStudentById(map.get("id"));
        return Result.success(student);
    }

    @RequestLog
    @PutMapping("/update")
    public Result update(@RequestBody Student student) {
        int i = studentService.updateStudent(student);
        return i == 1 ? Result.success("更新成功") : Result.error("更新失败");
    }

    @RequestLog
    @PostMapping("/repair")
    public Result Repair(@RequestBody Map<String, Object> map) {
        studentService.repair(map);
        return Result.success();
    }
}

