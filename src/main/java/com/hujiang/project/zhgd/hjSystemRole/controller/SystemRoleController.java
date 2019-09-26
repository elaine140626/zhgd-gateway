package com.hujiang.project.zhgd.hjSystemRole.controller;

import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjSystemRole.domain.HjSystemRole;
import com.hujiang.project.zhgd.hjSystemRole.domain.RoleParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @program: Provider01
 * @description:
 * @author: Mr.LiuYong
 * @create: 2019-05-20 19:15
 **/
@RestController
@RequestMapping(value = "/api/systemRoleApi",method = RequestMethod.POST)
public class SystemRoleController {


    @Autowired
    private SystemClient systemClient;

    /**
     * 修改前显示
     * @param hjSystemRole
     * @return
     */
    @RequestMapping(value = "selectSystemRoleId")
    public Map<String, Object> selectSystemRoleId( HjSystemRole hjSystemRole) {
        return systemClient.selectSystemRoleId(hjSystemRole);
    }
    /**
     * 创建角色
     * @param hjSystemRole
     * @return
     */
    @RequestMapping(value = "insertSystemRole")
    public Map<String, Object> insertSystemRole( HjSystemRole hjSystemRole,String ids) {
        return systemClient.insertSystemRole(hjSystemRole,ids);
    }

    /**
     * 修改角色
     * @param hjSystemRole
     * @return
     */
    @RequestMapping(value = "updateSystemRole")
    public Map<String, Object> updateSystemRole( HjSystemRole hjSystemRole,String ids) {
        return systemClient.updateSystemRole(hjSystemRole, ids);
    }

    /**
     * 删除角色
     * @param ids 角色id(1,2,3)
     * @return
     */
    @RequestMapping(value = "deleteSystemRole")
    public Map<String, Object> deleteSystemRole( String ids) {
        return systemClient.deleteSystemRole(ids);
    }


    /**
     * 角色列表
     * @param systemRoleParam
     * @return
     */
    @RequestMapping(value = "selectSystemRole")
    public Map<String, Object> selectSystemRole( RoleParam systemRoleParam) {
        return systemClient.selectSystemRole(systemRoleParam);
    }

    /**
     * 项目 或者 集团 公司 有那些角色
     * @param hjSystemRole
     * @return
     */
    @RequestMapping(value = "querySystemRole")
    public Map<String, Object> querySystemRole( HjSystemRole hjSystemRole) {
        return systemClient.querySystemRole(hjSystemRole);
    }



}
