package com.hujiang.project.zhgd.hjCompanyLibrary.service;

import com.hujiang.common.support.Convert;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjCompanyLibrary.domain.HjCompanyLibrary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 公司库 服务层实现
 * 
 * @author hujiang
 * @date 2019-04-29
 */
@Service
public class HjCompanyLibraryServiceImpl implements IHjCompanyLibraryService
{
	@Autowired
	private SystemClient systemClient;
	/**
	 * 查询指定公司下公司和项目信息
	 * @param
	 * @return
	 */
	@Override
	public Map<String,Object> selectHjCompanyProjectList(Integer companyId){
		return systemClient.selectHjCompanyProjectList(companyId);
	}
	/**
	 * 保存公司库信息
	 * @param
	 * @return
	 */
	@Override
	public AjaxResult insertHjCompanyLibrary(HjCompanyLibrary hjCompanyLibrary, Integer parentId)
	{
		int i = systemClient.insertHjCompanyLibrary(hjCompanyLibrary, parentId);
		if(i>0){
			return AjaxResult.success();
		}
		return AjaxResult.error(-1,"操作失败");
	}
	/**
	 * 根据id查询公司库信息
	 * @param
	 * @return
	 */
	@Override
	public AjaxResult selectHjCompanyLibraryIds(Integer id){
		System.out.println(id);
		HjCompanyLibrary companyLibrary = systemClient.selectHjCompanyLibraryIds(id);
		if(companyLibrary!=null){
			return AjaxResult.success(companyLibrary);
		}
		return AjaxResult.error(-1,"操作失败");
	}
	/**
	 * 修改保存公司库信息
	 * @param
	 * @return
	 */
	@Override
	public AjaxResult updateHjCompanyLibrary(HjCompanyLibrary hjCompanyLibrary){
		int i = systemClient.updateHjCompanyLibrary(hjCompanyLibrary);
		if(i>0){
			return AjaxResult.success();
		}
		return AjaxResult.error(-1,"操作失败");
	}

	/**
	 * 根据单位类型查询公司库信息列表
	 * @param
	 * @return
	 */
	@Override
	public AjaxResult selectHjCompanyLibraryList(HjCompanyLibrary hjCompanyLibrary){
		return AjaxResult.success(systemClient.selectHjCompanyLibraryList(hjCompanyLibrary));
	}
}
