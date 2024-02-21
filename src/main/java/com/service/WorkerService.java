package com.service;

import com.mapper.WorkerMapper;
import com.model.Worker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WorkerService {
    @Resource
    WorkerMapper workerMapper;

    public List<Worker> findAll() {
        return workerMapper.findAll();
    }

    public Worker selectRepairById(String id) {
        return workerMapper.selectRepairById(id);
    }
}
