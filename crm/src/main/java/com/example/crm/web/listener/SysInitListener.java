package com.example.crm.web.listener;

import com.example.crm.service.DicService;
import com.example.crm.settings.domain.DicValue;
import com.example.crm.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;
import java.util.Map;

@WebListener
@Component
public class SysInitListener implements ServletContextListener {
    @Autowired
    RedisUtil cache;
    @Autowired
    DicService ds;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        Map<String, List<DicValue>> map = ds.getAll();
        for (String key : map.keySet()) {
            cache.set("map",key,map.get(key));
        }
        cache.set("01资质审查","10");
        cache.set("02需求分析","25");
        cache.set("03价值建议","40");
        cache.set("04确定决策者","60");
        cache.set("05提案/报价","80");
        cache.set("06谈判/复审","90");
        cache.set("07成交","100");
        cache.set("08丢失的线索","0");
        cache.set("09因竞争丢失关闭","0");

    }
}