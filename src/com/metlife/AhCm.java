package com.metlife;

// default package


/**
 * AhCm entity. @author MyEclipse Persistence Tools
 */

public class AhCm implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 5233832514474460340L;
	private Integer ahCmId;
	private Integer time;
	private String channel;
	private String product;
	private Double totalAnp;
	private Double totalPy;
	private Double totalPlan;
	private Double totalAllAnp;
	private Double refundableAnp;
	private Double refundablePy;
	private Double refundablePlan;
	private Double refundableAllAnp;
	private Double excludeRefundableAnp;
	private Double excludeRefundablePy;
	private Double excludeRefundablePlan;
	private Double excludeRefundableAllAnp;
	private Double persistencyRatio;
	private Double lapseRatio;
	
	@Override
	public String toString() {
		return "AhCm [ahCmId=" + ahCmId + ", time=" + time + ", channel="
				+ channel + ", product=" + product + ", totalAnp=" + totalAnp
				+ ", totalPy=" + totalPy + ", totalPlan=" + totalPlan
				+ ", totalAllAnp=" + totalAllAnp + ", refundableAnp="
				+ refundableAnp + ", refundablePy=" + refundablePy
				+ ", refundablePlan=" + refundablePlan + ", refundableAllAnp="
				+ refundableAllAnp + ", excludeRefundableAnp="
				+ excludeRefundableAnp + ", excludeRefundablePy="
				+ excludeRefundablePy + ", excludeRefundablePlan="
				+ excludeRefundablePlan + ", excludeRefundableAllAnp="
				+ excludeRefundableAllAnp + ", persistencyRatio="
				+ persistencyRatio + ", lapseRatio=" + lapseRatio + "]";
	}
	// Constructors
	/** default constructor */
	public AhCm() {
	}

	/** full constructor */
	public AhCm(Integer time, String channel, String product, Double totalAnp,
			Double totalPy, Double totalPlan, Double totalAllAnp,
			Double refundableAnp, Double refundablePy, Double refundablePlan,
			Double refundableAllAnp, Double excludeRefundableAnp,
			Double excludeRefundablePy, Double excludeRefundablePlan,
			Double excludeRefundableAllAnp, Double persistencyRatio,
			Double lapseRatio) {
		this.time = time;
		this.channel = channel;
		this.product = product;
		this.totalAnp = totalAnp;
		this.totalPy = totalPy;
		this.totalPlan = totalPlan;
		this.totalAllAnp = totalAllAnp;
		this.refundableAnp = refundableAnp;
		this.refundablePy = refundablePy;
		this.refundablePlan = refundablePlan;
		this.refundableAllAnp = refundableAllAnp;
		this.excludeRefundableAnp = excludeRefundableAnp;
		this.excludeRefundablePy = excludeRefundablePy;
		this.excludeRefundablePlan = excludeRefundablePlan;
		this.excludeRefundableAllAnp = excludeRefundableAllAnp;
		this.persistencyRatio = persistencyRatio;
		this.lapseRatio = lapseRatio;
	}

	// Property accessors

	public Integer getAhCmId() {
		return this.ahCmId;
	}

	public void setAhCmId(Integer ahCmId) {
		this.ahCmId = ahCmId;
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

	public String getProduct() {
		return this.product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public Double getTotalAnp() {
		return this.totalAnp;
	}

	public void setTotalAnp(Double totalAnp) {
		this.totalAnp = totalAnp;
	}

	public Double getTotalPy() {
		return this.totalPy;
	}

	public void setTotalPy(Double totalPy) {
		this.totalPy = totalPy;
	}

	public Double getTotalPlan() {
		return this.totalPlan;
	}

	public void setTotalPlan(Double totalPlan) {
		this.totalPlan = totalPlan;
	}

	public Double getTotalAllAnp() {
		return this.totalAllAnp;
	}

	public void setTotalAllAnp(Double totalAllAnp) {
		this.totalAllAnp = totalAllAnp;
	}

	public Double getRefundableAnp() {
		return this.refundableAnp;
	}

	public void setRefundableAnp(Double refundableAnp) {
		this.refundableAnp = refundableAnp;
	}

	public Double getRefundablePy() {
		return this.refundablePy;
	}

	public void setRefundablePy(Double refundablePy) {
		this.refundablePy = refundablePy;
	}

	public Double getRefundablePlan() {
		return this.refundablePlan;
	}

	public void setRefundablePlan(Double refundablePlan) {
		this.refundablePlan = refundablePlan;
	}

	public Double getRefundableAllAnp() {
		return this.refundableAllAnp;
	}

	public void setRefundableAllAnp(Double refundableAllAnp) {
		this.refundableAllAnp = refundableAllAnp;
	}

	public Double getExcludeRefundableAnp() {
		return this.excludeRefundableAnp;
	}

	public void setExcludeRefundableAnp(Double excludeRefundableAnp) {
		this.excludeRefundableAnp = excludeRefundableAnp;
	}

	public Double getExcludeRefundablePy() {
		return this.excludeRefundablePy;
	}

	public void setExcludeRefundablePy(Double excludeRefundablePy) {
		this.excludeRefundablePy = excludeRefundablePy;
	}

	public Double getExcludeRefundablePlan() {
		return this.excludeRefundablePlan;
	}

	public void setExcludeRefundablePlan(Double excludeRefundablePlan) {
		this.excludeRefundablePlan = excludeRefundablePlan;
	}

	public Double getExcludeRefundableAllAnp() {
		return this.excludeRefundableAllAnp;
	}

	public void setExcludeRefundableAllAnp(Double excludeRefundableAllAnp) {
		this.excludeRefundableAllAnp = excludeRefundableAllAnp;
	}

	public Double getPersistencyRatio() {
		return this.persistencyRatio;
	}

	public void setPersistencyRatio(Double persistencyRatio) {
		this.persistencyRatio = persistencyRatio;
	}

	public Double getLapseRatio() {
		return this.lapseRatio;
	}

	public void setLapseRatio(Double lapseRatio) {
		this.lapseRatio = lapseRatio;
	}

}