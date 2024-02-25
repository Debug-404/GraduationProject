package com.service;

import com.mapper.AdminMapper;
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

    public int updateAdmin(Admin admin) {
        return adminMapper.updateAdmin(admin);
    }

}
