package com.hujiang.project.zhgd.sbExcessiveDust.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.sbExcessiveDust.domain.SbExcessiveDust;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(value = "/api/appDustApi",method = RequestMethod.POST)
public class AppDust extends BaseController {
    @Autowired
    private SystemClient systemClient;

    @PostMapping(value = "/getExcessive")
    public JSONObject getExcessive(@RequestParam(value = "projectId")Integer projectId,
                                   @RequestParam(value = "userId")Integer userId,
                                   @RequestParam(value = "status")Integer status,
                                   PageDomain pageDomain){
        return systemClient.getExcessive(projectId,userId,status,pageDomain.getPageSize(),pageDomain.getPageNum());
    }

    @PostMapping(value = "/updateExcessive")
    public JSONObject updateExcessive(@RequestParam(value = "id")Integer id,
                                      @RequestParam(value = "status")Integer status){
        return systemClient.updateExcessive(id, status);
    }

    @PostMapping(value = "/getCount")
    public JSONObject getCount(@RequestParam(value = "projectId")Integer projectId, @RequestParam(value = "userId")Integer userId){

        return systemClient.getCount(projectId, userId);
    }
}
