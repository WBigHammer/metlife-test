package com.metlife;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * AbstractASalesActualToAfyp entity provides the base persistence definition of
 * the ASalesActualToAfyp entity. @author MyEclipse Persistence Tools
 */
@MappedSuperclass
public abstract class AbstractASalesActualToAfyp implements
		java.io.Serializable {

	// Fields

	private BigDecimal salesActualToAfypId;
	private String channel;
	private String project;
	private String branch;
	private String city;
	private String coveragecode;
	private String type1;
	private String type2;
	private String type3;
	private String productLine;
	private double salesYearTotal;
	private double salesYearM01;
	private double salesYearM02;
	private double salesYearM03;
	private double salesYearM04;
	private double salesYearM05;
	private double salesYearM06;
	private double salesYearM07;
	private double salesYearM08;
	private double salesYearM09;
	private double salesYearM10;
	private double salesYearM11;
	private double salesYearM12;

	// Constructors

	/** default constructor */
	public AbstractASalesActualToAfyp() {
	}

	/** full constructor */
	public AbstractASalesActualToAfyp(String channel, String project,
			String branch, String city, String coveragecode, String type1,
			String type2, String type3, String productLine,
			double salesYearTotal, double salesYearM01, double salesYearM02,
			double salesYearM03, double salesYearM04, double salesYearM05,
			double salesYearM06, double salesYearM07, double salesYearM08,
			double salesYearM09, double salesYearM10, double salesYearM11,
			double salesYearM12) {
		this.channel = channel;
		this.project = project;
		this.branch = branch;
		this.city = city;
		this.coveragecode = coveragecode;
		this.type1 = type1;
		this.type2 = type2;
		this.type3 = type3;
		this.productLine = productLine;
		this.salesYearTotal = salesYearTotal;
		this.salesYearM01 = salesYearM01;
		this.salesYearM02 = salesYearM02;
		this.salesYearM03 = salesYearM03;
		this.salesYearM04 = salesYearM04;
		this.salesYearM05 = salesYearM05;
		this.salesYearM06 = salesYearM06;
		this.salesYearM07 = salesYearM07;
		this.salesYearM08 = salesYearM08;
		this.salesYearM09 = salesYearM09;
		this.salesYearM10 = salesYearM10;
		this.salesYearM11 = salesYearM11;
		this.salesYearM12 = salesYearM12;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "SALES_ACTUAL_TO_AFYP_ID", unique = true, nullable = false, precision = 20, scale = 0)
	public BigDecimal getSalesActualToAfypId() {
		return this.salesActualToAfypId;
	}

	public void setSalesActualToAfypId(BigDecimal salesActualToAfypId) {
		this.salesActualToAfypId = salesActualToAfypId;
	}

	@Column(name = "CHANNEL", length = 50)
	public String getChannel() {
		return this.channel;
	}

	public void setChannel(String channel) {
		this.channel = channel;
	}

	@Column(name = "PROJECT", length = 50)
	public String getProject() {
		return this.project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	@Column(name = "BRANCH", length = 50)
	public String getBranch() {
		return this.branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Column(name = "CITY", length = 20)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "COVERAGECODE", length = 100)
	public String getCoveragecode() {
		return this.coveragecode;
	}

	public void setCoveragecode(String coveragecode) {
		this.coveragecode = coveragecode;
	}

	@Column(name = "TYPE1", length = 50)
	public String getType1() {
		return this.type1;
	}

	public void setType1(String type1) {
		this.type1 = type1;
	}

	@Column(name = "TYPE2", length = 50)
	public String getType2() {
		return this.type2;
	}

	public void setType2(String type2) {
		this.type2 = type2;
	}

	@Column(name = "TYPE3", length = 50)
	public String getType3() {
		return this.type3;
	}

	public void setType3(String type3) {
		this.type3 = type3;
	}

	@Column(name = "PRODUCT_LINE", length = 100)
	public String getProductLine() {
		return this.productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	@Column(name = "SALES_YEAR_TOTAL", precision = 26, scale = 6)
	public double getSalesYearTotal() {
		return this.salesYearTotal;
	}

	public void setSalesYearTotal(double salesYearTotal) {
		this.salesYearTotal = salesYearTotal;
	}

	@Column(name = "SALES_YEAR_M01", precision = 26, scale = 6)
	public double getSalesYearM01() {
		return this.salesYearM01;
	}

	public void setSalesYearM01(double salesYearM01) {
		this.salesYearM01 = salesYearM01;
	}

	@Column(name = "SALES_YEAR_M02", precision = 26, scale = 6)
	public double getSalesYearM02() {
		return this.salesYearM02;
	}

	public void setSalesYearM02(double salesYearM02) {
		this.salesYearM02 = salesYearM02;
	}

	@Column(name = "SALES_YEAR_M03", precision = 26, scale = 6)
	public double getSalesYearM03() {
		return this.salesYearM03;
	}

	public void setSalesYearM03(double salesYearM03) {
		this.salesYearM03 = salesYearM03;
	}

	@Column(name = "SALES_YEAR_M04", precision = 26, scale = 6)
	public double getSalesYearM04() {
		return this.salesYearM04;
	}

	public void setSalesYearM04(double salesYearM04) {
		this.salesYearM04 = salesYearM04;
	}

	@Column(name = "SALES_YEAR_M05", precision = 26, scale = 6)
	public double getSalesYearM05() {
		return this.salesYearM05;
	}

	public void setSalesYearM05(double salesYearM05) {
		this.salesYearM05 = salesYearM05;
	}

	@Column(name = "SALES_YEAR_M06", precision = 26, scale = 6)
	public double getSalesYearM06() {
		return this.salesYearM06;
	}

	public void setSalesYearM06(double salesYearM06) {
		this.salesYearM06 = salesYearM06;
	}

	@Column(name = "SALES_YEAR_M07", precision = 26, scale = 6)
	public double getSalesYearM07() {
		return this.salesYearM07;
	}

	public void setSalesYearM07(double salesYearM07) {
		this.salesYearM07 = salesYearM07;
	}

	@Column(name = "SALES_YEAR_M08", precision = 26, scale = 6)
	public double getSalesYearM08() {
		return this.salesYearM08;
	}

	public void setSalesYearM08(double salesYearM08) {
		this.salesYearM08 = salesYearM08;
	}

	@Column(name = "SALES_YEAR_M09", precision = 26, scale = 6)
	public double getSalesYearM09() {
		return this.salesYearM09;
	}

	public void setSalesYearM09(double salesYearM09) {
		this.salesYearM09 = salesYearM09;
	}

	@Column(name = "SALES_YEAR_M10", precision = 26, scale = 6)
	public double getSalesYearM10() {
		return this.salesYearM10;
	}

	public void setSalesYearM10(double salesYearM10) {
		this.salesYearM10 = salesYearM10;
	}

	@Column(name = "SALES_YEAR_M11", precision = 26, scale = 6)
	public double getSalesYearM11() {
		return this.salesYearM11;
	}

	public void setSalesYearM11(double salesYearM11) {
		this.salesYearM11 = salesYearM11;
	}

	@Column(name = "SALES_YEAR_M12", precision = 26, scale = 6)
	public double getSalesYearM12() {
		return this.salesYearM12;
	}

	public void setSalesYearM12(double salesYearM12) {
		this.salesYearM12 = salesYearM12;
	}

}