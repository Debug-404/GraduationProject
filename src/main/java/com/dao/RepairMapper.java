package com.dao;

import com.model.Repair;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RepairMapper {
    List<Repair> findAll();

    Repair selectRepairById(String id);
}