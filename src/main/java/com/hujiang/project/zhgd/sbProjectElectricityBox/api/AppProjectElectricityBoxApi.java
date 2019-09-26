package com.hujiang.project.zhgd.sbProjectElectricityBox.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: Provider01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-06-24 11:52
 **/
@RestController
@RequestMapping(value = "/api/appProjectElectricityBox",method = RequestMethod.POST)
public class AppProjectElectricityBoxApi {
    @Autowired
    private SystemClient client;

    /**
     * 根据项目id获取电箱设备编号
     * @param projectId
     * @return
     */
    @PostMapping("getAppProjectElectricityBox")
    public JSONObject getAppProjectElectricityBox(@RequestParam(value = "projectId") Integer projectId){
        return client.getAppProjectElectricityBox(projectId);
    }

    @PostMapping("getBoxList")
    public AjaxResult getBoxList(@RequestParam(value = "pid") Integer pid){
        return client.getBoxList(pid);
    }
}
