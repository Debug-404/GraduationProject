package com.model;

import lombok.Data;

/**
 * 报修单
 */
@Data
public class Repair {
    //单号
    private int id;
    //学生学号
    private String sId;
    //学生姓名
    private String sName;
    //学生手机号
    private String sPhone;
    //报修宿舍楼
    private int dormBuildId;
    //报修宿舍房间号
    private int dormRoomId;
    //维修类型
    private String type;
    //表单内容
    private String content;
    //维修员
    private String repairer;
    private String rName;
    //维修员手机号
    private String rPhone;
    //维修状态
    private String state;
    //订单创建时间
    private String orderBuildTime;
    //订单完成时间
    private String orderFinishTime;
    private String finish;
}
