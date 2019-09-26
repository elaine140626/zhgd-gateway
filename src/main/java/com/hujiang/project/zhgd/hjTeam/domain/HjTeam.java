package com.hujiang.project.zhgd.hjTeam.domain;

import com.hujiang.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 班组表 hj_team
 * 
 * @author hujiang
 * @date 2019-04-29
 */
public class HjTeam
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	@Excel(name = "班组编号")
	private Integer id;
	/** 班组名称 */
	@Excel(name = "班组名称")
	private String teamName;
	/** 参建单位id */
	private Integer constructionId;
	/** 项目ID */
	private Integer projectId;
	/** 创建时间 */
	private String createDate;
	/** 修改时间 */
	private String updateDate;
	/** 备注 */
	private String remark;
	/** 项目名称*/
	@Excel(name = "项目信息")
	private String projectName;
	/** 参建单位名称 */
	@Excel(name = "参建单位信息")
	private String companyName;
	//参建单位名称
	private String constructionName;

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}


	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setTeamName(String teamName) 
	{
		this.teamName = teamName;
	}

	public String getTeamName() 
	{
		return teamName;
	}
	public void setConstructionId(Integer constructionId) 
	{
		this.constructionId = constructionId;
	}

	public Integer getConstructionId() 
	{
		return constructionId;
	}
	public void setProjectId(Integer projectId) 
	{
		this.projectId = projectId;
	}

	public Integer getProjectId() 
	{
		return projectId;
	}
	public void setCreateDate(String createDate)
	{
		this.createDate = createDate;
	}

	public String getCreateDate()
	{
		return createDate;
	}
	public void setUpdateDate(String updateDate)
	{
		this.updateDate = updateDate;
	}

	public String getUpdateDate()
	{
		return updateDate;
	}

	public String getConstructionName() {
		return constructionName;
	}

	public void setConstructionName(String constructionName) {
		this.constructionName = constructionName;
	}

	@Override
	public String toString() {
		return "HjTeam{" +
				"id=" + id +
				", teamName='" + teamName + '\'' +
				", constructionId=" + constructionId +
				", projectId=" + projectId +
				", createDate='" + createDate + '\'' +
				", updateDate='" + updateDate + '\'' +
				", remark='" + remark + '\'' +
				", projectName='" + projectName + '\'' +
				", companyName='" + companyName + '\'' +
				", constructionName='" + constructionName + '\'' +
				'}';
	}
}
