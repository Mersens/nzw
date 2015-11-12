package com.nongzi.vo;

import java.sql.Timestamp;

/**
 * Admins entity. @author MyEclipse Persistence Tools
 */

public class Admins implements java.io.Serializable {

	// Fields

	private String adminid;
	private Role role;
	private String username;
	private String userpwd;
	private Double islock;
	private Timestamp adddata;
	private String realname;

	// Constructors

	/** default constructor */
	public Admins() {
	}

	/** minimal constructor */
	public Admins(Role role, String username, String userpwd, Double islock) {
		this.role = role;
		this.username = username;
		this.userpwd = userpwd;
		this.islock = islock;
	}

	/** full constructor */
	public Admins(Role role, String username, String userpwd, Double islock,
			Timestamp adddata, String realname) {
		this.role = role;
		this.username = username;
		this.userpwd = userpwd;
		this.islock = islock;
		this.adddata = adddata;
		this.realname = realname;
	}

	// Property accessors

	public String getAdminid() {
		return this.adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return this.userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public Double getIslock() {
		return this.islock;
	}

	public void setIslock(Double islock) {
		this.islock = islock;
	}

	public Timestamp getAdddata() {
		return this.adddata;
	}

	public void setAdddata(Timestamp adddata) {
		this.adddata = adddata;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}

}