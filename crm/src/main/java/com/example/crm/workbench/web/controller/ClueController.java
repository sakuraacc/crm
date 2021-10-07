package com.example.crm.workbench.web.controller;

import com.example.crm.workbench.service.ClueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClueController {
    @Autowired
    private ClueService clueService;
}
