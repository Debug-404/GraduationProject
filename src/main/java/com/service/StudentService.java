package com.service;

import com.model.Student;
import com.model.User;

import java.util.List;

public interface StudentService {
    List<Student> selectAll();

    boolean selectStudentById(User user);

    int addStudent(Student student);

    int deleteStudent(String id);

    int updateStudent(Student student);
}
