package com.model;

import lombok.Data;
import lombok.ToString;

/**
 * 学生实体类
 */
@Data
@ToString(callSuper = true)
public class Student extends User {
    int age;
    String roomNo;
    int flag = 1;
}
