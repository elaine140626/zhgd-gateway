package com.hujiang.project.zhgd.sbGroupTalkback.api;

import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.sbGroupTalkback.domain.SbGroupTalkback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 获取集团对讲列表
 */
@RestController
@RequestMapping(value = "/api/sbGroupTalkback",method = RequestMethod.POST)
public class SbGroupTalkbackApi extends BaseController {
        @Autowired
        private SystemClient client;


        @PostMapping("/getAccountList")
        public List<SbGroupTalkback> getAccountList(SbGroupTalkback sbGroupTalkback){

            return client.getAccountList(sbGroupTalkback);
        }



}

