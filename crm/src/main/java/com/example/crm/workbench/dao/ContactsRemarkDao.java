package com.example.crm.workbench.dao;

import com.example.crm.workbench.domain.ContactsRemark;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContactsRemarkDao {

    int save(ContactsRemark contactsRemark);
}
