package com.hujiang.project.zhgd.hjAttendanceRecord.domain;

import java.util.Date;


/**
 * 考勤记录表 hj_attendance_record
 * 
 * @author hujiang
 * @date 2019-04-29
 */
public class HjAttendanceRecord
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Integer id;
	/** 项目编号 */
	private Integer projectId;
	/** 员工编号 */
	private Integer employeeId;
	/** 通过时间 ”yyyy-MM-dd hh:mm:ss” */
	private String passedTime;
	/** 通行方向  in—进，out—出 */
	private String direction;
	/** 通行方式 1—人脸识别，2—虹膜识别，3—指纹识别，4—掌形识别，5—身份证识别，6—实名卡，7—异常清退（适用于人员没有通过闸机系统出工地而导致人员状态不一致的情况），8—一键开闸(需要与闸机交互)， 9—应急通道（不需要与闸机交互），10—二维码识别，11-其他方式 */
	private Integer way;
	/** 工地现场采集的人脸照片，url */
	private String sitePhoto;
	/** 创建时间 */
	private Date createDate;
	/** 上传时间 */
	private String uploadTime;

	/** 考勤设备类型 */
	private String deviceType;
	/** 考勤设备唯一识别码 */
	private String deviceSn;

	public String getDeviceType() {
		return deviceType;
	}

	public void setDeviceType(String deviceType) {
		this.deviceType = deviceType;
	}

	public String getDeviceSn() {
		return deviceSn;
	}

	public void setDeviceSn(String deviceSn) {
		this.deviceSn = deviceSn;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setProjectId(Integer projectId) 
	{
		this.projectId = projectId;
	}

	public Integer getProjectId() 
	{
		return projectId;
	}
	public void setEmployeeId(Integer employeeId) 
	{
		this.employeeId = employeeId;
	}

	public Integer getEmployeeId() 
	{
		return employeeId;
	}
	public void setPassedTime(String passedTime) 
	{
		this.passedTime = passedTime;
	}

	public String getPassedTime() 
	{
		return passedTime;
	}
	public void setDirection(String direction) 
	{
		this.direction = direction;
	}

	public String getDirection() 
	{
		return direction;
	}
	public void setWay(Integer way) 
	{
		this.way = way;
	}

	public Integer getWay() 
	{
		return way;
	}
	public void setSitePhoto(String sitePhoto) 
	{
		this.sitePhoto = sitePhoto;
	}

	public String getSitePhoto() 
	{
		return sitePhoto;
	}
	public void setCreateDate(Date createDate) 
	{
		this.createDate = createDate;
	}


	public Date getCreateDate() 
	{
		return createDate;
	}

	public String getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(String uploadTime) {
		this.uploadTime = uploadTime;
	}

	@Override
	public String toString() {
		return "HjAttendanceRecord{" +
				"id=" + id +
				", projectId=" + projectId +
				", employeeId=" + employeeId +
				", passedTime='" + passedTime + '\'' +
				", direction='" + direction + '\'' +
				", way=" + way +
				", sitePhoto='" + sitePhoto + '\'' +
				", createDate=" + createDate +
				", uploadTime='" + uploadTime + '\'' +
				", deviceType='" + deviceType + '\'' +
				", deviceSn='" + deviceSn + '\'' +
				'}';
	}
}
