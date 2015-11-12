package com.nongzi.vo;

import com.nongzi.dao.BaseVo;

/**
 * Chanpinshuxing entity. @author MyEclipse Persistence Tools
 */

public class Chanpinshuxing extends BaseVo implements java.io.Serializable {

	// Fields

	private String chanpinshuxingid;
	private Shuxing shuxing;
	private Chanpin chanpin;
	private String shuxingval;

	// Constructors

	/** default constructor */
	public Chanpinshuxing() {
	}

	/** full constructor */
	public Chanpinshuxing(Shuxing shuxing, Chanpin chanpin, String shuxingval) {
		this.shuxing = shuxing;
		this.chanpin = chanpin;
		this.shuxingval = shuxingval;
	}

	// Property accessors

	public String getChanpinshuxingid() {
		return this.chanpinshuxingid;
	}

	public void setChanpinshuxingid(String chanpinshuxingid) {
		this.chanpinshuxingid = chanpinshuxingid;
	}

	public Shuxing getShuxing() {
		return this.shuxing;
	}

	public void setShuxing(Shuxing shuxing) {
		this.shuxing = shuxing;
	}

	public Chanpin getChanpin() {
		return this.chanpin;
	}

	public void setChanpin(Chanpin chanpin) {
		this.chanpin = chanpin;
	}

	public String getShuxingval() {
		return this.shuxingval;
	}

	public void setShuxingval(String shuxingval) {
		this.shuxingval = shuxingval;
	}

}