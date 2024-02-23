package com.utils;

import lombok.Data;

@Data
public class PageParam {
    /**
     * 页码
     */
    private Integer pageNum = 1;

    /**
     * 每页条数
     */
    private Integer pageSize = 10;
    
    public Integer getPageStartIndex() {
        return (this.pageNum - 1) * this.pageSize;
    }
}
