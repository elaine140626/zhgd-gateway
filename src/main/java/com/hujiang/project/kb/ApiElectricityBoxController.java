package com.hujiang.project.kb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * 电箱接口
 */
@RestController
@RequestMapping(value = "/api/electricityBox/get", method = RequestMethod.GET)
public class ApiElectricityBoxController {

    @Autowired
    private SystemClient client;
    private Logger logger = Logger.getLogger(ApiElectricityBoxController.class.getName());
    /**
     * 根据项目id获取项目电箱列表
     *
     * @param projectId
     * @return
     */
    @RequestMapping("list")
    public Object getProjectElectricityBox(String projectId) {
        System.out.println(projectId);
        return client.getProjectElectricityBox(projectId);
    }

    /**
     * 根据设备id获取电箱数据
     *
     * @param electricityBoxId
     * @param time
     * @return
     */
    @RequestMapping("message")
    public Object getElectricityBoxRecord(String electricityBoxId, @RequestParam(required = false) String time) {
        return client.getElectricityBoxRecord(electricityBoxId, time);
    }

    /**
     * 根据项目id获取电箱状态数据
     *
     * @param projectId
     * @return
     */
    @RequestMapping("getElectricBoxState")
    public JSONObject getElectricBoxState(String projectId) throws Exception {
        return client.getElectricBoxState(projectId);
    }


}
