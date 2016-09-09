package com.metlife;

import java.util.Date;

/**
 * MisAnporafypShowTemplate entity. @author MyEclipse Persistence Tools
 */

public class ANPOrAFYPShowTemplate implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 8101062122443545377L;
	private Integer anporafypShowTemplateId;
	private Date time;
	private Double monthlyActual;
	private Double monthlyProj;
	private Double monthlyPlan;
	private Double monthlyActvsproj;
	private Double monthlyActvsplan;
	private Double ytdActual;
	private Double ytdProj;
	private Double ytdPlan;
	private Double ytdActvsproj;
	private Double ytdActvsplan;
	private Double fullyearProj;
	private Double fullyearPlan;
	private Double fullyearProjvsplan;
	private Double actualQ1;
	private Double actualQ2;
	private Double actualQ3;
	private Double actualQ4;
	private String quota;

	// Constructors

	/** default constructor */
	public ANPOrAFYPShowTemplate() {
	}

	/** full constructor */
	public ANPOrAFYPShowTemplate( Date time, Double monthlyActual,
			Double monthlyProj, Double monthlyPlan, Double monthlyActvsproj,
			Double monthlyActvsplan, Double ytdActual, Double ytdProj,
			Double ytdPlan, Double ytdActvsproj, Double ytdActvsplan,
			Double fullyearProj, Double fullyearPlan,
			Double fullyearProjvsplan, Double actualQ1, Double actualQ2,
			Double actualQ3, Double actualQ4, String quota) {
		this.time = time;
		this.monthlyActual = monthlyActual;
		this.monthlyProj = monthlyProj;
		this.monthlyPlan = monthlyPlan;
		this.monthlyActvsproj = monthlyActvsproj;
		this.monthlyActvsplan = monthlyActvsplan;
		this.ytdActual = ytdActual;
		this.ytdProj = ytdProj;
		this.ytdPlan = ytdPlan;
		this.ytdActvsproj = ytdActvsproj;
		this.ytdActvsplan = ytdActvsplan;
		this.fullyearProj = fullyearProj;
		this.fullyearPlan = fullyearPlan;
		this.fullyearProjvsplan = fullyearProjvsplan;
		this.actualQ1 = actualQ1;
		this.actualQ2 = actualQ2;
		this.actualQ3 = actualQ3;
		this.actualQ4 = actualQ4;
		this.quota = quota;
	}

	// Property accessors

	public long getAnporafypShowTemplateId() {
		return this.anporafypShowTemplateId;
	}

	public void setAnporafypShowTemplateId(Integer anporafypShowTemplateId) {
		this.anporafypShowTemplateId = anporafypShowTemplateId;
	}


	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Double getMonthlyActual() {
		return this.monthlyActual;
	}

	public void setMonthlyActual(Double monthlyActual) {
		this.monthlyActual = monthlyActual;
	}

	public Double getMonthlyProj() {
		return this.monthlyProj;
	}

	public void setMonthlyProj(Double monthlyProj) {
		this.monthlyProj = monthlyProj;
	}

	public Double getMonthlyPlan() {
		return this.monthlyPlan;
	}

	public void setMonthlyPlan(Double monthlyPlan) {
		this.monthlyPlan = monthlyPlan;
	}

	public Double getMonthlyActvsproj() {
		return this.monthlyActvsproj;
	}

	public void setMonthlyActvsproj(Double monthlyActvsproj) {
		this.monthlyActvsproj = monthlyActvsproj;
	}

	public Double getMonthlyActvsplan() {
		return this.monthlyActvsplan;
	}

	public void setMonthlyActvsplan(Double monthlyActvsplan) {
		this.monthlyActvsplan = monthlyActvsplan;
	}

	public Double getYtdActual() {
		return this.ytdActual;
	}

	public void setYtdActual(Double ytdActual) {
		this.ytdActual = ytdActual;
	}

	public Double getYtdProj() {
		return this.ytdProj;
	}

	public void setYtdProj(Double ytdProj) {
		this.ytdProj = ytdProj;
	}

	public Double getYtdPlan() {
		return this.ytdPlan;
	}

	public void setYtdPlan(Double ytdPlan) {
		this.ytdPlan = ytdPlan;
	}

	public Double getYtdActvsproj() {
		return this.ytdActvsproj;
	}

	public void setYtdActvsproj(Double ytdActvsproj) {
		this.ytdActvsproj = ytdActvsproj;
	}

	public Double getYtdActvsplan() {
		return this.ytdActvsplan;
	}

	public void setYtdActvsplan(Double ytdActvsplan) {
		this.ytdActvsplan = ytdActvsplan;
	}

	public Double getFullyearProj() {
		return this.fullyearProj;
	}

	public void setFullyearProj(Double fullyearProj) {
		this.fullyearProj = fullyearProj;
	}

	public Double getFullyearPlan() {
		return this.fullyearPlan;
	}

	public void setFullyearPlan(Double fullyearPlan) {
		this.fullyearPlan = fullyearPlan;
	}

	public Double getFullyearProjvsplan() {
		return this.fullyearProjvsplan;
	}

	public void setFullyearProjvsplan(Double fullyearProjvsplan) {
		this.fullyearProjvsplan = fullyearProjvsplan;
	}

	public Double getActualQ1() {
		return this.actualQ1;
	}

	public void setActualQ1(Double actualQ1) {
		this.actualQ1 = actualQ1;
	}

	public Double getActualQ2() {
		return this.actualQ2;
	}

	public void setActualQ2(Double actualQ2) {
		this.actualQ2 = actualQ2;
	}

	public Double getActualQ3() {
		return this.actualQ3;
	}

	public void setActualQ3(Double actualQ3) {
		this.actualQ3 = actualQ3;
	}

	public Double getActualQ4() {
		return this.actualQ4;
	}

	public void setActualQ4(Double actualQ4) {
		this.actualQ4 = actualQ4;
	}

	public String getQuota() {
		return this.quota;
	}

	public void setQuota(String quota) {
		this.quota = quota;
	}

}