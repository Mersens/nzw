package com.nongzi.vo;

import com.nongzi.dao.BaseVo;

/**
 * Chanpinorleimu entity. @author MyEclipse Persistence Tools
 */

public class Chanpinorleimu extends BaseVo implements java.io.Serializable {

	// Fields

	private String lcid;
	private Leimu leimu;
	private Chanpin chanpin;

	// Constructors

	/** default constructor */
	public Chanpinorleimu() {
	}

	/** full constructor */
	public Chanpinorleimu(Leimu leimu, Chanpin chanpin) {
		this.leimu = leimu;
		this.chanpin = chanpin;
	}

	// Property accessors

	public String getLcid() {
		return this.lcid;
	}

	public void setLcid(String lcid) {
		this.lcid = lcid;
	}

	public Leimu getLeimu() {
		return this.leimu;
	}

	public void setLeimu(Leimu leimu) {
		this.leimu = leimu;
	}

	public Chanpin getChanpin() {
		return this.chanpin;
	}

	public void setChanpin(Chanpin chanpin) {
		this.chanpin = chanpin;
	}

}