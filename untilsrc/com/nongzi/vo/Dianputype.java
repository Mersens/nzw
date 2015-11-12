package com.nongzi.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Dianputype entity. @author MyEclipse Persistence Tools
 */

public class Dianputype implements java.io.Serializable {

	// Fields

	private String typeid;
	private String typename;
	private Integer paixuval;
	private Timestamp addtime;
	private Set dianpus = new HashSet(0);

	// Constructors

	/** default constructor */
	public Dianputype() {
	}

	/** minimal constructor */
	public Dianputype(String typename, Integer paixuval, Timestamp addtime) {
		this.typename = typename;
		this.paixuval = paixuval;
		this.addtime = addtime;
	}

	/** full constructor */
	public Dianputype(String typename, Integer paixuval, Timestamp addtime,
			Set dianpus) {
		this.typename = typename;
		this.paixuval = paixuval;
		this.addtime = addtime;
		this.dianpus = dianpus;
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

	public Integer getPaixuval() {
		return this.paixuval;
	}

	public void setPaixuval(Integer paixuval) {
		this.paixuval = paixuval;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Set getDianpus() {
		return this.dianpus;
	}

	public void setDianpus(Set dianpus) {
		this.dianpus = dianpus;
	}

}