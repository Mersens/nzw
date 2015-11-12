package com.nongzi.vo;

import java.sql.Timestamp;

import com.nongzi.dao.BaseVo;

/**
 * Dianpuleimu entity. @author MyEclipse Persistence Tools
 */

public class Dianpuleimu extends BaseVo implements java.io.Serializable {

	// Fields

	private String lianpuleimuid;
	private Leimu leimu;
	private Dianpu dianpu;
	private User user;
	private Timestamp addtime;

	// Constructors

	/** default constructor */
	public Dianpuleimu() {
	}

	/** full constructor */
	public Dianpuleimu(Leimu leimu, Dianpu dianpu, User user, Timestamp addtime) {
		this.leimu = leimu;
		this.dianpu = dianpu;
		this.user = user;
		this.addtime = addtime;
	}

	// Property accessors

	public String getLianpuleimuid() {
		return this.lianpuleimuid;
	}

	public void setLianpuleimuid(String lianpuleimuid) {
		this.lianpuleimuid = lianpuleimuid;
	}

	public Leimu getLeimu() {
		return this.leimu;
	}

	public void setLeimu(Leimu leimu) {
		this.leimu = leimu;
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

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

}