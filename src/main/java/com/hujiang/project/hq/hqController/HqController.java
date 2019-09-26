package com.hujiang.project.hq.hqController;

import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 设备通行记录
 */
@RestController
@RequestMapping(value = "/Subscribe",method = RequestMethod.POST)
public class HqController {
@Autowired
private SystemClient client;
    @RequestMapping("/Verify")
    public void record(@RequestBody String json){
        client.hqRecord(json);
    }
}
