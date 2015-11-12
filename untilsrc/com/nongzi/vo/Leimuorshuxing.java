package com.nongzi.vo;

import java.sql.Timestamp;

import com.nongzi.dao.BaseVo;

/**
 * Leimuorshuxing entity. @author MyEclipse Persistence Tools
 */

public class Leimuorshuxing extends BaseVo implements java.io.Serializable {

	// Fields

	private String lsid;
	private Shuxing shuxing;
	private Leimu leimu;
	private Integer orderval;
	private Timestamp addtime;

	// Constructors

	/** default constructor */
	public Leimuorshuxing() {
	}

	/** full constructor */
	public Leimuorshuxing(Shuxing shuxing, Leimu leimu, Integer orderval,
			Timestamp addtime) {
		this.shuxing = shuxing;
		this.leimu = leimu;
		this.orderval = orderval;
		this.addtime = addtime;
	}

	// Property accessors

	public String getLsid() {
		return this.lsid;
	}

	public void setLsid(String lsid) {
		this.lsid = lsid;
	}

	public Shuxing getShuxing() {
		return this.shuxing;
	}

	public void setShuxing(Shuxing shuxing) {
		this.shuxing = shuxing;
	}

	public Leimu getLeimu() {
		return this.leimu;
	}

	public void setLeimu(Leimu leimu) {
		this.leimu = leimu;
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