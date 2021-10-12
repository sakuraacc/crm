package com.example.crm.settings.dao;

import com.example.crm.settings.domain.DicValue;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DicValueDao {
    List<DicValue> getListByCode(String code);
}
