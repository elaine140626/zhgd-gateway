package com.hujiang.project.zhgd.sbCurrentTemperature.api;

import com.hujiang.project.zhgd.client.SystemClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(value = "/api/electricityBoxExternal")
public class ElectricityBoxExternalApi {

    @Autowired
    private SystemClient systemClient;

    @PostMapping("/addElectricityBox")
    public Map<String,Object> addElectricityBox(@RequestBody String json){
        return systemClient.addElectricityBox(json);
    }

}
