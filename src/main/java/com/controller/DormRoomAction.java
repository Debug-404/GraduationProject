package com.controller;

import com.mapper.DormRoomMapper;
import com.model.DormRoom;
import com.utils.Result;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/room")
public class DormRoomAction {
    @Resource
    DormRoomMapper dormRoomMapper;

    /**
     * 首页顶部：空宿舍统计
     */
    @GetMapping("/noFullRoom")
    public Result notFullRoom() {
        int i = dormRoomMapper.notFullRoom();
        return Result.success(i);
    }

    /**
     * 添加房间
     */
    @PostMapping("/add")

    public Result addNewRoom(@RequestBody DormRoom dormRoom) {
        int i = dormRoomMapper.addNewRoom(dormRoom);
        return Result.success(i);
    }

    /**
     * 更新房间
     */
    @PutMapping("/update")
    public Result updateNewRoom(@RequestBody DormRoom dormRoom) {
        int i = dormRoomMapper.updateNewRoom(dormRoom);
        return Result.success(i);
    }

    /**
     * 删除房间
     */
    @DeleteMapping("/delete/{dormRoomId}")
    public Result deleteRoom(@PathVariable Integer dormRoomId) {
        int i = dormRoomMapper.deleteRoom(dormRoomId);
        return Result.success(i);
    }

    /**
     * 主页 住宿人数
     */
    @GetMapping("/selectHaveRoomStuNum")
    public Result selectHaveRoomStuNum() {
        Long num = dormRoomMapper.selectHaveRoomStuNum();
        return Result.success(num);
    }

    /**
     * 住宿分布人数
     */
    @GetMapping("/getEachBuildingStuNum/{num}")
    public Result getEachBuildingStuNum(@PathVariable int num) {
        Long stuNum = dormRoomMapper.getEachBuildingStuNum(num);
        return Result.success(stuNum);
    }
}
