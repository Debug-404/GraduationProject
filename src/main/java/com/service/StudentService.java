package com.service;

import com.dao.StudentMapper;
import com.model.Student;
import com.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Resource
    StudentMapper studentMapper;


    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    //page
    public List<String> findByLimit(int currentPage, int pageSize) {
        //currentPage 第几页
        //pageSize 每页显示几个
        Map<String, Object> map = new HashMap<>();
        map.put("startIndex", (currentPage - 1) * pageSize);
        map.put("pageSize", pageSize);
        return studentMapper.findByLimit(map);
    }


    public Student selectStudentById(String id) {
        return studentMapper.selectStudentById(id);
    }


    public boolean selectPassword(User user) {
        Student student = studentMapper.selectStudentById(user.getId());
        return student.getPassword().equals(user.getPassword());
    }


    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }


    public int deleteStudent(String id) {
        return studentMapper.deleteStudent(id);
    }


    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    public void repair(Map<String, Object> map) {
        studentMapper.repair(map);
    }
}
