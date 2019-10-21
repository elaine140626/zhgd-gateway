package com.hujiang.project.zhgd.sbEquipmentWarning.domain;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/pcEquipmentWarning",method = RequestMethod.POST)
public class PcEquipmentWarning {

    @Autowired
    private SystemClient systemClient;
    @PostMapping("/warningCount")
    public JSONObject warningCount(@RequestParam(value = "projectId") Integer projectId){

        return systemClient.warningCount(projectId);
    }
    @PostMapping("/getWarningList")
    public JSONObject getWarningList(@RequestParam(value = "userName",required = false)String userName,
                                     @RequestParam(value = "userId",required = false)Integer userId,
                                     @RequestParam(value = "areaName",required = false)String areaName,
                                     @RequestParam(value = "areaId",required =  false)Integer areaId,
                                     @RequestParam(value = "projectId",required = false)Integer projectId,
                                     @RequestParam(value = "warningType",required = false)Integer warningType,
                                     @RequestParam(value = "startTime",required = false)String startTime,
                                     @RequestParam(value = "endTime",required = false)String endTime,
                                     @RequestParam(value = "pageSize",required = false)Integer pageSize,
                                     @RequestParam(value = "pageNum",required = false)Integer pageNum){

        return systemClient.getWarningList(userName,userId,areaName,areaId,projectId,warningType,startTime,endTime,pageSize,pageNum);
    }
}
