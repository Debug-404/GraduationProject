package com.service;

import com.model.Student;

public interface StudentService {


    Student selectStudentById(String id);

    int addStudent(Student student);

    int deleteStudent(String id);

    int updateStudent(Student student);
}
