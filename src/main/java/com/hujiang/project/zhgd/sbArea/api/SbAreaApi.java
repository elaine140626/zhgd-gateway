package com.hujiang.project.zhgd.sbArea.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.sbArea.domain.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/areaApi",method = RequestMethod.POST)
public class SbAreaApi {
    @Autowired
    private SystemClient systemClient;

//    @PostMapping("/addArea")
//    @ResponseBody
//    public JSONObject addArea(@RequestBody Area sbArea){
//        return systemClient.addArea(sbArea);
//    }
}
