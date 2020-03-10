package com.hujiang.project.zhgd.hjAttendanceRecord.controller;


import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.Constants;
import com.hujiang.project.zhgd.RestTemplateUtil;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjAttendanceRecord.domain.HjAttendanceRecord;
import com.hujiang.project.zhgd.hjAttendanceRecord.service.IHjAttendanceRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * App两制考勤记录
 *
 * @author hujiang
 * @date 2019-05-19
 */
@Controller
@RequestMapping(value = "/api/attendanceRecordApi",method = RequestMethod.POST)
public class AttendanceRecordApi {


    @Autowired
    private IHjAttendanceRecordService hjAttendanceRecordService;
    @Autowired
    private RestTemplateUtil restTemplateUtil;
    @Autowired
    private SystemClient client;

    /**
     * 智慧工地1.0，工人上工情况
     * */
    @RequestMapping(value = "/TheWorkersWork")
    @ResponseBody
    public JSONObject TheWorkersWork(@RequestParam("projectId") Integer projectId){
        return client.TheWorkersWork(projectId);
    }
    /**
     * 劳务工人考勤情况
     * @param hjAttendanceRecord 考勤记录表
     * @return
     */
    @RequestMapping("/selectWorkerAttendance")
    @ResponseBody
    public Map<String, Object> selectWorkerAttendance(HjAttendanceRecord hjAttendanceRecord)
    {
        return hjAttendanceRecordService.selectWorkerAttendance(hjAttendanceRecord);
    }


    /**
     * 管理人员考勤情况
     * @param hjAttendanceRecord 考勤记录表
     * @return
     */
    @RequestMapping("/selectAdministration")
    @ResponseBody
    public Map<String, Object> selectAdministration(HjAttendanceRecord hjAttendanceRecord)
    {
        return hjAttendanceRecordService.selectAdministration(hjAttendanceRecord);
    }



//    /**
//     * 人脸考勤
//     * @param
//     * @return
//     */
//    @RequestMapping("/insertAdministration")
//    @ResponseBody
//    public Map<String, Object> insertAdministration(HjAttendanceRecord hjAttendanceRecord)
//    {
//        return hjAttendanceRecordService.insertAdministration(hjAttendanceRecord);
//    }


    /**
     * 人脸考勤
     * @param
     * @return
     */
    @RequestMapping("/insertAdministration")
    @ResponseBody
    public Map<String, Object> insertAdministration( HjAttendanceRecord hjAttendanceRecord,
                                                    MultipartFile file)throws Exception
    {
        return client.insertAdministrationAttendanceRecord(hjAttendanceRecord,file);
//        return (Map<String, Object>)restTemplateUtil.PostFile(hjAttendanceRecord, Constants.SERVICE_NAME+"provider/attendanceRecordApi/insertAdministration",file);
    }


    @RequestMapping("/getNearlyEightDays")
    @ResponseBody
    public JSONObject attendanceRecordApiGetNearlyEightDays( @RequestParam("projectId") Integer projectId){
        return client.attendanceRecordApiGetNearlyEightDays(projectId);
}

    @RequestMapping("/getTeamCount")
    @ResponseBody
    public JSONObject attendanceRecordApiGetTeamCount( @RequestParam("projectId") Integer projectId){
        return client.attendanceRecordApiGetTeamCount(projectId);
    }

    /**
     * 现场工种
     * @param projectId
     * @return
     */
    @RequestMapping("/getWorkType")
    @ResponseBody
    public JSONObject attendanceRecordApiGetWorkType( @RequestParam("projectId") Integer projectId){
        return client.attendanceRecordApiGetWorkType(projectId);
    }
    /**
     * 分包单位考勤情况
     * @param projectId
     * @return
     */
    @RequestMapping("/getBuildcompanyData")
    @ResponseBody
    public JSONObject attendanceRecordApiGetBuildcompanyData( @RequestParam("projectId") Integer projectId){
        return client.attendanceRecordApiGetBuildcompanyData(projectId);
    }
    /**
     * 今日劳动曲线1.0
     * @param projectId
     * @return
     */
    @RequestMapping("/getXS")
    @ResponseBody
    public JSONObject attendanceRecordApiGetXS( @RequestParam("projectId") Integer projectId){
        return client.attendanceRecordApiGetXS(projectId);
    }
}
