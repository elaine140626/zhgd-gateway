package com.hujiang.project.ys.apiRecord;

import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/ys")
public class YsRecordApi {
    @Autowired
    private SystemClient client;
    @PostMapping(value = "/setRecord")
    public String setRecordYs(@RequestBody String json){
        return client.setRecordYs(json);
    }
}
