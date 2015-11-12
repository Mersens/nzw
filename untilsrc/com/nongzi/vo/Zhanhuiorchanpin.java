package com.nongzi.vo;

import java.sql.Timestamp;

/**
 * Zhanhuiorchanpin entity. @author MyEclipse Persistence Tools
 */

public class Zhanhuiorchanpin implements java.io.Serializable {

	// Fields

	private String zcid;
	private Chanpin chanpin;
	private Zhanhui zhanhui;
	private Timestamp addtime;

	// Constructors

	/** default constructor */
	public Zhanhuiorchanpin() {
	}

	/** full constructor */
	public Zhanhuiorchanpin(Chanpin chanpin, Zhanhui zhanhui, Timestamp addtime) {
		this.chanpin = chanpin;
		this.zhanhui = zhanhui;
		this.addtime = addtime;
	}

	// Property accessors

	public String getZcid() {
		return this.zcid;
	}

	public void setZcid(String zcid) {
		this.zcid = zcid;
	}

	public Chanpin getChanpin() {
		return this.chanpin;
	}

	public void setChanpin(Chanpin chanpin) {
		this.chanpin = chanpin;
	}

	public Zhanhui getZhanhui() {
		return this.zhanhui;
	}

	public void setZhanhui(Zhanhui zhanhui) {
		this.zhanhui = zhanhui;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

}