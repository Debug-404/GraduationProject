package com.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.WorkerMapper;
import com.model.Worker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WorkerService {
    @Resource
    WorkerMapper workerMapper;

    public PageInfo<Worker> find(Integer pageNum, Integer pageSize, String search) {
        PageHelper.startPage((pageNum - 1) * pageSize, pageSize);
        List<Worker> list = workerMapper.find(search);
        return new PageInfo<>(list);
    }

    public Worker selectRepairById(String id) {
        return workerMapper.selectRepairById(id);
    }

    //接单最少数
    public Worker minRepairNum() {
        return workerMapper.minRepairNum();
    }

    public int addNewDormManager(Worker worker) {
        return workerMapper.addNewDormManager(worker);
    }

    public int updateNewDormManager(Worker worker) {
        return workerMapper.updateNewDormManager(worker);
    }

    public int deleteDormManager(String id) {
        return workerMapper.deleteDormManager(id);
    }

}
