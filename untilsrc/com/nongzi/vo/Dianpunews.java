package com.nongzi.vo;

import java.sql.Timestamp;

import com.nongzi.dao.BaseVo;

/**
 * Dianpunews entity. @author MyEclipse Persistence Tools
 */

public class Dianpunews extends BaseVo implements java.io.Serializable {

	// Fields

	private String newsid;
	private Dianpu dianpu;
	private User user;
	private String title;
	private String imgsrc;
	private String keywords;
	private String miaoshu;
	private String center;
	private Integer xinwenstatic;
	private Timestamp addtime;
	private Integer htmlid;

	// Constructors

	/** default constructor */
	public Dianpunews() {
	}

	/** minimal constructor */
	public Dianpunews(Dianpu dianpu, User user, String title, String center,
			Integer xinwenstatic, Timestamp addtime, Integer htmlid) {
		this.dianpu = dianpu;
		this.user = user;
		this.title = title;
		this.center = center;
		this.xinwenstatic = xinwenstatic;
		this.addtime = addtime;
		this.htmlid = htmlid;
	}

	/** full constructor */
	public Dianpunews(Dianpu dianpu, User user, String title, String imgsrc,
			String keywords, String miaoshu, String center,
			Integer xinwenstatic, Timestamp addtime, Integer htmlid) {
		this.dianpu = dianpu;
		this.user = user;
		this.title = title;
		this.imgsrc = imgsrc;
		this.keywords = keywords;
		this.miaoshu = miaoshu;
		this.center = center;
		this.xinwenstatic = xinwenstatic;
		this.addtime = addtime;
		this.htmlid = htmlid;
	}

	// Property accessors

	public String getNewsid() {
		return this.newsid;
	}

	public void setNewsid(String newsid) {
		this.newsid = newsid;
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

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImgsrc() {
		return this.imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getMiaoshu() {
		return this.miaoshu;
	}

	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}

	public String getCenter() {
		return this.center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public Integer getXinwenstatic() {
		return this.xinwenstatic;
	}

	public void setXinwenstatic(Integer xinwenstatic) {
		this.xinwenstatic = xinwenstatic;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Integer getHtmlid() {
		return this.htmlid;
	}

	public void setHtmlid(Integer htmlid) {
		this.htmlid = htmlid;
	}

}