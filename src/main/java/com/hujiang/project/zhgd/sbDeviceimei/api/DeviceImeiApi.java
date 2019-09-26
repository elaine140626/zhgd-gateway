package com.hujiang.project.zhgd.sbDeviceimei.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.sbDeviceimei.domain.SbDeviceimei;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/deviceImeiApi",method = RequestMethod.POST)
public class DeviceImeiApi {
    @Autowired
    private SystemClient systemClient;

//    @PostMapping("/addDeviceImei")
//    @ResponseBody
//    public JSONObject addDeviceImei(@RequestBody SbDeviceimei sbDeviceimei){
//    return systemClient.addDeviceImei(sbDeviceimei);
//    }
}
