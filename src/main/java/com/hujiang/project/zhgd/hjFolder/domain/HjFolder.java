package com.hujiang.project.zhgd.hjFolder.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;


/**
 * 文件夹表 hj_folder
 * 
 * @author hujiang
 * @date 2019-06-28
 */
public class HjFolder
{
	private static final long serialVersionUID = 1L;
	
	/** 编号 */
	private Integer id;
	/** 文件夹名 */
	private String folderName;
	/** 上传者账号 */
	private String uploadAccount;
	/** 项目id */
	private Integer projectId;
	/** 创建时间 */
	private String createTime;
	/** 父文件夹id */
	private Integer parentLevel;
	/** 子菜单 */
	private List<HjFolder> children;

	public List<HjFolder> getChildren() {
		return children;
	}

	public void setChildren(List<HjFolder> children) {
		this.children = children;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setFolderName(String folderName) 
	{
		this.folderName = folderName;
	}

	public String getFolderName() 
	{
		return folderName;
	}
	public void setUploadAccount(String uploadAccount) 
	{
		this.uploadAccount = uploadAccount;
	}

	public String getUploadAccount() 
	{
		return uploadAccount;
	}
	public void setProjectId(Integer projectId) 
	{
		this.projectId = projectId;
	}

	public Integer getProjectId() 
	{
		return projectId;
	}
	public void setCreateTime(String createTime)
	{
		this.createTime = createTime;
	}

	public String getCreateTime()
	{
		return createTime;
	}
	public void setParentLevel(Integer parentLevel) 
	{
		this.parentLevel = parentLevel;
	}

	public Integer getParentLevel() 
	{
		return parentLevel;
	}
	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("folderName", getFolderName())
            .append("uploadAccount", getUploadAccount())
            .append("projectId", getProjectId())
            .append("createTime", getCreateTime())
            .append("parentLevel", getParentLevel())
            .toString();
    }
}
