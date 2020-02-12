package com.hujiang.project.zhgd.sbCurrentTemperature.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.common.utils.poi.ExcelUtil;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.Util;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.sbCurrentTemperature.domain.SbCurrentTemperature;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

/**
 * @program: Provider01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-06-24 10:54
 **/
@RestController
@RequestMapping(value = "/api/appCurrentTemperature",method = RequestMethod.POST)
public class AppCurrentTemperatureApi extends BaseController {

    @Autowired
    private SystemClient client;

    /**
     * 智能电箱界面数据
     * @param electricityBoxId 设备编号
     * @return
     */
    @PostMapping(value = "/getEquipmentInformation")
    public JSONObject getEquipmentInformation(@RequestParam(value = "electricityBoxId")String electricityBoxId){
        return client.getEquipmentInformation(electricityBoxId);
    }

    /**
     * 电箱数据分页
     * @return
     */
    @PostMapping("/list")
    public JSONObject list(@RequestParam(value = "sn")String sn,
                           @RequestParam(value = "dateTime",required = false)String dateTime,
                           @RequestParam(value = "endTime",required = false)String endTime,
                           @RequestParam(value = "pageNum") Integer pageNum,
                           @RequestParam(value = "pageSize") Integer pageSize){
        return client.list(sn, dateTime,endTime, pageNum, pageSize);
    }
}
