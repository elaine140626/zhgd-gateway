package com.hujiang.project.zhgd.hjProject.service;

import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.hjProject.domain.HjProject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * 项目 服务层
 * 
 * @author hujiang
 * @date 2019-04-29
 */
public interface IHjProjectService 
{
	/**
	 * 添加项目
	 * @param hjProject
	 * @param cid
	 * @param file
	 * @return
	 */
	AjaxResult addSave(HjProject hjProject, Integer cid, MultipartFile file);
}
