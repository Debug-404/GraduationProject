package com.mapper;

import com.model.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface NoticeMapper {
    //新增通知
    int addNewNotice(Notice notice);

    //查询
    List<Notice> find(String search);

    //更新通知信息
    int updateNewNotice(Notice notice);

    //删除通知
    int deleteNotice(Integer id);

    // 首页通知展示
    List<Notice> homePageNotice();
}
