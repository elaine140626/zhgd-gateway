package com.hujiang.project.zhgd.sbHire.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * 移动端
 */
@RestController
@RequestMapping(value = "/api/hireAppApi",method = RequestMethod.POST)
public class SbHireAppApi extends BaseController {
    @Autowired
    private SystemClient client;

    /**
     * 实时监控
     * @return
     * @throws ParseException
     */
    @PostMapping("/getHirePeople")
    public JSONObject getAppHirePeople( @RequestParam(value = "projectId")int projectId)  {
        return client.getAppHirePeople(projectId);
    }
    /**
     * 搜索查询
     * @return
     */
    @PostMapping("/getHireByNameSearch")
    public JSONObject getAppHireByNameSearch(@RequestParam(value = "userName",required = false) String userName,
                                             @RequestParam(value = "projectId")int projectId) {
        return client.getAppHireByNameSearch(userName,projectId);
    }
    /**
     * 历史记录
     * @return
     */
    @PostMapping("/getHireByNameHistory")
    public JSONObject getHireByNameHistory(@RequestParam(value = "userName",required = false) String userName,
                                           @RequestParam(value = "projectId")int projectId) {
        return client.getAppHireByNameHistory(userName,projectId);
    }
    /**
     *  根据人员姓名查询多个判断是否状态：在线/离线
     */
    @PostMapping("/getHirePeopleList")
    public JSONObject getAppHirePeopleList(@RequestParam(value = "userName",required = false)String userName,
                                           @RequestParam(value = "projectId")int projectId) throws ParseException{
        return client.getAppHirePeopleList(userName,projectId);
    }
}
