package com.service.Impl;

import com.dao.AdminMapper;
import com.model.Admin;
import com.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceImpl implements AdminService {

    @Resource
    AdminMapper adminMapper;

    @Override
    public Admin selectAdminById(String id) {
        return adminMapper.selectAdminById(id);
    }
}
