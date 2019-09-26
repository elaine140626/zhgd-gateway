package com.hujiang.project.zhgd.hjConstructionProject.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.framework.web.page.TableDataInfo;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjConstructionCompany.domain.HjConstructionCompany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/OptionsConstructionApi",method = RequestMethod.POST)
public class OptionsConstructionApi extends BaseController {
    @Autowired
    private SystemClient systemClient;


    /**
     * 查询参建单位列表
     * @param projectId 项目id
     * @return
     */
    @PostMapping("/getConstructionList")
    public JSONObject getConstructionList(@RequestParam("projectId") Integer projectId, PageDomain pageDomain)
    {
        return systemClient.getConstructionList(projectId,pageDomain.getPageSize(),pageDomain.getPageNum());
    }
}
