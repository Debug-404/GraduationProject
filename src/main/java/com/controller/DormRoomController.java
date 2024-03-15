package com.controller;

import com.annotation.RequestLog;
import com.github.pagehelper.PageInfo;
import com.model.DormRoom;
import com.service.DormRoomService;
import com.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;

@RestController
@RequestMapping("/room")
public class DormRoomController {
    @Resource
    DormRoomService dormRoomService;


    /**
     * 查找房间
     */
    @RequestLog
    @GetMapping("/find")
    public Result findPage(@RequestParam(defaultValue = "1") Integer pageNum,
                           @RequestParam(defaultValue = "10") Integer pageSize,
                           @RequestParam(defaultValue = "") String search) {
        PageInfo<DormRoom> page = dormRoomService.find(pageNum, pageSize, search);
        return page != null ? Result.success(page) : Result.error("查询失败");
    }

    /**
     * 首页顶部：空宿舍统计
     */
    @RequestLog
    @GetMapping("/noFullRoom")
    public Result notFullRoom() {
        int i = dormRoomService.notFullRoom();
        return Result.success(i);
    }

    /**
     * 添加房间
     */
    @RequestLog
    @PostMapping("/add")
    public Result addNewRoom(@RequestBody DormRoom dormRoom) {
        int i = dormRoomService.addNewRoom(dormRoom);
        return Result.success(i);
    }

    /**
     * 更新房间
     */
    @RequestLog
    @PutMapping("/update")
    public Result updateNewRoom(@RequestBody DormRoom dormRoom) {
        int i = dormRoomService.updateNewRoom(dormRoom);
        return Result.success(i);
    }

    /**
     * 删除房间
     */
    @RequestLog
    @DeleteMapping("/delete/{dormRoomId}")
    public Result deleteRoom(@PathVariable Integer dormRoomId) {
        int i = dormRoomService.deleteRoom(dormRoomId);
        return Result.success(i);
    }

    /**
     * 主页 住宿人数
     */
    @RequestLog
    @GetMapping("/selectHaveRoomStuNum")
    public Result selectHaveRoomStuNum() {
        Long num = dormRoomService.selectHaveRoomStuNum();
        return Result.success(num);
    }

    /**
     * 住宿分布人数
     */
    @RequestLog
    @GetMapping("/getEachBuildingStuNum/{num}")
    public Result getEachBuildingStuNum(@PathVariable int num) {
        ArrayList<Long> arrayList = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            Long eachBuildingStuNum = dormRoomService.getEachBuildingStuNum(i);
            arrayList.add(eachBuildingStuNum);
        }
        return Result.success(arrayList);
    }
}
