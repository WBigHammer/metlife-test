package com.metlife.user.sql;

import java.util.Date;

/**
 * SysUser entity. @author MyEclipse Persistence Tools
 */

public class SysUser implements java.io.Serializable {

	// Fields

	private String userId;
	private String userName;
	private String userCname;
	private String email;
	private String mobilePhone;
	private String password;
	private String salt;
	private Date createDate;
	private String status;
	private boolean deleted;
	private boolean admin;

	// Constructors

	/** default constructor */
	public SysUser() {
	}

	/** minimal constructor */
	public SysUser(Date createDate) {
		this.createDate = createDate;
	}

	/** full constructor */
	public SysUser(String userName, String userCname, String email,
			String mobilePhone, String password, String salt, Date createDate,
			String status, boolean deleted, boolean admin) {
		this.userName = userName;
		this.userCname = userCname;
		this.email = email;
		this.mobilePhone = mobilePhone;
		this.password = password;
		this.salt = salt;
		this.createDate = createDate;
		this.status = status;
		this.deleted = deleted;
		this.admin = admin;
	}

	// Property accessors

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserCname() {
		return this.userCname;
	}

	public void setUserCname(String userCname) {
		this.userCname = userCname;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobilePhone() {
		return this.mobilePhone;
	}

	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return this.salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean getDeleted() {
		return this.deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public boolean getAdmin() {
		return this.admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

}