package com.nongzi.vo;

import java.sql.Timestamp;

/**
 * Dianpuguanli entity. @author MyEclipse Persistence Tools
 */

public class Dianpuguanli implements java.io.Serializable {

	// Fields

	private String guanliid;
	private Dianpu dianpu;
	private User user;
	private Integer islock;
	private Timestamp addtime;

	// Constructors

	/** default constructor */
	public Dianpuguanli() {
	}

	/** full constructor */
	public Dianpuguanli(Dianpu dianpu, User user, Integer islock,
			Timestamp addtime) {
		this.dianpu = dianpu;
		this.user = user;
		this.islock = islock;
		this.addtime = addtime;
	}

	// Property accessors

	public String getGuanliid() {
		return this.guanliid;
	}

	public void setGuanliid(String guanliid) {
		this.guanliid = guanliid;
	}

	public Dianpu getDianpu() {
		return this.dianpu;
	}

	public void setDianpu(Dianpu dianpu) {
		this.dianpu = dianpu;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getIslock() {
		return this.islock;
	}

	public void setIslock(Integer islock) {
		this.islock = islock;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

}