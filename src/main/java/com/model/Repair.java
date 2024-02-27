package com.model;

import lombok.Data;

/**
 * 报修单
 */
@Data
public class Repair {
    //单号
    int id;
    //学生学号
    String studentId;
    //学生姓名
    String studentName;
    //学生手机号
    String studentPhone;
    //报修宿舍楼
    int dormBuildId;
    //报修宿舍房间号
    int dormRoomId;
    //维修类型
    String type;
    //表单内容
    String content;
    //维修员
    String workerId;
    String workerName;
    //维修员手机号
    String workerPhone;
    //维修状态
    String state = "未完成";
    //订单创建时间
    String orderBuildTime;
    //订单完成时间
    String orderFinishTime;
    int finish;
    //评价
    String evaluate;
}
