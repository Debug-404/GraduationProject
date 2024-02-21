package com.service;

import com.mapper.RepairMapper;
import com.model.Repair;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RepairService {

    @Resource
    RepairMapper repairMapper;

    //显示订单数量
    public int showOrderNum() {
        return repairMapper.showOrderNum();
    }


    //新增订单
    public int addNewOrder(Repair repair) {
        return repairMapper.addNewOrder(repair);
    }


    //更新订单信息
    public int updateNewOrder(Repair repair) {
        return repairMapper.updateNewOrder(repair);
    }

    //删除订单
    public int deleteOrder(Integer id) {
        return repairMapper.deleteOrder(id);
    }
}
