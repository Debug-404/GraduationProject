package com.mapper;

import com.model.DormManager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DormManagerMapper {

    //宿管登陆
    DormManager selectDormManagerById(String id);

    //新增宿管
    int addNewDormManager(DormManager dormManager);

    //查询宿管
    List<DormManager> find(String search);

    //更新宿管信息
    int updateDormManager(DormManager dormManager);

    //删除宿管信息
    int deleteDormManager(String username);
}
