package com.example.crm.web.controller;

import com.example.crm.service.UserService;
import com.example.crm.service.impl.UserServiceImpl;
import com.example.crm.settings.domain.TblUser;
import com.example.crm.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl us;
    @RequestMapping(value="login.do",method = RequestMethod.POST)
    public @ResponseBody Map<String, Object> login(HttpServletRequest req, HttpSession session){
        String loginAct = req.getParameter("loginAct");
        String loginPwd = req.getParameter("loginPwd");
        loginPwd= MD5Util.getMD5(loginPwd);
        String ip=req.getRemoteAddr();
        try {
            TblUser user=us.login(loginAct,loginPwd,ip);
            session.setAttribute("user",user);
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("success",true);
            return map;

        }catch (Exception e){
            e.printStackTrace();
            Map<String,Object> map=new HashMap<String,Object>();
            String msg=e.getMessage();
            map.put("success",false);
            map.put("msg",msg);
            return map;

        }
    }
}
