package com.hujiang.project.zhgd.sbUnloaderRegistration.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.framework.web.page.TableDataInfo;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.sbUnloaderAlarmtime.domain.SbUnloaderAlarmtime;
import com.hujiang.project.zhgd.sbUnloaderRealtime.domain.SbUnloaderRealtime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api/unloaderAppApi",method = RequestMethod.POST)
public class AppUnloader {
    @Autowired
    private SystemClient systemClient;

    @PostMapping(value = "/getUnloader")
    public JSONObject getUnloader(@RequestParam("projectId")Integer projectId){
       return systemClient.getUnloader(projectId);
    }
    @PostMapping(value = "/getSbUnloaderRealtimeList")
    public JSONObject getSbUnloaderRealtimeList(@RequestParam(value = "projectId")Integer projectId,
                                                @RequestParam(value = "deviceId") String deviceId){

        return systemClient.getSbUnloaderRealtimeList(projectId,deviceId);
    }
    /**
     * 卸料app历史记录
     * @param projectId
     * @param deviceId
     * @param time
     * @param pageDomain
     * @return
     */
    @PostMapping(value = "/getSbUnloaderHistory")
    public JSONObject getSbUnloaderHistory(@RequestParam(value = "projectId")Integer projectId,
                                           @RequestParam(value = "deviceId") String deviceId,
                                           @RequestParam(value = "time",required = false)String time,
                                           PageDomain pageDomain){

        return systemClient.getSbUnloaderHistory(projectId,deviceId,time,pageDomain.getPageSize(),pageDomain.getPageNum());
    }

    /**
     * 卸料app报警记录
     * @param projectId
     * @param deviceId
     * @param time
     * @param pageDomain
     * @return
     */
    @PostMapping(value = "/getSbUnloaderAlarmtimeList")
    public JSONObject getSbUnloaderAlarmtimeList(@RequestParam("projectId")Integer projectId,
                                                 @RequestParam(value = "deviceId") String deviceId,
                                                 @RequestParam(value = "time",required = false)String time,
                                                 PageDomain pageDomain){

        return systemClient.getSbUnloaderAlarmtimeList(projectId,deviceId,time,pageDomain.getPageSize(),pageDomain.getPageNum());
    }
}
