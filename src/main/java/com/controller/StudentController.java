package com.controller;

import com.annotation.PassToken;
import com.annotation.RequestLog;
import com.github.pagehelper.PageInfo;
import com.model.Student;
import com.model.User;
import com.service.StudentService;
import com.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
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
    public Result login(@RequestBody User user, HttpSession session) {
        Student student = studentService.selectStudentById(user.getId());
        if (student == null) return Result.unauthorized("账号或者密码错误，请重新登录");
        if (student.getPassword().equals(user.getPassword())) {
            session.setAttribute("Identity", "stu");
            session.setAttribute("User", student);
            return Result.success("登录成功", student);
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
    @RequestLog
    @GetMapping("/find")
    public Result findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           @RequestParam(defaultValue = "") String search) {
        PageInfo<Student> list = studentService.find(pageNum, pageSize, search);
        if (list != null) {
            return Result.success(list);
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
        System.out.println(student);
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
    @GetMapping("/getStudent/{id}")
    public Result getStudent(@PathVariable String id) {
        Student student = studentService.selectStudentById(id);
        return student != null ? Result.success(student) : Result.error("学号已经存在");
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

