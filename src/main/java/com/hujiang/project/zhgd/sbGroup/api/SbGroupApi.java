package com.hujiang.project.zhgd.sbGroup.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api",method = RequestMethod.POST)
public class SbGroupApi {
    @Autowired
    private SystemClient client;


    @PostMapping(value = "/equipment")
    public JSONObject equipment(@RequestParam(value = "cid")int cid){
        return client.equipment(cid);
    }
    @PostMapping(value = "/marginAlarm")
    public JSONObject marginAlarm(@RequestParam(value = "cid")int cid){
        return client.marginAlarm(cid);
    }

    @PostMapping(value = "/lifterAlarm")
    public JSONObject lifterAlarm(@RequestParam(value = "cid")int cid){
        return client.lifterAlarm(cid);
    }


    @PostMapping(value = "/company")
    public AjaxResult company(@RequestParam(value = "cid")Integer cid){
        return client.company(cid);
    }
    @PostMapping(value = "/totalList")
    public AjaxResult totalList(@RequestParam(value = "cid")Integer cid){
        return client.totalList(cid);
    }

    @PostMapping(value = "/projectList")
    public AjaxResult projectList(@RequestParam(value = "cid")Integer cid){
        return client.projectList(cid);
    }
    @PostMapping(value = "/count")
    public AjaxResult count(@RequestParam(value = "cid")Integer cid){
        return client.count(cid);
    }
    @PostMapping(value = "/clickCard")
    public AjaxResult clickCard(@RequestParam(value = "cid")Integer cid,@RequestParam(value = "start")Long start,@RequestParam(value = "end")Long end){
        return client.clickCard(cid,start,end);
    }
    @PostMapping(value = "/plateList")
    public AjaxResult plateList(@RequestParam(value = "cid")Integer cid,@RequestParam(value = "start")Long start,@RequestParam(value = "end")Long end){
        return client.plateList(cid,start,end);
    }
    @PostMapping(value = "/environmentList")
    public AjaxResult environmentList(@RequestParam(value = "cid")Integer cid){
        return client.environmentList(cid);
    }
}
