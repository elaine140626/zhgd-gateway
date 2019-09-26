package com.hujiang.project.hq.hqController;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/DevService",method = RequestMethod.POST)
public class HqTest {
    @Autowired
    private SystemClient client;
    @RequestMapping(value = "/GetRequest.ashx")
    public JSONObject getRequest(@RequestBody String json){
        System.out.println(json);

        return client.xm(JSONObject.parseObject(json).getString("sn"));
    }
      @PostMapping(value = "/FeedBack.ashx")
    public void feedBack(@RequestBody String json){
        System.out.println(json);

        client.feedBack(json);
    }

}
