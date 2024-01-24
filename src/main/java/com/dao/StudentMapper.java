package com.dao;

import com.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {

    Student selectStudentById(String id);

    int addStudent(Student student);

    int deleteStudent(String id);

    int updateStudent(Student student);
}
