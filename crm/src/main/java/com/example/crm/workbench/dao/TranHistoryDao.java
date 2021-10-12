package com.example.crm.workbench.dao;

import com.example.crm.workbench.domain.TranHistory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TranHistoryDao {

    int save(TranHistory th);

    List<TranHistory> getHistoryListByTranId(String tranId);
}
