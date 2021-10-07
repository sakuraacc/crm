package com.example.crm.workbench.service.impl;

import com.example.crm.settings.dao.TblUserMapper;
import com.example.crm.settings.domain.TblUser;
import com.example.crm.vo.PaginationVo;
import com.example.crm.workbench.dao.TblActivityMapper;
import com.example.crm.workbench.dao.TblActivityRemarkMapper;
import com.example.crm.workbench.domain.TblActivity;
import com.example.crm.workbench.domain.TblActivityRemark;
import com.example.crm.workbench.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityServiceImple implements ActivityService {
    @Autowired
    private TblUserMapper userDao;
    @Autowired
    private TblActivityMapper activityMapper;
    @Autowired
    private TblActivityRemarkMapper activityRemarkMapper;

    @Override
    public boolean save(TblActivity activity) {
        int count = activityMapper.insert(activity);
        return count==1;
    }

    @Override
    public PaginationVo<TblActivity> pageList(Map<String, Object> map) {
        int total = activityMapper.getTotalByCondition(map);
        List<TblActivity> list = activityMapper.getActivityListByCondition(map);
        PaginationVo<TblActivity> vo = new PaginationVo<>();
        vo.setTotal(total);
        vo.setDataList(list);
        return vo;
    }

    @Override
    public boolean delete(String[] id) {
        boolean flag = true;
        int count1 = activityRemarkMapper.selectByActivityId(id);
        int count2 = activityRemarkMapper.deleteByActivityId(id);
        if(count1!=count2){
            flag = false;
        }
        int count3 = activityMapper.deleteByIds(id);
        if(count3!=id.length){
            flag = false;
        }
        return flag;
    }

    @Override
    public Map<String, Object> getUserListAndActivity(String id) {
        List<TblUser> uList = userDao.getUserList();
        TblActivity a = activityMapper.selectByPrimaryKey(id);
        Map<String,Object> map = new HashMap<>();
        map.put("uList",uList);
        map.put("a",a);
        return map;
    }

    @Override
    public boolean update(TblActivity activity) {
        int count = activityMapper.update(activity);
        return count==1;
    }

    @Override
    public TblActivity detail(String id) {
        TblActivity a = activityMapper.detail(id);
        return a;
    }

    @Override
    public List<TblActivityRemark> getRemarkListByAid(String activityId) {
        List<TblActivityRemark> arList = activityRemarkMapper.getRemarkListByAid(activityId);
        return arList;
    }

    @Override
    public boolean deleteRemark(String id) {
        int count = activityRemarkMapper.deleteByPrimaryKey(id);
        return count==1;
    }

    @Override
    public boolean saveRemark(TblActivityRemark activityRemark) {
        int count = activityRemarkMapper.insertSelective(activityRemark);
        return count==1;
    }

    @Override
    public boolean updateRemark(TblActivityRemark activityRemark) {
        int count = activityRemarkMapper.updateByPrimaryKeySelective(activityRemark);
        return count==1;
    }

}
