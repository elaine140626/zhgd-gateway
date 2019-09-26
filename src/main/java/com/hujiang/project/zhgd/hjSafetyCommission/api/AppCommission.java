package com.hujiang.project.zhgd.hjSafetyCommission.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/appCommissionApi",method = RequestMethod.POST)
public class AppCommission extends BaseController {
    @Autowired
    private SystemClient systemClient;
    @PostMapping(value = "/getCommission")
    @ResponseBody
    public JSONObject getCommission(Integer projectId,
                                    Integer userId,
                                    Integer status,
                                    PageDomain pageDomain){

        return systemClient.getCommission(projectId,userId,status,pageDomain.getPageSize(),pageDomain.getPageNum());
    }
    @PostMapping(value = "/updateCommission")
    @ResponseBody
    public JSONObject updateCommission(Integer id,
                                      Integer status){
        return systemClient.updateCommission(id, status);
    }

}
