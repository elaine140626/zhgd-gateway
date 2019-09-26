package com.hujiang.project.zhgd.hjProjectWorkers.service;

import com.hujiang.common.support.Convert;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjProjectWorkers.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 项目工人 服务层实现
 * 
 * @author hujiang
 * @date 2019-05-19
 */
@Service
public class HjProjectWorkersServiceImpl implements IHjProjectWorkersService
{
	@Autowired
	private SystemClient systrmUserClient;



	/**
	 * 人员信息列表
	 * @param empNameParam
	 * @return
	 */
	@Override
	public Map<String, Object> selectProjectWorkers(EmpNameParam empNameParam) {
		return systrmUserClient.selectProjectWorkers(empNameParam);
	}

	/**
	 * 人员信息 所属单位
	 * @param projectWorkers
	 * @return
	 */
	@Override
	public Map<String, Object> selectConstructionProject(ProjectWorkers projectWorkers) {
		return systrmUserClient.selectConstructionProject(projectWorkers);
	}

	/**
	 * 人员信息 详情
	 * @param projectWorkersParam
	 * @return
	 */
	@Override
	public Map<String, Object> selectProjectWorkersDetails(ProjectWorkersParam projectWorkersParam) {
		return systrmUserClient.selectProjectWorkersDetails(projectWorkersParam);
	}

	/**
	 * 实名制录入
	 * @param hjProjectWorkers
	 * @return
	 */
	@Override
	public Map<String, Object> insertProjectWorkers(HjProjectWorkers hjProjectWorkers) {

		return systrmUserClient.insertProjectWorkers(hjProjectWorkers);
	}

	/**
	 * 人员信息 修改
	 * @param hjProjectWorkers
	 * @return
	 */
	@Override
	public Map<String, Object> updateProjectWorkers(HjProjectWorkers hjProjectWorkers){
		return systrmUserClient.updateProjectWorkers(hjProjectWorkers);
	}
	/**
	 * 人员信息 是否签订
	 * @param signParam
	 * @return
	 */
	@Override
	public Map<String, Object> selectSignParam(SignParam signParam){
		return systrmUserClient.selectSignParam(signParam);
	}

	/**
	 * 获取银行卡信息
	 * @return 身份信息
	 */
	@Override
	public Map<String, Object> getAliOcrBankcard(AliOcrBankCard aliOcrBankCard){
		return systrmUserClient.getAliOcrBankcard(aliOcrBankCard);
	}
}
