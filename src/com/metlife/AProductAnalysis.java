package com.metlife;

import java.math.BigDecimal;

/**
 * AProductAnalysis entity. @author MyEclipse Persistence Tools
 */

public class AProductAnalysis implements java.io.Serializable {

	// Fields

	private BigDecimal productAnalysisId;
	private String branch;
	private String city;
	private String channel;
	private String product;
	private double anp;
	private double coverage;
	private double premium;
	private Integer number;
	private String mainInsurance;
	private double additionalRate;
	private double averageAnp;
	private double averageCoverage;
	private String coverageRange;
	private double coverageNumberDistribution;
	private double coverageAnpDistribution;
	private double averagePremium;
	private String payYearsArange;
	private double payYearsNumDistribution;
	private double payYearsAnpDistribution;
	private String genderClassification;
	private double genderNumDistribution;
	private double genderAnpDistribution;
	private String ageRange;
	private double ageNumDistribution;
	private double ageAnpDistribution;
	private String occupationClassification;
	private double occupationNumDistribution;
	private double occupationAnpDistribution;
	private String incomeRange;
	private double incomeNumDistribution;
	private double incomeAnpDistribution;
	private String assurerGenderClassification;
	private double assurerGenderNumDistribute;
	private double assurerGenderAnpDistribute;
	private String assurerAgeRange;
	private String assurerAgeNumDistribution;
	private double assurerAgeAnpDistribution;
	private String type2;
	private String type3;
	private String type4;
	private String optionalRider;
	private short rank;

	// Constructors

	/** default constructor */
	public AProductAnalysis() {
	}

	/** full constructor */
	public AProductAnalysis(String branch, String city, String channel,
			String product, double anp, double coverage, double premium,
			Integer number, String mainInsurance, double additionalRate,
			double averageAnp, double averageCoverage, String coverageRange,
			double coverageNumberDistribution, double coverageAnpDistribution,
			double averagePremium, String payYearsArange,
			double payYearsNumDistribution, double payYearsAnpDistribution,
			String genderClassification, double genderNumDistribution,
			double genderAnpDistribution, String ageRange,
			double ageNumDistribution, double ageAnpDistribution,
			String occupationClassification, double occupationNumDistribution,
			double occupationAnpDistribution, String incomeRange,
			double incomeNumDistribution, double incomeAnpDistribution,
			String assurerGenderClassification,
			double assurerGenderNumDistribute,
			double assurerGenderAnpDistribute, String assurerAgeRange,
			String assurerAgeNumDistribution, double assurerAgeAnpDistribution,
			String type2, String type3, String type4, String optionalRider,
			short rank) {
		this.branch = branch;
		this.city = city;
		this.channel = channel;
		this.product = product;
		this.anp = anp;
		this.coverage = coverage;
		this.premium = premium;
		this.number = number;
		this.mainInsurance = mainInsurance;
		this.additionalRate = additionalRate;
		this.averageAnp = averageAnp;
		this.averageCoverage = averageCoverage;
		this.coverageRange = coverageRange;
		this.coverageNumberDistribution = coverageNumberDistribution;
		this.coverageAnpDistribution = coverageAnpDistribution;
		this.averagePremium = averagePremium;
		this.payYearsArange = payYearsArange;
		this.payYearsNumDistribution = payYearsNumDistribution;
		this.payYearsAnpDistribution = payYearsAnpDistribution;
		this.genderClassification = genderClassification;
		this.genderNumDistribution = genderNumDistribution;
		this.genderAnpDistribution = genderAnpDistribution;
		this.ageRange = ageRange;
		this.ageNumDistribution = ageNumDistribution;
		this.ageAnpDistribution = ageAnpDistribution;
		this.occupationClassification = occupationClassification;
		this.occupationNumDistribution = occupationNumDistribution;
		this.occupationAnpDistribution = occupationAnpDistribution;
		this.incomeRange = incomeRange;
		this.incomeNumDistribution = incomeNumDistribution;
		this.incomeAnpDistribution = incomeAnpDistribution;
		this.assurerGenderClassification = assurerGenderClassification;
		this.assurerGenderNumDistribute = assurerGenderNumDistribute;
		this.assurerGenderAnpDistribute = assurerGenderAnpDistribute;
		this.assurerAgeRange = assurerAgeRange;
		this.assurerAgeNumDistribution = assurerAgeNumDistribution;
		this.assurerAgeAnpDistribution = assurerAgeAnpDistribution;
		this.type2 = type2;
		this.type3 = type3;
		this.type4 = type4;
		this.optionalRider = optionalRider;
		this.rank = rank;
	}

	// Property accessors

	public BigDecimal getProductAnalysisId() {
		return this.productAnalysisId;
	}

	public void setProductAnalysisId(BigDecimal productAnalysisId) {
		this.productAnalysisId = productAnalysisId;
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

	public double getAnp() {
		return this.anp;
	}

	public void setAnp(double anp) {
		this.anp = anp;
	}

	public double getCoverage() {
		return this.coverage;
	}

	public void setCoverage(double coverage) {
		this.coverage = coverage;
	}

	public double getPremium() {
		return this.premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public Integer getNumber() {
		return this.number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getMainInsurance() {
		return this.mainInsurance;
	}

	public void setMainInsurance(String mainInsurance) {
		this.mainInsurance = mainInsurance;
	}

	public double getAdditionalRate() {
		return this.additionalRate;
	}

	public void setAdditionalRate(double additionalRate) {
		this.additionalRate = additionalRate;
	}

	public double getAverageAnp() {
		return this.averageAnp;
	}

	public void setAverageAnp(double averageAnp) {
		this.averageAnp = averageAnp;
	}

	public double getAverageCoverage() {
		return this.averageCoverage;
	}

	public void setAverageCoverage(double averageCoverage) {
		this.averageCoverage = averageCoverage;
	}

	public String getCoverageRange() {
		return this.coverageRange;
	}

	public void setCoverageRange(String coverageRange) {
		this.coverageRange = coverageRange;
	}

	public double getCoverageNumberDistribution() {
		return this.coverageNumberDistribution;
	}

	public void setCoverageNumberDistribution(double coverageNumberDistribution) {
		this.coverageNumberDistribution = coverageNumberDistribution;
	}

	public double getCoverageAnpDistribution() {
		return this.coverageAnpDistribution;
	}

	public void setCoverageAnpDistribution(double coverageAnpDistribution) {
		this.coverageAnpDistribution = coverageAnpDistribution;
	}

	public double getAveragePremium() {
		return this.averagePremium;
	}

	public void setAveragePremium(double averagePremium) {
		this.averagePremium = averagePremium;
	}

	public String getPayYearsArange() {
		return this.payYearsArange;
	}

	public void setPayYearsArange(String payYearsArange) {
		this.payYearsArange = payYearsArange;
	}

	public double getPayYearsNumDistribution() {
		return this.payYearsNumDistribution;
	}

	public void setPayYearsNumDistribution(double payYearsNumDistribution) {
		this.payYearsNumDistribution = payYearsNumDistribution;
	}

	public double getPayYearsAnpDistribution() {
		return this.payYearsAnpDistribution;
	}

	public void setPayYearsAnpDistribution(double payYearsAnpDistribution) {
		this.payYearsAnpDistribution = payYearsAnpDistribution;
	}

	public String getGenderClassification() {
		return this.genderClassification;
	}

	public void setGenderClassification(String genderClassification) {
		this.genderClassification = genderClassification;
	}

	public double getGenderNumDistribution() {
		return this.genderNumDistribution;
	}

	public void setGenderNumDistribution(double genderNumDistribution) {
		this.genderNumDistribution = genderNumDistribution;
	}

	public double getGenderAnpDistribution() {
		return this.genderAnpDistribution;
	}

	public void setGenderAnpDistribution(double genderAnpDistribution) {
		this.genderAnpDistribution = genderAnpDistribution;
	}

	public String getAgeRange() {
		return this.ageRange;
	}

	public void setAgeRange(String ageRange) {
		this.ageRange = ageRange;
	}

	public double getAgeNumDistribution() {
		return this.ageNumDistribution;
	}

	public void setAgeNumDistribution(double ageNumDistribution) {
		this.ageNumDistribution = ageNumDistribution;
	}

	public double getAgeAnpDistribution() {
		return this.ageAnpDistribution;
	}

	public void setAgeAnpDistribution(double ageAnpDistribution) {
		this.ageAnpDistribution = ageAnpDistribution;
	}

	public String getOccupationClassification() {
		return this.occupationClassification;
	}

	public void setOccupationClassification(String occupationClassification) {
		this.occupationClassification = occupationClassification;
	}

	public double getOccupationNumDistribution() {
		return this.occupationNumDistribution;
	}

	public void setOccupationNumDistribution(double occupationNumDistribution) {
		this.occupationNumDistribution = occupationNumDistribution;
	}

	public double getOccupationAnpDistribution() {
		return this.occupationAnpDistribution;
	}

	public void setOccupationAnpDistribution(double occupationAnpDistribution) {
		this.occupationAnpDistribution = occupationAnpDistribution;
	}

	public String getIncomeRange() {
		return this.incomeRange;
	}

	public void setIncomeRange(String incomeRange) {
		this.incomeRange = incomeRange;
	}

	public double getIncomeNumDistribution() {
		return this.incomeNumDistribution;
	}

	public void setIncomeNumDistribution(double incomeNumDistribution) {
		this.incomeNumDistribution = incomeNumDistribution;
	}

	public double getIncomeAnpDistribution() {
		return this.incomeAnpDistribution;
	}

	public void setIncomeAnpDistribution(double incomeAnpDistribution) {
		this.incomeAnpDistribution = incomeAnpDistribution;
	}

	public String getAssurerGenderClassification() {
		return this.assurerGenderClassification;
	}

	public void setAssurerGenderClassification(
			String assurerGenderClassification) {
		this.assurerGenderClassification = assurerGenderClassification;
	}

	public double getAssurerGenderNumDistribute() {
		return this.assurerGenderNumDistribute;
	}

	public void setAssurerGenderNumDistribute(double assurerGenderNumDistribute) {
		this.assurerGenderNumDistribute = assurerGenderNumDistribute;
	}

	public double getAssurerGenderAnpDistribute() {
		return this.assurerGenderAnpDistribute;
	}

	public void setAssurerGenderAnpDistribute(double assurerGenderAnpDistribute) {
		this.assurerGenderAnpDistribute = assurerGenderAnpDistribute;
	}

	public String getAssurerAgeRange() {
		return this.assurerAgeRange;
	}

	public void setAssurerAgeRange(String assurerAgeRange) {
		this.assurerAgeRange = assurerAgeRange;
	}

	public String getAssurerAgeNumDistribution() {
		return this.assurerAgeNumDistribution;
	}

	public void setAssurerAgeNumDistribution(String assurerAgeNumDistribution) {
		this.assurerAgeNumDistribution = assurerAgeNumDistribution;
	}

	public double getAssurerAgeAnpDistribution() {
		return this.assurerAgeAnpDistribution;
	}

	public void setAssurerAgeAnpDistribution(double assurerAgeAnpDistribution) {
		this.assurerAgeAnpDistribution = assurerAgeAnpDistribution;
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

	public String getType4() {
		return this.type4;
	}

	public void setType4(String type4) {
		this.type4 = type4;
	}

	public String getOptionalRider() {
		return this.optionalRider;
	}

	public void setOptionalRider(String optionalRider) {
		this.optionalRider = optionalRider;
	}

	public short getRank() {
		return this.rank;
	}

	public void setRank(short rank) {
		this.rank = rank;
	}

}