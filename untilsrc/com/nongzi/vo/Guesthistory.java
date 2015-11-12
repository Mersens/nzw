package com.nongzi.vo;

import java.sql.Timestamp;

/**
 * Guesthistory entity. @author MyEclipse Persistence Tools
 */

public class Guesthistory implements java.io.Serializable {

	// Fields

	private String guestid;
	private Dianpu dianpu;
	private Chanpin chanpin;
	private User user;
	private Gongsi gongsi;
	private Integer xinxistatic;
	private Timestamp addtime;

	// Constructors

	/** default constructor */
	public Guesthistory() {
	}

	/** minimal constructor */
	public Guesthistory(Chanpin chanpin, User user, Integer xinxistatic,
			Timestamp addtime) {
		this.chanpin = chanpin;
		this.user = user;
		this.xinxistatic = xinxistatic;
		this.addtime = addtime;
	}

	/** full constructor */
	public Guesthistory(Dianpu dianpu, Chanpin chanpin, User user,
			Gongsi gongsi, Integer xinxistatic, Timestamp addtime) {
		this.dianpu = dianpu;
		this.chanpin = chanpin;
		this.user = user;
		this.gongsi = gongsi;
		this.xinxistatic = xinxistatic;
		this.addtime = addtime;
	}

	// Property accessors

	public String getGuestid() {
		return this.guestid;
	}

	public void setGuestid(String guestid) {
		this.guestid = guestid;
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

	public Integer getXinxistatic() {
		return this.xinxistatic;
	}

	public void setXinxistatic(Integer xinxistatic) {
		this.xinxistatic = xinxistatic;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

}