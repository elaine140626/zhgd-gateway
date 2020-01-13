package com.hujiang.project.zhgd.sbAccountTalkback.api;

import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.framework.web.page.PageDomain;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.sbAccountTalkback.domain.SbAccountTalkback;
import com.hujiang.project.zhgd.sbGroupTalkback.domain.SbGroupTalkback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 获取对讲列表
 */
@RestController
@RequestMapping(value = "/api/sbAccountTalkback")
public class SbAccountTalkbackApi extends BaseController {
        @Autowired
        private SystemClient systemClient;

        /**
         * 分页查询对讲机列表
         * @param cpid
         * @param isIdType
         * @param atName
         * @param pageDomain
         * @return
         */
        @PostMapping("/getAccountListPage")
        public AjaxResult getAccountListPage(Integer cpid, String isIdType, SbAccountTalkback sbAccountTalkback, PageDomain pageDomain){
//                System.out.println(pageSize+","+pageNum);
            return systemClient.getAccountListPage(cpid,isIdType,sbAccountTalkback,pageDomain.getPageSize(),pageDomain.getPageNum());
        }
}

