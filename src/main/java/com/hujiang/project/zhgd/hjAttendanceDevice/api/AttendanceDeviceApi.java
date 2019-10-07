package com.hujiang.project.zhgd.hjAttendanceDevice.api;

import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjAttendanceDevice.domain.HjAttendanceDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/attendanceDeviceApi")
public class AttendanceDeviceApi {

    @Autowired
    private SystemClient client;
    @PostMapping(value = "/insertAttendanceDevice")
    public AjaxResult insertAttendanceDevice( HjAttendanceDevice hjAttendanceDevice){

        return client.insertAttendanceDevice(hjAttendanceDevice);
    }
     @PostMapping(value = "/updateAttendanceDevice")
    public AjaxResult updateAttendanceDevice( HjAttendanceDevice hjAttendanceDevice){

        return client.updateAttendanceDevice(hjAttendanceDevice);
    }

}
