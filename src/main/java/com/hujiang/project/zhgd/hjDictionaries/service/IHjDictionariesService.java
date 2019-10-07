package com.hujiang.project.zhgd.hjDictionaries.service;

import com.hujiang.project.zhgd.hjDictionaries.domain.HjDictionaries;

import java.util.List;
import java.util.Map;

/**
 * 字典 服务层
 * 
 * @author hujiang
 * @date 2019-04-29
 */
public interface IHjDictionariesService 
{

	/**
     * 查询字典列表
     * 
     * @param hjDictionaries 字典信息
     * @return 字典集合
     */
	Map<String, Object> selectHjDictionariesList(HjDictionaries hjDictionaries);

	/**
     * 查询字典列表
     *
     * @param
     * @return 字典集合
     */
	Map<String, Object> selectDictionariesWorkType(Integer pid);

}
