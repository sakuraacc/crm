package com.example.crm.workbench.dao;

import com.example.crm.workbench.domain.ContactsActivityRelation;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContactsActivityRelationDao {

    int save(ContactsActivityRelation contactsActivityRelation);
}
