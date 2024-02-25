package com.model;

import lombok.Data;
import lombok.ToString;

/**
 * 维修员实体类
 */
@Data
@ToString(callSuper = true)
public class Worker extends User {
    //接单数量
    int repairNum;
}
