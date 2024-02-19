package com.controller.admin;

import com.annotation.PassToken;
import com.annotation.RequestLog;
import com.model.Admin;
import com.model.Student;
import com.model.User;
import com.service.AdminService;
import com.service.StudentService;
import com.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class adminAction {

    @Resource
    StudentService studentService;

    @Resource
    AdminService adminService;

    @PassToken
    @RequestLog
    @RequestMapping(value = "/login")
    public Result login(@RequestBody User user) {
        Admin admin = adminService.selectAdminById(user.getId());
        if (admin.getPassword().equals(user.getPassword())) {
            return Result.success("登录成功");
        } else return Result.unauthorized("账号或者密码错误，请重新登录");
    }

    @RequestLog
    @PostMapping("/getStudent/{id}")
    public Result getStudent(@PathVariable String id) {
        Student student = studentService.selectStudentById(id);
        return Result.success(student);
    }

    @RequestLog
    @DeleteMapping("/delete")
    public Result delete(@RequestBody String id) {
        int i = studentService.deleteStudent(id);
        return i == 1 ? Result.success("删除成功") : Result.error("删除失败");
    }


    @RequestLog
    @PostMapping("/getAll")
    public Result getAll() {
        return Result.success(studentService.findAll());
    }


    @RequestLog
    @PostMapping("/add")
    public Result add(@RequestBody Student student) {
        int i = studentService.addStudent(student);
        System.out.println(i);
        return Result.success();
    }

    @RequestLog
    @PostMapping("/intoNotice")
    public Result intoNotice(@RequestBody Map<String, Object> map) {
        adminService.intoNotice(map);
        return Result.success();
    }

    @RequestLog
    @PostMapping("/getNotice/{currentPage}")
    public Result getNotice(@PathVariable int currentPage) {
        return Result.success(adminService.findByLimit(currentPage, 5));
    }

}
