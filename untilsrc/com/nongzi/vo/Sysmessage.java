package com.nongzi.vo;

import java.sql.Timestamp;

import com.nongzi.dao.BaseVo;

/**
 * Sysmessage entity. @author MyEclipse Persistence Tools
 */

public class Sysmessage extends BaseVo implements java.io.Serializable {

	// Fields

	private String messageid;
	private User userByFormuserid;
	private User userByUserid;
	private Gongsi gongsi;
	private String msgcenter;
	private Timestamp addtime;
	private Integer typeid;
	private Integer msgstatic;

	// Constructors

	/** default constructor */
	public Sysmessage() {
	}

	/** minimal constructor */
	public Sysmessage(User userByUserid, String msgcenter, Timestamp addtime,
			Integer typeid, Integer msgstatic) {
		this.userByUserid = userByUserid;
		this.msgcenter = msgcenter;
		this.addtime = addtime;
		this.typeid = typeid;
		this.msgstatic = msgstatic;
	}

	/** full constructor */
	public Sysmessage(User userByFormuserid, User userByUserid, Gongsi gongsi,
			String msgcenter, Timestamp addtime, Integer typeid,
			Integer msgstatic) {
		this.userByFormuserid = userByFormuserid;
		this.userByUserid = userByUserid;
		this.gongsi = gongsi;
		this.msgcenter = msgcenter;
		this.addtime = addtime;
		this.typeid = typeid;
		this.msgstatic = msgstatic;
	}

	// Property accessors

	public String getMessageid() {
		return this.messageid;
	}

	public void setMessageid(String messageid) {
		this.messageid = messageid;
	}

	public User getUserByFormuserid() {
		return this.userByFormuserid;
	}

	public void setUserByFormuserid(User userByFormuserid) {
		this.userByFormuserid = userByFormuserid;
	}

	public User getUserByUserid() {
		return this.userByUserid;
	}

	public void setUserByUserid(User userByUserid) {
		this.userByUserid = userByUserid;
	}

	public Gongsi getGongsi() {
		return this.gongsi;
	}

	public void setGongsi(Gongsi gongsi) {
		this.gongsi = gongsi;
	}

	public String getMsgcenter() {
		return this.msgcenter;
	}

	public void setMsgcenter(String msgcenter) {
		this.msgcenter = msgcenter;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Integer getTypeid() {
		return this.typeid;
	}

	public void setTypeid(Integer typeid) {
		this.typeid = typeid;
	}

	public Integer getMsgstatic() {
		return this.msgstatic;
	}

	public void setMsgstatic(Integer msgstatic) {
		this.msgstatic = msgstatic;
	}

}