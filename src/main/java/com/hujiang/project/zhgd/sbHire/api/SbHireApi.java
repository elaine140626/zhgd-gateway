package com.hujiang.project.zhgd.sbHire.api;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.sbHire.api.domain.SbArea;
import com.hujiang.project.zhgd.sbHire.api.domain.SbHire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
/**
 * 人员定位pc
 */
@RestController
@RequestMapping(value = "/api/hireApi",method = RequestMethod.POST)
public class SbHireApi extends BaseController {
        @Autowired
        private SystemClient client;

        @PostMapping("/addHire")
        public JSONObject addHire(@RequestBody String json){
            return client.addHire(json);
        }

        @PostMapping("/getHirePeople")
        public JSONObject getHirePeople(@RequestParam(value = "projectId")int projectId)  {
            return client.getHirePeople(projectId);
        }
        /**
         * 搜索查询
         *
         * @param filed 按名字、设备、电话查询当天的定位信息
         * @return
         */
        @PostMapping("/getHireSearch")
        public JSONObject getPeopleAreaSearch(@RequestParam(value = "filed", required = false) String filed,@RequestParam(value = "projectId")int projectId) {
            return client.getPeopleAreaSearch(filed,projectId);
        }

        /**
         * 历史轨迹 按照时间排序
         * @return
         */
        @PostMapping("/getHireHistory")
        public JSONObject getHireHistory(@RequestParam(value = "filed", required = false) String filed,
                                         @RequestParam(value = "projectId")int projectId,
                                         @RequestParam(value = "startTime", required = false) String startTime) {
            return client.getHireHistory(filed,projectId, startTime);
        }
        /**
         * 电子围栏
         * */
        @PostMapping(value = "/edit")
        @ResponseBody
        public JSONObject updateRadius(SbArea sbArea){
            return client.updateRadius(sbArea);
        }
    }

