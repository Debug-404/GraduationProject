package com.model;

import lombok.Data;
import lombok.ToString;

/**
 * 宿舍管理员
 */
@Data
@ToString(callSuper = true)
public class DormManager extends User {
    private int dormBuildId;
}
