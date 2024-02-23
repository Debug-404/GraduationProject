package com.mapper;

import com.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface StudentMapper {
    //获取全部学生信息
    List<Student> findAll();

    int stuNum();

    //分页查询
    List<Student> findByLimit(Map<String, Object> map);

    //查询学生
    List<Student> find(Map<String, Object> map);

    //根据学号查询单个学生信息
    Student selectStudentById(String id);

    // 增加
    int addStudent(Student student);

    //删除
    int deleteStudent(String id);

    //更新
    int updateStudent(Student student);

    //更新密码
    int updatePassword(Map<String, String> map);

    void repair(Map<String, Object> map);
}
