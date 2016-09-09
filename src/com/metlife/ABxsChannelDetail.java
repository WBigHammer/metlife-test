package com.metlife;

import java.math.BigDecimal;

/**
 * ABxsChannelDetail entity. @author MyEclipse Persistence Tools
 */

public class ABxsChannelDetail implements java.io.Serializable {

	// Fields

	private BigDecimal bxsChannelDetailId;
	private Integer time;
	private short rank;
	private String bank;
	private double dayAnp;
	private double monthlyAnpTarget;
	private double monthlyAnp;
	private double monthlyAnpAchievingRate;
	private double ytdAnpTarget;
	private double ytdAnp;
	private double ytdAnpAchievingRate;
	private double fullYearAnpTarget;
	private double fullYearAnp;
	private double fullYearAnpAchievingRate;
	private double monthlyFyp;
	private double ytdFyp;
	private double monthlyAfyp;
	private double ytdAfyp;
	private String channel;

	// Constructors

	/** default constructor */
	public ABxsChannelDetail() {
	}

	/** full constructor */
	public ABxsChannelDetail(Integer time, short rank, String bank,
			double dayAnp, double monthlyAnpTarget, double monthlyAnp,
			double monthlyAnpAchievingRate, double ytdAnpTarget, double ytdAnp,
			double ytdAnpAchievingRate, double fullYearAnpTarget,
			double fullYearAnp, double fullYearAnpAchievingRate,
			double monthlyFyp, double ytdFyp, double monthlyAfyp,
			double ytdAfyp, String channel) {
		this.time = time;
		this.rank = rank;
		this.bank = bank;
		this.dayAnp = dayAnp;
		this.monthlyAnpTarget = monthlyAnpTarget;
		this.monthlyAnp = monthlyAnp;
		this.monthlyAnpAchievingRate = monthlyAnpAchievingRate;
		this.ytdAnpTarget = ytdAnpTarget;
		this.ytdAnp = ytdAnp;
		this.ytdAnpAchievingRate = ytdAnpAchievingRate;
		this.fullYearAnpTarget = fullYearAnpTarget;
		this.fullYearAnp = fullYearAnp;
		this.fullYearAnpAchievingRate = fullYearAnpAchievingRate;
		this.monthlyFyp = monthlyFyp;
		this.ytdFyp = ytdFyp;
		this.monthlyAfyp = monthlyAfyp;
		this.ytdAfyp = ytdAfyp;
		this.channel = channel;
	}

	// Property accessors

	public BigDecimal getBxsChannelDetailId() {
		return this.bxsChannelDetailId;
	}

	public void setBxsChannelDetailId(BigDecimal bxsChannelDetailId) {
		this.bxsChannelDetailId = bxsChannelDetailId;
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

	public String getBank() {
		return this.bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public double getDayAnp() {
		return this.dayAnp;
	}

	public void setDayAnp(double dayAnp) {
		this.dayAnp = dayAnp;
	}

	public double getMonthlyAnpTarget() {
		return this.monthlyAnpTarget;
	}

	public void setMonthlyAnpTarget(double monthlyAnpTarget) {
		this.monthlyAnpTarget = monthlyAnpTarget;
	}

	public double getMonthlyAnp() {
		return this.monthlyAnp;
	}

	public void setMonthlyAnp(double monthlyAnp) {
		this.monthlyAnp = monthlyAnp;
	}

	public double getMonthlyAnpAchievingRate() {
		return this.monthlyAnpAchievingRate;
	}

	public void setMonthlyAnpAchievingRate(double monthlyAnpAchievingRate) {
		this.monthlyAnpAchievingRate = monthlyAnpAchievingRate;
	}

	public double getYtdAnpTarget() {
		return this.ytdAnpTarget;
	}

	public void setYtdAnpTarget(double ytdAnpTarget) {
		this.ytdAnpTarget = ytdAnpTarget;
	}

	public double getYtdAnp() {
		return this.ytdAnp;
	}

	public void setYtdAnp(double ytdAnp) {
		this.ytdAnp = ytdAnp;
	}

	public double getYtdAnpAchievingRate() {
		return this.ytdAnpAchievingRate;
	}

	public void setYtdAnpAchievingRate(double ytdAnpAchievingRate) {
		this.ytdAnpAchievingRate = ytdAnpAchievingRate;
	}

	public double getFullYearAnpTarget() {
		return this.fullYearAnpTarget;
	}

	public void setFullYearAnpTarget(double fullYearAnpTarget) {
		this.fullYearAnpTarget = fullYearAnpTarget;
	}

	public double getFullYearAnp() {
		return this.fullYearAnp;
	}

	public void setFullYearAnp(double fullYearAnp) {
		this.fullYearAnp = fullYearAnp;
	}

	public double getFullYearAnpAchievingRate() {
		return this.fullYearAnpAchievingRate;
	}

	public void setFullYearAnpAchievingRate(double fullYearAnpAchievingRate) {
		this.fullYearAnpAchievingRate = fullYearAnpAchievingRate;
	}

	public double getMonthlyFyp() {
		return this.monthlyFyp;
	}

	public void setMonthlyFyp(double monthlyFyp) {
		this.monthlyFyp = monthlyFyp;
	}

	public double getYtdFyp() {
		return this.ytdFyp;
	}

	public void setYtdFyp(double ytdFyp) {
		this.ytdFyp = ytdFyp;
	}

	public double getMonthlyAfyp() {
		return this.monthlyAfyp;
	}

	public void setMonthlyAfyp(double monthlyAfyp) {
		this.monthlyAfyp = monthlyAfyp;
	}

	public double getYtdAfyp() {
		return this.ytdAfyp;
	}

	public void setYtdAfyp(double ytdAfyp) {
		this.ytdAfyp = ytdAfyp;
	}

	public String getChannel() {
		return this.channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

}