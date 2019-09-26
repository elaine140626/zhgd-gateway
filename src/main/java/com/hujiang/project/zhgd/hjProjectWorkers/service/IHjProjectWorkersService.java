package com.hujiang.project.zhgd.hjProjectWorkers.service;

import com.hujiang.project.zhgd.hjProjectWorkers.domain.*;

import java.util.List;
import java.util.Map;

/**
 * 项目工人 服务层
 * 
 * @author hujiang
 * @date 2019-05-19
 */
public interface IHjProjectWorkersService 
{

	/**
	 * 人员信息列表
	 * @param empNameParam
	 * @return
	 */
    Map<String, Object> selectProjectWorkers(EmpNameParam empNameParam);

	/**
	 * 人员信息 所属单位
	 * @param projectWorkers
	 * @return
	 */
    Map<String, Object> selectConstructionProject(ProjectWorkers projectWorkers);

	/**
	 * 人员信息 详情
	 * @param projectWorkersParam
	 * @return
	 */
    Map<String, Object> selectProjectWorkersDetails(ProjectWorkersParam projectWorkersParam);

	/**
	 * 实名制录入
	 * @param hjProjectWorkers
	 * @return
	 */
	Map<String, Object> insertProjectWorkers(HjProjectWorkers hjProjectWorkers);
	/**
	 * 人员信息 修改
	 * @param hjProjectWorkers
	 * @return
	 */
	Map<String, Object> updateProjectWorkers(HjProjectWorkers hjProjectWorkers);
	/**
	 * 人员信息 是否签订
	 * @param signParam
	 * @return
	 */
	Map<String, Object> selectSignParam(SignParam signParam);

	/**
	 * 获取银行卡信息
	 * @return 身份信息
	 */
	Map<String, Object> getAliOcrBankcard(AliOcrBankCard aliOcrBankCard);
}
