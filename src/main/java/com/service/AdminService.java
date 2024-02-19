package com.service;

import com.dao.AdminMapper;
import com.model.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AdminService {

    @Resource
    AdminMapper adminMapper;


    public Admin selectAdminById(String id) {
        return adminMapper.selectAdminById(id);
    }


    public int intoNotice(Map<String, Object> map) {
        return adminMapper.intoNotice(map);
    }

    public List<Map<String, Object>> findByLimit(int currentPage, int pageSize) {
        //currentPage 第几页
        //pageSize 每页显示几个
        Map<String, Object> map = new HashMap<>();
        map.put("startIndex", (currentPage - 1) * pageSize);
        map.put("pageSize", pageSize);
        return adminMapper.findByLimit(map);
    }
}
