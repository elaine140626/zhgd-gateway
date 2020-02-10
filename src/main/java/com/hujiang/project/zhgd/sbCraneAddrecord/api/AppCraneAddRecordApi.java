package com.hujiang.project.zhgd.sbCraneAddrecord.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 塔吊
 */
@RestController
@RequestMapping(value = "/api/appCraneAddRecord",method = RequestMethod.POST)
public class AppCraneAddRecordApi extends BaseController {
    @Autowired
    private SystemClient client;

    /**
     * 首页
     * @param deviceId
     * @return
     */
    @PostMapping(value = "/getCraneAddRecord")
    public JSONObject getCraneAddRecord(@RequestParam(value = "deviceId")String deviceId,@RequestParam(value = "projectId")Integer projectId){
        return client.getCraneAddRecord(deviceId,projectId);
    }

    /**
     * 历史记录
     * @param deviceId
     * @param dateTime
     * @return
     */
    @PostMapping(value = "/getCraneAddRecordHistory")
    public JSONObject getCraneAddRecordHistory(@RequestParam(value = "deviceId")String deviceId,
                                               @RequestParam(value = "pageNum")Integer pageNum,
                                               @RequestParam(value = "pageSize")Integer pageSize,
                                               @RequestParam(value = "dateTime",required = false)String dateTime,
                                               @RequestParam(value = "endTime",required = false)String endTime
    ){
        return client.getCraneAddRecordHistory(deviceId, pageNum, pageSize, dateTime,endTime);
    }

    /**
     * 切换设备
     * @return
     */
    @PostMapping(value = "/getCraneHxzId")
    public JSONObject getCraneHxzId(@RequestParam(value = "projectId")int projectId){
        return client.getCraneHxzId(projectId);
    }
    /**
     * 智慧工地1.0看板 塔吊
     * */
    @PostMapping(value = "/kanban")
    public JSONObject kanban(@RequestParam(value = "pid")Integer pid){
        return client.appCraneAddRecordKanban(pid);
    }
}
