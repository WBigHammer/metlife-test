package com.metlife;

import java.math.BigDecimal;

/**
 * AAgentDailyDealResult entity. @author MyEclipse Persistence Tools
 */

public class AAgentDailyDealResult implements java.io.Serializable {

	// Fields

	private BigDecimal AAgentDailyDealResultId;
	private long time;
	private String branch;
	private double anp;
	private double dealAnp;
	private double case_;

	// Constructors

	/** default constructor */
	public AAgentDailyDealResult() {
	}

	/** full constructor */
	public AAgentDailyDealResult(long time, String branch, double anp,
			double dealAnp, double case_) {
		this.time = time;
		this.branch = branch;
		this.anp = anp;
		this.dealAnp = dealAnp;
		this.case_ = case_;
	}

	// Property accessors

	public BigDecimal getAAgentDailyDealResultId() {
		return this.AAgentDailyDealResultId;
	}

	public void setAAgentDailyDealResultId(BigDecimal AAgentDailyDealResultId) {
		this.AAgentDailyDealResultId = AAgentDailyDealResultId;
	}

	public long getTime() {
		return this.time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getBranch() {
		return this.branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public double getAnp() {
		return this.anp;
	}

	public void setAnp(double anp) {
		this.anp = anp;
	}

	public double getDealAnp() {
		return this.dealAnp;
	}

	public void setDealAnp(double dealAnp) {
		this.dealAnp = dealAnp;
	}

	public double getCase_() {
		return this.case_;
	}

	public void setCase_(double case_) {
		this.case_ = case_;
	}

}