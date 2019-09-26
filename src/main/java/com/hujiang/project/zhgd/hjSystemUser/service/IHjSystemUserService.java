package com.hujiang.project.zhgd.hjSystemUser.service;

import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.hjSystemUser.domain.HjSystemUser;
import com.hujiang.project.zhgd.hjSystemUser.domain.PasswordParam;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 系统用户 服务层
 * 
 * @author hujiang
 * @date 2019-04-29
 */
public interface IHjSystemUserService 
{
	/**
	 * 登录
	 * @param user
	 * @return
	 */
	AjaxResult pcLogin(HjSystemUser user);

	AjaxResult appLogin(HjSystemUser user);

	/**
	 * 修改密码
	 * @param passwordParam 密码
	 * @return id 用户id
	 */
	Map<String, Object> updateUserPassword(PasswordParam passwordParam);

	/**
	 * 切换项目
	 * @param userId 人员id
	 * @return
	 */
	Map<String, Object> queryProject(Integer userId);

}
