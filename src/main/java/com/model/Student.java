package com.model;

import lombok.Data;

/**
 * 学生实体类
 */
@Data
public class Student {
    String id;
    String password;
    String name;
    int age;
    String sex;
    String phone;
    String roomNo;
    int flag = 1;
}
