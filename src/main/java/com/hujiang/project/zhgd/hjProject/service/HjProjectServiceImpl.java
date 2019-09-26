package com.hujiang.project.zhgd.hjProject.service;

import com.hujiang.common.support.Convert;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjProject.domain.HjProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 项目 服务层实现
 * 
 * @author hujiang
 * @date 2019-04-29
 */
@Service
public class HjProjectServiceImpl implements IHjProjectService
{
	@Autowired
	private SystemClient systrmUserClient;

	/**
	 * 添加项目
	 * @param hjProject
	 * @param cid
	 * @param file
	 * @return
	 */
	public AjaxResult addSave(HjProject hjProject, Integer cid, MultipartFile file){
		return systrmUserClient.addSave(hjProject, cid, file);
	}


}
