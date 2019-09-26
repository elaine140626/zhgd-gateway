package com.hujiang.project.zhgd.dustEmissionThresholdValue.api;

import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.dustEmissionThresholdValue.domain.DustEmissionThresholdValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: Provider01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-07-08 18:15
 **/
@RestController
@RequestMapping(value = "/api/DustEmissionThresholdValueAPI")
public class DustEmissionThresholdValueAPI extends BaseController {
    @Autowired
    private SystemClient client;

    /**
     * 扬尘阈值查询
     * @param thresholdValue
     * @return
     */
    @PostMapping("getThresholdValue")
    public AjaxResult getThresholdValue(DustEmissionThresholdValue thresholdValue){
        return client.getThresholdValue(thresholdValue);
    }

    /**
     * 扬尘阈值修改
     * @param thresholdValue
     * @return
     */
    @PostMapping("updateThresholdValue")
    public AjaxResult updateThresholdValue(DustEmissionThresholdValue thresholdValue){
        return client.updateThresholdValue(thresholdValue);
    }
}
