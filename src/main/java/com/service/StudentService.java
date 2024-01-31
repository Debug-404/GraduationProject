package com.service;

import com.dao.StudentMapper;
import com.model.Repair;
import com.model.Student;
import com.model.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Resource
    StudentMapper studentMapper;


    public List<Student> selectAll() {
        return studentMapper.selectAll();
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
        // 学号，姓名,电话,地址 address，类型
        Repair repair = new Repair();
        map.put("rid", repair.getId());
        map.put("rphone", repair.getPhone());
        studentMapper.repair(map);
        System.out.println("报修");
    }
}
