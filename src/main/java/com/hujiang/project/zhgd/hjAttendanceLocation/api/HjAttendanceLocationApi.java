package com.hujiang.project.zhgd.hjAttendanceLocation.api;

import com.hujiang.framework.web.domain.AjaxResult;

import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjAttendanceLocation.domain.HjAttendanceLocation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/location")
public class HjAttendanceLocationApi {
    @Autowired
    private SystemClient client;


    @PostMapping("/insert")
    public AjaxResult insertHjAttendanceLocation( HjAttendanceLocation hjAttendanceLocation){
        return client.insertHjAttendanceLocation(hjAttendanceLocation);
    }

    @PostMapping("/modify")
    public AjaxResult updateHjAttendanceLocation(HjAttendanceLocation hjAttendanceLocation){
        return client.updateHjAttendanceLocation(hjAttendanceLocation);
    }

    @PostMapping("/query")
    public AjaxResult selectHjAttendanceLocationList(HjAttendanceLocation hjAttendanceLocation){
        return client.selectHjAttendanceLocationList(hjAttendanceLocation);
    }

    @PostMapping("/remove")
    public AjaxResult deleteHjAttendanceLocationByIds(String id){
        return client.deleteHjAttendanceLocationByIds(id);
    }

}