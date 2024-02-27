package com.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.DormManagerMapper;
import com.model.DormManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class DormManagerService {

    /**
     * 注入DAO层对象
     */
    @Resource
    private DormManagerMapper dormManagerMapper;

    /**
     * 宿管查询
     */

    public DormManager selectDormManagerById(String id) {
        return dormManagerMapper.selectDormManagerById(id);
    }


    /**
     * 宿管分页
     */

    public PageInfo<DormManager> find(Integer pageNum, Integer pageSize, String search) {
        PageHelper.startPage((pageNum - 1) * pageSize, pageSize);
        List<DormManager> list = dormManagerMapper.find(search);
        return new PageInfo<>(list);
    }

    /**
     * 宿管新增
     */

    public int addNewDormManager(DormManager dormManager) {
        return dormManagerMapper.addNewDormManager(dormManager);
    }

    /**
     * 宿管信息更新
     */

    public int updateNewDormManager(DormManager dormManager) {
        return dormManagerMapper.updateDormManager(dormManager);
    }

    /**
     * 宿管删除
     */

    public int deleteDormManager(String username) {
        return dormManagerMapper.deleteDormManager(username);

    }
}
