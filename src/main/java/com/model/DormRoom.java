package com.model;

import lombok.Data;

/**
 * 宿舍房间
 */
@Data
public class DormRoom {
    //宿舍房间号
    private Integer dormRoomId;
    //宿舍楼号
    private int dormBuildId;
    //楼层
    private int floorNum;
    //房间最大入住人数
    private int maxCapacity;
    //当前房间入住人数
    private int currentCapacity;
}
