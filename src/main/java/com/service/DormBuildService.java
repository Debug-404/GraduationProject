package com.service;

import com.mapper.DormBuildMapper;
import com.model.DormBuild;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DormBuildService {
    @Resource
    DormBuildMapper dormBuildMapper;

    //新增楼宇
    public int addNewBuilding(DormBuild dormBuild) {
        return dormBuildMapper.addNewBuilding(dormBuild);
    }

    //更新楼宇信息
    public int updateNewBuilding(DormBuild dormBuild) {
        return dormBuildMapper.updateNewBuilding(dormBuild);
    }

    //删除楼宇信息
    public int deleteBuilding(Integer id) {
        return dormBuildMapper.deleteBuilding(id);
    }

    public List<DormBuild> getBuildingId() {
        return dormBuildMapper.getBuildingId();
    }
}
