package com.hujiang.project.kb;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjArea.domain.HjArea;
import com.hujiang.project.zhgd.hjArea.service.IHjAreaService;
import com.hujiang.project.zhgd.hjProject.domain.HjProject;
import com.hujiang.project.zhgd.hjProject.service.IHjProjectService;
import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 两制人员统计
 */
@RestController
@RequestMapping(value = "/api/lz/get", method = RequestMethod.GET)
public class ApiLZController {
    @Autowired
    private SystemClient client;
    /**
     * 根据项目id获取城市天气
     *
     * @param pid
     * @return
     */
    @RequestMapping("getWeather")
    public JSONObject getWeather(@RequestParam(value = "pid") Integer pid)throws Exception {
        return client.getWeather(pid);
    }

}
