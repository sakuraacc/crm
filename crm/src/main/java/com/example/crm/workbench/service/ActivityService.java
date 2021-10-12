package com.example.crm.workbench.service;

import com.example.crm.vo.PaginationVo;
import com.example.crm.workbench.domain.TblActivity;
import com.example.crm.workbench.domain.TblActivityRemark;

import java.util.List;
import java.util.Map;

public interface ActivityService {


    boolean save(TblActivity activity);

    PaginationVo<TblActivity> pageList(Map<String, Object> map);

    boolean delete(String[] id);

    Map<String, Object> getUserListAndActivity(String id);

    boolean update(TblActivity activity);

    TblActivity detail(String id);

    List<TblActivityRemark> getRemarkListByAid(String activityId);

    boolean deleteRemark(String id);

    boolean saveRemark(TblActivityRemark activityRemark);

    boolean updateRemark(TblActivityRemark activityRemark);

    List<TblActivity> getActivityListByClueId(String clueId);

    List<TblActivity> getActivityListByNameAndNotByclueId(Map<String, String> map);

    List<TblActivity> getActivityListByName(String aname);
}
