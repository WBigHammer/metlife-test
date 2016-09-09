package com.metlife;

import java.math.BigDecimal;

/**
 * ABxsBigClient entity. @author MyEclipse Persistence Tools
 */

public class ABxsBigClient implements java.io.Serializable {

	// Fields

	private BigDecimal bxsBigClientId;
	private Integer time;
	private short rank;
	private String branch;
	private String city;
	private double dayClientNumber;
	private double dayAnp;
	private double monthlyClientNumber;
	private double monthlyAnp;
	private double quarterlyClientNumber;
	private double quarterlyTargetClientNumber;
	private double quarterlyAchievingRate;
	private double quarterlyAnp;
	private double quarterlyTargetAnp;
	private double quarterlyAnpAchievingRate;
	private double fullYearClientNumber;
	private double fullYearTargetClientNumber;
	private double fullYearAchievingRate;
	private double fullYearAnp;
	private double fullYearTargetAnp;
	private double fullYearAnpAchievingRate;

	// Constructors

	/** default constructor */
	public ABxsBigClient() {
	}

	/** full constructor */
	public ABxsBigClient(Integer time, short rank, String branch, String city,
			double dayClientNumber, double dayAnp, double monthlyClientNumber,
			double monthlyAnp, double quarterlyClientNumber,
			double quarterlyTargetClientNumber, double quarterlyAchievingRate,
			double quarterlyAnp, double quarterlyTargetAnp,
			double quarterlyAnpAchievingRate, double fullYearClientNumber,
			double fullYearTargetClientNumber, double fullYearAchievingRate,
			double fullYearAnp, double fullYearTargetAnp,
			double fullYearAnpAchievingRate) {
		this.time = time;
		this.rank = rank;
		this.branch = branch;
		this.city = city;
		this.dayClientNumber = dayClientNumber;
		this.dayAnp = dayAnp;
		this.monthlyClientNumber = monthlyClientNumber;
		this.monthlyAnp = monthlyAnp;
		this.quarterlyClientNumber = quarterlyClientNumber;
		this.quarterlyTargetClientNumber = quarterlyTargetClientNumber;
		this.quarterlyAchievingRate = quarterlyAchievingRate;
		this.quarterlyAnp = quarterlyAnp;
		this.quarterlyTargetAnp = quarterlyTargetAnp;
		this.quarterlyAnpAchievingRate = quarterlyAnpAchievingRate;
		this.fullYearClientNumber = fullYearClientNumber;
		this.fullYearTargetClientNumber = fullYearTargetClientNumber;
		this.fullYearAchievingRate = fullYearAchievingRate;
		this.fullYearAnp = fullYearAnp;
		this.fullYearTargetAnp = fullYearTargetAnp;
		this.fullYearAnpAchievingRate = fullYearAnpAchievingRate;
	}

	// Property accessors

	public BigDecimal getBxsBigClientId() {
		return this.bxsBigClientId;
	}

	public void setBxsBigClientId(BigDecimal bxsBigClientId) {
		this.bxsBigClientId = bxsBigClientId;
	}

	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public short getRank() {
		return this.rank;
	}

	public void setRank(short rank) {
		this.rank = rank;
	}

	public String getBranch() {
		return this.branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public double getDayClientNumber() {
		return this.dayClientNumber;
	}

	public void setDayClientNumber(double dayClientNumber) {
		this.dayClientNumber = dayClientNumber;
	}

	public double getDayAnp() {
		return this.dayAnp;
	}

	public void setDayAnp(double dayAnp) {
		this.dayAnp = dayAnp;
	}

	public double getMonthlyClientNumber() {
		return this.monthlyClientNumber;
	}

	public void setMonthlyClientNumber(double monthlyClientNumber) {
		this.monthlyClientNumber = monthlyClientNumber;
	}

	public double getMonthlyAnp() {
		return this.monthlyAnp;
	}

	public void setMonthlyAnp(double monthlyAnp) {
		this.monthlyAnp = monthlyAnp;
	}

	public double getQuarterlyClientNumber() {
		return this.quarterlyClientNumber;
	}

	public void setQuarterlyClientNumber(double quarterlyClientNumber) {
		this.quarterlyClientNumber = quarterlyClientNumber;
	}

	public double getQuarterlyTargetClientNumber() {
		return this.quarterlyTargetClientNumber;
	}

	public void setQuarterlyTargetClientNumber(
			double quarterlyTargetClientNumber) {
		this.quarterlyTargetClientNumber = quarterlyTargetClientNumber;
	}

	public double getQuarterlyAchievingRate() {
		return this.quarterlyAchievingRate;
	}

	public void setQuarterlyAchievingRate(double quarterlyAchievingRate) {
		this.quarterlyAchievingRate = quarterlyAchievingRate;
	}

	public double getQuarterlyAnp() {
		return this.quarterlyAnp;
	}

	public void setQuarterlyAnp(double quarterlyAnp) {
		this.quarterlyAnp = quarterlyAnp;
	}

	public double getQuarterlyTargetAnp() {
		return this.quarterlyTargetAnp;
	}

	public void setQuarterlyTargetAnp(double quarterlyTargetAnp) {
		this.quarterlyTargetAnp = quarterlyTargetAnp;
	}

	public double getQuarterlyAnpAchievingRate() {
		return this.quarterlyAnpAchievingRate;
	}

	public void setQuarterlyAnpAchievingRate(double quarterlyAnpAchievingRate) {
		this.quarterlyAnpAchievingRate = quarterlyAnpAchievingRate;
	}

	public double getFullYearClientNumber() {
		return this.fullYearClientNumber;
	}

	public void setFullYearClientNumber(double fullYearClientNumber) {
		this.fullYearClientNumber = fullYearClientNumber;
	}

	public double getFullYearTargetClientNumber() {
		return this.fullYearTargetClientNumber;
	}

	public void setFullYearTargetClientNumber(double fullYearTargetClientNumber) {
		this.fullYearTargetClientNumber = fullYearTargetClientNumber;
	}

	public double getFullYearAchievingRate() {
		return this.fullYearAchievingRate;
	}

	public void setFullYearAchievingRate(double fullYearAchievingRate) {
		this.fullYearAchievingRate = fullYearAchievingRate;
	}

	public double getFullYearAnp() {
		return this.fullYearAnp;
	}

	public void setFullYearAnp(double fullYearAnp) {
		this.fullYearAnp = fullYearAnp;
	}

	public double getFullYearTargetAnp() {
		return this.fullYearTargetAnp;
	}

	public void setFullYearTargetAnp(double fullYearTargetAnp) {
		this.fullYearTargetAnp = fullYearTargetAnp;
	}

	public double getFullYearAnpAchievingRate() {
		return this.fullYearAnpAchievingRate;
	}

	public void setFullYearAnpAchievingRate(double fullYearAnpAchievingRate) {
		this.fullYearAnpAchievingRate = fullYearAnpAchievingRate;
	}

}