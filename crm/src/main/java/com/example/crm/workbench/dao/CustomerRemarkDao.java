package com.example.crm.workbench.dao;

import com.example.crm.workbench.domain.CustomerRemark;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CustomerRemarkDao {

    int save(CustomerRemark customerRemark);
}
