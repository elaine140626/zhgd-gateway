package com.hujiang.project.zhgd.hjSystemUser.controller;

import com.hujiang.framework.web.controller.BaseController;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjSystemUser.domain.HjSystemUser;
import com.hujiang.project.zhgd.hjSystemUser.domain.SystemUserParam;
import com.hujiang.project.zhgd.hjSystemUser.domain.UserParam;
import com.hujiang.project.zhgd.hjSystemUser.service.IHjSystemUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * 系统用户 信息操作处理
 *
 * @author hujiang
 * @date 2019-04-29
 */
@RestController
@RequestMapping(value = "/api/system/computer", method = RequestMethod.POST)
public class PC_HjSystemUserController extends BaseController {
    @Autowired
    private IHjSystemUserService systemUserService;
    @Autowired
    private SystemClient systemClient;

    @RequestMapping("test")
    public AjaxResult test(){
        return systemClient.test();
    }
    /**
     * pc登录
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/login")
    public AjaxResult pcLogin(HjSystemUser user) {
        if (user.getUserAccount() == null || user.getUserPassword() == null) {
            return error(-1, "账户密码不能为空");
        }
        return systemUserService.pcLogin(user);
    }

    /**
     * 查看账号是否存在
     * @param user
     * @return
     */
    @RequestMapping(value = "selectSystemUser")
    public Map<String, Object> selectSystemUser( HjSystemUser user) {
        return systemClient.selectSystemUser(user);
    }


    /**
     * 创建账号
     * @param systemUserParam
     * @return
     */
    @RequestMapping(value = "insertSystemUser")
    public Map<String, Object> insertSystemUser( SystemUserParam systemUserParam) {
        return systemClient.insertSystemUser(systemUserParam);
    }

    /**
     * 修改账号
     * @param hjSystemUser
     * @return
     */
    @RequestMapping(value = "updateSystemUser")
    public Map<String, Object> updateSystemUser( HjSystemUser hjSystemUser,String ids) {
        System.out.println(hjSystemUser);
        return systemClient.updateSystemUser(hjSystemUser,ids);
    }

    /**
     * 删除账号
     * @param ids 角色id(1,2,3)
     * @return
     */
    @RequestMapping(value = "deleteSystemUser")
    public Map<String, Object> deleteSystemUser( String ids) {
        return systemClient.deleteSystemUser(ids);
    }


    /**
     * 列表账号
     * @param userParam
     * @return
     */
    @RequestMapping(value = "querySystemUser")
    public Map<String, Object> querySystemUser( UserParam userParam) {
        System.out.println(userParam);
        return systemClient.querySystemUser(userParam);
    }
    /**
     * 修改前显示
     * @param hjSystemUser
     * @return
     */
    @RequestMapping(value = "selectUserId")
    public Map<String, Object> selectUserId( HjSystemUser hjSystemUser) {
        return systemClient.selectUserId(hjSystemUser);
    }


}
