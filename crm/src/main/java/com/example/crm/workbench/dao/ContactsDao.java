package com.example.crm.workbench.dao;

import com.example.crm.workbench.domain.Contacts;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContactsDao {

    int save(Contacts con);
}
