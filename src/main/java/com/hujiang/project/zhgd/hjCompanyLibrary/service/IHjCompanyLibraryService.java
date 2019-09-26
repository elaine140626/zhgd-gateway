package com.hujiang.project.zhgd.hjCompanyLibrary.service;

import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.hjCompanyLibrary.domain.HjCompanyLibrary;

import java.util.List;
import java.util.Map;

/**
 * 公司库 服务层
 * 
 * @author hujiang
 * @date 2019-04-29
 */
public interface IHjCompanyLibraryService 
{
	/**
	 * 保存公司库信息
	 * @param
	 * @return
	 */
	AjaxResult insertHjCompanyLibrary(HjCompanyLibrary hjCompanyLibrary, Integer parentId);

	/**
	 * 根据id查询公司库信息
	 * @param
	 * @return
	 */
	AjaxResult selectHjCompanyLibraryIds(Integer id);
	/**
	 * 修改保存公司库信息
	 * @param
	 * @return
	 */
	AjaxResult updateHjCompanyLibrary(HjCompanyLibrary hjCompanyLibrary);

	/**
	 * 根据单位类型查询公司库信息列表
	 * @param
	 * @return
	 */
	AjaxResult selectHjCompanyLibraryList(HjCompanyLibrary hjCompanyLibrary);
	/**
	 * 查询指定公司下公司和项目信息
	 * @param
	 * @return
	 */
	Map<String,Object> selectHjCompanyProjectList(Integer companyId);
}
