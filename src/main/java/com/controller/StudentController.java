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
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/stu")
public class StudentController {

    @Resource
    StudentService studentService;


    @RequestLog
    @PostMapping("/repair")
    public Result Repair(@RequestBody Map<String, Object> map) {
        studentService.repair(map);
        return Result.success("报修成功，后续维修员会与您联系");
    }

    /**
     * 学生登录
     */
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

    /**
     * 查找学生信息
     */
    @GetMapping("/find")
    public Result findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           @RequestParam(defaultValue = "") String search) {
        List<Student> list = studentService.find(pageNum, pageSize, search);
        HashMap<String, Object> map = new HashMap<>();
        map.put("list", list);
        map.put("total", studentService.stuNum());
        if (list != null) {
            return Result.success(map);
        } else {
            return Result.error("查询失败");
        }
    }

    /**
     * 添加学生信息
     */
    @RequestLog
    @PostMapping("/add")
    public Result add(@RequestBody Student student) {
        int i = studentService.addStudent(student);
        return i == 1 ? Result.success("添加成功") : Result.error("添加失败");
    }

    /**
     * 删除学生信息
     */
    @RequestLog
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable String id) {
        int i = studentService.deleteStudent(id);
        return i == 1 ? Result.success("删除成功") : Result.error("删除失败");
    }

    /**
     * 更新学生信息
     */
    @RequestLog
    @PutMapping("/update")
    public Result update(@RequestBody Student student) {
        int i = studentService.updateStudent(student);
        return i == 1 ? Result.success("更新成功") : Result.error("更新失败");
    }

    /**
     * 获取全部学生信息
     */
    @RequestLog
    @PostMapping("/find")
    public Result getAll() {
        return Result.success(studentService.findAll());
    }

    /**
     * 根据学号获取学生信息
     */
    @RequestLog
    @PostMapping("/getStudent/{id}")
    public Result getStudent(@PathVariable String id) {
        Student student = studentService.selectStudentById(id);
        return Result.success(student);
    }

    /**
     * 根据学号获取学生信息
     */
    @RequestLog
    @PostMapping("/getStudent")
    public Result getStudent(@RequestBody Map<String, String> map) {
        Student student = studentService.selectStudentById(map.get("id"));
        return Result.success(student);
    }


    /**
     * 主页顶部：学生统计
     */
    @RequestLog
    @GetMapping("/stuNum")
    public Result stuNum() {
        int num = studentService.stuNum();
        if (num > 0) {
            return Result.success(num);
        } else {
            return Result.error("查询失败");
        }
    }
}
