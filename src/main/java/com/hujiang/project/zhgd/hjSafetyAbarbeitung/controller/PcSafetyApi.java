package com.hujiang.project.zhgd.hjSafetyAbarbeitung.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.framework.web.page.TableDataInfo;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjSafetyAbarbeitung.domain.HjSafetyNoPass;
import com.hujiang.project.zhgd.hjSafetyAbarbeitung.domain.Safety;
import com.hujiang.project.zhgd.hjSafetyAbarbeitung.domain.SafetyRectification;
import com.hujiang.project.zhgd.hjSystemUser.domain.HjSystemUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/api/safetyPcApi",method = RequestMethod.POST)
public class PcSafetyApi {
    @Autowired
    private SystemClient systemClient;

    @PostMapping(value = "/statisticsCount")
    public JSONObject statisticsCount(@RequestParam(value = "differentiate") Integer differentiate,
                                      @RequestParam(value = "projectId") Integer projectId,
                                      @RequestParam(value = "startTime",required = false)String startTime,
                                      @RequestParam(value = "endTime",required = false)String endTime){

        return systemClient.statisticsCount(differentiate, projectId, startTime, endTime);
    }

    /**
     * 检查记录查询信息
     * @param projectId
     * @return
     */
    @PostMapping(value = "/getInformationList")
    public JSONObject getInformationList(@RequestParam(value = "projectId") Integer projectId){

        return systemClient.getInformationList(projectId);
    }

    /**
     * 检查记录
     * @param status
     * @param initiatorTime
     * @param initiatorName
     * @param rectifyName
     * @param reviewName
     * @param constructionId
     * @param areaId
     * @param problemGradeId
     * @param differentiate
     * @return
     */
    @PostMapping(value = "/getInspectionRecordList")
    public JSONObject getInspectionRecordList(@RequestParam(value = "projectId") Integer projectId,
                                              @RequestParam(value = "hiddenId",required = false)Integer hiddenId,
                                              @RequestParam(value = "status",required = false)Integer status,
                                              @RequestParam(value = "initiatorTime",required = false)String initiatorTime,
                                              @RequestParam(value = "initiatorName",required = false)String initiatorName,
                                              @RequestParam(value = "rectifyName",required = false)String rectifyName,
                                              @RequestParam(value = "reviewName",required = false)String reviewName,
                                              @RequestParam(value = "constructionId",required = false)Integer constructionId,
                                              @RequestParam(value = "areaId",required = false)Integer areaId,
                                              @RequestParam(value = "problemGradeId",required = false)Integer problemGradeId,
                                              @RequestParam(value = "differentiate")Integer differentiate,
                                              PageDomain pageDomain){

        return systemClient.getInspectionRecordList(projectId, hiddenId, status, initiatorTime, initiatorName,
                rectifyName, reviewName, constructionId, areaId, problemGradeId, differentiate,pageDomain.getPageNum(),pageDomain.getPageSize());
    }

    /**
     * 检查记录详情
     * @param safetyId
     * @return
     */
    @PostMapping(value = "getInspectionRecordDetails")
    public JSONObject getInspectionRecordDetails(@RequestParam(value = "safetyId")Integer safetyId){

        return systemClient.getInspectionRecordDetails(safetyId);
    }

    /**
     * 查询分包单位
     * @param projectId
     * @return
     */
    @PostMapping(value = "/getConstructionList")
    public JSONObject getConstructionList(@RequestParam(value = "projectId") Integer projectId){

        return systemClient.getConstructionList(projectId);
    }
    /**
     * 查询检查区域
     * @param constructionId
     * @return
     */
    @PostMapping(value = "/getAreaList")
    public JSONObject getAreaList(@RequestParam(value = "constructionId") Integer constructionId){

        return systemClient.getAreaList(constructionId);
    }


    /**
     * 整改单管理
     * @return
     */
    @PostMapping(value = "/getManagementList")
    public JSONObject getManagementList(@RequestParam(value = "projectId") Integer projectId,
                                        @RequestParam(value = "status",required = false)Integer status,
                                        @RequestParam(value = "initiatorTime",required = false)String initiatorTime,
                                        @RequestParam(value = "initiatorName",required = false)String initiatorName,
                                        @RequestParam(value = "rectifyName",required = false)String rectifyName,
                                        @RequestParam(value = "reviewName",required = false)String reviewName,
                                        @RequestParam(value = "constructionId",required = false)Integer constructionId,
                                        @RequestParam(value = "differentiate")Integer differentiate,
                                        PageDomain pageDomain){

        return systemClient.getManagementList(projectId, status, initiatorTime, initiatorName,
                rectifyName, reviewName, constructionId, differentiate,pageDomain.getPageNum(),pageDomain.getPageSize());
    }

    /**
     * 整改单详情
     * @param safetyId
     * @return
     */
    @PostMapping(value = "/getManagementDetails")
    public JSONObject getManagementDetails(@RequestParam(value = "safetyId")Integer safetyId){

        return systemClient.getManagementDetails(safetyId);
    }

    @PostMapping(value = "/getHiddenList")
    public JSONObject getHiddenList(){
        return systemClient.getHiddenList();
    }

    @PostMapping(value = "/updateSafety")
    public JSONObject updateSafety(@RequestParam(value = "safetyId") Integer safetyId,
                                   @RequestParam(value = "initiatorId",required = false)Integer initiatorId,
                                   @RequestParam(value = "rectifyId",required = false)Integer rectifyId,
                                   @RequestParam(value = "reviewId",required = false)Integer reviewId,
                                   @RequestParam(value = "make",required = false)String[] makes,
                                   @RequestParam(value = "areaId",required = false)Integer areaId,
                                   @RequestParam(value = "safetyDeadline",required = false)String safetyDeadline,
                                   @RequestParam(value = "hiddenId",required = false)Integer hiddenId,
                                   @RequestParam(value = "safetyRequire",required = false)String safetyRequire,
                                   @RequestParam(value = "initiatorTime",required = false)String initiatorTime,
                                   @RequestParam(value = "rectifyTime",required = false)String rectifyTime,
                                   @RequestParam(value = "reviewTime",required = false)String reviewTime)
    {

        return systemClient.updateSafety(safetyId, initiatorId, rectifyId, reviewId, makes, areaId, safetyDeadline, hiddenId, safetyRequire, initiatorTime, rectifyTime, reviewTime);
    }
    @PostMapping(value = "/deleteSafety")
    public JSONObject deleteSafety(@RequestParam("safetyId")Integer safetyId){

        return systemClient.deleteSafety(safetyId);
    }
}
