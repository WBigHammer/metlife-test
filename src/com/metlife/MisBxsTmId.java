package com.metlife;

import java.util.Date;

/**
 * MisBxsTmId entity. @author MyEclipse Persistence Tools
 */

public class MisBxsTmId implements java.io.Serializable {

	// Fields

	private long bxsTmId;
	private Date time;
	private String channelCode;
	private String institutionsCode;
	private String institutionsName;
	private String projectCode;
	private String projectName;
	private String productCode;
	private String productClassify;
	private short payperiod;
	private short policyperiod;
	private double m1;
	private double m2;
	private double m3;
	private double m4;
	private double m5;
	private double m6;
	private double m7;
	private double m8;
	private double m9;
	private double m10;
	private double m11;
	private double m12;
	private String name;
	private String clientType;
	private String distribution;
	private String lob;
	private String holdingCompany;
	private String id;

	// Constructors

	/** default constructor */
	public MisBxsTmId() {
	}

	/** full constructor */
	public MisBxsTmId(long bxsTmId, Date time, String channelCode,
			String institutionsCode, String institutionsName,
			String projectCode, String projectName, String productCode,
			String productClassify, short payperiod, short policyperiod,
			double m1, double m2, double m3, double m4, double m5, double m6,
			double m7, double m8, double m9, double m10, double m11,
			double m12, String name, String clientType, String distribution,
			String lob, String holdingCompany, String id) {
		this.bxsTmId = bxsTmId;
		this.time = time;
		this.channelCode = channelCode;
		this.institutionsCode = institutionsCode;
		this.institutionsName = institutionsName;
		this.projectCode = projectCode;
		this.projectName = projectName;
		this.productCode = productCode;
		this.productClassify = productClassify;
		this.payperiod = payperiod;
		this.policyperiod = policyperiod;
		this.m1 = m1;
		this.m2 = m2;
		this.m3 = m3;
		this.m4 = m4;
		this.m5 = m5;
		this.m6 = m6;
		this.m7 = m7;
		this.m8 = m8;
		this.m9 = m9;
		this.m10 = m10;
		this.m11 = m11;
		this.m12 = m12;
		this.name = name;
		this.clientType = clientType;
		this.distribution = distribution;
		this.lob = lob;
		this.holdingCompany = holdingCompany;
		this.id = id;
	}

	// Property accessors

	public long getBxsTmId() {
		return this.bxsTmId;
	}

	public void setBxsTmId(long bxsTmId) {
		this.bxsTmId = bxsTmId;
	}

	public Date getTime() {
		return this.time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public String getChannelCode() {
		return this.channelCode;
	}

	public void setChannelCode(String channelCode) {
		this.channelCode = channelCode;
	}

	public String getInstitutionsCode() {
		return this.institutionsCode;
	}

	public void setInstitutionsCode(String institutionsCode) {
		this.institutionsCode = institutionsCode;
	}

	public String getInstitutionsName() {
		return this.institutionsName;
	}

	public void setInstitutionsName(String institutionsName) {
		this.institutionsName = institutionsName;
	}

	public String getProjectCode() {
		return this.projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return this.projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getProductClassify() {
		return this.productClassify;
	}

	public void setProductClassify(String productClassify) {
		this.productClassify = productClassify;
	}

	public short getPayperiod() {
		return this.payperiod;
	}

	public void setPayperiod(short payperiod) {
		this.payperiod = payperiod;
	}

	public short getPolicyperiod() {
		return this.policyperiod;
	}

	public void setPolicyperiod(short policyperiod) {
		this.policyperiod = policyperiod;
	}

	public double getM1() {
		return this.m1;
	}

	public void setM1(double m1) {
		this.m1 = m1;
	}

	public double getM2() {
		return this.m2;
	}

	public void setM2(double m2) {
		this.m2 = m2;
	}

	public double getM3() {
		return this.m3;
	}

	public void setM3(double m3) {
		this.m3 = m3;
	}

	public double getM4() {
		return this.m4;
	}

	public void setM4(double m4) {
		this.m4 = m4;
	}

	public double getM5() {
		return this.m5;
	}

	public void setM5(double m5) {
		this.m5 = m5;
	}

	public double getM6() {
		return this.m6;
	}

	public void setM6(double m6) {
		this.m6 = m6;
	}

	public double getM7() {
		return this.m7;
	}

	public void setM7(double m7) {
		this.m7 = m7;
	}

	public double getM8() {
		return this.m8;
	}

	public void setM8(double m8) {
		this.m8 = m8;
	}

	public double getM9() {
		return this.m9;
	}

	public void setM9(double m9) {
		this.m9 = m9;
	}

	public double getM10() {
		return this.m10;
	}

	public void setM10(double m10) {
		this.m10 = m10;
	}

	public double getM11() {
		return this.m11;
	}

	public void setM11(double m11) {
		this.m11 = m11;
	}

	public double getM12() {
		return this.m12;
	}

	public void setM12(double m12) {
		this.m12 = m12;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClientType() {
		return this.clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}

	public String getDistribution() {
		return this.distribution;
	}

	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}

	public String getLob() {
		return this.lob;
	}

	public void setLob(String lob) {
		this.lob = lob;
	}

	public String getHoldingCompany() {
		return this.holdingCompany;
	}

	public void setHoldingCompany(String holdingCompany) {
		this.holdingCompany = holdingCompany;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MisBxsTmId))
			return false;
		MisBxsTmId castOther = (MisBxsTmId) other;

		return (this.getBxsTmId() == castOther.getBxsTmId())
				&& ((this.getTime() == castOther.getTime()) || (this.getTime() != null
						&& castOther.getTime() != null && this.getTime()
						.equals(castOther.getTime())))
				&& ((this.getChannelCode() == castOther.getChannelCode()) || (this
						.getChannelCode() != null
						&& castOther.getChannelCode() != null && this
						.getChannelCode().equals(castOther.getChannelCode())))
				&& ((this.getInstitutionsCode() == castOther
						.getInstitutionsCode()) || (this.getInstitutionsCode() != null
						&& castOther.getInstitutionsCode() != null && this
						.getInstitutionsCode().equals(
								castOther.getInstitutionsCode())))
				&& ((this.getInstitutionsName() == castOther
						.getInstitutionsName()) || (this.getInstitutionsName() != null
						&& castOther.getInstitutionsName() != null && this
						.getInstitutionsName().equals(
								castOther.getInstitutionsName())))
				&& ((this.getProjectCode() == castOther.getProjectCode()) || (this
						.getProjectCode() != null
						&& castOther.getProjectCode() != null && this
						.getProjectCode().equals(castOther.getProjectCode())))
				&& ((this.getProjectName() == castOther.getProjectName()) || (this
						.getProjectName() != null
						&& castOther.getProjectName() != null && this
						.getProjectName().equals(castOther.getProjectName())))
				&& ((this.getProductCode() == castOther.getProductCode()) || (this
						.getProductCode() != null
						&& castOther.getProductCode() != null && this
						.getProductCode().equals(castOther.getProductCode())))
				&& ((this.getProductClassify() == castOther
						.getProductClassify()) || (this.getProductClassify() != null
						&& castOther.getProductClassify() != null && this
						.getProductClassify().equals(
								castOther.getProductClassify())))
				&& (this.getPayperiod() == castOther.getPayperiod())
				&& (this.getPolicyperiod() == castOther.getPolicyperiod())
				&& (this.getM1() == castOther.getM1())
				&& (this.getM2() == castOther.getM2())
				&& (this.getM3() == castOther.getM3())
				&& (this.getM4() == castOther.getM4())
				&& (this.getM5() == castOther.getM5())
				&& (this.getM6() == castOther.getM6())
				&& (this.getM7() == castOther.getM7())
				&& (this.getM8() == castOther.getM8())
				&& (this.getM9() == castOther.getM9())
				&& (this.getM10() == castOther.getM10())
				&& (this.getM11() == castOther.getM11())
				&& (this.getM12() == castOther.getM12())
				&& ((this.getName() == castOther.getName()) || (this.getName() != null
						&& castOther.getName() != null && this.getName()
						.equals(castOther.getName())))
				&& ((this.getClientType() == castOther.getClientType()) || (this
						.getClientType() != null
						&& castOther.getClientType() != null && this
						.getClientType().equals(castOther.getClientType())))
				&& ((this.getDistribution() == castOther.getDistribution()) || (this
						.getDistribution() != null
						&& castOther.getDistribution() != null && this
						.getDistribution().equals(castOther.getDistribution())))
				&& ((this.getLob() == castOther.getLob()) || (this.getLob() != null
						&& castOther.getLob() != null && this.getLob().equals(
						castOther.getLob())))
				&& ((this.getHoldingCompany() == castOther.getHoldingCompany()) || (this
						.getHoldingCompany() != null
						&& castOther.getHoldingCompany() != null && this
						.getHoldingCompany().equals(
								castOther.getHoldingCompany())))
				&& ((this.getId() == castOther.getId()) || (this.getId() != null
						&& castOther.getId() != null && this.getId().equals(
						castOther.getId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getBxsTmId();
		result = 37 * result
				+ (getTime() == null ? 0 : this.getTime().hashCode());
		result = 37
				* result
				+ (getChannelCode() == null ? 0 : this.getChannelCode()
						.hashCode());
		result = 37
				* result
				+ (getInstitutionsCode() == null ? 0 : this
						.getInstitutionsCode().hashCode());
		result = 37
				* result
				+ (getInstitutionsName() == null ? 0 : this
						.getInstitutionsName().hashCode());
		result = 37
				* result
				+ (getProjectCode() == null ? 0 : this.getProjectCode()
						.hashCode());
		result = 37
				* result
				+ (getProjectName() == null ? 0 : this.getProjectName()
						.hashCode());
		result = 37
				* result
				+ (getProductCode() == null ? 0 : this.getProductCode()
						.hashCode());
		result = 37
				* result
				+ (getProductClassify() == null ? 0 : this.getProductClassify()
						.hashCode());
		result = 37 * result + this.getPayperiod();
		result = 37 * result + this.getPolicyperiod();
		result = 37 * result + (int) this.getM1();
		result = 37 * result + (int) this.getM2();
		result = 37 * result + (int) this.getM3();
		result = 37 * result + (int) this.getM4();
		result = 37 * result + (int) this.getM5();
		result = 37 * result + (int) this.getM6();
		result = 37 * result + (int) this.getM7();
		result = 37 * result + (int) this.getM8();
		result = 37 * result + (int) this.getM9();
		result = 37 * result + (int) this.getM10();
		result = 37 * result + (int) this.getM11();
		result = 37 * result + (int) this.getM12();
		result = 37 * result
				+ (getName() == null ? 0 : this.getName().hashCode());
		result = 37
				* result
				+ (getClientType() == null ? 0 : this.getClientType()
						.hashCode());
		result = 37
				* result
				+ (getDistribution() == null ? 0 : this.getDistribution()
						.hashCode());
		result = 37 * result
				+ (getLob() == null ? 0 : this.getLob().hashCode());
		result = 37
				* result
				+ (getHoldingCompany() == null ? 0 : this.getHoldingCompany()
						.hashCode());
		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		return result;
	}

}