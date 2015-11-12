package com.nongzi.vo;

import java.sql.Timestamp;

import com.nongzi.dao.BaseVo;

/**
 * Chanpinimg entity. @author MyEclipse Persistence Tools
 */

public class Chanpinimg extends BaseVo implements java.io.Serializable {

	// Fields

	private String tupianid;
	private Chanpin chanpin;
	private String imgsrc;
	private String size64;
	private String size310;
	private String typeid;
	private Integer imgtype;
	private Timestamp addtime;
	private Integer orderval;

	// Constructors

	/** default constructor */
	public Chanpinimg() {
	}

	/** minimal constructor */
	public Chanpinimg(Chanpin chanpin, String imgsrc, String typeid,
			Integer imgtype, Timestamp addtime, Integer orderval) {
		this.chanpin = chanpin;
		this.imgsrc = imgsrc;
		this.typeid = typeid;
		this.imgtype = imgtype;
		this.addtime = addtime;
		this.orderval = orderval;
	}

	/** full constructor */
	public Chanpinimg(Chanpin chanpin, String imgsrc, String size64,
			String size310, String typeid, Integer imgtype, Timestamp addtime,
			Integer orderval) {
		this.chanpin = chanpin;
		this.imgsrc = imgsrc;
		this.size64 = size64;
		this.size310 = size310;
		this.typeid = typeid;
		this.imgtype = imgtype;
		this.addtime = addtime;
		this.orderval = orderval;
	}

	// Property accessors

	public String getTupianid() {
		return this.tupianid;
	}

	public void setTupianid(String tupianid) {
		this.tupianid = tupianid;
	}

	public Chanpin getChanpin() {
		return this.chanpin;
	}

	public void setChanpin(Chanpin chanpin) {
		this.chanpin = chanpin;
	}

	public String getImgsrc() {
		return this.imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public String getSize64() {
		return this.size64;
	}

	public void setSize64(String size64) {
		this.size64 = size64;
	}

	public String getSize310() {
		return this.size310;
	}

	public void setSize310(String size310) {
		this.size310 = size310;
	}

	public String getTypeid() {
		return this.typeid;
	}

	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}

	public Integer getImgtype() {
		return this.imgtype;
	}

	public void setImgtype(Integer imgtype) {
		this.imgtype = imgtype;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Integer getOrderval() {
		return this.orderval;
	}

	public void setOrderval(Integer orderval) {
		this.orderval = orderval;
	}

}