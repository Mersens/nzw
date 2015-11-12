package com.nongzi.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Role entity. @author MyEclipse Persistence Tools
 */

public class Role implements java.io.Serializable {

	// Fields

	private String roleid;
	private String rolename;
	private String fatherid;
	private Timestamp addDate;
	private Double islock;
	private Set roleitems = new HashSet(0);
	private Set adminses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Role() {
	}

	/** minimal constructor */
	public Role(String rolename, String fatherid, Timestamp addDate,
			Double islock) {
		this.rolename = rolename;
		this.fatherid = fatherid;
		this.addDate = addDate;
		this.islock = islock;
	}

	/** full constructor */
	public Role(String rolename, String fatherid, Timestamp addDate,
			Double islock, Set roleitems, Set adminses) {
		this.rolename = rolename;
		this.fatherid = fatherid;
		this.addDate = addDate;
		this.islock = islock;
		this.roleitems = roleitems;
		this.adminses = adminses;
	}

	// Property accessors

	public String getRoleid() {
		return this.roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public String getFatherid() {
		return this.fatherid;
	}

	public void setFatherid(String fatherid) {
		this.fatherid = fatherid;
	}

	public Timestamp getAddDate() {
		return this.addDate;
	}

	public void setAddDate(Timestamp addDate) {
		this.addDate = addDate;
	}

	public Double getIslock() {
		return this.islock;
	}

	public void setIslock(Double islock) {
		this.islock = islock;
	}

	public Set getRoleitems() {
		return this.roleitems;
	}

	public void setRoleitems(Set roleitems) {
		this.roleitems = roleitems;
	}

	public Set getAdminses() {
		return this.adminses;
	}

	public void setAdminses(Set adminses) {
		this.adminses = adminses;
	}

}