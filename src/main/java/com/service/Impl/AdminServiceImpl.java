package com.service.Impl;

import com.dao.AdminMapper;
import com.model.Student;
import com.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    AdminMapper adminMapper;

    @Override
    public List<Student> selectAll() {
        return adminMapper.selectAll();
    }
}
