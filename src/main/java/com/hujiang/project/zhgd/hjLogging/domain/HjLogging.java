package com.hujiang.project.zhgd.hjLogging.domain;

import com.hujiang.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 考勤，实名制日志表 hj_logging
 * 
 * @author hujiang
 * @date 2019-06-14
 */
public class HjLogging
{
	private static final long serialVersionUID = 1L;
	
	/** 主键 */
	@Excel(name = "编号")
	private Integer id;
	/** 项目id */
	@Excel(name = "项目id")
	private Integer projectId;
	/** 0-考勤 1-进场 2-退场 */
	@Excel(name = "操作类型",readConverterExp = "0=考勤,1=进场,2=退场" )
	private Integer loggingType;
	/** 时间 */
	@Excel(name = "时间")
	private String loggingTime;
	/** 成功或者失败原因 */
	@Excel(name = "结果")
	private String loggingMessage;
	/** 0-成功 1-失败 */
	private Integer loggingResult;
	/** 返回值 */
	private String loggingData;
	/** 0-上班，1下班 */
	@Excel(name = "考勤类型",readConverterExp = "in=上班,out=下班" )
	private String inOut;
	/** 人员姓名 */
	@Excel(name = "人员姓名")
	private String userName;
	/** 人员id */
	private Integer userId;
	/** 对接平台（对应数据字典表） */
	@Excel(name = "对接平台")
	private String loggingTag;

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
	public void setLoggingType(Integer loggingType) 
	{
		this.loggingType = loggingType;
	}

	public Integer getLoggingType() 
	{
		return loggingType;
	}
	public void setLoggingTime(String loggingTime) 
	{
		this.loggingTime = loggingTime;
	}

	public String getLoggingTime() 
	{
		return loggingTime;
	}
	public void setLoggingMessage(String loggingMessage) 
	{
		this.loggingMessage = loggingMessage;
	}

	public String getLoggingMessage() 
	{
		return loggingMessage;
	}
	public void setLoggingResult(Integer loggingResult) 
	{
		this.loggingResult = loggingResult;
	}

	public Integer getLoggingResult() 
	{
		return loggingResult;
	}
	public void setLoggingData(String loggingData) 
	{
		this.loggingData = loggingData;
	}

	public String getLoggingData() 
	{
		return loggingData;
	}
	public void setInOut(String inOut)
	{
		this.inOut = inOut;
	}

	public String getInOut()
	{
		return inOut;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getUserName() 
	{
		return userName;
	}
	public void setUserId(Integer userId) 
	{
		this.userId = userId;
	}

	public Integer getUserId() 
	{
		return userId;
	}
	public void setLoggingTag(String loggingTag) 
	{
		this.loggingTag = loggingTag;
	}

	public String getLoggingTag() 
	{
		return loggingTag;
	}
	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("loggingType", getLoggingType())
            .append("loggingTime", getLoggingTime())
            .append("loggingMessage", getLoggingMessage())
            .append("loggingResult", getLoggingResult())
            .append("loggingData", getLoggingData())
            .append("inOut", getInOut())
            .append("userName", getUserName())
            .append("userId", getUserId())
            .append("loggingTag", getLoggingTag())
            .toString();
    }
}
