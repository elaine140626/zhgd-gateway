package com.hujiang.project.zhgd.hjZhgdVehicle.domain;


import com.hujiang.framework.aspectj.lang.annotation.Excel;

/**
 * 车牌数据表 hujiang_vehicle
 * 
 * @author hujiang
 * @date 2019-06-19
 */
public class VehiclePc
{
	private static final long serialVersionUID = 1L;
	
	/** id */
	@Excel(name = "id")
	private Integer id;
	/** 车牌 */
	@Excel(name = "车牌")
	private String vehicleNo;
	/** 抬杆时间 */
	@Excel(name = "抬杆时间")
	private String liftTime;

	/**驾驶员姓名*/
	@Excel(name = "驾驶员姓名")
	private String name;
	/** 通道名称*/
	@Excel(name = "通道名称")
	private String gateinname;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVehicleNo() {
		return vehicleNo;
	}

	public void setVehicleNo(String vehicleNo) {
		this.vehicleNo = vehicleNo;
	}

	public String getLiftTime() {
		return liftTime;
	}

	public void setLiftTime(String liftTime) {
		this.liftTime = liftTime;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public String getGateinname() {
		return gateinname;
	}

	public void setGateinname(String gateinname) {
		this.gateinname = gateinname;
	}

	@Override
	public String toString() {
		return "VehiclePc{" +
				"id=" + id +
				", vehicleNo='" + vehicleNo + '\'' +
				", liftTime='" + liftTime + '\'' +
				", name='" + name + '\'' +
				", gateinname='" + gateinname + '\'' +
				'}';
	}
}
