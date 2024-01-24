package com.service;

import com.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> selectAll();

    Student selectStudentById(String id);

    int addStudent(Student student);

    int deleteStudent(String id);

    int updateStudent(Student student);
}
