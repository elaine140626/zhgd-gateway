package com.hujiang.project.zhgd.hjSystemUser.controller;

import com.alibaba.fastjson.JSONObject;
import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.Constants;
import com.hujiang.project.zhgd.RestTemplateUtil;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjSystemUser.domain.HjSystemUser;
import com.hujiang.project.zhgd.hjSystemUser.domain.PasswordParam;
import com.hujiang.project.zhgd.hjSystemUser.service.IHjSystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统用户 信息操作处理
 *
 * @author hujiang
 * @date 2019-04-29
 */
@RestController
@RequestMapping(value = "/api/system/application", method = RequestMethod.POST)
public class APP_HjSystemUserController extends BaseController {
    @Autowired
    private IHjSystemUserService systemUserService;
    @Autowired
    private RestTemplateUtil restTemplateUtil;
    @Autowired
    private SystemClient systemClient;


    /**
     * app登录
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/login")
    public AjaxResult appLogin(HjSystemUser user) {
        if (user.getUserAccount() == null || user.getUserPassword() == null) {
            return error(-1, "账户密码不能为空");
        }
        return systemUserService.appLogin(user);
    }

    /**
     * 修改密码
     * @param passwordParam 密码
     * @return id 用户id
     */
    @RequestMapping(value = "updateUserPassword")
    public Map<String, Object> updateUserPassword( PasswordParam passwordParam){
        return systemUserService.updateUserPassword(passwordParam);
    }

    /**
     * 切换项目
     * @param userId 人员id
     * @return
     */
    @RequestMapping("/queryProject")
    public Map<String, Object> queryProject(Integer userId)
    {
        return systemUserService.queryProject(userId);
    }

    @PostMapping("/updateUserById")
    public JSONObject updateUserById(@RequestParam(value = "userName",required = false)String userName,
                                     @RequestParam(value = "userPhone",required = false)String userPhone,
                                     @RequestParam(value = "userId",required = false)Integer userId){
        return systemClient.updateUserById(userName,  userPhone, userId);
    }
}
