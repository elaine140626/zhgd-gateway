package com.hujiang.project.zhgd.sbElevatorAddrecord.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjSystemUser.domain.HjSystemUser;
import com.hujiang.project.zhgd.hjSystemUser.service.IHjSystemUserService;
import com.hujiang.project.zhgd.sbElevatorAddrecord.api.domain.OptionsElevator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/OptionsElevatorApi",method = RequestMethod.POST)
public class OptionsElevatorApi {
    @Autowired
    private SystemClient systemClient;

    @PostMapping("/getElevatorList")
    public JSONObject getElevatorList(@RequestParam("projectId")Integer projectId){

        return systemClient.getElevatorList(projectId);
    }
    @PostMapping("/insertElevator")
    public JSONObject insertElevator(OptionsElevator optionsElevator){
        return systemClient.insertElevator(optionsElevator);
    }
    @PostMapping("/updateElevator")
    public JSONObject updateElevator(OptionsElevator optionsElevator){
        return systemClient.updateElevator(optionsElevator);
    }

    @PostMapping("/deleteElevator")
    public JSONObject deleteElevator(@RequestParam("id")Integer id,@RequestParam(value = "devCcrq",required =false)String devCcrq){

        return systemClient.deleteElevator(id,devCcrq);
    }
    @PostMapping("/getElevatorUserList")
    public JSONObject getElevatorUserList(@RequestParam("projectId")Integer projectId,
                                       @RequestParam(value = "filed",required = false)String filed){

        return systemClient.getElevatorUserList(projectId,filed);
    }
}
