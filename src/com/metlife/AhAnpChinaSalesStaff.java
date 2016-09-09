package com.metlife;

import java.util.Date;

/**
 * AhAnpChinaSalesStaff entity. @author MyEclipse Persistence Tools
 */

public class AhAnpChinaSalesStaff implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 9181623912411191893L;
	private Integer ahChinaTotalAnpId;//ID
	private Integer actualAnpByChannel;//实际值
	private Integer planAnpByChannel;//计划值
	private Date time;				//日期(取年月)
	private String channel;			//渠道

	@Override
	public String toString() {
		return "AhAnpChinaSalesStaff [ahChinaTotalAnpId=" + ahChinaTotalAnpId
				+ ", actualAnpByChannel=" + actualAnpByChannel
				+ ", planAnpByChannel=" + planAnpByChannel + ", time=" + time
				+ ", channel=" + channel + "]";
	}
	// Constructors

	/** default constructor */
	public AhAnpChinaSalesStaff() {
	}

	/** minimal constructor */
	public AhAnpChinaSalesStaff(String channel) {
		this.channel = channel;
	}

	/** full constructor */
	public AhAnpChinaSalesStaff(Integer actualAnpByChannel, Integer planAnpByChannel,
			Date time, String channel) {
		this.actualAnpByChannel = actualAnpByChannel;
		this.planAnpByChannel = planAnpByChannel;
		this.time = time;
		this.channel = channel;
	}

	// Property accessors

	public Integer getAhChinaTotalAnpId() {
		return this.ahChinaTotalAnpId;
	}

	public void setAhChinaTotalAnpId(Integer ahChinaTotalAnpId) {
		this.ahChinaTotalAnpId = ahChinaTotalAnpId;
	}

	public long getActualAnpByChannel() {
		return this.actualAnpByChannel;
	}

	public void setActualAnpByChannel(Integer actualAnpByChannel) {
		this.actualAnpByChannel = actualAnpByChannel;
	}

	public long getPlanAnpByChannel() {
		return this.planAnpByChannel;
	}

	public void setPlanAnpByChannel(Integer planAnpByChannel) {
		this.planAnpByChannel = planAnpByChannel;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getChannel() {
		return this.channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

}