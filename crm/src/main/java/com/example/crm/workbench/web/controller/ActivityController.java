package com.example.crm.workbench.web.controller;

import com.example.crm.service.UserService;
import com.example.crm.settings.dao.TblUserMapper;
import com.example.crm.settings.domain.TblUser;
import com.example.crm.utils.DateTimeUtil;
import com.example.crm.utils.UUIDUtil;
import com.example.crm.vo.PaginationVo;
import com.example.crm.workbench.domain.TblActivity;
import com.example.crm.workbench.domain.TblActivityRemark;
import com.example.crm.workbench.service.ActivityService;
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
public class ActivityController {
    @Autowired
    UserService us;
    @Autowired
    ActivityService as;
    @RequestMapping("getUserList.do")
    @ResponseBody
    public List<TblUser> getlist(){
        List<TblUser> tblUserList = us.getUserList();
        return tblUserList;
    }
    @RequestMapping("save.do")
    @ResponseBody
    public Object addActivity(TblActivity activity,HttpSession session){
        activity.setId(UUIDUtil.getUUID());
        activity.setCreatetime(DateTimeUtil.getSysTime());
        TblUser user =(TblUser)(session.getAttribute("user"));
        activity.setCreateby(user.getName());
        boolean flag = as.save(activity);
        String str = "{\"success\":"+flag+"}";
        return str;
    }
    @RequestMapping("pageList.do")
    @ResponseBody
    public Object pageList(String name,String owner,String startdate,String enddate,String pageNoStr,String pageSizeStr){
        int pageNo = Integer.parseInt(pageNoStr);
        int pageSize = Integer.parseInt(pageSizeStr);
        int skipCount = (pageNo-1)*pageSize;
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name",name);
        map.put("owner",owner);
        map.put("stardate",startdate);
        map.put("enddate",enddate);
        map.put("skipCount",skipCount);
        map.put("pageSize",pageSize);
        PaginationVo<TblActivity> vo = as.pageList(map);
        return vo;
    }
    @RequestMapping("delete.do")
    @ResponseBody
    public Object delete(String[] id){
        boolean flag = as.delete(id);
        String json = "{\"success\":"+flag+"}";
        return json;
    }
    @RequestMapping("getUserListAndActivity.do")
    @ResponseBody
    public Object getUserandList(String id){
        Map<String,Object> map = as.getUserListAndActivity(id);
        return map;
    }
    @RequestMapping("update.do")
    @ResponseBody
    public Object updateActivity(TblActivity activity,HttpSession session){
        activity.setEdittime(DateTimeUtil.getSysTime());
        TblUser user =(TblUser)(session.getAttribute("user"));
        activity.setEditby(user.getName());
        boolean flag = as.update(activity);
        String str = "{\"success\":"+flag+"}";
        return str;
    }
    @RequestMapping("/workbench/activity/detail")
    public ModelAndView s4(String id ){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("workbench/activity/detail");
        TblActivity a = as.detail(id);
        mv.addObject("a",a);
        return mv;
    }
    @RequestMapping("getRemarkListByAid.do")
    @ResponseBody
    public Object getRemarkListByAid(String activityId){
        List<TblActivityRemark> arList = as.getRemarkListByAid(activityId);
        return arList;
    }
    @RequestMapping("deleteRemark.do")
    @ResponseBody
    public Object deleteRemark(String id){
        boolean flag = as.deleteRemark(id);
        Map<String,Boolean> map = new HashMap<>();
        map.put("success",flag);
        return map;
    }
    @RequestMapping("saveRemark.do")
    @ResponseBody
    public Object saveRemark(TblActivityRemark activityRemark){
        activityRemark.setId(UUIDUtil.getUUID());
        activityRemark.setCreatetime(DateTimeUtil.getSysTime());
        activityRemark.setEditflag("0");
        boolean flag = as.saveRemark(activityRemark);
        Map<String,Object> map=new HashMap<>();
        map.put("success",flag);
        map.put("ar",activityRemark);
        return map;
    }
    @RequestMapping("updateRemark.do")
    @ResponseBody
    public Object updateRemark(TblActivityRemark activityRemark,HttpSession session){
        activityRemark.setEdittime(DateTimeUtil.getSysTime());
        TblUser user = (TblUser)session.getAttribute("user");
        activityRemark.setEditby(user.getName());
        activityRemark.setEditflag("1");
        boolean flag = as.updateRemark(activityRemark);
        Map<String,Object> map=new HashMap<>();
        map.put("success",flag);
        map.put("ar",activityRemark);
        return map;
    }
}
