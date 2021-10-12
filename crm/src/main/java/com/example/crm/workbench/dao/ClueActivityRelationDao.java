package com.example.crm.workbench.dao;

import com.example.crm.workbench.domain.ClueActivityRelation;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClueActivityRelationDao {


    int unbund(String id);

    int bund(ClueActivityRelation car);

    List<ClueActivityRelation> getListByClueId(String clueId);

    int delete(ClueActivityRelation clueActivityRelation);
}
