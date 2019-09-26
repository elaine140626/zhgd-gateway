package com.hujiang.project.zhgd.sbElevatorAddrecord.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 升降机
 */
@RestController
@RequestMapping(value = "/api/appElevatorAddRecord",method = RequestMethod.POST)
public class AppElevatorAddRecordApi {
    @Autowired
    private SystemClient client;

    /**
     * 升降机界面
     * @return
     */
    @PostMapping(value = "/getElevatorAddRecord")
    public JSONObject getElevatorAddRecord(@RequestParam(value = "deviceId")String deviceId,@RequestParam(value = "projectId")Integer projectId){
        return client.getElevatorAddRecord(deviceId,projectId);
    }

    /**
     * 切换设备
     * @return
     */
    @PostMapping(value = "/getElevatorHxzId")
    public JSONObject getElevatorHxzId(@RequestParam(value = "projectId")int projectId){
        return client.getElevatorHxzId(projectId);
    }
    /**
     * 升降机看板接口
     * @return
     */
    @PostMapping(value = "/crane")
    public JSONObject appElevatorAddRecordCrane(@RequestParam(value = "pid")Integer projectId){
        return client.appElevatorAddRecordCrane(projectId);
    }
}
