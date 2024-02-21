package com.mapper;

import com.model.Worker;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface WorkerMapper {
    List<Worker> findAll();

    Worker selectRepairById(String id);
}
