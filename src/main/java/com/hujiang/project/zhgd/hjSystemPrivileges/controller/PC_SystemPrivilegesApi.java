package com.hujiang.project.zhgd.hjSystemPrivileges.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjSystemPrivileges.domain.HjSystemPrivileges;
import com.hujiang.project.zhgd.hjSystemPrivileges.domain.SystemRoleParam;
import com.hujiang.project.zhgd.hjSystemPrivileges.service.IHjSystemPrivilegesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @program: Provider01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-05-21 15:32
 **/
@RestController
@RequestMapping(value = "api/systemPrivileges/pc", method = RequestMethod.POST)
public class PC_SystemPrivilegesApi extends BaseController {

    @Autowired
    private IHjSystemPrivilegesService hjSystemPrivilegesService;
    @Autowired
    private SystemClient systemClient;

    /**
     * pc菜单权限
     * @param uid
     * @param appOrPc
     * @return
     */
    @RequestMapping(value = "getSystemPrivileges")
    public AjaxResult getSystemPrivileges_pc(Integer uid, Integer appOrPc,Integer parentId) {
        return hjSystemPrivilegesService.selectHjSystemPrivilegesByUser(uid, appOrPc, parentId);
    }
    /**
     * 查询权限列表
     * @param systemRoleParam
     * @return
     */
    @RequestMapping(value = "selectSystemPrivileges")
    public Map<String, Object> selectSystemPrivileges( SystemRoleParam systemRoleParam){
        System.out.println(systemRoleParam);
        return systemClient.selectSystemPrivileges(systemRoleParam);
    }

    @PostMapping(value = "/getPrivilegesList")
    public JSONObject getPrivilegesList(@RequestParam("userId")Integer userId){
       return systemClient.getPrivilegesList(userId);
    }

    /**
     * 查询全部
     * @param hjSystemPrivileges
     * @return
     */
    @RequestMapping(value = "querySystemPrivileges")
    public Map<String, Object> querySystemPrivileges(HjSystemPrivileges hjSystemPrivileges) {
        return systemClient.querySystemPrivileges(hjSystemPrivileges);
    }
}
