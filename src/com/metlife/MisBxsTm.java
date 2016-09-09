package com.metlife;

/**
 * MisBxsTm entity. @author MyEclipse Persistence Tools
 */

public class MisBxsTm implements java.io.Serializable {

	// Fields

	private MisBxsTmId id;

	// Constructors

	/** default constructor */
	public MisBxsTm() {
	}

	/** full constructor */
	public MisBxsTm(MisBxsTmId id) {
		this.id = id;
	}

	// Property accessors

	public MisBxsTmId getId() {
		return this.id;
	}

	public void setId(MisBxsTmId id) {
		this.id = id;
	}

}