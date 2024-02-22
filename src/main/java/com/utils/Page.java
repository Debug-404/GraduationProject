package com.utils;

import java.util.HashMap;
import java.util.Map;

public class Page {
    public static Map<String, Integer> page(int currentPage, int pageSize) {
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", (currentPage - 1) * pageSize);
        map.put("pageSize", pageSize);
        return map;
    }
}
