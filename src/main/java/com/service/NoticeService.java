package com.service;

import com.mapper.NoticeMapper;
import com.model.Notice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NoticeService {
    /**
     * 注入DAO层对象
     */
    @Resource
    NoticeMapper noticeMapper;

    /**
     * 公告添加
     */

    public int addNewNotice(Notice notice) {
        return noticeMapper.addNewNotice(notice);
    }

    /**
     * 公告查找
     */
    public List<Notice> find(Integer startIndex, Integer pageSize, String search) {
        Map<String, Object> map = new HashMap<>();
        map.put("startIndex", startIndex);
        map.put("pageSize", pageSize);
        map.put("search", search);
        return noticeMapper.find(map);
    }

    /**
     * 公告更新
     */

    public int updateNewNotice(Notice notice) {
        return noticeMapper.updateNewNotice(notice);
    }

    /**
     * 公告删除
     */

    public int deleteNotice(Integer id) {
        return noticeMapper.deleteNotice(id);
    }

    /**
     * 首页公告展示
     */
    public List<Notice> homePageNotice() {
        return noticeMapper.homePageNotice();

    }
}
