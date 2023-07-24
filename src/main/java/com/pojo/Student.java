package com.pojo;

import lombok.Data;

/**
 * 学生实体类
 */
@Data
public class Student {
    private String id;
    private String password;
    private String name;
    private String phone;
    private String roomNo;
}
