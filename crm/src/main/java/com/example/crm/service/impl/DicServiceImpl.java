package com.example.crm.service.impl;

import com.example.crm.service.DicService;
import com.example.crm.settings.dao.DicTypeDao;
import com.example.crm.settings.dao.DicValueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DicServiceImpl implements DicService {
    @Autowired
    private DicTypeDao dicTypeDao;
    @Autowired
    private DicValueDao dicValueDao;
}
