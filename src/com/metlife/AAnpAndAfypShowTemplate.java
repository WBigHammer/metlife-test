package com.metlife;

import java.math.BigDecimal;

/**
 * AAnpAndAfypShowTemplate entity. @author MyEclipse Persistence Tools
 */

public class AAnpAndAfypShowTemplate implements java.io.Serializable {

	// Fields

	private BigDecimal anporafypShowTemplateId;
	private String quota;
	private Integer time;
	private String channel;
	private String project;
	private String productLine;
	private String type1;
	private String type2;
	private String type3;
	private double monthlyActual;
	private double monthlyProj;
	private double monthlyPlan;
	private double monthlyActVsProj;
	private double monthlyActVsPlan;
	private double ytdActual;
	private double ytdProj;
	private double ytdPlan;
	private double ytdActVsProj;
	private double ytdActVsPlan;
	private double fullYearProj;
	private double fullYearPlan;
	private double fullYearProjVsPlan;
	private double actualQ1;
	private double actualQ2;
	private double actualQ3;
	private double actualQ4;

	// Constructors

	/** default constructor */
	public AAnpAndAfypShowTemplate() {
	}

	/** full constructor */
	public AAnpAndAfypShowTemplate(String quota, Integer time, String channel,
			String project, String productLine, String type1, String type2,
			String type3, double monthlyActual, double monthlyProj,
			double monthlyPlan, double monthlyActVsProj,
			double monthlyActVsPlan, double ytdActual, double ytdProj,
			double ytdPlan, double ytdActVsProj, double ytdActVsPlan,
			double fullYearProj, double fullYearPlan,
			double fullYearProjVsPlan, double actualQ1, double actualQ2,
			double actualQ3, double actualQ4) {
		this.quota = quota;
		this.time = time;
		this.channel = channel;
		this.project = project;
		this.productLine = productLine;
		this.type1 = type1;
		this.type2 = type2;
		this.type3 = type3;
		this.monthlyActual = monthlyActual;
		this.monthlyProj = monthlyProj;
		this.monthlyPlan = monthlyPlan;
		this.monthlyActVsProj = monthlyActVsProj;
		this.monthlyActVsPlan = monthlyActVsPlan;
		this.ytdActual = ytdActual;
		this.ytdProj = ytdProj;
		this.ytdPlan = ytdPlan;
		this.ytdActVsProj = ytdActVsProj;
		this.ytdActVsPlan = ytdActVsPlan;
		this.fullYearProj = fullYearProj;
		this.fullYearPlan = fullYearPlan;
		this.fullYearProjVsPlan = fullYearProjVsPlan;
		this.actualQ1 = actualQ1;
		this.actualQ2 = actualQ2;
		this.actualQ3 = actualQ3;
		this.actualQ4 = actualQ4;
	}

	// Property accessors

	public BigDecimal getAnporafypShowTemplateId() {
		return this.anporafypShowTemplateId;
	}

	public void setAnporafypShowTemplateId(BigDecimal anporafypShowTemplateId) {
		this.anporafypShowTemplateId = anporafypShowTemplateId;
	}

	public String getQuota() {
		return this.quota;
	}

	public void setQuota(String quota) {
		this.quota = quota;
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

	public String getProject() {
		return this.project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getProductLine() {
		return this.productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public String getType1() {
		return this.type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	public String getType2() {
		return this.type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	public String getType3() {
		return this.type3;
	}

	public void setType3(String type3) {
		this.type3 = type3;
	}

	public double getMonthlyActual() {
		return this.monthlyActual;
	}

	public void setMonthlyActual(double monthlyActual) {
		this.monthlyActual = monthlyActual;
	}

	public double getMonthlyProj() {
		return this.monthlyProj;
	}

	public void setMonthlyProj(double monthlyProj) {
		this.monthlyProj = monthlyProj;
	}

	public double getMonthlyPlan() {
		return this.monthlyPlan;
	}

	public void setMonthlyPlan(double monthlyPlan) {
		this.monthlyPlan = monthlyPlan;
	}

	public double getMonthlyActVsProj() {
		return this.monthlyActVsProj;
	}

	public void setMonthlyActVsProj(double monthlyActVsProj) {
		this.monthlyActVsProj = monthlyActVsProj;
	}

	public double getMonthlyActVsPlan() {
		return this.monthlyActVsPlan;
	}

	public void setMonthlyActVsPlan(double monthlyActVsPlan) {
		this.monthlyActVsPlan = monthlyActVsPlan;
	}

	public double getYtdActual() {
		return this.ytdActual;
	}

	public void setYtdActual(double ytdActual) {
		this.ytdActual = ytdActual;
	}

	public double getYtdProj() {
		return this.ytdProj;
	}

	public void setYtdProj(double ytdProj) {
		this.ytdProj = ytdProj;
	}

	public double getYtdPlan() {
		return this.ytdPlan;
	}

	public void setYtdPlan(double ytdPlan) {
		this.ytdPlan = ytdPlan;
	}

	public double getYtdActVsProj() {
		return this.ytdActVsProj;
	}

	public void setYtdActVsProj(double ytdActVsProj) {
		this.ytdActVsProj = ytdActVsProj;
	}

	public double getYtdActVsPlan() {
		return this.ytdActVsPlan;
	}

	public void setYtdActVsPlan(double ytdActVsPlan) {
		this.ytdActVsPlan = ytdActVsPlan;
	}

	public double getFullYearProj() {
		return this.fullYearProj;
	}

	public void setFullYearProj(double fullYearProj) {
		this.fullYearProj = fullYearProj;
	}

	public double getFullYearPlan() {
		return this.fullYearPlan;
	}

	public void setFullYearPlan(double fullYearPlan) {
		this.fullYearPlan = fullYearPlan;
	}

	public double getFullYearProjVsPlan() {
		return this.fullYearProjVsPlan;
	}

	public void setFullYearProjVsPlan(double fullYearProjVsPlan) {
		this.fullYearProjVsPlan = fullYearProjVsPlan;
	}

	public double getActualQ1() {
		return this.actualQ1;
	}

	public void setActualQ1(double actualQ1) {
		this.actualQ1 = actualQ1;
	}

	public double getActualQ2() {
		return this.actualQ2;
	}

	public void setActualQ2(double actualQ2) {
		this.actualQ2 = actualQ2;
	}

	public double getActualQ3() {
		return this.actualQ3;
	}

	public void setActualQ3(double actualQ3) {
		this.actualQ3 = actualQ3;
	}

	public double getActualQ4() {
		return this.actualQ4;
	}

	public void setActualQ4(double actualQ4) {
		this.actualQ4 = actualQ4;
	}

}