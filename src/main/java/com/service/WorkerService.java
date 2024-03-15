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

    /**
     * 维修员分页查找
     */
    public PageInfo<Worker> find(Integer pageNum, Integer pageSize, String search) {
        PageHelper.startPage((pageNum - 1) * pageSize, pageSize);
        List<Worker> list = workerMapper.find(search);
        return new PageInfo<>(list);
    }

    /**
     * 根据id查找维修员
     */
    public Worker selectRepairById(String id) {
        return workerMapper.selectWorkerById(id);
    }

    /**
     * 维修员添加
     */
    public int addNewWorker(Worker worker) {
        return workerMapper.addNewWorker(worker);
    }

    /**
     * 维修员信息更新
     */
    public int updateWorker(Worker worker) {
        return workerMapper.updateWorker(worker);
    }

    /**
     * 维修员删除
     */
    public int deleteWorker(String id) {
        return workerMapper.deleteWorker(id);
    }

}
