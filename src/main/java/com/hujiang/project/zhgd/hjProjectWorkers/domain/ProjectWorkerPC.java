package com.hujiang.project.zhgd.hjProjectWorkers.domain;

import com.hujiang.framework.aspectj.lang.annotation.Excel;

/**
 * 项目工人表 hj_project_workers
 * 
 * @author hujiang
 * @date 2019-05-19
 */
public class ProjectWorkerPC
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	@Excel(name = "员工编号")
	private Integer id;
	/** 姓名 */
	@Excel(name = "姓名")
	private String empName;
	//班组名
	@Excel(name = "班组名")
	private String teamName;
	//参建单位名
	@Excel(name = "参建单位名")
	private String constructionName;
	//项目名
	@Excel(name = "项目名")
	private String projectName;
	//工种名
	@Excel(name = "工种名")
	private String title;
	//是否班组长
	@Excel(name = "是否班组长",readConverterExp = "0=否,1=是")
	private Integer isTeam;
	/** 进退场状态（0、进场。1、退场,2未同步） */
	@Excel(name = "进退场状态",readConverterExp = "0=在场,1=离场,2=未同步")
	private Integer enterAndRetreatCondition;
	/** 身份证号码 */
	@Excel(name = "身份证号码")
	private String idCode;
	/** 手机号码 */
	@Excel(name = "手机号码")
	private String emp_phon;
	/** 居住地址 */
	@Excel(name = "居住地址")
	private String idAddress ;
	private String quarantine;
private String faceImg;

	public String getFaceImg() {
		return faceImg;
	}

	public void setFaceImg(String faceImg) {
		this.faceImg = faceImg;
	}

	public String getQuarantine() {
		return quarantine;
	}

	public void setQuarantine(String quarantine) {
		this.quarantine = quarantine;
	}
	public String getIdCode() {
		return idCode;
	}
	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}
	public String getIdAddress() {
		return idAddress;
	}

	public void setIdAddress(String idAddress) {
		this.idAddress = idAddress;
	}

	public String getEmp_phon() {
		return emp_phon;
	}

	public void setEmp_phon(String emp_phon) {
		this.emp_phon = emp_phon;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getConstructionName() {
		return constructionName;
	}

	public void setConstructionName(String constructionName) {
		this.constructionName = constructionName;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getIsTeam() {
		return isTeam;
	}

	public void setIsTeam(Integer isTeam) {
		this.isTeam = isTeam;
	}

	public Integer getEnterAndRetreatCondition() {
		return enterAndRetreatCondition;
	}

	public void setEnterAndRetreatCondition(Integer enterAndRetreatCondition) {
		this.enterAndRetreatCondition = enterAndRetreatCondition;
	}

	@Override
	public String toString() {
		return "ProjectWorkerPC{" +
				"id=" + id +
				", empName='" + empName + '\'' +
				", teamName='" + teamName + '\'' +
				", constructionName='" + constructionName + '\'' +
				", projectName='" + projectName + '\'' +
				", title='" + title + '\'' +
				", isTeam=" + isTeam +
				", enterAndRetreatCondition=" + enterAndRetreatCondition +
				'}';
	}
}
