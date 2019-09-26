package com.hujiang.project.zhgd.sbProjectElectricityBox.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 项目电箱表 sb_project_electricity_box
 * 
 * @author hujiang
 * @date 2019-06-24
 */
public class SbProjectElectricityBox
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Integer id;
	/** 项目id */
	private Integer projectId;
	/** 项目电箱备注 */
	private String comments;
	/** 电箱编号 */
	private String electricityBoxId;
	/**设备名称 例如：3#配电箱*/
	private String electricityBoxName;

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
	public void setComments(String comments) 
	{
		this.comments = comments;
	}

	public String getComments() 
	{
		return comments;
	}
	public void setElectricityBoxId(String electricityBoxId) 
	{
		this.electricityBoxId = electricityBoxId;
	}

	public String getElectricityBoxName() {
		return electricityBoxName;
	}

	public void setElectricityBoxName(String electricityBoxName) {
		this.electricityBoxName = electricityBoxName;
	}

	public String getElectricityBoxId()
	{
		return electricityBoxId;
	}
	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("projectId", getProjectId())
            .append("comments", getComments())
            .append("electricityBoxId", getElectricityBoxId())
            .toString();
    }
}
