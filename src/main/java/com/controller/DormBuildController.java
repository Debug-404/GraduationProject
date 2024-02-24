package com.controller;

import com.annotation.RequestLog;
import com.github.pagehelper.PageInfo;
import com.model.DormBuild;
import com.service.DormBuildService;
import com.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/building")
public class DormBuildController {
    @Resource
    DormBuildService dormBuildService;

    /**
     * 楼宇查找
     */
    @GetMapping("/find")
    public Result findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           @RequestParam(defaultValue = "") String search) {
        PageInfo<DormBuild> page = dormBuildService.find(pageNum, pageSize, search);
        if (page != null) {
            return Result.success(page);
        } else {
            return Result.error("查询失败");
        }
    }

    /**
     * 楼宇添加
     */
    @RequestLog
    @PostMapping("/add")
    public Result add(@RequestBody DormBuild dormBuild) {
        int i = dormBuildService.addNewBuilding(dormBuild);
        return i == 1 ? Result.success("添加成功") : Result.error("添加失败");
    }

    /**
     * 楼宇信息更新
     */
    @RequestLog
    @PutMapping("/update")
    public Result update(@RequestBody DormBuild dormBuild) {
        int i = dormBuildService.updateNewBuilding(dormBuild);
        return i == 1 ? Result.success("更新成功") : Result.error("更新失败");
    }

    /**
     * 楼宇删除
     */
    @RequestLog
    @DeleteMapping("/delete/{dormBuildId}")
    public Result delete(@PathVariable Integer dormBuildId) {
        int i = dormBuildService.deleteBuilding(dormBuildId);
        return i == 1 ? Result.success("删除成功") : Result.error("删除失败");
    }


    /**
     * 首页Echarts 获取楼宇信息
     */
    @RequestLog
    @GetMapping("/getBuildingName")
    public Result getBuildingName() {
        List<DormBuild> buildingName = dormBuildService.getBuildingId();
        List<Integer> buildingId = buildingName.stream()
                .map(dormBuildId -> dormBuildId.getDormBuildId())
                .collect(Collectors.toList());
        System.out.println(buildingId);
        return Result.success(buildingId);
    }
}
