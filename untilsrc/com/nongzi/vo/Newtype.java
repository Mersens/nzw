package com.nongzi.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Newtype entity. @author MyEclipse Persistence Tools
 */

public class Newtype implements java.io.Serializable {

	// Fields

	private String newtypeid;
	private String typename;
	private String typefid;
	private String type;
	private Integer orderby;
	private Set newstables = new HashSet(0);

	// Constructors

	/** default constructor */
	public Newtype() {
	}

	/** minimal constructor */
	public Newtype(String typename, String typefid, String type) {
		this.typename = typename;
		this.typefid = typefid;
		this.type = type;
	}

	/** full constructor */
	public Newtype(String typename, String typefid, String type,
			Integer orderby, Set newstables) {
		this.typename = typename;
		this.typefid = typefid;
		this.type = type;
		this.orderby = orderby;
		this.newstables = newstables;
	}

	// Property accessors

	public String getNewtypeid() {
		return this.newtypeid;
	}

	public void setNewtypeid(String newtypeid) {
		this.newtypeid = newtypeid;
	}

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public String getTypefid() {
		return this.typefid;
	}

	public void setTypefid(String typefid) {
		this.typefid = typefid;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getOrderby() {
		return this.orderby;
	}

	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}

	public Set getNewstables() {
		return this.newstables;
	}

	public void setNewstables(Set newstables) {
		this.newstables = newstables;
	}

}