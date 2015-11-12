package com.nongzi.vo;

import java.sql.Timestamp;

import com.nongzi.dao.BaseVo;

/**
 * Leimuoryongtu entity. @author MyEclipse Persistence Tools
 */

public class Leimuoryongtu extends BaseVo  implements java.io.Serializable {

	// Fields

	private String lyid;
	private Leimu leimu;
	private Chanpinyongtu chanpinyongtu;
	private Integer orderval;
	private Timestamp addtime;

	// Constructors

	/** default constructor */
	public Leimuoryongtu() {
	}

	/** full constructor */
	public Leimuoryongtu(Leimu leimu, Chanpinyongtu chanpinyongtu,
			Integer orderval, Timestamp addtime) {
		this.leimu = leimu;
		this.chanpinyongtu = chanpinyongtu;
		this.orderval = orderval;
		this.addtime = addtime;
	}

	// Property accessors

	public String getLyid() {
		return this.lyid;
	}

	public void setLyid(String lyid) {
		this.lyid = lyid;
	}

	public Leimu getLeimu() {
		return this.leimu;
	}

	public void setLeimu(Leimu leimu) {
		this.leimu = leimu;
	}

	public Chanpinyongtu getChanpinyongtu() {
		return this.chanpinyongtu;
	}

	public void setChanpinyongtu(Chanpinyongtu chanpinyongtu) {
		this.chanpinyongtu = chanpinyongtu;
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