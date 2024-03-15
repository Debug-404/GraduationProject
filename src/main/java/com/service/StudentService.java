package com.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.StudentMapper;
import com.model.Student;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentService {

    @Resource
    StudentMapper studentMapper;

    /**
     * 获取全部学生
     */
    public List<Student> findAll() {
        return studentMapper.findAll();
    }


    /**
     * 查询学生
     */
    public PageInfo<Student> find(Integer pageNum, Integer pageSize, String search) {
        PageHelper.startPage((pageNum - 1) * pageSize, pageSize);
        List<Student> list = studentMapper.find(search);
        return new PageInfo<>(list);
    }

    /**
     * 根据学号查询
     */
    public Student selectStudentById(String id) {
        return studentMapper.selectStudentById(id);
    }

    /**
     * 添加学生信息
     */
    public int addStudent(Student student) {
        return studentMapper.addStudent(student);
    }

    /**
     * 删除学生信息
     */
    public int deleteStudent(String id) {
        return studentMapper.deleteStudent(id);
    }

    /**
     * 更新学生信息
     */
    public int updateStudent(Student student) {
        return studentMapper.updateStudent(student);
    }

    /**
     * 主页顶部：学生数量统计
     */
    public int stuNum() {
        return studentMapper.stuNum();
    }
}
