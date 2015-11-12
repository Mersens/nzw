package com.nongzi.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Zhanhuitype entity. @author MyEclipse Persistence Tools
 */

public class Zhanhuitype implements java.io.Serializable {

	// Fields

	private String typeid;
	private String typename;
	private Integer orderby;
	private Set zhanhuinewses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Zhanhuitype() {
	}

	/** full constructor */
	public Zhanhuitype(String typename, Integer orderby, Set zhanhuinewses) {
		this.typename = typename;
		this.orderby = orderby;
		this.zhanhuinewses = zhanhuinewses;
	}

	// Property accessors

	public String getTypeid() {
		return this.typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public String getTypename() {
		return this.typename;
	}

	public void setTypename(String typename) {
		this.typename = typename;
	}

	public Integer getOrderby() {
		return this.orderby;
	}

	public void setOrderby(Integer orderby) {
		this.orderby = orderby;
	}

	public Set getZhanhuinewses() {
		return this.zhanhuinewses;
	}

	public void setZhanhuinewses(Set zhanhuinewses) {
		this.zhanhuinewses = zhanhuinewses;
	}

}