package com.metlife;

/**
 * AQuickViewBps3Id entity. @author MyEclipse Persistence Tools
 */

public class AQuickViewBps3Id implements java.io.Serializable {

	// Fields

	private long quickViewBps3Id;
	private long time;
	private String channel;
	private double monthlyActual;
	private double monthlyProj;
	private double monthlyLy;
	private double monthlyPlan;
	private double monthlyActVsProj;
	private double monthlyActVsLy;
	private double monthlyActVsPlan;
	private double quarterlyLast;
	private double quarterlyActual;
	private double quarterlyLyActual;
	private double quarterlyPlan;
	private double quarterlyActualVsLast;
	private double quarterlyActYoy;
	private double quarterlyActVsPlan;
	private double ytdAct;
	private double ytdPlan;
	private double ytdLy;
	private double ytdActVsPlan;
	private double ytdActVsLy;
	private double fullYearLy;
	private double fullYearAct;
	private double fullYearProj;
	private double fullYearPlan;
	private double fullYearProjVsLy;
	private double fullYearProjVsPlan;

	// Constructors

	/** default constructor */
	public AQuickViewBps3Id() {
	}

	/** full constructor */
	public AQuickViewBps3Id(long quickViewBps3Id, long time, String channel,
			double monthlyActual, double monthlyProj, double monthlyLy,
			double monthlyPlan, double monthlyActVsProj, double monthlyActVsLy,
			double monthlyActVsPlan, double quarterlyLast,
			double quarterlyActual, double quarterlyLyActual,
			double quarterlyPlan, double quarterlyActualVsLast,
			double quarterlyActYoy, double quarterlyActVsPlan, double ytdAct,
			double ytdPlan, double ytdLy, double ytdActVsPlan,
			double ytdActVsLy, double fullYearLy, double fullYearAct,
			double fullYearProj, double fullYearPlan, double fullYearProjVsLy,
			double fullYearProjVsPlan) {
		this.quickViewBps3Id = quickViewBps3Id;
		this.time = time;
		this.channel = channel;
		this.monthlyActual = monthlyActual;
		this.monthlyProj = monthlyProj;
		this.monthlyLy = monthlyLy;
		this.monthlyPlan = monthlyPlan;
		this.monthlyActVsProj = monthlyActVsProj;
		this.monthlyActVsLy = monthlyActVsLy;
		this.monthlyActVsPlan = monthlyActVsPlan;
		this.quarterlyLast = quarterlyLast;
		this.quarterlyActual = quarterlyActual;
		this.quarterlyLyActual = quarterlyLyActual;
		this.quarterlyPlan = quarterlyPlan;
		this.quarterlyActualVsLast = quarterlyActualVsLast;
		this.quarterlyActYoy = quarterlyActYoy;
		this.quarterlyActVsPlan = quarterlyActVsPlan;
		this.ytdAct = ytdAct;
		this.ytdPlan = ytdPlan;
		this.ytdLy = ytdLy;
		this.ytdActVsPlan = ytdActVsPlan;
		this.ytdActVsLy = ytdActVsLy;
		this.fullYearLy = fullYearLy;
		this.fullYearAct = fullYearAct;
		this.fullYearProj = fullYearProj;
		this.fullYearPlan = fullYearPlan;
		this.fullYearProjVsLy = fullYearProjVsLy;
		this.fullYearProjVsPlan = fullYearProjVsPlan;
	}

	// Property accessors

	public long getQuickViewBps3Id() {
		return this.quickViewBps3Id;
	}

	public void setQuickViewBps3Id(long quickViewBps3Id) {
		this.quickViewBps3Id = quickViewBps3Id;
	}

	public long getTime() {
		return this.time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getChannel() {
		return this.channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
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

	public double getMonthlyLy() {
		return this.monthlyLy;
	}

	public void setMonthlyLy(double monthlyLy) {
		this.monthlyLy = monthlyLy;
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

	public double getMonthlyActVsLy() {
		return this.monthlyActVsLy;
	}

	public void setMonthlyActVsLy(double monthlyActVsLy) {
		this.monthlyActVsLy = monthlyActVsLy;
	}

	public double getMonthlyActVsPlan() {
		return this.monthlyActVsPlan;
	}

	public void setMonthlyActVsPlan(double monthlyActVsPlan) {
		this.monthlyActVsPlan = monthlyActVsPlan;
	}

	public double getQuarterlyLast() {
		return this.quarterlyLast;
	}

	public void setQuarterlyLast(double quarterlyLast) {
		this.quarterlyLast = quarterlyLast;
	}

	public double getQuarterlyActual() {
		return this.quarterlyActual;
	}

	public void setQuarterlyActual(double quarterlyActual) {
		this.quarterlyActual = quarterlyActual;
	}

	public double getQuarterlyLyActual() {
		return this.quarterlyLyActual;
	}

	public void setQuarterlyLyActual(double quarterlyLyActual) {
		this.quarterlyLyActual = quarterlyLyActual;
	}

	public double getQuarterlyPlan() {
		return this.quarterlyPlan;
	}

	public void setQuarterlyPlan(double quarterlyPlan) {
		this.quarterlyPlan = quarterlyPlan;
	}

	public double getQuarterlyActualVsLast() {
		return this.quarterlyActualVsLast;
	}

	public void setQuarterlyActualVsLast(double quarterlyActualVsLast) {
		this.quarterlyActualVsLast = quarterlyActualVsLast;
	}

	public double getQuarterlyActYoy() {
		return this.quarterlyActYoy;
	}

	public void setQuarterlyActYoy(double quarterlyActYoy) {
		this.quarterlyActYoy = quarterlyActYoy;
	}

	public double getQuarterlyActVsPlan() {
		return this.quarterlyActVsPlan;
	}

	public void setQuarterlyActVsPlan(double quarterlyActVsPlan) {
		this.quarterlyActVsPlan = quarterlyActVsPlan;
	}

	public double getYtdAct() {
		return this.ytdAct;
	}

	public void setYtdAct(double ytdAct) {
		this.ytdAct = ytdAct;
	}

	public double getYtdPlan() {
		return this.ytdPlan;
	}

	public void setYtdPlan(double ytdPlan) {
		this.ytdPlan = ytdPlan;
	}

	public double getYtdLy() {
		return this.ytdLy;
	}

	public void setYtdLy(double ytdLy) {
		this.ytdLy = ytdLy;
	}

	public double getYtdActVsPlan() {
		return this.ytdActVsPlan;
	}

	public void setYtdActVsPlan(double ytdActVsPlan) {
		this.ytdActVsPlan = ytdActVsPlan;
	}

	public double getYtdActVsLy() {
		return this.ytdActVsLy;
	}

	public void setYtdActVsLy(double ytdActVsLy) {
		this.ytdActVsLy = ytdActVsLy;
	}

	public double getFullYearLy() {
		return this.fullYearLy;
	}

	public void setFullYearLy(double fullYearLy) {
		this.fullYearLy = fullYearLy;
	}

	public double getFullYearAct() {
		return this.fullYearAct;
	}

	public void setFullYearAct(double fullYearAct) {
		this.fullYearAct = fullYearAct;
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

	public double getFullYearProjVsLy() {
		return this.fullYearProjVsLy;
	}

	public void setFullYearProjVsLy(double fullYearProjVsLy) {
		this.fullYearProjVsLy = fullYearProjVsLy;
	}

	public double getFullYearProjVsPlan() {
		return this.fullYearProjVsPlan;
	}

	public void setFullYearProjVsPlan(double fullYearProjVsPlan) {
		this.fullYearProjVsPlan = fullYearProjVsPlan;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof AQuickViewBps3Id))
			return false;
		AQuickViewBps3Id castOther = (AQuickViewBps3Id) other;

		return (this.getQuickViewBps3Id() == castOther.getQuickViewBps3Id())
				&& (this.getTime() == castOther.getTime())
				&& ((this.getChannel() == castOther.getChannel()) || (this
						.getChannel() != null && castOther.getChannel() != null && this
						.getChannel().equals(castOther.getChannel())))
				&& (this.getMonthlyActual() == castOther.getMonthlyActual())
				&& (this.getMonthlyProj() == castOther.getMonthlyProj())
				&& (this.getMonthlyLy() == castOther.getMonthlyLy())
				&& (this.getMonthlyPlan() == castOther.getMonthlyPlan())
				&& (this.getMonthlyActVsProj() == castOther
						.getMonthlyActVsProj())
				&& (this.getMonthlyActVsLy() == castOther.getMonthlyActVsLy())
				&& (this.getMonthlyActVsPlan() == castOther
						.getMonthlyActVsPlan())
				&& (this.getQuarterlyLast() == castOther.getQuarterlyLast())
				&& (this.getQuarterlyActual() == castOther.getQuarterlyActual())
				&& (this.getQuarterlyLyActual() == castOther
						.getQuarterlyLyActual())
				&& (this.getQuarterlyPlan() == castOther.getQuarterlyPlan())
				&& (this.getQuarterlyActualVsLast() == castOther
						.getQuarterlyActualVsLast())
				&& (this.getQuarterlyActYoy() == castOther.getQuarterlyActYoy())
				&& (this.getQuarterlyActVsPlan() == castOther
						.getQuarterlyActVsPlan())
				&& (this.getYtdAct() == castOther.getYtdAct())
				&& (this.getYtdPlan() == castOther.getYtdPlan())
				&& (this.getYtdLy() == castOther.getYtdLy())
				&& (this.getYtdActVsPlan() == castOther.getYtdActVsPlan())
				&& (this.getYtdActVsLy() == castOther.getYtdActVsLy())
				&& (this.getFullYearLy() == castOther.getFullYearLy())
				&& (this.getFullYearAct() == castOther.getFullYearAct())
				&& (this.getFullYearProj() == castOther.getFullYearProj())
				&& (this.getFullYearPlan() == castOther.getFullYearPlan())
				&& (this.getFullYearProjVsLy() == castOther
						.getFullYearProjVsLy())
				&& (this.getFullYearProjVsPlan() == castOther
						.getFullYearProjVsPlan());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getQuickViewBps3Id();
		result = 37 * result + (int) this.getTime();
		result = 37 * result
				+ (getChannel() == null ? 0 : this.getChannel().hashCode());
		result = 37 * result + (int) this.getMonthlyActual();
		result = 37 * result + (int) this.getMonthlyProj();
		result = 37 * result + (int) this.getMonthlyLy();
		result = 37 * result + (int) this.getMonthlyPlan();
		result = 37 * result + (int) this.getMonthlyActVsProj();
		result = 37 * result + (int) this.getMonthlyActVsLy();
		result = 37 * result + (int) this.getMonthlyActVsPlan();
		result = 37 * result + (int) this.getQuarterlyLast();
		result = 37 * result + (int) this.getQuarterlyActual();
		result = 37 * result + (int) this.getQuarterlyLyActual();
		result = 37 * result + (int) this.getQuarterlyPlan();
		result = 37 * result + (int) this.getQuarterlyActualVsLast();
		result = 37 * result + (int) this.getQuarterlyActYoy();
		result = 37 * result + (int) this.getQuarterlyActVsPlan();
		result = 37 * result + (int) this.getYtdAct();
		result = 37 * result + (int) this.getYtdPlan();
		result = 37 * result + (int) this.getYtdLy();
		result = 37 * result + (int) this.getYtdActVsPlan();
		result = 37 * result + (int) this.getYtdActVsLy();
		result = 37 * result + (int) this.getFullYearLy();
		result = 37 * result + (int) this.getFullYearAct();
		result = 37 * result + (int) this.getFullYearProj();
		result = 37 * result + (int) this.getFullYearPlan();
		result = 37 * result + (int) this.getFullYearProjVsLy();
		result = 37 * result + (int) this.getFullYearProjVsPlan();
		return result;
	}

}