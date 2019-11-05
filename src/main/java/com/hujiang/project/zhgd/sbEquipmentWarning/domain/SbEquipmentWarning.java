package com.hujiang.project.zhgd.sbEquipmentWarning.domain;

/**
 * 定位报警表 sb_equipment_warning
 * 
 * @author hujiang
 * @date 2019-10-19
 */
public class SbEquipmentWarning
{

	/** 自增ID */
	private Integer id;
	/** 设备imei：关联设备表id */
	private String imei;
	/** 报警类型 0 sos  1 摔跌  2 长时间未移动  3 低电量 */
	private Integer warningType;
	/** 报警时间 */
	private String warningTime;

    /** 工业区ID*/
    private Integer areaId;
    /** 工业区名称*/
    private String areaName;
    /** 项目人员ID*/
    private Integer userId;
    /** 项目人员名称*/
    private String userName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Integer getWarningType() {
        return warningType;
    }

    public void setWarningType(Integer warningType) {
        this.warningType = warningType;
    }

    public String getWarningTime() {
        return warningTime;
    }

    public void setWarningTime(String warningTime) {
        this.warningTime = warningTime;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        return "SbEquipmentWarning{" +
                "id=" + id +
                ", imei='" + imei + '\'' +
                ", warningType=" + warningType +
                ", warningTime='" + warningTime + '\'' +
                ", areaId=" + areaId +
                ", areaName='" + areaName + '\'' +
                ", userId=" + userId +
                ", userName='" + userName + '\'' +
                '}';
    }
}
