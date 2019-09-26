package com.hujiang.project.zhgd.SbProjectVideoArea.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: Provider01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-06-23 14:03
 **/
@RestController
@RequestMapping(value = "/api/appProjectVideoAreaApi",method = RequestMethod.POST)
public class AppProjectVideoAreaApi {
    @Autowired
    private SystemClient client;

    /**
     * 根据项目id获取项目视频区
     * @param projectId
     * @return
     */
    @PostMapping("getAppProjectVideoArea")
    public JSONObject getAppProjectVideoArea(@RequestParam(value = "projectId") Integer projectId){
        return client.getAppProjectVideoArea(projectId);
    }
}
