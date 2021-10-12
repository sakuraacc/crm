package com.example.crm.workbench.dao;

import com.example.crm.workbench.domain.Tran;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface TranDao {

    int save(Tran t);

    Tran detail(String id);

    int getTotal();

    List<Map<String, Object>> getChars();
}
