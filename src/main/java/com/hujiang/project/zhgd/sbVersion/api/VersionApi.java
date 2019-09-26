package com.hujiang.project.zhgd.sbVersion.api;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.sbVersion.domain.SbVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/versionApi",method = RequestMethod.POST)
public class VersionApi {
    @Autowired
    private SystemClient systemClient;

    @PostMapping("/getVersion")
    public JSONObject getVersion(){
        return systemClient.getVersion();
    }
}
