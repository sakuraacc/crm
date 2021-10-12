package com.example.crm.settings.dao;

import com.example.crm.settings.domain.DicType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DicTypeDao {
    List<DicType> getTypeList();
}
