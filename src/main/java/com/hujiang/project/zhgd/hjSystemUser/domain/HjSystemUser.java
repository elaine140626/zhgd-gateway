package com.hujiang.project.zhgd.hjSystemUser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;


/**
 * 系统用户表 hj_system_user
 * 
 * @author hujiang
 * @date 2019-04-29
 */
public class HjSystemUser
{
	private static final long serialVersionUID = 1L;
	
	/** ID */
	private Integer id;
	/** 名称 */
	private String userName;
	/** 联系电话 */
	private String userPhone;
	/** 账户 */
	private String userAccount;
	/** 密码 */
	private String userPassword;
	/** 账户状态（0：禁用  1：启用） */
	private String userState;
	/** 账户类型（0.集团，1：公司  2：项目） */
	private Integer userType;
	/** 登录项（0 只登录app，1 pc 2.pc+app） */
	private Integer entry;
	/** 创建者（添加规则：角色名-用户名） */
	private String creator;
	/** 创建时间 */
	private String createDate;
	/** 修改时间 */
	private String updateDate;

	public void setId(Integer id) 
	{
		this.id = id;
	}

	public Integer getId() 
	{
		return id;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}

	public String getUserName() 
	{
		return userName;
	}
	public void setUserPhone(String userPhone) 
	{
		this.userPhone = userPhone;
	}

	public String getUserPhone() 
	{
		return userPhone;
	}
	public void setUserAccount(String userAccount) 
	{
		this.userAccount = userAccount;
	}

	public String getUserAccount() 
	{
		return userAccount;
	}
	public void setUserPassword(String userPassword) 
	{
		this.userPassword = userPassword;
	}

	public String getUserPassword() 
	{
		return userPassword;
	}
	public void setUserState(String userState) 
	{
		this.userState = userState;
	}

	public String getUserState() 
	{
		return userState;
	}
	public void setuserType(Integer userType)
	{
		this.userType = userType;
	}

	public Integer getuserType()
	{
		return userType;
	}
	public void setEntry(Integer entry) 
	{
		this.entry = entry;
	}

	public Integer getEntry() 
	{
		return entry;
	}
	public void setCreator(String creator) 
	{
		this.creator = creator;
	}

	public String getCreator() 
	{
		return creator;
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
	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userName", getUserName())
            .append("userPhone", getUserPhone())
            .append("userAccount", getUserAccount())
            .append("userPassword", getUserPassword())
            .append("userState", getUserState())
            .append("userType", getuserType())
            .append("entry", getEntry())
            .append("creator", getCreator())
            .append("createDate", getCreateDate())
            .append("updateDate", getUpdateDate())
            .toString();
    }
}
