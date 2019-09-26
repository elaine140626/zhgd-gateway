package com.hujiang.project.zhgd.hjArea.service;

import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.hjArea.domain.HjArea;

import java.util.List;

/**
 * 城市 服务层
 * 
 * @author hujiang
 * @date 2019-04-29
 */
public interface IHjAreaService 
{

	/**
     * 查询城市列表
     * 
     * @param hjArea 城市信息
     * @return 城市集合
     */
	AjaxResult selectHjAreaList(Long id);

	
}
