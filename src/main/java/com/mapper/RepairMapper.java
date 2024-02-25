package com.mapper;

import com.model.Repair;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface RepairMapper {


    //显示订单数量
    int showOrderNum();

    //新增订单
    int addNewOrder(Repair repair);


    //更新订单信息
    int updateNewOrder(Repair repair);

    //删除订单
    int deleteOrder(Integer id);

    //查找订单
    List<Repair> find(String search);

    List<Repair> individualFind(@Param("search") String search, @Param("sId") String sId);
}