package com.service;

import com.dao.AdminMapper;
import com.model.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminService {

    @Resource
    AdminMapper adminMapper;


    public Admin selectAdminById(String id) {
        return adminMapper.selectAdminById(id);
    }
}
