package com.hujiang.project.zhgd.hjSafetyAbarbeitung.controller;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/optionsSafetyApi",method = RequestMethod.POST)
public class OptionsSafety {
    @Autowired
    private SystemClient systemClient;
    @PostMapping("/getOptionsList")
    public JSONObject getOptionsList(@RequestParam(value = "projectId")Integer projectId){
        return systemClient.getOptionsList(projectId);
    }
    @PostMapping("/getUserList")
    public JSONObject getUserList(@RequestParam(value = "projectId")Integer projectId){
        return systemClient.getUserList(projectId);
    }
    /**
     * 增加工业区
     * @return
     */
    @PostMapping("/addArea")
    public JSONObject addArea(@RequestParam("areaName")String areaName,
                              @RequestParam("address")String address,
                              @RequestParam("constructionId")Integer constructionId){

        return systemClient.addSafetyArea(areaName,address,constructionId);
    }
    /**
     * 修改工业区
     * @return
     */
    @PostMapping("/updateArea")
    public JSONObject updateArea(@RequestParam("areaId")Integer areaId,
                                 @RequestParam("areaName")String areaName,
                                 @RequestParam("address")String address,
                                 @RequestParam("constructionId")Integer constructionId){

        return systemClient.updateSafetyArea(areaId,areaName,address,constructionId);
    }

    /**
     * 增加负责人
     * @param userId
     * @param areaId
     * @return
     */
    @PostMapping("/addAreaUser")
    public JSONObject addAreaUser(@RequestParam("userId")Integer userId,
                                  @RequestParam("areaId")Integer areaId){

        return systemClient.addSafetyAreaUser(userId,areaId);
    }

    /**
     * 删除负责人
     * @return
     */
    @PostMapping("deleteAreaUser")
    public JSONObject deleteAreaUser(@RequestParam("userId")Integer userId,
                                     @RequestParam("areaId")Integer areaId){
        return systemClient.deleteSafetyAreaUser(userId,areaId);
    }

    /**
     * 删除工业区
     * @return
     */
    @PostMapping("deleteArea")
    public JSONObject deleteArea(@RequestParam("areaId")Integer areaId){
        return systemClient.deleteSafetyArea(areaId);
    }
}
