package com.model;

import lombok.Data;

/**
 * 管理员实体类
 */
@Data
public class Admin {
    String id;
    String password;
    String name;
    String sex;
    String phone;
}
