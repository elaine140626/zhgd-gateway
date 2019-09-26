package com.hujiang.project.zhgd.hjZhgdDriver.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.page.TableDataInfo;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjZhgdDriver.domain.HjZhgdDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/driver")
public class DriverApi extends BaseController {

    @Autowired
    private SystemClient client;

    @PostMapping(value = "/insertDriver")
    @ResponseBody
    public JSONObject add(String driver, String vehicle, Integer projectId){
        return client.addDriver(driver, vehicle, projectId);
    }

    @PostMapping(value = "/selectAll")
    @ResponseBody
    public JSONObject all(HjZhgdDriver hjZhgdDriver,@RequestParam("pageSize") Integer pageSize, @RequestParam("pageNum")Integer pageNum){
        return client.all(hjZhgdDriver,pageSize,pageNum);
    }

    @PostMapping(value = "/delDriver")
    @ResponseBody
    public JSONObject del(Integer id){
        return client.del(id);
    }

    @PostMapping(value = "/updateDriver")
    @ResponseBody
    public JSONObject uod(HjZhgdDriver hjZhgdDriver){
        return client.uod(hjZhgdDriver);
    }
}
