package com.model;

import lombok.Data;

/**
 * 宿舍楼
 */
@Data
public class DormBuild {
    //id
    private Integer id;
    //宿舍楼号码
    private int dormBuildId;
    //宿舍楼名称
    private String dormBuildName;
    //宿舍楼备注
    private String dormBuildDetail;
}
