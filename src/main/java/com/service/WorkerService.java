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
        return workerMapper.selectWorkerById(id);
    }

    public int addNewWorker(Worker worker) {
        return workerMapper.addNewWorker(worker);
    }

    public int updateWorker(Worker worker) {
        return workerMapper.updateWorker(worker);
    }

    public int deleteWorker(String id) {
        return workerMapper.deleteWorker(id);
    }

}
