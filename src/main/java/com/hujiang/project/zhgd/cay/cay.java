package com.hujiang.project.zhgd.cay;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api",method = RequestMethod.POST)
public class cay {

    @Autowired
    private SystemClient client;

    @RequestMapping(value = "/cay",method = RequestMethod.POST)
    public JSONObject cay(Integer projectId){
        return client.cay(projectId);
    }

    @RequestMapping(value = "/caySbDelete")
    public JSONObject delete(String sn,String xmid,String devType,String devCcrq,String subId){
        return client.deletecay(sn,xmid,devType,devCcrq,subId);
    }
}
