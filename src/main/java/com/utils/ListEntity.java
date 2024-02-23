package com.utils;

import lombok.Data;

import java.util.List;

@Data
public class ListEntity<T> {

    private int count;
    private List<T> list;

    public ListEntity() {
    }

    public ListEntity(Integer count) {
        this.count = count;
    }

    public ListEntity(List<T> list) {
        this.count = list != null ? list.size() : 0;
        this.list = list;
    }

    public ListEntity(int count, List<T> list) {
        this.count = count;
        this.list = list;
    }
}
