package com.nongzi.vo;

import java.sql.Timestamp;

/**
 * History entity. @author MyEclipse Persistence Tools
 */

public class History implements java.io.Serializable {

	// Fields

	private String lishiid;
	private Dianpu dianpu;
	private Chanpin chanpin;
	private User user;
	private Gongsi gongsi;
	private Integer lishistatic;
	private Timestamp addtime;

	// Constructors

	/** default constructor */
	public History() {
	}

	/** full constructor */
	public History(Dianpu dianpu, Chanpin chanpin, User user, Gongsi gongsi,
			Integer lishistatic, Timestamp addtime) {
		this.dianpu = dianpu;
		this.chanpin = chanpin;
		this.user = user;
		this.gongsi = gongsi;
		this.lishistatic = lishistatic;
		this.addtime = addtime;
	}

	// Property accessors

	public String getLishiid() {
		return this.lishiid;
	}

	public void setLishiid(String lishiid) {
		this.lishiid = lishiid;
	}

	public Dianpu getDianpu() {
		return this.dianpu;
	}

	public void setDianpu(Dianpu dianpu) {
		this.dianpu = dianpu;
	}

	public Chanpin getChanpin() {
		return this.chanpin;
	}

	public void setChanpin(Chanpin chanpin) {
		this.chanpin = chanpin;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Gongsi getGongsi() {
		return this.gongsi;
	}

	public void setGongsi(Gongsi gongsi) {
		this.gongsi = gongsi;
	}

	public Integer getLishistatic() {
		return this.lishistatic;
	}

	public void setLishistatic(Integer lishistatic) {
		this.lishistatic = lishistatic;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

}