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
        repair.setWorkerId(worker.getId());
        repair.setWorkerName(worker.getName());
        repair.setWorkerPhone(worker.getPhone());
        worker.setRepairNum(worker.getRepairNum() + 1);
        workerMapper.updateWorker(worker);
        return repairMapper.addNewOrder(repair);
    }

    //更新订单信息
    public int updateNewOrder(Repair repair) {
        if (repair.getState().equals("完成")) {
            Worker worker = workerMapper.selectWorkerById(repair.getWorkerId());
            worker.setRepairNum(worker.getRepairNum() - 1);
            workerMapper.updateWorker(worker);
            repair.setFinish(1);
        }
        return repairMapper.updateNewOrder(repair);
    }

    //删除订单
    public int deleteOrder(Integer id) {
        Repair repair = repairMapper.selectRepairerById(id);
        String repairer = repair.getWorkerId();
        Worker worker = workerMapper.selectWorkerById(repairer);
        worker.setRepairNum(worker.getRepairNum() - 1);
        workerMapper.updateWorker(worker);
        return repairMapper.deleteOrder(id);
    }

    //查找订单
    public PageInfo<Repair> find(Integer pageNum, Integer pageSize, String search) {
        PageHelper.startPage((pageNum - 1) * pageSize, pageSize);
        List<Repair> list = repairMapper.find(search);
        return new PageInfo<>(list);
    }

    //查询个人申报
    public PageInfo<Repair> individualFind(Integer pageNum, Integer pageSize, String search, String sId) {
        PageHelper.startPage((pageNum - 1) * pageSize, pageSize);
        List<Repair> list = repairMapper.individualFind(search, sId);
        return new PageInfo<>(list);
    }
}
