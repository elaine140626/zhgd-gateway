package com.hujiang.project.zhgd.hjSystemUser.service;

import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;

import com.hujiang.project.zhgd.hjSystemUser.domain.PasswordParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hujiang.project.zhgd.hjSystemUser.domain.HjSystemUser;

import java.util.Map;

/**
 * 系统用户 服务层实现
 * 
 * @author hujiang
 * @date 2019-04-29
 */
@Service
public class HjSystemUserServiceImpl implements IHjSystemUserService 
{
	@Autowired
	private SystemClient systrmUserClient;

	/**
	 * pc登录
	 * @param user
	 * @return
	 */
	public AjaxResult pcLogin(HjSystemUser user){
		return systrmUserClient.pcLogin(user);
	}

	/**
	 * app登录
	 * @param user
	 * @return
	 */
	public AjaxResult appLogin(HjSystemUser user){
		return systrmUserClient.appLogin(user);
	}
	/**
	 * 修改密码
	 * @param passwordParam 密码
	 * @return id 用户id
	 */
	public Map<String, Object> updateUserPassword(PasswordParam passwordParam){
		return systrmUserClient.updateUserPassword(passwordParam);

	}

	/**
	 * 切换项目
	 * @param userId 人员id
	 * @return
	 */
	public Map<String, Object> queryProject(Integer userId){
		return systrmUserClient.queryProject(userId);
	}
	
}
