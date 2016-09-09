package com.metlife;

import java.math.BigDecimal;

/**
 * AAgyAgentDailyDealResult entity. @author MyEclipse Persistence Tools
 */

public class AAgyAgentDailyDealResult implements java.io.Serializable {

	// Fields

	private BigDecimal agentDailyDealResultId;
	private Integer time;
	private String cityCode;
	private String city;
	private double anp;

	// Constructors

	/** default constructor */
	public AAgyAgentDailyDealResult() {
	}

	/** full constructor */
	public AAgyAgentDailyDealResult(Integer time, String cityCode, String city,
			double anp) {
		this.time = time;
		this.cityCode = cityCode;
		this.city = city;
		this.anp = anp;
	}

	// Property accessors

	public BigDecimal getAgentDailyDealResultId() {
		return this.agentDailyDealResultId;
	}

	public void setAgentDailyDealResultId(BigDecimal agentDailyDealResultId) {
		this.agentDailyDealResultId = agentDailyDealResultId;
	}

	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getAnp() {
		return this.anp;
	}

	public void setAnp(double anp) {
		this.anp = anp;
	}

}