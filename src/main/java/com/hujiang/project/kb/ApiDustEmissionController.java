package com.hujiang.project.kb;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.sbDustEmission.domain.SbDustEmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * 扬尘接口
 */
@RestController
@RequestMapping(value = "/api/dustEmission/get",method = RequestMethod.GET)
public class ApiDustEmissionController {

    @Autowired
    private SystemClient client;



    /**
     * 根据项目id获取扬尘设备列表
     * @param pid
     * @return
     */
    @RequestMapping("/getDustEmissionList")
    public JSONObject getDustEmissionList(String pid){
       return client.getDustEmissionList(pid);
    }

    /**
     * 根据编号获取设备记录
     * @param sid
     * @return
     */
    @RequestMapping("/DustEmissionDatas")
    public JSONObject getDustEmissionData(String sid)throws Exception{
        return client.getDustEmissionData(sid);
    }

    /**
     *绿色施工界面中心数据
     * @param pid
     * @return
     * @throws Exception
     */
    @RequestMapping("HomeDustEmissionCentre")
    public JSONObject getHomeDustEmission(String pid)throws Exception{
        return client.getHomeDustEmission(pid);
    }



}
