package com.hujiang.project.zhgd.hjSystemPrivileges.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.hjSystemPrivileges.service.IHjSystemPrivilegesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: Provider01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-05-21 15:32
 **/
@RestController
@RequestMapping(value = "api/systemPrivileges/app", method = RequestMethod.POST)
public class APP_SystemPrivilegesApi extends BaseController {

    @Autowired
    private IHjSystemPrivilegesService hjSystemPrivilegesService;

    /**
     * app账户菜单权限
     * @param uid
     * @param appOrPc
     * @return
     */
    @RequestMapping(value = "getSystemPrivileges")
    public AjaxResult getSystemPrivileges_app(Integer uid, Integer appOrPc,Integer parentId) {
        return hjSystemPrivilegesService.selectHjSystemPrivilegesByUser(uid, appOrPc,parentId);
    }

}
