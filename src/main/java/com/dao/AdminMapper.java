package com.dao;

import com.model.Admin;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface AdminMapper {
    Admin selectAdminById(String id);

    //发布告示
    int intoNotice(Map<String, Object> map);

    //告示分页获取
    @MapKey("id")
    List<Map<String, Object>> findByLimit(Map<String, Object> map);
}
