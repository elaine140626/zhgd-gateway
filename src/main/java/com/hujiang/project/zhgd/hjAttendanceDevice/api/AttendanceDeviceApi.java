package com.hujiang.project.zhgd.hjAttendanceDevice.api;

import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjAttendanceDevice.domain.HjAttendanceDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

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
    @PostMapping(value = "/selectAttendanceDevice")
    public Map<String,Object> selectAttendanceDevice(HjAttendanceDevice hjAttendanceDevice, Integer pageNum, Integer pageSize){
        return client.selectAttendanceDevice(hjAttendanceDevice,pageNum,pageSize);
    }
    /**
     * 删除人脸机设备
     * @param ids
     * @return
     */
//    @PostMapping()
//    public AjaxResult remove(@RequestParam("ids") String ids)
//    {
//        return ;
//    }
}
