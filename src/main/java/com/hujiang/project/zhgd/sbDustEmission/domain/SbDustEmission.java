package com.hujiang.project.zhgd.sbDustEmission.domain;

import com.hujiang.framework.aspectj.lang.annotation.Excel;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.math.BigDecimal;


/**
 * 扬尘数据表 sb_dust_emission
 * 
 * @author hujiang
 * @date 2019-06-18
 */
public class SbDustEmission
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	@Excel(name = "序号")
	private Long id;
	/** 扬尘设备sn */
	@Excel(name = "扬尘设备sn")
	private String sn;
	/** 获取时间 */
	@Excel(name = "监测时间")
	private String date;
	/** PM2.5 扬尘,单位:μg/m3 */
	@Excel(name = "PM2.5 扬尘,单位:μg/m3")
	private BigDecimal pm25;
	/** PM10 扬尘,单位:μg/m3 */
	@Excel(name = "PM10 扬尘,单位:μg/m3")
	private BigDecimal pm10;
	/** 扬尘Tsp */
	@Excel(name = "扬尘Tsp")
	private BigDecimal tsp;
	/** 噪声,单位:DB */
	@Excel(name = "噪声,单位:DB")
	private BigDecimal noise;
	/** 温度,单位:℃ */
	@Excel(name = " 温度,单位:℃")
	private BigDecimal temperature;
	/** 湿度 */
	@Excel(name = "湿度%")
	private BigDecimal humidity;
	/** 风速,单位:km/h */
	@Excel(name = "风速,单位:km/h ")
	private BigDecimal windSpeed;
	/** 风向,0-15 */
	@Excel(name = "风向,0-15")
	private Long winddirection;
	/** 风力 */
	@Excel(name = "风力")
	private BigDecimal windPower;
	/** 气压 */
	@Excel(name = "气压")
	private BigDecimal airPressure;

	public void setId(Long id) 
	{
		this.id = id;
	}

	public Long getId() 
	{
		return id;
	}
	public void setSn(String sn) 
	{
		this.sn = sn;
	}

	public String getSn() 
	{
		return sn;
	}
	public void setDate(String date)
	{
		this.date = date;
	}

	public String getDate()
	{
		return date;
	}
	public void setPm25(BigDecimal pm25) 
	{
		this.pm25 = pm25;
	}

	public BigDecimal getPm25() 
	{
		return pm25;
	}
	public void setPm10(BigDecimal pm10) 
	{
		this.pm10 = pm10;
	}

	public BigDecimal getPm10() 
	{
		return pm10;
	}
	public void setTsp(BigDecimal tsp) 
	{
		this.tsp = tsp;
	}

	public BigDecimal getTsp() 
	{
		return tsp;
	}
	public void setNoise(BigDecimal noise) 
	{
		this.noise = noise;
	}

	public BigDecimal getNoise() 
	{
		return noise;
	}
	public void setTemperature(BigDecimal temperature) 
	{
		this.temperature = temperature;
	}

	public BigDecimal getTemperature() 
	{
		return temperature;
	}
	public void setHumidity(BigDecimal humidity) 
	{
		this.humidity = humidity;
	}

	public BigDecimal getHumidity() 
	{
		return humidity;
	}
	public void setWindSpeed(BigDecimal windSpeed) 
	{
		this.windSpeed = windSpeed;
	}

	public BigDecimal getWindSpeed() 
	{
		return windSpeed;
	}
	public void setWinddirection(Long winddirection) 
	{
		this.winddirection = winddirection;
	}

	public Long getWinddirection() 
	{
		return winddirection;
	}
	public void setWindPower(BigDecimal windPower) 
	{
		this.windPower = windPower;
	}

	public BigDecimal getWindPower() 
	{
		return windPower;
	}
	public void setAirPressure(BigDecimal airPressure) 
	{
		this.airPressure = airPressure;
	}

	public BigDecimal getAirPressure() 
	{
		return airPressure;
	}
	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sn", getSn())
            .append("date", getDate())
            .append("pm25", getPm25())
            .append("pm10", getPm10())
            .append("tsp", getTsp())
            .append("noise", getNoise())
            .append("temperature", getTemperature())
            .append("humidity", getHumidity())
            .append("windSpeed", getWindSpeed())
            .append("winddirection", getWinddirection())
            .append("windPower", getWindPower())
            .append("airPressure", getAirPressure())
            .toString();
    }
}
