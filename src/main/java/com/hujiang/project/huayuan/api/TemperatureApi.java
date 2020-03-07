package com.hujiang.project.huayuan.api;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/api/hy")
public class TemperatureApi {
    private Logger logger = Logger.getLogger(TemperatureApi.class.getName());
    @PostMapping(value = "/temperature")
    public String getTemperature(@RequestBody String json){
        logger.info("体温数据：" + json);

        JSONObject result=new JSONObject();
        result.put("code",0);
        result.put("msg","成功");
        return result.toJSONString();
    }
}
