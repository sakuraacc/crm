package com.example.crm.service.impl;

import com.example.crm.exception.LoginException;
import com.example.crm.service.UserService;
import com.example.crm.settings.dao.TblUserMapper;
import com.example.crm.settings.domain.TblUser;
import com.example.crm.utils.DateTimeUtil;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private TblUserMapper userDao;
    @Override
    public TblUser login(String loginAct, String loginPwd, String ip) throws LoginException {
        Map<String,String> map = new HashMap<String,String>();
        map.put("loginAct",loginAct);
        map.put("loginPwd",loginPwd);
        TblUser user = userDao.login(map);
        if(user==null){
            throw new LoginException("账号密码错误");
        }
        String expiretime=user.getExpiretime();
        String currentTime= DateTimeUtil.getSysTime();
        if(expiretime.compareTo(currentTime)<0){
            throw new LoginException("账号失效");
        }
        String lockState = user.getLockstate();
        if("0".equals(lockState)){
            throw new LoginException("账号已锁定");
        }
//        String allowIps=user.getAllowips();
//        if(!allowIps.contains(ip)){
//            throw new LoginException("ip地址受限");
//        }
        return user;
    }

    @Override
    public List<TblUser> getUserList() {
        List<TblUser> tblUserList = userDao.getUserList();
        return tblUserList;
    }
}
