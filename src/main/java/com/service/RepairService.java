package com.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.RepairMapper;
import com.mapper.WorkerMapper;
import com.model.Repair;
import com.model.Worker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RepairService {

    @Resource
    RepairMapper repairMapper;

    @Resource
    WorkerMapper workerMapper;

    //显示订单数量
    public int showOrderNum() {
        return repairMapper.showOrderNum();
    }


    //新增订单
    public int addNewOrder(Repair repair) {
        Worker worker = workerMapper.minRepairNum();
        repair.setRepairer(worker.getId());
        repair.setRName(worker.getName());
        repair.setRPhone(worker.getPhone());
        return repairMapper.addNewOrder(repair);
    }

    //更新订单信息
    public int updateNewOrder(Repair repair) {
        if (repair.getState().equals("完成"))
            repair.setFinish(1);
        return repairMapper.updateNewOrder(repair);
    }

    //删除订单
    public int deleteOrder(Integer id) {
        return repairMapper.deleteOrder(id);
    }

    public PageInfo<Repair> find(Integer pageNum, Integer pageSize, String search) {
        PageHelper.startPage((pageNum - 1) * pageSize, pageSize);
        List<Repair> list = repairMapper.find(search);
        return new PageInfo<>(list);
    }

    public PageInfo<Repair> individualFind(Integer pageNum, Integer pageSize, String search, String sId) {

        PageHelper.startPage((pageNum - 1) * pageSize, pageSize);
        List<Repair> list = repairMapper.individualFind(search, sId);
        return new PageInfo<>(list);
    }
}
