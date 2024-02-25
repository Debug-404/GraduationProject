package com.mapper;

import com.model.Worker;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WorkerMapper {
    List<Worker> find(String search);

    Worker selectRepairById(String id);

    //接单最少数
    Worker minRepairNum();

    int addNewDormManager(Worker worker);

    int updateNewDormManager(Worker worker);

    int deleteDormManager(String id);
}
