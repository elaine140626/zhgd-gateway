package com.hujiang.project.zhgd.hjghformwork.api;

import com.alibaba.fastjson.JSONArray;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * @program: Provider01
 * @description:
 * @author: yant
 **/
@RestController
@RequestMapping(value = "/api/HjGhformworktApi",method = RequestMethod.POST)
public class HjGhformworktApi extends BaseController {


    @Autowired
    private SystemClient client;
    /**
     * 查询结构物列表
     * @param projectId
     * @return
     */
    @PostMapping(value = "selectStructure")
    public  AjaxResult selectStructure(@RequestParam("projectId")Integer projectId){
        return client.selectStructure(projectId);
    }

    /**
     * 查询所有的因素列表
     * @return
     */
    @PostMapping(value = "selectDisplay" )
    public AjaxResult selectDisplay(@RequestParam(value = "structureId")Integer structureId){

        return client.selectDisplay(structureId);
    }

    /**
     * 查询所有的监测点
     * @return
     */
    @PostMapping(value = "getFactorList" )
    public AjaxResult getFactorList(@RequestParam(value = "structureId")Integer structureId,@RequestParam(value = "displayId") Integer displayId){

        return client.getFactorList(structureId,displayId);
    }

    /**
     * 查询测点历史数据
     * @param factorId
     * @return
     */
    @PostMapping(value = "getFactorData" )
    public AjaxResult getFactorData(@RequestParam(value = "factorId") Integer factorId,@RequestParam(value = "date") String date,
                                    @RequestParam(value = "pageSize")Integer pageSize,
                                    @RequestParam(value = "pageNum")Integer pageNum){

        return client.getFactorData(factorId,date,pageSize,pageNum);
    }

    /**
     * 查询报警数据
     * @param structureId
     * @return
     */
    @PostMapping(value = "selectUserAlarms" )
    public AjaxResult selectUserAlarms(@RequestParam(value = "structureId")Integer structureId,@RequestParam(value = "date") String date,
                                       @RequestParam(value = "pageSize")Integer pageSize,
                                       @RequestParam(value = "pageNum")Integer pageNum){

        return client.selectUserAlarms(structureId,date,pageSize,pageNum);

    }


    /**
     * 按时间段查询历史数据
     * @param factorId
     * @param startTime
     * @param endTime
     * @return
     */
    @PostMapping(value = "getFactorDataT" )
    public AjaxResult getFactorDataT(@RequestParam(value = "factorId") Integer factorId,@RequestParam(value = "startTime") String startTime, @RequestParam(value = "endTime")String endTime,  @RequestParam(value = "pageSize")Integer pageSize,
                                     @RequestParam(value = "pageNum")Integer pageNum){

        return client.getFactorDataT(factorId,startTime,endTime,pageSize,pageNum);
    }


    /**
     * 查询历史数据最大、最小、平均值
     * @param displayId
     * @return
     */
    @PostMapping(value = "getParmeterAvg" )
    public AjaxResult getParmeterAvg(@RequestParam(value = "displayId") Integer displayId,@RequestParam(value = "factorId") Integer factorId){

        return client.getParmeterAvg(displayId,factorId);
    }

    /**
     * 当日数据表特殊点
     * @param factorId
     * @return
     */
    @PostMapping(value = "selectSpecial" )
    public List selectSpecial(@RequestParam(value = "factorId")Integer factorId,@RequestParam(value = "param")String param,@RequestParam(value = "date") String date){
        return client.selectSpecial(factorId,param,date);
    }


    /**
     * 历史数据图表
     * @param factorId
     * @param startTime
     * @param endTime
     * @return
     */
    @PostMapping(value = "selectSpecialS" )
    public JSONArray selectSpecialS(@RequestParam(value = "displayId") Integer displayId,@RequestParam(value = "factorId") Integer factorId, @RequestParam(value = "startTime") String startTime, @RequestParam(value = "endTime")String endTime) {
        return client.selectSpecialS(displayId,factorId,startTime,endTime);
    }

    /**
     * 报警数据统计等级比例
     * @param structureId
     * @return
     */
    @PostMapping(value = "statisticsAlertor" )
    public AjaxResult statisticsAlertor(@RequestParam(value = "structureId")Integer structureId){
        return client.statisticsAlertor(structureId);
    }

    /**
     * 查询报警数据
     * @param factorName
     * @return
     */
    @PostMapping(value = "selectUserAlarmsByFactor" )
    public AjaxResult selectUserAlarmsByFactor(@RequestParam(value = "factorName")String factorName,@RequestParam(value = "date") String date){

        return client.selectUserAlarmsByFactor(factorName,date);
    }

}
