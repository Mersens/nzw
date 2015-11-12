package com.nongzi.vo;

import java.sql.Timestamp;

import com.nongzi.dao.BaseVo;

/**
 * Usersession entity. @author MyEclipse Persistence Tools
 */

public class Usersession extends BaseVo implements java.io.Serializable {

	// Fields

	private String usersessionid;
	private User user;
	private String ip;
	private String macadd;
	private Timestamp addtime;

	// Constructors

	/** default constructor */
	public Usersession() {
	}

	/** minimal constructor */
	public Usersession(User user, Timestamp addtime) {
		this.user = user;
		this.addtime = addtime;
	}

	/** full constructor */
	public Usersession(User user, String ip, String macadd, Timestamp addtime) {
		this.user = user;
		this.ip = ip;
		this.macadd = macadd;
		this.addtime = addtime;
	}

	// Property accessors

	public String getUsersessionid() {
		return this.usersessionid;
	}

	public void setUsersessionid(String usersessionid) {
		this.usersessionid = usersessionid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getIp() {
		return this.ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMacadd() {
		return this.macadd;
	}

	public void setMacadd(String macadd) {
		this.macadd = macadd;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

}