package com.nongzi.vo;

import java.sql.Timestamp;

/**
 * Zhanhuiordianpu entity. @author MyEclipse Persistence Tools
 */

public class Zhanhuiordianpu implements java.io.Serializable {

	// Fields

	private String zdid;
	private Dianpu dianpu;
	private Zhanhui zhanhui;
	private Timestamp addtime;

	// Constructors

	/** default constructor */
	public Zhanhuiordianpu() {
	}

	/** full constructor */
	public Zhanhuiordianpu(Dianpu dianpu, Zhanhui zhanhui, Timestamp addtime) {
		this.dianpu = dianpu;
		this.zhanhui = zhanhui;
		this.addtime = addtime;
	}

	// Property accessors

	public String getZdid() {
		return this.zdid;
	}

	public void setZdid(String zdid) {
		this.zdid = zdid;
	}

	public Dianpu getDianpu() {
		return this.dianpu;
	}

	public void setDianpu(Dianpu dianpu) {
		this.dianpu = dianpu;
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