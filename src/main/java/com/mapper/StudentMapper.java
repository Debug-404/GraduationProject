package com.mapper;

import com.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StudentMapper {
    //获取全部学生信息
    List<Student> findAll();

    //学生数量
    int stuNum();

    //查询学生
    List<Student> find(String search);

    //根据学号查询单个学生信息
    Student selectStudentById(String id);

    // 增加
    int addStudent(Student student);

    //删除
    int deleteStudent(String id);

    //更新
    int updateStudent(Student student);
}
