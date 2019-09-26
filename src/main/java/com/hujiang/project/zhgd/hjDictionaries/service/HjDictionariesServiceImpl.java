
package com.hujiang.project.zhgd.hjDictionaries.service;

import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjDictionaries.domain.HjDictionaries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 字典 服务层实现
 * 
 * @author hujiang
 * @date 2019-04-29
 */
@Service
public class HjDictionariesServiceImpl implements IHjDictionariesService
{
	@Autowired
	private SystemClient systrmUserClient;
	/**
     * 查询字典列表
     * 
     * @param hjDictionaries 字典信息
     * @return 字典集合
     */
	@Override
	public Map<String, Object> selectHjDictionariesList(HjDictionaries hjDictionaries)
	{
	    return systrmUserClient.selectDictionaries(hjDictionaries);
	}

	
}
