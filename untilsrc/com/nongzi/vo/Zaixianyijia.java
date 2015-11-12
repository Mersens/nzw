package com.nongzi.vo;

import java.sql.Timestamp;

import com.nongzi.dao.BaseVo;

/**
 * Zaixianyijia entity. @author MyEclipse Persistence Tools
 */

public class Zaixianyijia extends BaseVo implements java.io.Serializable {

	// Fields

	private String xunjiaid;
	private Dianpu dianpu;
	private User user;
	private String mingcheng;
	private Integer shuliang;
	private String msgcenter;
	private String lianxiren;
	private String dianhua;
	private Timestamp addtime;
	private Integer xinxistatic;

	// Constructors

	/** default constructor */
	public Zaixianyijia() {
	}

	/** minimal constructor */
	public Zaixianyijia(Dianpu dianpu, String mingcheng, Integer shuliang,
			String msgcenter, String lianxiren, String dianhua,
			Timestamp addtime, Integer xinxistatic) {
		this.dianpu = dianpu;
		this.mingcheng = mingcheng;
		this.shuliang = shuliang;
		this.msgcenter = msgcenter;
		this.lianxiren = lianxiren;
		this.dianhua = dianhua;
		this.addtime = addtime;
		this.xinxistatic = xinxistatic;
	}

	/** full constructor */
	public Zaixianyijia(Dianpu dianpu, User user, String mingcheng,
			Integer shuliang, String msgcenter, String lianxiren,
			String dianhua, Timestamp addtime, Integer xinxistatic) {
		this.dianpu = dianpu;
		this.user = user;
		this.mingcheng = mingcheng;
		this.shuliang = shuliang;
		this.msgcenter = msgcenter;
		this.lianxiren = lianxiren;
		this.dianhua = dianhua;
		this.addtime = addtime;
		this.xinxistatic = xinxistatic;
	}

	// Property accessors

	public String getXunjiaid() {
		return this.xunjiaid;
	}

	public void setXunjiaid(String xunjiaid) {
		this.xunjiaid = xunjiaid;
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

	public String getMingcheng() {
		return this.mingcheng;
	}

	public void setMingcheng(String mingcheng) {
		this.mingcheng = mingcheng;
	}

	public Integer getShuliang() {
		return this.shuliang;
	}

	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}

	public String getMsgcenter() {
		return this.msgcenter;
	}

	public void setMsgcenter(String msgcenter) {
		this.msgcenter = msgcenter;
	}

	public String getLianxiren() {
		return this.lianxiren;
	}

	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}

	public String getDianhua() {
		return this.dianhua;
	}

	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Integer getXinxistatic() {
		return this.xinxistatic;
	}

	public void setXinxistatic(Integer xinxistatic) {
		this.xinxistatic = xinxistatic;
	}

}