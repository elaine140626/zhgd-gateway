package com.hujiang.project.zhgd.lzfw.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.web.multipart.MultipartFile;

/**
 * 工人表 hj_workers_information
 * 
 * @author hujiang
 * @date 2019-07-03
 */
public class HjWorkersInformation
{
	/** ID */
	private Integer id;
	/** 简易劳动合同 */
	private String laborContract;
	/** 两制确认书 */
	private String twoSystems;
	/** 进场确认书 */
	private String enter;
	/** 出场确认书 */
	private String come;
	/** 身份证正反面复印件 */
	private String identity;
	/** 资料是否齐全（0、不齐全，1、齐全） */
	private Integer material;
	/** 关联用户表 */
	private Integer userId;

	private MultipartFile file;

	private Integer typeid;

	private String empName;	//姓名
	private String idCode;
	private String jobName;
	private Integer workTypenameId;
	private Integer empDept;
	private Integer enterAndRetreatCondition;
	private Integer constructionId;		//所属分包单位

	private Integer projectId; //项目ID

	private String path;

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getProjectId() {
		return projectId;
	}

	public void setProjectId(Integer projectId) {
		this.projectId = projectId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getIdCode() {
		return idCode;
	}

	public void setIdCode(String idCode) {
		this.idCode = idCode;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public Integer getWorkTypenameId() {
		return workTypenameId;
	}

	public void setWorkTypenameId(Integer workTypenameId) {
		this.workTypenameId = workTypenameId;
	}

	public Integer getEmpDept() {
		return empDept;
	}

	public void setEmpDept(Integer empDept) {
		this.empDept = empDept;
	}

	public Integer getConstructionId() {
		return constructionId;
	}

	public void setConstructionId(Integer constructionId) {
		this.constructionId = constructionId;
	}

	public Integer getEnterAndRetreatCondition() {
		return enterAndRetreatCondition;
	}

	public void setEnterAndRetreatCondition(Integer enterAndRetreatCondition) {
		this.enterAndRetreatCondition = enterAndRetreatCondition;
	}

	public Integer getTypeid() {
		return typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public Integer getId()
	{
		return id;
	}
	public void setLaborContract(String laborContract)
	{
		this.laborContract = laborContract;
	}

	public String getLaborContract()
	{
		return laborContract;
	}
	public void setTwoSystems(String twoSystems)
	{
		this.twoSystems = twoSystems;
	}

	public String getTwoSystems()
	{
		return twoSystems;
	}
	public void setEnter(String enter)
	{
		this.enter = enter;
	}

	public String getEnter()
	{
		return enter;
	}
	public void setCome(String come)
	{
		this.come = come;
	}

	public String getCome()
	{
		return come;
	}
	public void setIdentity(String identity)
	{
		this.identity = identity;
	}

	public String getIdentity()
	{
		return identity;
	}
	public void setMaterial(Integer material)
	{
		this.material = material;
	}

	public Integer getMaterial()
	{
		return material;
	}
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}

	public Integer getUserId()
	{
		return userId;
	}

	@Override
	public String toString() {
		return "HjWorkersInformation{" +
				"id=" + id +
				", laborContract='" + laborContract + '\'' +
				", twoSystems='" + twoSystems + '\'' +
				", enter='" + enter + '\'' +
				", come='" + come + '\'' +
				", identity='" + identity + '\'' +
				", material=" + material +
				", userId=" + userId +
				", file=" + file +
				", typeid=" + typeid +
				", empName='" + empName + '\'' +
				", idCode='" + idCode + '\'' +
				", jobName=" + jobName +
				", workTypenameId=" + workTypenameId +
				", empDept=" + empDept +
				", enterAndRetreatCondition=" + enterAndRetreatCondition +
				", constructionId=" + constructionId +
				", projectId=" + projectId +
				", path='" + path + '\'' +
				'}';
	}
}
