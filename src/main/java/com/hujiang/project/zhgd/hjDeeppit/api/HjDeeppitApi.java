package com.hujiang.project.zhgd.hjDeeppit.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjDeeppit.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


/**
 * @program: 基坑api
 * @description:
 * @author: tony
 * @create:
 **/
@RestController
@RequestMapping(value = "/api/hjDeeppit",method = RequestMethod.POST)
public class HjDeeppitApi extends BaseController {

    @Autowired
    SystemClient client;

    /**
     * 关联项目
     * @param sPD
     * @return
     */
    @PostMapping(value = "insertDeeppit")
    public AjaxResult insertDeeppit(@RequestBody SbProjectDeeppitStructures sPD){
        return client.insertDeeppit(sPD);
    }
    /**
     * 查询结构物列表
     * @param projectId
     * @return
     */
    @PostMapping(value = "selectStructure")
    public AjaxResult selectStructure(@RequestParam("projectId")Integer projectId){

        return client.selectStructureDeeppit(projectId);
    }

    /**
     * 查询所有的因素列表
     * @return
     */
    @PostMapping(value = "selectDisplay" )
    public AjaxResult selectDisplay(@RequestParam(value = "structureId")Integer structureId){

        return client.selectDisplayDeeppit(structureId);
    }

    /**
     * 查询所有的监测点
     * @return
     */
    @PostMapping(value = "/getFactorList" )
    public AjaxResult getFactorList(@RequestParam(value = "structureId")Integer structureId, @RequestParam(value = "displayId") Integer displayId){

        return client.getFactorListDeeppit(structureId,displayId);
    }

    /**
     * 查询测点历史数据
     * @param factorId
     * @return
     */
    @PostMapping(value = "getFactorData" )
    public JSONObject getFactorData(@RequestParam(value = "factorId") Integer factorId,
                                    @RequestParam(value = "date") String date,
                                    @RequestParam(value = "endTime") String endTime,
                                    @RequestParam(value = "pageSize")Integer pageSize,
                                    @RequestParam(value = "pageNum")Integer pageNum){

        return client.getFactorDataDeeppit(factorId,date,endTime,pageSize, pageNum);
    }

    /**
     * 查询历史数据最大、最小、平均值
     * @param displayId
     * @return
     */
    @PostMapping(value = "getParmeterAvg" )
    public AjaxResult getFactorDataInfo(@RequestParam(value = "displayId") Integer displayId, @RequestParam(value = "factorId") Integer factorId){

        return client.getFactorDataInfoDeeppit(displayId,factorId);
    }

    /**
     * 查询报警数据
     * @param structureId
     * @return
     */
    @PostMapping(value = "selectUserAlarms" )
    public AjaxResult selectUserAlarms(@RequestParam(value = "structureId")Integer structureId,
                                       @RequestParam(value = "date")String date,
                                       @RequestParam(value = "endTime",required = false) String endTime,
                                       @RequestParam(value = "pageSize")Integer pageSize,
                                       @RequestParam(value = "pageNum")Integer pageNum){

        return client.selectUserAlarmsDeeppit(structureId,date,endTime,pageSize,pageNum);
    }

    /**
     * 报警数据统计等级比例
     * @param structureId
     * @return
     */
    @PostMapping(value = "statisticsAlertor" )
    public AjaxResult statisticsAlertor(@RequestParam(value = "structureId")Integer structureId){

        return client.statisticsAlertorDeeppit(structureId);
    }




    /**
     * 按时间段查询历史数据
     * @param factorId
     * @param startTime
     * @param endTime
     * @return
     */
    @PostMapping(value = "getFactorDataT" )
    public AjaxResult getFactorDataT(@RequestParam(value = "factorId") Integer factorId, @RequestParam(value = "startTime") String startTime, @RequestParam(value = "endTime")String endTime,  @RequestParam(value = "pageSize")Integer pageSize,
                                     @RequestParam(value = "pageNum")Integer pageNum){

        return client.getFactorDataTDeeppit(factorId,startTime,endTime,pageSize,pageNum);
    }


    /**
     * 当日数据表特殊点
     * @param factorId
     * @return
     */
    @PostMapping(value = "selectSpecial" )
    public List selectSpecial(@RequestParam(value = "factorId")Integer factorId, @RequestParam(value = "param")String param, @RequestParam(value = "date") String date){

        return client.selectSpecialDeeppit(factorId,param,date);
    }


    /**
     * 历史数据图表
     * @param factorId
     * @param startTime
     * @param endTime
     * @return
     */
    @PostMapping(value = "selectSpecialS" )
    public JSONArray getFactorDataT(@RequestParam(value = "displayId") Integer displayId, @RequestParam(value = "factorId") Integer factorId, @RequestParam(value = "startTime") String startTime, @RequestParam(value = "endTime")String endTime) {

        return client.getFactorDataTDeeppit(displayId,factorId,startTime,endTime);
    }

    /**
     * 查询报警数据
     * @param factorName
     * @return
     */
    @PostMapping(value = "selectUserAlarmsByFactor" )
    public AjaxResult selectUserAlarmsByFactor(@RequestParam(value = "factorName")String factorName, @RequestParam(value = "date") String date){

        return client.selectUserAlarmsByFactorDeeppit(factorName,date);
    }
}
