package com.metlife;

/**
 * AByBranch entity. @author MyEclipse Persistence Tools
 */

public class AByBranch implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 572598992441606274L;
	private Long byBranchId;
	private Long time;
	private String channel;
	private String branch;
	private Double monthlyActual;
	private Double monthlyProj;
	private Double monthlyLy;
	private Double monthlyPlan;
	private Double monthlyActVsProj;
	private Double monthlyActVsLy;
	private Double monthlyActVsPlan;
	private Double quarterlyLast;
	private Double quarterlyActual;
	private Double quarterlyLyActual;
	private Double quarterlyPlan;
	private Double quarterlyActualVsLast;
	private Double quarterlyActYoy;
	private Double quarterlyActPlan;
	private Double ytdAct;
	private Double ytdPlan;
	private Double ytdLy;
	private Double ytdActVsPlan;
	private Double fullYearProj;
	private Double fullYearLy;
	private Double fullYearPlan;
	private Double fullYearProjVsLy;
	private Double fullYearProjVsPlan;

	@Override
	public String toString() {
		return "AByBranch [byBranchId=" + byBranchId + ", time=" + time
				+ ", channel=" + channel + ", branch=" + branch
				+ ", monthlyActual=" + monthlyActual + ", monthlyProj="
				+ monthlyProj + ", monthlyLy=" + monthlyLy + ", monthlyPlan="
				+ monthlyPlan + ", monthlyActVsProj=" + monthlyActVsProj
				+ ", monthlyActVsLy=" + monthlyActVsLy + ", monthlyActVsPlan="
				+ monthlyActVsPlan + ", quarterlyLast=" + quarterlyLast
				+ ", quarterlyActual=" + quarterlyActual
				+ ", quarterlyLyActual=" + quarterlyLyActual
				+ ", quarterlyPlan=" + quarterlyPlan
				+ ", quarterlyActualVsLast=" + quarterlyActualVsLast
				+ ", quarterlyActYoy=" + quarterlyActYoy
				+ ", quarterlyActPlan=" + quarterlyActPlan + ", ytdAct="
				+ ytdAct + ", ytdPlan=" + ytdPlan + ", ytdLy=" + ytdLy
				+ ", ytdActVsPlan=" + ytdActVsPlan + ", fullYearProj="
				+ fullYearProj + ", fullYearLy=" + fullYearLy
				+ ", fullYearPlan=" + fullYearPlan + ", fullYearProjVsLy="
				+ fullYearProjVsLy + ", fullYearProjVsPlan="
				+ fullYearProjVsPlan + "]";
	}
	
	// Constructors

	/** default constructor */
	public AByBranch() {
	}

	/** full constructor */
	public AByBranch(Long time, String channel, String branch,
			Double monthlyActual, Double monthlyProj, Double monthlyLy,
			Double monthlyPlan, Double monthlyActVsProj, Double monthlyActVsLy,
			Double monthlyActVsPlan, Double quarterlyLast,
			Double quarterlyActual, Double quarterlyLyActual,
			Double quarterlyPlan, Double quarterlyActualVsLast,
			Double quarterlyActYoy, Double quarterlyActPlan, Double ytdAct,
			Double ytdPlan, Double ytdLy, Double ytdActVsPlan,
			Double fullYearProj, Double fullYearLy, Double fullYearPlan,
			Double fullYearProjVsLy, Double fullYearProjVsPlan) {
		this.time = time;
		this.channel = channel;
		this.branch = branch;
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
		this.quarterlyActPlan = quarterlyActPlan;
		this.ytdAct = ytdAct;
		this.ytdPlan = ytdPlan;
		this.ytdLy = ytdLy;
		this.ytdActVsPlan = ytdActVsPlan;
		this.fullYearProj = fullYearProj;
		this.fullYearLy = fullYearLy;
		this.fullYearPlan = fullYearPlan;
		this.fullYearProjVsLy = fullYearProjVsLy;
		this.fullYearProjVsPlan = fullYearProjVsPlan;
	}

	// Property accessors

	public Long getByBranchId() {
		return this.byBranchId;
	}

	public void setByBranchId(Long byBranchId) {
		this.byBranchId = byBranchId;
	}

	public Long getTime() {
		return this.time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public String getChannel() {
		return this.channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	public String getBranch() {
		return this.branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
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

	public Double getMonthlyLy() {
		return this.monthlyLy;
	}

	public void setMonthlyLy(Double monthlyLy) {
		this.monthlyLy = monthlyLy;
	}

	public Double getMonthlyPlan() {
		return this.monthlyPlan;
	}

	public void setMonthlyPlan(Double monthlyPlan) {
		this.monthlyPlan = monthlyPlan;
	}

	public Double getMonthlyActVsProj() {
		return this.monthlyActVsProj;
	}

	public void setMonthlyActVsProj(Double monthlyActVsProj) {
		this.monthlyActVsProj = monthlyActVsProj;
	}

	public Double getMonthlyActVsLy() {
		return this.monthlyActVsLy;
	}

	public void setMonthlyActVsLy(Double monthlyActVsLy) {
		this.monthlyActVsLy = monthlyActVsLy;
	}

	public Double getMonthlyActVsPlan() {
		return this.monthlyActVsPlan;
	}

	public void setMonthlyActVsPlan(Double monthlyActVsPlan) {
		this.monthlyActVsPlan = monthlyActVsPlan;
	}

	public Double getQuarterlyLast() {
		return this.quarterlyLast;
	}

	public void setQuarterlyLast(Double quarterlyLast) {
		this.quarterlyLast = quarterlyLast;
	}

	public Double getQuarterlyActual() {
		return this.quarterlyActual;
	}

	public void setQuarterlyActual(Double quarterlyActual) {
		this.quarterlyActual = quarterlyActual;
	}

	public Double getQuarterlyLyActual() {
		return this.quarterlyLyActual;
	}

	public void setQuarterlyLyActual(Double quarterlyLyActual) {
		this.quarterlyLyActual = quarterlyLyActual;
	}

	public Double getQuarterlyPlan() {
		return this.quarterlyPlan;
	}

	public void setQuarterlyPlan(Double quarterlyPlan) {
		this.quarterlyPlan = quarterlyPlan;
	}

	public Double getQuarterlyActualVsLast() {
		return this.quarterlyActualVsLast;
	}

	public void setQuarterlyActualVsLast(Double quarterlyActualVsLast) {
		this.quarterlyActualVsLast = quarterlyActualVsLast;
	}

	public Double getQuarterlyActYoy() {
		return this.quarterlyActYoy;
	}

	public void setQuarterlyActYoy(Double quarterlyActYoy) {
		this.quarterlyActYoy = quarterlyActYoy;
	}

	public Double getQuarterlyActPlan() {
		return this.quarterlyActPlan;
	}

	public void setQuarterlyActPlan(Double quarterlyActPlan) {
		this.quarterlyActPlan = quarterlyActPlan;
	}

	public Double getYtdAct() {
		return this.ytdAct;
	}

	public void setYtdAct(Double ytdAct) {
		this.ytdAct = ytdAct;
	}

	public Double getYtdPlan() {
		return this.ytdPlan;
	}

	public void setYtdPlan(Double ytdPlan) {
		this.ytdPlan = ytdPlan;
	}

	public Double getYtdLy() {
		return this.ytdLy;
	}

	public void setYtdLy(Double ytdLy) {
		this.ytdLy = ytdLy;
	}

	public Double getYtdActVsPlan() {
		return this.ytdActVsPlan;
	}

	public void setYtdActVsPlan(Double ytdActVsPlan) {
		this.ytdActVsPlan = ytdActVsPlan;
	}

	public Double getFullYearProj() {
		return this.fullYearProj;
	}

	public void setFullYearProj(Double fullYearProj) {
		this.fullYearProj = fullYearProj;
	}

	public Double getFullYearLy() {
		return this.fullYearLy;
	}

	public void setFullYearLy(Double fullYearLy) {
		this.fullYearLy = fullYearLy;
	}

	public Double getFullYearPlan() {
		return this.fullYearPlan;
	}

	public void setFullYearPlan(Double fullYearPlan) {
		this.fullYearPlan = fullYearPlan;
	}

	public Double getFullYearProjVsLy() {
		return this.fullYearProjVsLy;
	}

	public void setFullYearProjVsLy(Double fullYearProjVsLy) {
		this.fullYearProjVsLy = fullYearProjVsLy;
	}

	public Double getFullYearProjVsPlan() {
		return this.fullYearProjVsPlan;
	}

	public void setFullYearProjVsPlan(Double fullYearProjVsPlan) {
		this.fullYearProjVsPlan = fullYearProjVsPlan;
	}

}