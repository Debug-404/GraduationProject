package com.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.NoticeMapper;
import com.model.Notice;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class NoticeService {

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
    public PageInfo<Notice> find(Integer pageNum, Integer pageSize, String search) {
        PageHelper.startPage((pageNum - 1) * pageSize, pageSize);
        List<Notice> list = noticeMapper.find(search);
        return new PageInfo<>(list);
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
