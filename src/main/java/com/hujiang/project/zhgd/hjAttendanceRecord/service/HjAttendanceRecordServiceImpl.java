package com.hujiang.project.zhgd.hjAttendanceRecord.service;

import com.hujiang.common.support.Convert;
import com.hujiang.project.zhgd.client.SystemClient;
import com.hujiang.project.zhgd.hjAttendanceRecord.domain.HjAttendanceRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 考勤记录 服务层实现
 * 
 * @author hujiang
 * @date 2019-04-29
 */
@Service
public class HjAttendanceRecordServiceImpl implements IHjAttendanceRecordService 
{

	@Autowired
	private SystemClient systrmUserClient;
	/**
	 * 劳务工人考勤情况
	 * @return
	 */
	@Override
	public Map<String, Object> selectWorkerAttendance(HjAttendanceRecord hjAttendanceRecord) {
		return systrmUserClient.selectWorkerAttendance(hjAttendanceRecord);
	}

	/**
	 * 管理人员考勤情况
	 * @return
	 */
	@Override
	public Map<String, Object> selectAdministration(HjAttendanceRecord hjAttendanceRecord) {
		return systrmUserClient.selectAdministration(hjAttendanceRecord);
	}


	/**
	 * 人脸考勤
	 * @param
	 * @return
	 */
	@Override
	public Map<String, Object> insertAdministration(HjAttendanceRecord hjAttendanceRecord) {
		return systrmUserClient.insertAdministration(hjAttendanceRecord);
	}

}
