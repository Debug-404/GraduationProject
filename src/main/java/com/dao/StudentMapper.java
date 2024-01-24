package com.dao;

import com.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface StudentMapper {
    List<Student> selectAll();

    Student selectStudentById(String id);

    int addStudent(Student student);

    int deleteStudent(String id);

    int updateStudent(Student student);

    int updatePassword(Map<String, String> map);
}
