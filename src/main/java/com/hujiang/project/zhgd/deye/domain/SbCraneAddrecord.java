package com.hujiang.project.zhgd.deye.domain;

import com.hujiang.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 塔式起重机实时数据表 sb_crane_addrecord
 * 
 * @author hujiang
 * @date 2019-06-21
 */
public class SbCraneAddrecord
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	@Excel(name = "id")
	private Long id;
	/** 设备编号--32位 */
	@Excel(name = "设备编号--32位")
	private String deviceNo;
	/** 运行时,格式为yyyy-MM-dd hh:mm:ss */
	@Excel(name = "运行时间")
	private String runtime;
	/** 载重（T) */
	@Excel(name = " 载重（T)")
	private Double load;
	/** 载重比 */
	@Excel(name = "载重比")
	private Double loadRatio;
	/** 力矩 */
	@Excel(name = "力矩")
	private Double moment;
	/** 力矩比 */
	@Excel(name = "力矩比")
	private Double momentRatio;
	/** 回转角度 */
	@Excel(name = "回转角度")
	private Double slewingSpeed;
	/** 是否左限位报警(0.否1.是) */
	@Excel(name = "是否左限位报警",readConverterExp ="0=否,1=是")
	private Integer isLeftWarning;
	/** 是否右限位报警(0.否1.是) */
	@Excel(name = "是否右限位报警",readConverterExp ="0=否,1=是")
	private Integer isRightWarning;
	/** 幅度 */
	@Excel(name = "幅度")
	private Double range;
	/** 是否前限位报警(0.否1.是) */
	@Excel(name = "是否前限位报警",readConverterExp ="0=否,1=是")
	private Integer isForwardWarning;
	/** 是否后限位报警(0.否1.是) */
	@Excel(name = "是否后限位报警",readConverterExp ="0=否,1=是")
	private Integer isBackwardWarning;
	/** 高度 */
	@Excel(name = "高度")
	private Double height;
	/** 是否上限位报警(0.否1.是) */
	@Excel(name = "是否上限位报警",readConverterExp ="0=否,1=是" )
	private Integer isUpWarning;
	/** 塔机工作环境温度 */
	@Excel(name = "塔机工作环境温度")
	private Double workEnvironment;
	/** 实时标志(0历史数据,1实时数据) */
	@Excel(name = "安装方式",readConverterExp = "0=历史数据,1=实时数据")
	private Integer realTimeFlag;
	/** 安装方式 */
	@Excel(name = "安装方式")
	private Integer installationMethod;
	/** 风速 m/s */
	@Excel(name = "风速")
	private Double windSpeed;
	/** 持卡卡号 */
	@Excel(name = "持卡卡号")
	private String cardNum;
	/** 持卡人姓名 */
	@Excel(name = "持卡人姓名")
	private String operatorName;
	/** 设备编号 */
	@Excel(name = "设备编号")
	private String hxzid;
	/** 倍率 */
	@Excel(name = "倍率")
	private Double magnification;
	/**倾角*/
	@Excel(name = "倾角")
	private String obliguity;

    public String getObliguity() {
        return obliguity;
    }

    public void setObliguity(String obliguity) {
        this.obliguity = obliguity;
    }

    public void setId(Long id)
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setDeviceNo(String deviceNo) 
	{
		this.deviceNo = deviceNo;
	}

	public String getDeviceNo() 
	{
		return deviceNo;
	}
	public void setRuntime(String runtime) 
	{
		this.runtime = runtime;
	}

	public String getRuntime() 
	{
		return runtime;
	}
	public void setLoad(Double load) 
	{
		this.load = load;
	}

	public Double getLoad() 
	{
		return load;
	}
	public void setLoadRatio(Double loadRatio) 
	{
		this.loadRatio = loadRatio;
	}

	public Double getLoadRatio() 
	{
		return loadRatio;
	}
	public void setMoment(Double moment) 
	{
		this.moment = moment;
	}

	public Double getMoment() 
	{
		return moment;
	}
	public void setMomentRatio(Double momentRatio) 
	{
		this.momentRatio = momentRatio;
	}

	public Double getMomentRatio() 
	{
		return momentRatio;
	}
	public void setSlewingSpeed(Double slewingSpeed) 
	{
		this.slewingSpeed = slewingSpeed;
	}

	public Double getSlewingSpeed() 
	{
		return slewingSpeed;
	}
	public void setIsLeftWarning(Integer isLeftWarning) 
	{
		this.isLeftWarning = isLeftWarning;
	}

	public Integer getIsLeftWarning() 
	{
		return isLeftWarning;
	}
	public void setIsRightWarning(Integer isRightWarning) 
	{
		this.isRightWarning = isRightWarning;
	}

	public Integer getIsRightWarning() 
	{
		return isRightWarning;
	}
	public void setRange(Double range) 
	{
		this.range = range;
	}

	public Double getRange() 
	{
		return range;
	}
	public void setIsForwardWarning(Integer isForwardWarning) 
	{
		this.isForwardWarning = isForwardWarning;
	}

	public Integer getIsForwardWarning() 
	{
		return isForwardWarning;
	}
	public void setIsBackwardWarning(Integer isBackwardWarning) 
	{
		this.isBackwardWarning = isBackwardWarning;
	}

	public Integer getIsBackwardWarning() 
	{
		return isBackwardWarning;
	}
	public void setHeight(Double height) 
	{
		this.height = height;
	}

	public Double getHeight() 
	{
		return height;
	}
	public void setIsUpWarning(Integer isUpWarning) 
	{
		this.isUpWarning = isUpWarning;
	}

	public Integer getIsUpWarning() 
	{
		return isUpWarning;
	}
	public void setWorkEnvironment(Double workEnvironment) 
	{
		this.workEnvironment = workEnvironment;
	}

	public Double getWorkEnvironment() 
	{
		return workEnvironment;
	}
	public void setRealTimeFlag(Integer realTimeFlag) 
	{
		this.realTimeFlag = realTimeFlag;
	}

	public Integer getRealTimeFlag() 
	{
		return realTimeFlag;
	}
	public void setInstallationMethod(Integer installationMethod) 
	{
		this.installationMethod = installationMethod;
	}

	public Integer getInstallationMethod() 
	{
		return installationMethod;
	}
	public void setWindSpeed(Double windSpeed) 
	{
		this.windSpeed = windSpeed;
	}

	public Double getWindSpeed() 
	{
		return windSpeed;
	}
	public void setCardNum(String cardNum) 
	{
		this.cardNum = cardNum;
	}

	public String getCardNum() 
	{
		return cardNum;
	}
	public void setOperatorName(String operatorName) 
	{
		this.operatorName = operatorName;
	}

	public String getOperatorName() 
	{
		return operatorName;
	}
	public void setHxzid(String hxzid) 
	{
		this.hxzid = hxzid;
	}

	public String getHxzid() 
	{
		return hxzid;
	}
	public void setMagnification(Double magnification) 
	{
		this.magnification = magnification;
	}

	public Double getMagnification() 
	{
		return magnification;
	}
	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceNo", getDeviceNo())
            .append("runtime", getRuntime())
            .append("load", getLoad())
            .append("loadRatio", getLoadRatio())
            .append("moment", getMoment())
            .append("momentRatio", getMomentRatio())
            .append("slewingSpeed", getSlewingSpeed())
            .append("isLeftWarning", getIsLeftWarning())
            .append("isRightWarning", getIsRightWarning())
            .append("range", getRange())
            .append("isForwardWarning", getIsForwardWarning())
            .append("isBackwardWarning", getIsBackwardWarning())
            .append("height", getHeight())
            .append("isUpWarning", getIsUpWarning())
            .append("workEnvironment", getWorkEnvironment())
            .append("realTimeFlag", getRealTimeFlag())
            .append("installationMethod", getInstallationMethod())
            .append("windSpeed", getWindSpeed())
            .append("cardNum", getCardNum())
            .append("operatorName", getOperatorName())
            .append("hxzid", getHxzid())
            .append("magnification", getMagnification())
            .toString();
    }
}
