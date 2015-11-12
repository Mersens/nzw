package com.nongzi.vo;

import java.sql.Timestamp;

/**
 * Leimuorpinpai entity. @author MyEclipse Persistence Tools
 */

public class Leimuorpinpai implements java.io.Serializable {

	// Fields

	private String lpid;
	private Leimu leimu;
	private Chanpinpinpai chanpinpinpai;
	private Integer orderval;
	private Timestamp addtime;

	// Constructors

	/** default constructor */
	public Leimuorpinpai() {
	}

	/** full constructor */
	public Leimuorpinpai(Leimu leimu, Chanpinpinpai chanpinpinpai,
			Integer orderval, Timestamp addtime) {
		this.leimu = leimu;
		this.chanpinpinpai = chanpinpinpai;
		this.orderval = orderval;
		this.addtime = addtime;
	}

	// Property accessors

	public String getLpid() {
		return this.lpid;
	}

	public void setLpid(String lpid) {
		this.lpid = lpid;
	}

	public Leimu getLeimu() {
		return this.leimu;
	}

	public void setLeimu(Leimu leimu) {
		this.leimu = leimu;
	}

	public Chanpinpinpai getChanpinpinpai() {
		return this.chanpinpinpai;
	}

	public void setChanpinpinpai(Chanpinpinpai chanpinpinpai) {
		this.chanpinpinpai = chanpinpinpai;
	}

	public Integer getOrderval() {
		return this.orderval;
	}

	public void setOrderval(Integer orderval) {
		this.orderval = orderval;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

}