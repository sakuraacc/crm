package com.example.crm;

import com.example.crm.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Text01 {
    @Autowired
    RedisUtil redisUtil;
    @RequestMapping("text01.do")
    @ResponseBody
    public String text01(){
    return "0";
    }
}
