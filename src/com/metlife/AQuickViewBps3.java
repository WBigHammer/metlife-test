package com.metlife;

/**
 * AQuickViewBps3 entity. @author MyEclipse Persistence Tools
 */

public class AQuickViewBps3 implements java.io.Serializable {

	// Fields

	private AQuickViewBps3Id id;

	// Constructors

	/** default constructor */
	public AQuickViewBps3() {
	}

	/** full constructor */
	public AQuickViewBps3(AQuickViewBps3Id id) {
		this.id = id;
	}

	// Property accessors

	public AQuickViewBps3Id getId() {
		return this.id;
	}

	public void setId(AQuickViewBps3Id id) {
		this.id = id;
	}

}