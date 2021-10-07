package com.example.crm.service;

import com.example.crm.exception.LoginException;
import com.example.crm.settings.domain.TblUser;

import java.util.List;

public interface UserService {
 TblUser login(String loginAct,String loginPwd,String ip) throws LoginException;

    List<TblUser> getUserList();
}
