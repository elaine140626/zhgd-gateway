package com.hujiang.project.zhgd.inOut;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/inOutKanBan")
public class inOutKanBan {
    private Logger logger = Logger.getLogger(inOutKanBan.class.getName());
    @Autowired
    private SystemClient client;
    /**
     * 实名制进出看板
     */
    @PostMapping("/selectIndex")
    public AjaxResult selectIndex(String  pid){
        if("".equals(pid)||pid==null||"null".equals(pid)){
            return null;
        }
        logger.info("实名制进出看板接口开始----/provider/inOutKanBan/selectIndex===="+pid);
        return client.inOutKanBanSelectIndex(Integer.valueOf(pid));
    }
    /**
     * 实名制电视看板
     */
    @PostMapping("/selectTV")
    public AjaxResult selectTV(Integer pid){
        logger.info("实名制电视看板接口开始----/provider/inOutKanBan/selectTV");
        return client.selectTV(pid);
    }

}
