package com.example.crm.workbench.dao;

import com.example.crm.workbench.domain.ClueRemark;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClueRemarkDao {

    List<ClueRemark> getListByClueId(String clueId);

    int delete(ClueRemark clueRemark);
}
