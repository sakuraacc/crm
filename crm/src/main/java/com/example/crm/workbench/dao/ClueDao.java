package com.example.crm.workbench.dao;

import com.example.crm.workbench.domain.Clue;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClueDao {


    int save(Clue c);

    Clue detail(String id);

    Clue getById(String clueId);

    int delete(String clueId);
}
