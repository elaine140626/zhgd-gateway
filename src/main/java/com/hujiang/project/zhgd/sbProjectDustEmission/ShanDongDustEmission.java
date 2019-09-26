package com.hujiang.project.zhgd.sbProjectDustEmission;

import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.sbDustEmission.domain.SdDustEmission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 山东扬尘
 */
@RestController
@RequestMapping(value = "/api/dustEmission",method = RequestMethod.POST)
public class ShanDongDustEmission {
    @Autowired
    private SystemClient systemClient;

    @RequestMapping("/addDustEmission")
    @ResponseBody
    public Map<String,Object> addDustEmission(@RequestBody String json){
        return systemClient.addDustEmission(json);
    }
}
