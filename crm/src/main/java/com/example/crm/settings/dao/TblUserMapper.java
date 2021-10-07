package com.example.crm.settings.dao;

import com.example.crm.settings.domain.TblUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TblUserMapper {
    TblUser login(Map<String,String> map);
    int deleteByPrimaryKey(String id);
    int insert(TblUser record);
    int insertSelective(TblUser record);
    TblUser selectByPrimaryKey(String id);
    int updateByPrimaryKeySelective(TblUser record);
    int updateByPrimaryKey(TblUser record);

    List<TblUser> getUserList();
}