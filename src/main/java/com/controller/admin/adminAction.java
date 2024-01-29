package com.controller.admin;

import com.annotation.RequestLog;
import com.model.Student;
import com.service.Impl.AdminServiceImpl;
import com.service.StudentService;
import com.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/admin")
public class adminAction {
    @Resource
    AdminServiceImpl adminService;

    @Resource
    StudentService studentService;

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
        return Result.success(studentService.selectAll());
    }


}
