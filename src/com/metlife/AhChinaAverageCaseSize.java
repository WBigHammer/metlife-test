package com.metlife;

import java.math.BigDecimal;

/**
 * AAhChinaAverageCaseSize entity. @author MyEclipse Persistence Tools
 */

public class AhChinaAverageCaseSize implements java.io.Serializable {

	// Fields

	private BigDecimal ahChinaAverageCaseSizeId;
	private Integer time;
	private String channel;
	private double actual;
	private double plan;
	private double actualPrior;

	// Constructors

	/** default constructor */
	public AhChinaAverageCaseSize() {
	}

	/** full constructor */
	public AhChinaAverageCaseSize(Integer time, String channel, double actual,
			double plan, double actualPrior) {
		this.time = time;
		this.channel = channel;
		this.actual = actual;
		this.plan = plan;
		this.actualPrior = actualPrior;
	}

	// Property accessors

	public BigDecimal getAhChinaAverageCaseSizeId() {
		return this.ahChinaAverageCaseSizeId;
	}

	public void setAhChinaAverageCaseSizeId(BigDecimal ahChinaAverageCaseSizeId) {
		this.ahChinaAverageCaseSizeId = ahChinaAverageCaseSizeId;
	}

	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public String getChannel() {
		return this.channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public double getActual() {
		return this.actual;
	}

	public void setActual(double actual) {
		this.actual = actual;
	}

	public double getPlan() {
		return this.plan;
	}

	public void setPlan(double plan) {
		this.plan = plan;
	}

	public double getActualPrior() {
		return this.actualPrior;
	}

	public void setActualPrior(double actualPrior) {
		this.actualPrior = actualPrior;
	}

}