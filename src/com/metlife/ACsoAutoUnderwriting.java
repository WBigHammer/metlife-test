package com.metlife;

import java.math.BigDecimal;

/**
 * ACsoAutoUnderwriting entity. @author MyEclipse Persistence Tools
 */

public class ACsoAutoUnderwriting implements java.io.Serializable {

	// Fields

	private BigDecimal autoUndewritinngId;
	private Integer time;
	private String productLine;
	private Integer sumNumber;
	private Integer autoNumber;

	// Constructors

	/** default constructor */
	public ACsoAutoUnderwriting() {
	}

	/** full constructor */
	public ACsoAutoUnderwriting(Integer time, String productLine,
			Integer sumNumber, Integer autoNumber) {
		this.time = time;
		this.productLine = productLine;
		this.sumNumber = sumNumber;
		this.autoNumber = autoNumber;
	}

	// Property accessors

	public BigDecimal getAutoUndewritinngId() {
		return this.autoUndewritinngId;
	}

	public void setAutoUndewritinngId(BigDecimal autoUndewritinngId) {
		this.autoUndewritinngId = autoUndewritinngId;
	}

	public Integer getTime() {
		return this.time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public String getProductLine() {
		return this.productLine;
	}

	public void setProductLine(String productLine) {
		this.productLine = productLine;
	}

	public Integer getSumNumber() {
		return this.sumNumber;
	}

	public void setSumNumber(Integer sumNumber) {
		this.sumNumber = sumNumber;
	}

	public Integer getAutoNumber() {
		return this.autoNumber;
	}

	public void setAutoNumber(Integer autoNumber) {
		this.autoNumber = autoNumber;
	}

}