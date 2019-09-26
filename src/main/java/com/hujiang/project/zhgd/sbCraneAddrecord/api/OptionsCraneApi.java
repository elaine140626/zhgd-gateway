package com.hujiang.project.zhgd.sbCraneAddrecord.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/OptionsCraneApi",method = RequestMethod.POST)
public class OptionsCraneApi {
    @Autowired
    private SystemClient systemClient;

    @PostMapping("/getCraneList")
    public JSONObject getCraneList(@RequestParam("projectId")Integer projectId){
        return systemClient.getCraneList(projectId);
    }
    @PostMapping("/updateCrane")
    public JSONObject updateCrane(@RequestParam("id")Integer id,
                                  @RequestParam("craneName")String craneName,
                                  @RequestParam("hxzId")String hxzId){
        return systemClient.updateCrane(id, craneName,hxzId);
    }
    @PostMapping("/deleteCrane")
    public JSONObject deleteCrane(@RequestParam("id")Integer id){
        return  systemClient.deleteCrane(id);
    }
    @PostMapping("/insertCrane")
    public JSONObject insertCrane(@RequestParam("craneName")String craneName,
                                  @RequestParam("hxzId")String hxzId,
                                  @RequestParam("projectId")Integer projectId){
        return  systemClient.insertCrane(craneName,hxzId,projectId);
    }
    @PostMapping("/getCraneUserList")
    public JSONObject getCraneUserList(@RequestParam("projectId")Integer projectId,
                                       @RequestParam(value = "filed",required = false)String filed){
        return systemClient.getCraneUserList(projectId,filed);
    }
}
