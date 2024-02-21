package com.model;

import lombok.Data;

@Data
public class User {
    protected String id;
    protected String password;
    protected String name;
    protected String sex;
    protected int age;
    protected String phone;
    protected String identity;
}
