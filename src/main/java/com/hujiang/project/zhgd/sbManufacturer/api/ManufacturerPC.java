package com.hujiang.project.zhgd.sbManufacturer.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.sbManufacturer.domain.SbManufacturer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/manufacturer" ,method =  RequestMethod.POST)
public class ManufacturerPC {

    @Autowired
    private SystemClient systemClient;

    @RequestMapping("/list")
    public JSONObject all(SbManufacturer sbManufacturer){
        return systemClient.allFirm(sbManufacturer);
    }

}
