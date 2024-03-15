package com.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.DormRoomMapper;
import com.model.DormRoom;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DormRoomService {

    @Resource
    DormRoomMapper dormRoomMapper;

    //统计没有住满的宿舍数量
    public int notFullRoom() {
        return dormRoomMapper.notFullRoom();
    }

    /**
     * 新增宿舍
     */
    public int addNewRoom(DormRoom dormRoom) {
        return dormRoomMapper.addNewRoom(dormRoom);
    }

    /**
     * 更新宿舍信息
     */
    public int updateNewRoom(DormRoom dormRoom) {
        return dormRoomMapper.updateNewRoom(dormRoom);
    }

    /**
     * 删除宿舍信息
     */
    public int deleteRoom(Integer dormRoomId) {
        return dormRoomMapper.deleteRoom(dormRoomId);
    }

    /**
     * 主页 住宿人数
     */
    public Long selectHaveRoomStuNum() {
        return dormRoomMapper.selectHaveRoomStuNum();
    }

    /**
     * 获取每栋宿舍学生总人数
     */
    public Long getEachBuildingStuNum(int dormBuildId) {
        return dormRoomMapper.getEachBuildingStuNum(dormBuildId);
    }

    /**
     * 查找房间
     */
    public PageInfo<DormRoom> find(Integer pageNum, Integer pageSize, String search) {
        PageHelper.startPage((pageNum - 1) * pageSize, pageSize);
        List<DormRoom> list = dormRoomMapper.find(search);
        return new PageInfo<>(list);
    }
}
