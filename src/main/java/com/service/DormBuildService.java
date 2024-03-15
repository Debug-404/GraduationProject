package com.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.DormBuildMapper;
import com.model.DormBuild;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DormBuildService {
    @Resource
    DormBuildMapper dormBuildMapper;

    /**
     * 新增楼宇
     */
    public int addNewBuilding(DormBuild dormBuild) {
        return dormBuildMapper.addNewBuilding(dormBuild);
    }

    /**
     * 更新楼宇信息
     */
    public int updateNewBuilding(DormBuild dormBuild) {
        return dormBuildMapper.updateNewBuilding(dormBuild);
    }

    /**
     * 删除楼宇信息
     */
    public int deleteBuilding(Integer id) {
        return dormBuildMapper.deleteBuilding(id);
    }

    /**
     * 首页Echarts 获取楼宇信息
     */
    public List<DormBuild> getBuildingId() {
        return dormBuildMapper.getBuildingId();
    }

    /**
     * 楼宇查找
     */
    public PageInfo<DormBuild> find(Integer pageNum, Integer pageSize, String search) {
        PageHelper.startPage((pageNum - 1) * pageSize, pageSize);
        List<DormBuild> list = dormBuildMapper.find(search);
        return new PageInfo<>(list);
    }
}
