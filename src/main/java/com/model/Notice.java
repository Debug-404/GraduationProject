package com.model;

import lombok.Data;

/**
 * 公告
 */

@Data
public class Notice {

    private int id;

    private String title;

    private String text;

    private String time;
}
