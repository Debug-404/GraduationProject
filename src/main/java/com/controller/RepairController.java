package com.controller;

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
     * 添加订单
     */
    @PostMapping("/add")
    public Result add(@RequestBody Repair repair) {
        int i = repairService.addNewOrder(repair);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.error("添加失败");
        }
    }

    /**
     * 更新订单
     */
    @PutMapping("/update")
    public Result update(@RequestBody Repair repair) {
        int i = repairService.updateNewOrder(repair);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.error("更新失败");
        }
    }

    /**
     * 删除订单
     */
    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable Integer id) {
        int i = repairService.deleteOrder(id);
        if (i == 1) {
            return Result.success();
        } else {
            return Result.error("删除失败");
        }
    }


    /**
     * 首页顶部：报修统计
     */
    @GetMapping("/orderNum")
    public Result orderNum() {
        int num = repairService.showOrderNum();
        if (num >= 0) {
            return Result.success(num);
        } else {
            return Result.error("报修统计查询失败");
        }
    }
}
