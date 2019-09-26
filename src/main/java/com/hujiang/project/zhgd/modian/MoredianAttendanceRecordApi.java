package com.hujiang.project.zhgd.modian;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjAttendanceRecord.domain.HjAttendanceRecord;
import com.hujiang.project.zhgd.hjAttendanceRecord.service.IHjAttendanceRecordService;
import com.hujiang.project.zhgd.hjProjectWorkers.domain.HjProjectWorkers;
import com.hujiang.project.zhgd.hjProjectWorkers.service.IHjProjectWorkersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * @program: LZ
 * @description: 魔点考勤记录Api
 * @author: Mr.LiuYong
 * @create: 2019-05-14 08:59
 **/
@RestController
@RequestMapping(value = "/api/moredian",method = RequestMethod.POST)
public class MoredianAttendanceRecordApi extends BaseController {
    private Logger logger = Logger.getLogger(MoredianAttendanceRecordApi.class.getName());
    @Autowired
    private SystemClient systemClient;
    /**
     * 功能描述 :接收上传的考勤记录
     * @author Mr.LiuYong
     * @date  2019/5/14 9:02
     * @param request, json
     * @return com.hujiang.framework.web.domain.AjaxResult
     */
    @RequestMapping(value = "record")
    public AjaxResult record(HttpServletRequest request, @RequestBody String json){
        logger.info("com.hujiang.project.zhgd.moredian.moredianAttendanceRecord.api.MoredianAttendanceRecordApi.record:\n请求地址"+request.getRemoteAddr());
        logger.info("com.hujiang.project.zhgd.moredian.moredianAttendanceRecord.api.MoredianAttendanceRecordApi.record:\n接收数据"+json);

        return systemClient.record(json);
    }




}
