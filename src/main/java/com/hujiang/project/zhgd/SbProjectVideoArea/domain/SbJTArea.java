package com.hujiang.project.zhgd.SbProjectVideoArea.domain;

import java.util.List;

/**
 * 集团分类列表
 * 
 * @author hujiang
 * @date 2019-07-08
 */
public class SbJTArea
{
	private static final long serialVersionUID = 1L;
	

	/** 视频区 */
	private String areaName;

	private List<ProjectVideoJT> projectList;

	public List<ProjectVideoJT> getProjectList() {
		return projectList;
	}

	public void setProjectList(List<ProjectVideoJT> projectList) {
		this.projectList = projectList;
	}

	public void setAreaName(String areaName)
	{
		this.areaName = areaName;
	}

	public String getAreaName() 
	{
		return areaName;
	}


}
