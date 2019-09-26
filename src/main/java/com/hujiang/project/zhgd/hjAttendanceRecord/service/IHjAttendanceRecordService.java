package com.hujiang.project.zhgd.hjAttendanceRecord.service;

import com.hujiang.project.zhgd.hjAttendanceRecord.domain.HjAttendanceRecord;

import java.util.List;
import java.util.Map;

/**
 * 考勤记录 服务层
 * 
 * @author hujiang
 * @date 2019-04-29
 */
public interface IHjAttendanceRecordService 
{


	/**
	 * 劳务工人考勤情况
	 * @param hjAttendanceRecor 获取 项目id
	 * @return
	 */
    Map<String, Object> selectWorkerAttendance(HjAttendanceRecord hjAttendanceRecor);

	/**
	 * 管理人员考勤情况
	 *@param hjAttendanceRecor 获取 项目id
	 * @return
	 */
	Map<String, Object> selectAdministration(HjAttendanceRecord hjAttendanceRecor);

	/**
	 * 人脸考勤
	 * @param
	 * @return
	 */
    Map<String, Object> insertAdministration(HjAttendanceRecord hjAttendanceRecord);
}
