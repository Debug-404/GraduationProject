package com.service;

import com.dao.RepairMapper;
import com.model.Repair;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RepairService {
    @Resource
    RepairMapper repairMapper;


    Repair selectRepairById(String id) {
        return repairMapper.selectRepairById(id);
    }
    
}
