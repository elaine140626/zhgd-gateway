package com.hujiang.project.zhgd.hjSystemPrivileges.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.hujiang.common.support.Convert;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjSystemPrivileges.domain.HjSystemPrivileges;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * 系统-权限 服务层实现
 * 
 * @author hujiang
 * @date 2019-04-29
 */
@Service
public class HjSystemPrivilegesServiceImpl implements IHjSystemPrivilegesService 
{
	@Autowired
	private SystemClient systrmUserClient;

	/**
	 * 根据用户id查询pc或app菜单权限
	 * @param uid
	 * @param appOrPc
	 * @return
	 */
	@Override
	public AjaxResult selectHjSystemPrivilegesByUser(Integer uid, Integer appOrPc,Integer parentId) {
		if(appOrPc==1){//pc 菜单
			return systrmUserClient.getSystemPrivileges_pc(uid, appOrPc, parentId);
		}
		return systrmUserClient.getSystemPrivileges_app(uid, appOrPc, parentId);//app 菜单
	}

}
