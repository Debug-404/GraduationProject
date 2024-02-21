package com.service;

import com.mapper.NoticeMapper;
import com.model.Notice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
