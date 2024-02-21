package com.controller;

import com.model.DormBuild;
import com.service.DormBuildService;
import com.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/building")
public class DormBuildAction {
    @Resource
    DormBuildService dormBuildService;

    /**
     * 楼宇添加
     */
    @PostMapping("/add")
    public Result add(@RequestBody DormBuild dormBuild) {
        int i = dormBuildService.addNewBuilding(dormBuild);
        return i == 1 ? Result.success("添加成功") : Result.error("添加失败");
    }

    /**
     * 楼宇信息更新
     */
    @PutMapping("/update")
    public Result update(@RequestBody DormBuild dormBuild) {
        int i = dormBuildService.updateNewBuilding(dormBuild);
        return i == 1 ? Result.success("更新成功") : Result.error("更新失败");
    }

    /**
     * 楼宇删除
     */
    @DeleteMapping("/delete/{dormBuildId}")
    public Result delete(@PathVariable Integer dormBuildId) {
        int i = dormBuildService.deleteBuilding(dormBuildId);
        return i == 1 ? Result.success("删除成功") : Result.error("删除失败");
    }


    /**
     * 首页Echarts 获取楼宇信息
     */
    @GetMapping("/getBuildingName")
    public Result getBuildingName() {
        List<DormBuild> buildingName = dormBuildService.getBuildingId();
        return Result.success(buildingName);
    }
}
