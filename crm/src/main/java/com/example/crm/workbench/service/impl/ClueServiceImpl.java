package com.example.crm.workbench.service.impl;

import com.example.crm.workbench.dao.ClueDao;
import com.example.crm.workbench.service.ClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClueServiceImpl implements ClueService {
    @Autowired
    private ClueDao clueDao;
}
