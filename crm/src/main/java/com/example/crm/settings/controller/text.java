package com.example.crm.settings.controller;

import com.example.crm.settings.dao.TblUserMapper;
import com.example.crm.settings.domain.TblUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class text {
    @RequestMapping("/login")
    public String login1(){
        return "login";
    }
    @RequestMapping("/workbench/index")
    public String s1(){
        return "workbench/index";
    }
    @RequestMapping("/workbench/main/index")
    public String s2(){
        return "workbench/main/index";
    }
    @RequestMapping("/workbench/activity/index")
    public String s3(){
        return "workbench/activity/index";
    }

    @RequestMapping("/workbench/clue/index")
    public String s4(){
        return "workbench/clue/index";
    }
    @RequestMapping("/workbench/customer/index")
    public String s5(){
        return "workbench/customer/index";
    }
    @RequestMapping("/workbench/contacts/index")
    public String s6(){
        return "workbench/contacts/index";
    }
    @RequestMapping("/workbench/transaction/index")
    public String s7(){
        return "workbench/transaction/index";
    }
    @RequestMapping("/workbench/visit/index")
    public String s8(){
        return "workbench/visit/index";
    }
    @RequestMapping("/workbench/clue/detail")
    public String d1(){
        return "workbench/clue/detail";
    }
    @RequestMapping("/workbench/clue/convert")
    public String s9(){
        return "workbench/clue/convert";
    }
    @RequestMapping("/workbench/transaction/save")
    public String s10(){
        return "workbench/transaction/save";
    }
    @RequestMapping("/workbench/transaction/edit")
    public String s11(){
        return "workbench/transaction/edit";
    }
    @RequestMapping("/workbench/transaction/detail")
    public String s12(){
        return "workbench/transaction/detail";
    }

}
