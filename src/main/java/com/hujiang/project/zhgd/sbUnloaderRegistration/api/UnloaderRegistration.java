package com.hujiang.project.zhgd.sbUnloaderRegistration.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 卸料
 */
@RestController
@RequestMapping(value = "/zhgd")
public class UnloaderRegistration {


    //卸料注册信息
    @Autowired private SystemClient systemClient;


    /**  注册信息 */
    @PostMapping("/LoginDataUnloadingPlatform")
    public JSONObject LoginDataUnloadingPlatform(@RequestBody String json){

        return systemClient.LoginDataUnloadingPlatform(json);
    }

    /** 基础参数 */
    @PostMapping("/BaseDataUnloadingPlatform")
    public JSONObject BaseDataUnloadingPlatform(@RequestBody String json){
        return systemClient.BaseDataUnloadingPlatform(json);
    }

    /** 实时数据 */
    @PostMapping("/RealtimeDataUnloadingPlatform")
    public JSONObject RealtimeDataUnloadingPlatform(@RequestBody String json){
        return systemClient.RealtimeDataUnloadingPlatform(json);
    }

    /** 报警时段数据 */
    @PostMapping("/AlarmDataUnloadingPlatform")
    public JSONObject AlarmDataUnloadingPlatform(@RequestBody String json){
        return systemClient.AlarmDataUnloadingPlatform(json);
    }
    /** 报警时刻数据*/
    @PostMapping("/AlarmStartUnloadingPlatform")
    public JSONObject AlarmStartUnloadingPlatform(@RequestBody String json){
        return systemClient.AlarmStartUnloadingPlatform(json);
    }
}
