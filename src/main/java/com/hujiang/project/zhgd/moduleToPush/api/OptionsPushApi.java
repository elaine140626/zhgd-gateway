package com.hujiang.project.zhgd.moduleToPush.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/OptionsPushApi",method = RequestMethod.POST)
public class OptionsPushApi {
    @Autowired
    private SystemClient systemClient;

    @PostMapping(value = "/optionsPush")
    public JSONObject optionsPush(@RequestParam(value = "onOff")Integer onOff,
                                  @RequestParam(value = "userId")Integer userId,
                                  @RequestParam(value = "privilegesId")Integer privilegesId) {
        return systemClient.optionsPush(onOff,userId,privilegesId);
    }
}
