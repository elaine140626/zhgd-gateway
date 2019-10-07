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
    public JSONObject updateCrane(@RequestParam("id")String id,
                                  @RequestParam("craneName")String craneName,
                                  @RequestParam("hxzId")String hxzId,
                                  @RequestParam("serialNum")String serialNum,//广东省统一安装告 知编号（产权备案 编号）
                                  @RequestParam("tcMaxScope")String tcMaxScope,//最大幅度（M）
                                  @RequestParam("tcMaxHeight")String tcMaxHeight,//最大高度（M)
                                  @RequestParam("tcLoadCapacity")String tcLoadCapacity,//最大载重（kg）
                                  @RequestParam("tcLoadMoment")String tcLoadMoment,//额定起重力矩（N·m）
                                  @RequestParam(value = "jdbh" ,required = false)String jdbh,
                                  @RequestParam(value = "xmid" ,required = false)String xmid,
                                  @RequestParam(value = "subId" ,required = false)String subId,
                                  @RequestParam("scznl")String scznl,
                                  @RequestParam("manufacturerId")String manufacturerId,
                                  @RequestParam("installCompany")String installCompany //设备安装单位
    ){
        return systemClient.updateCrane(id, craneName, hxzId, serialNum, tcMaxScope, tcMaxHeight, tcLoadCapacity, tcLoadMoment, jdbh, xmid, subId, scznl, manufacturerId, installCompany);
    }
    @PostMapping("/deleteCrane")
    public JSONObject deleteCrane(@RequestParam("id")Integer id,@RequestParam(value = "devCcrq",required =false)String devCcrq){
        return  systemClient.deleteCrane(id,devCcrq);
    }

    @PostMapping("/insertCrane")
    public JSONObject insertCrane(@RequestParam(value = "craneName")String craneName,
                                  @RequestParam(value = "hxzId")String hxzId,
                                  @RequestParam(value = "projectId")Integer projectId,
                                  @RequestParam(value = "serialNum")String serialNum,//广东省统一安装告 知编号（产权备案 编号）
                                  @RequestParam(value = "tcMaxScope")String tcMaxScope,//最大幅度（M）
                                  @RequestParam(value = "tcMaxHeight")String tcMaxHeight,//最大高度（M)
                                  @RequestParam(value = "tcLoadCapacity")String tcLoadCapacity,//最大载重（kg）
                                  @RequestParam(value = "tcLoadMoment")String tcLoadMoment,//额定起重力矩（N·m）
                                  @RequestParam(value = "jdbh" ,required = false)String jdbh,
                                  @RequestParam(value = "xmid" ,required = false)String xmid,
                                  @RequestParam(value = "subId" ,required = false)String subId,
                                  @RequestParam(value = "scznl")String scznl,
                                  @RequestParam(value = "manufacturerId")String manufacturerId,
                                  @RequestParam(value = "installCompany")String installCompany //设备安装单位
    ){
        return  systemClient.insertCrane(craneName, hxzId, projectId, serialNum, tcMaxScope, tcMaxHeight, tcLoadCapacity, tcLoadMoment, jdbh, xmid, subId, scznl, manufacturerId,installCompany);
    }
    @PostMapping("/getCraneUserList")
    public JSONObject getCraneUserList(@RequestParam("projectId")Integer projectId,
                                       @RequestParam(value = "filed",required = false)String filed){
        return systemClient.getCraneUserList(projectId,filed);
    }
}
