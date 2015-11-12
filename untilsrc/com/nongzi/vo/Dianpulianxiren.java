package com.nongzi.vo;

import java.sql.Timestamp;

import com.nongzi.dao.BaseVo;

/**
 * Dianpulianxiren entity. @author MyEclipse Persistence Tools
 */

public class Dianpulianxiren extends BaseVo implements java.io.Serializable {

	// Fields

	private String lianxirenid;
	private Dianpu dianpu;
	private User user;
	private String xingming;
	private String dianhua;
	private String qq;
	private Integer xinxiststic;
	private Timestamp addtime;

	// Constructors

	/** default constructor */
	public Dianpulianxiren() {
	}

	/** full constructor */
	public Dianpulianxiren(Dianpu dianpu, User user, String xingming,
			String dianhua, String qq, Integer xinxiststic, Timestamp addtime) {
		this.dianpu = dianpu;
		this.user = user;
		this.xingming = xingming;
		this.dianhua = dianhua;
		this.qq = qq;
		this.xinxiststic = xinxiststic;
		this.addtime = addtime;
	}

	// Property accessors

	public String getLianxirenid() {
		return this.lianxirenid;
	}

	public void setLianxirenid(String lianxirenid) {
		this.lianxirenid = lianxirenid;
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

	public String getXingming() {
		return this.xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}

	public String getDianhua() {
		return this.dianhua;
	}

	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public Integer getXinxiststic() {
		return this.xinxiststic;
	}

	public void setXinxiststic(Integer xinxiststic) {
		this.xinxiststic = xinxiststic;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

}