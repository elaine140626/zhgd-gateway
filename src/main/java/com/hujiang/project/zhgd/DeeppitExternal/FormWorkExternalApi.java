package com.hujiang.project.zhgd.DeeppitExternal;


import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 高支模对外接口
 */
@RestController
@RequestMapping(value = "/api/formWorkExternalApi",method = RequestMethod.POST)
public class FormWorkExternalApi {
    @Autowired
    private SystemClient systemClient;


    @PostMapping(value ="/addFormWorkDisplay")
        public Map<String,Object> addFormWorkDisplay(@RequestBody String json){
        return  systemClient.addFormWorkDisplay(json);
        }


    @PostMapping(value ="/addFormWorkFactor")
    public Map<String,Object> addFormWorkFactor(@RequestBody String json){

        return systemClient.addFormWorkFactor(json);
    }


    @PostMapping(value = "/addFormWorkGroup")
    public Map<String,Object> addFormWorkGroup(@RequestBody String json) {
        return systemClient.addFormWorkGroup(json);
    }

    @PostMapping(value = "/addFormWorkData")
    public Map<String,Object> addFormWorkData(@RequestBody String json){
        return systemClient.addFormWorkData(json);
    }

    @PostMapping(value = "/addFormWorkAlarmData")
    public Map<String,Object> addFormWorkAlarmData(@RequestBody String json){

        return systemClient.addFormWorkAlarmData(json);
    }
}
