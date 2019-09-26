package com.hujiang.project.zhgd.hjSystemPrivileges.service;

import com.alibaba.fastjson.JSONArray;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.hjSystemPrivileges.domain.HjSystemPrivileges;

import java.util.List;
import java.util.Map;

/**
 * 系统-权限 服务层
 * 
 * @author hujiang
 * @date 2019-04-29
 */
public interface IHjSystemPrivilegesService 
{
	/**
	 * 根据用户id查询pc或app菜单权限
	 * @param uid
	 * @param appOrPc
	 * @return
	 */
	AjaxResult selectHjSystemPrivilegesByUser(Integer uid, Integer appOrPc,Integer parentId);

}
