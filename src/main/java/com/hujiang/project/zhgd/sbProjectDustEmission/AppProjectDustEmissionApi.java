package com.hujiang.project.zhgd.sbProjectDustEmission;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

/**
 * @program: Consumer01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-06-18 16:07
 **/
@RestController
@RequestMapping(value = "/api/appProjectDustEmission",method = RequestMethod.POST)
public class AppProjectDustEmissionApi {
    private Logger logger =Logger.getLogger(AppProjectDustEmissionApi.class.getName());
    @Autowired
    private SystemClient client;

    /**
     * 根据项目id查询项目扬尘设备列表
     * @param projectId
     * @return
     */
    @PostMapping("getAppProjectDustEmission")
    public JSONObject getAppProjectDustEmission(@RequestParam(value = "projectId",required = false)Long projectId){
        logger.info("com.hujiang.project.zhgd.sbProjectDustEmission.AppProjectDustEmissionApi.getAppProjectDustEmission:projectId="+projectId);
        return client.getAppProjectDustEmission(projectId);
    }




}
