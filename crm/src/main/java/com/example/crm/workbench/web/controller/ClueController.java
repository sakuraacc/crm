package com.example.crm.workbench.web.controller;

import com.example.crm.service.UserService;
import com.example.crm.settings.domain.DicValue;
import com.example.crm.settings.domain.TblUser;
import com.example.crm.utils.DateTimeUtil;
import com.example.crm.utils.RedisUtil;
import com.example.crm.utils.UUIDUtil;
import com.example.crm.workbench.domain.Clue;
import com.example.crm.workbench.domain.ClueActivityRelation;
import com.example.crm.workbench.domain.TblActivity;
import com.example.crm.workbench.domain.Tran;
import com.example.crm.workbench.service.ActivityService;
import com.example.crm.workbench.service.ClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ClueController {
    @Autowired
    private ClueService cs;
    @Autowired
    private UserService us;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ActivityService as;
    @RequestMapping("/workbench/clue/getUserList.do")
    @ResponseBody
    public Object getUserList(){
        List<TblUser> uList = us.getUserList();
        List<DicValue> appellation = (List<DicValue>) redisUtil.get("map","appellationList");
        List<DicValue> clueState = (List<DicValue>) redisUtil.get("map","clueStateList");
        List<DicValue> source = (List<DicValue>) redisUtil.get("map","sourceList");
        Map<String,Object> map = new HashMap<>();
        map.put("uList",uList);
        map.put("appellation",appellation);
        map.put("clueState",clueState);
        map.put("source",source);
        return map;
    }
    @RequestMapping("workbench/clue/save.do")
    @ResponseBody
    public Object save(Clue c, HttpSession session){
        c.setId(UUIDUtil.getUUID());
        c.setCreateTime(DateTimeUtil.getSysTime());
        TblUser user = (TblUser)session.getAttribute("user");
        c.setCreateBy(user.getName());
        boolean flag = cs.save(c);
        Map<String,Boolean> map = new HashMap<>();
        map.put("success",flag);
        return  map;

    }
    @RequestMapping("/workbench/clue/detail.do")
    public ModelAndView detail(String id){
        Clue c = cs.detail(id);
        ModelAndView mv = new ModelAndView();
        mv.addObject("c",c);
        mv.setViewName("workbench/clue/detail");
        return mv;
    }
    @RequestMapping("workbench/clue/getActivityListByClueId.do")
    @ResponseBody
    public Object getActivityListByClueId(String clueId){
        List<TblActivity> aList = as.getActivityListByClueId(clueId);
        return aList;
    }
    @RequestMapping("/workbench/clue/unbund.do")
    @ResponseBody
    public Object unbund(String id){
        boolean flag = cs.unboud(id);
        Map<String,Boolean> map = new HashMap<>();
        map.put("success",flag);
        return map;
    }
    @RequestMapping("/workbench/clue/getActivityListByNameAndNotByclueId.do")
    @ResponseBody
    public Object getActivityListByNameAndNotByclueId(String aname,String clueId){
        Map<String,String> map = new HashMap<>();
        map.put("aname",aname);
        map.put("clueId",clueId);
        List<TblActivity> aList = as.getActivityListByNameAndNotByclueId(map);
        return aList;
    }
    @RequestMapping("/workbench/clue/bund.do")
    @ResponseBody
    public  Object bunddo(String cid,String[] aids){
        boolean flag = cs.bund(cid,aids);
        Map<String,Boolean> map = new HashMap<>();
        map.put("success",flag);
        return map;
    }
    @RequestMapping("/workbench/clue/convert")
    public ModelAndView s9(String id,String fullname,String appellation,String company,String owner){
        ModelAndView mv = new ModelAndView();
        mv.addObject("id",id);
        mv.addObject("fullname",fullname);
        mv.addObject("appellation",appellation);
        mv.addObject("company",company);
        mv.addObject("owner",owner);
        mv.setViewName("workbench/clue/convert");
    return mv;
    }
    @RequestMapping("/workbench/clue/redis")
    @ResponseBody
    public Object Redis(){
        List<DicValue> list = (List<DicValue>) redisUtil.get("map","stageList");
        return list;

    }
    @RequestMapping("/workbench/clue/getActivityListByName.do")
    @ResponseBody
    public Object getActivityListByName(String aname){
        List<TblActivity> aList = as.getActivityListByName(aname);
        return aList;
    }
    @RequestMapping("/workbench/clue/convert.do")
    public ModelAndView convert(HttpSession session,String flag,String clueId,String money,String name,String expectedDate,String stage,String activityId){
        ModelAndView mv = new ModelAndView();
        Tran t = null;
        TblUser user = (TblUser)session.getAttribute("user");
        String createBy = user.getName();
        if("a".equals(flag)){
            t = new Tran();
            t.setId(UUIDUtil.getUUID());
            t.setMoney(money);
            t.setName(name);
            t.setExpectedDate(expectedDate);
            t.setStage(stage);
            t.setActivityId(activityId);
            t.setCreateBy(user.getName());
            t.setCreateTime(DateTimeUtil.getSysTime());
        }
        boolean flag1 = cs.convert(clueId,t,createBy);
        mv.setViewName("workbench/clue/index");
        return mv;
    }
}
