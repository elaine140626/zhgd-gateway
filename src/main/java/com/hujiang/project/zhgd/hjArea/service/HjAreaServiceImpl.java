package com.hujiang.project.zhgd.hjArea.service;

import com.hujiang.common.support.Convert;
import com.hujiang.framework.web.domain.AjaxResult;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjArea.domain.HjArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 城市 服务层实现
 * 
 * @author hujiang
 * @date 2019-04-29
 */
@Service
public class HjAreaServiceImpl implements IHjAreaService 
{
	@Autowired
	private SystemClient systrmUserClient;


	/**
     * 查询城市列表
     *
     * @return 城市集合
     */
	@Override
	public AjaxResult selectHjAreaList(Long id)
	{
	    return systrmUserClient.getArea(id);
	}
	

}
