package com.mapper;

import com.model.DormBuild;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface DormBuildMapper {

    //新增楼宇
    int addNewBuilding(DormBuild dormBuild);

    //查询楼宇
    List<DormBuild> find(Map<String, Object> map);

    //更新楼宇信息
    int updateNewBuilding(DormBuild dormBuild);

    //删除楼宇信息
    int deleteBuilding(Integer id);

    List<DormBuild> getBuildingId();
}
