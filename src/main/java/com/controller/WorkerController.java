package com.controller;

import com.annotation.RequestLog;
import com.github.pagehelper.PageInfo;
import com.model.User;
import com.model.Worker;
import com.service.WorkerService;
import com.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/worker")
public class WorkerController {

    @Resource
    WorkerService workerService;

    /**
     * 维修员登录
     */
    @RequestLog
    @PostMapping("/login")
    public Result login(@RequestBody User user, HttpSession session) {
        Worker worker = workerService.selectRepairById(user.getId());
        if (worker == null) return Result.unauthorized("用户名或密码错误");
        if (worker.getPassword().equals(user.getPassword())) {
            session.setAttribute("Identity", "dormManager");
            session.setAttribute("User", worker);
            return Result.success(worker);
        } else {
            return Result.error("用户名或密码错误");
        }
    }

    /**
     * 维修员查找
     */
    @RequestLog
    @GetMapping("/find")
    public Result findAll(@RequestParam(defaultValue = "1") Integer pageNum,
                          @RequestParam(defaultValue = "10") Integer pageSize,
                          @RequestParam(defaultValue = "") String search) {
        PageInfo<Worker> pageInfo = workerService.find(pageNum, pageSize, search);
        return Result.success(pageInfo);
    }

    /**
     * 维修员查找
     */
    @RequestLog
    @PostMapping("/getWorker/{id}")
    public Result selectRepairById(@PathVariable String id) {
        Worker worker = workerService.selectRepairById(id);
        return Result.success(worker);
    }

    /**
     * 维修员添加
     */
    @RequestLog
    @PostMapping("/add")
    public Result add(@RequestBody Worker worker) {
        int i = workerService.addNewWorker(worker);
        return i == 1 ? Result.success("添加成功") : Result.error("添加失败");
    }

    /**
     * 维修员信息更新
     */
    @RequestLog
    @PutMapping("/update")
    public Result update(@RequestBody Worker worker) {
        int i = workerService.updateWorker(worker);
        return i == 1 ? Result.success("更新成功") : Result.error("更新失败");
    }

    /**
     * 维修员删除
     */
    @RequestLog
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable String id) {
        int i = workerService.deleteWorker(id);
        return i == 1 ? Result.success("删除成功") : Result.error("删除失败");
    }
}
