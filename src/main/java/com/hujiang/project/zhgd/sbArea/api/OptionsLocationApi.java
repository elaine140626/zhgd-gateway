package com.hujiang.project.zhgd.sbArea.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api/OptionsLocationApi",method = RequestMethod.POST)
public class OptionsLocationApi extends BaseController {
    @Autowired
    private SystemClient systemClient;

    @PostMapping("/getAreaList")
    public JSONObject getAreaList(@RequestParam("projectId")Integer projectId){
        return systemClient.getLocationAreaList(projectId);
    }
    @PostMapping("/updateArea")
    public JSONObject updateArea(@RequestParam("areaId")Integer areaId,
                                     @RequestParam("areaName")String areaName,
                                     @RequestParam("areaAddress")String areaAddress,
                                     @RequestParam("constructionId")Integer constructionId){

        return systemClient.updateLocationArea(areaId, areaName, areaAddress, constructionId);
    }
    @PostMapping("/addArea")
    public JSONObject addArea(@RequestParam("areaName")String areaName,
                                     @RequestParam("areaAddress")String areaAddress,
                                     @RequestParam("constructionId")Integer constructionId,
                                     @RequestParam("areaXloc")Double areaXloc,
                                     @RequestParam("areaYloc")Double areaYloc,
                                     @RequestParam("radius")Double radius,
                                     @RequestParam("projectId")Integer projectId){

        return systemClient.addLocationArea(areaName, areaAddress, constructionId, areaXloc, areaYloc, radius, projectId);
    }
    @PostMapping("/deleteArea")
    public JSONObject deleteArea(@RequestParam("areaId")Integer areaId){

        return systemClient.deleteLocationArea(areaId);
    }
    @PostMapping("/getAreaUserList")
    public JSONObject getUserList(@RequestParam(value = "areaId",required = false) Integer areaId,
                                      @RequestParam(value = "filed",required = false)String filed,
                                      @RequestParam(value = "userName",required = false)String userName,
                                      @RequestParam(value = "projectId")Integer projectId,PageDomain pageDomain){

        return systemClient.getLocationUserList(areaId,filed, projectId,pageDomain.getPageSize(),pageDomain.getPageNum());
    }
    @PostMapping("/getAreaById")
    public JSONObject getAreaById(@RequestParam("areaId")Integer areaId){
        return systemClient.getAreaById(areaId);
    }
    @PostMapping("/updateAreaUser")
    public JSONObject updateAreaUser(@RequestParam(value = "areaId") Integer areaId,
                                 @RequestParam(value = "userName")String userName,
                                 @RequestParam(value = "userPhone",required = false)String userPhone,
                                 @RequestParam(value = "imei")String imei,
                                 @RequestParam(value = "userId")Integer userId){

        return systemClient.updateAreaUser(areaId, userName, userPhone, imei, userId);
    }
    @PostMapping("/deleteAreaUser")
    public JSONObject deleteLocationAreaUser(@RequestParam(value = "userId") Integer userId,
                                             @RequestParam(value = "areaId")Integer areaId){

        return systemClient.deleteLocationAreaUser(userId,areaId);
    }
    @PostMapping("/addAreaUser")
    public JSONObject addAreaUser(@RequestParam(value = "areaId")Integer areaId,
                                     @RequestParam(value = "userName")String userName,
                                     @RequestParam(value = "userPhone",required = false)String userPhone,
                                     @RequestParam(value = "imei")String imei){

        return systemClient.addLocationAreaUser(areaId, userName, userPhone, imei);
    }

}
