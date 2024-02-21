package com.controller;

import com.model.Worker;
import com.service.WorkerService;
import com.utils.Result;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/worker")
public class WorkerAction {

    @Resource
    WorkerService workerService;

    @PostMapping("/findAll")
    public Result findAll() {
        List<Worker> list = workerService.findAll();
        return Result.success(list);
    }

    @PostMapping("/getWorker/{id}")
    public Result selectRepairById(@PathVariable String id) {
        Worker worker = workerService.selectRepairById(id);
        return Result.success(worker);
    }
}
