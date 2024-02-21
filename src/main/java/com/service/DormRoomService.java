package com.service;

import com.mapper.DormRoomMapper;
import com.model.DormRoom;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class DormRoomService {

    @Resource
    DormRoomMapper dormRoomMapper;

    //统计没有住满的宿舍数量
    int notFullRoom() {
        return 1;
    }

    //新增宿舍
    int addNewRoom(DormRoom dormRoom) {
        return dormRoomMapper.addNewRoom(dormRoom);
    }

    //更新宿舍信息
    int updateNewRoom(DormRoom dormRoom) {
        return dormRoomMapper.updateNewRoom(dormRoom);
    }

    //删除宿舍信息
    int deleteRoom(Integer dormRoomId) {
        return dormRoomMapper.deleteRoom(dormRoomId);
    }

    //主页 住宿人数
    Long selectHaveRoomStuNum() {
        return dormRoomMapper.selectHaveRoomStuNum();
    }

    //获取每栋宿舍学生总人数
    Long getEachBuildingStuNum(int dormBuildId) {
        return dormRoomMapper.getEachBuildingStuNum(dormBuildId);
    }
}
