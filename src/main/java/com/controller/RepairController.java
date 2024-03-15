package com.controller;

import com.annotation.RequestLog;
import com.github.pagehelper.PageInfo;
import com.model.Repair;
import com.service.RepairService;
import com.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/repair")
public class RepairController {

    @Resource
    RepairService repairService;

    /**
     * 查找订单
     */
    @RequestLog
    @GetMapping("/find")
    public Result findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           @RequestParam(defaultValue = "") String search) {
        PageInfo<Repair> pageInfo = repairService.find(pageNum, pageSize, search);
        return pageInfo != null ? Result.success(pageInfo) : Result.error("查询失败");
    }

    /**
     * 个人申报报修 分页查询
     */
    @RequestLog
    @GetMapping("/find/{id}")
    public Result individualFind(@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "10") Integer pageSize,
                                 @RequestParam(defaultValue = "") String search,
                                 @PathVariable String id) {
        PageInfo<Repair> pageInfo = repairService.individualFind(pageNum, pageSize, search, id);
        return pageInfo != null ? Result.success(pageInfo) : Result.error("查询失败");
    }

    /**
     * 添加订单
     */
    @RequestLog
    @PostMapping("/add")
    public Result add(@RequestBody Repair repair) {
        int i = repairService.addNewOrder(repair);
        return i == 1 ? Result.success() : Result.error("添加失败");

    }

    /**
     * 更新订单
     */
    @RequestLog
    @PutMapping("/update")
    public Result update(@RequestBody Repair repair) {
        int i = repairService.updateNewOrder(repair);
        return i == 1 ? Result.success() : Result.error("更新失败");
    }

    /**
     * 删除订单
     */
    @RequestLog
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        int i = repairService.deleteOrder(id);
        return i == 1 ? Result.success() : Result.error("删除失败");
    }

    /**
     * 首页顶部：报修统计
     */
    @RequestLog
    @GetMapping("/orderNum")
    public Result orderNum() {
        int num = repairService.showOrderNum();
        return num >= 0 ? Result.success(num) : Result.error("报修统计查询失败");
    }
}
