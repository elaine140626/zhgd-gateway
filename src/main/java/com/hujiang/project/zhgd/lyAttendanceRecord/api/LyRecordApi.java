package com.hujiang.project.zhgd.lyAttendanceRecord.api;

import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.lyAttendanceRecord.domain.LyAttendanceRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/lyRecord",method = RequestMethod.POST)
public class LyRecordApi {
    @Autowired
    private SystemClient client;


    /**
     * 信息查询人员资料
     */
    @PostMapping("/selectPersonnelRecord")
    public AjaxResult selectPersonnelRecord(LyAttendanceRecord lyAttendanceRecord){

            return client.selectPersonnelRecord(lyAttendanceRecord);
    }

}
