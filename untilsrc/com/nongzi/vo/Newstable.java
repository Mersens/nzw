package com.nongzi.vo;

import java.sql.Timestamp;

/**
 * Newstable entity. @author MyEclipse Persistence Tools
 */

public class Newstable implements java.io.Serializable {

	// Fields

	private String newsid;
	private User user;
	private Newtype newtype;
	private String title;
	private String center;
	private String newsimg;
	private Integer ishot;
	private String keywords;
	private String description;
	private String newssrc;
	private Timestamp addtime;
	private Integer htmlid;
	private Integer oncliknums;
	private String newstatic;
	private String url;

	// Constructors

	/** default constructor */
	public Newstable() {
	}

	/** minimal constructor */
	public Newstable(User user, Newtype newtype, String title, String center,
			Integer ishot, Timestamp addtime, Integer htmlid,
			Integer oncliknums, String newstatic) {
		this.user = user;
		this.newtype = newtype;
		this.title = title;
		this.center = center;
		this.ishot = ishot;
		this.addtime = addtime;
		this.htmlid = htmlid;
		this.oncliknums = oncliknums;
		this.newstatic = newstatic;
	}

	/** full constructor */
	public Newstable(User user, Newtype newtype, String title, String center,
			String newsimg, Integer ishot, String keywords, String description,
			String newssrc, Timestamp addtime, Integer htmlid,
			Integer oncliknums, String newstatic, String url) {
		this.user = user;
		this.newtype = newtype;
		this.title = title;
		this.center = center;
		this.newsimg = newsimg;
		this.ishot = ishot;
		this.keywords = keywords;
		this.description = description;
		this.newssrc = newssrc;
		this.addtime = addtime;
		this.htmlid = htmlid;
		this.oncliknums = oncliknums;
		this.newstatic = newstatic;
		this.url = url;
	}

	// Property accessors

	public String getNewsid() {
		return this.newsid;
	}

	public void setNewsid(String newsid) {
		this.newsid = newsid;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Newtype getNewtype() {
		return this.newtype;
	}

	public void setNewtype(Newtype newtype) {
		this.newtype = newtype;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCenter() {
		return this.center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public String getNewsimg() {
		return this.newsimg;
	}

	public void setNewsimg(String newsimg) {
		this.newsimg = newsimg;
	}

	public Integer getIshot() {
		return this.ishot;
	}

	public void setIshot(Integer ishot) {
		this.ishot = ishot;
	}

	public String getKeywords() {
		return this.keywords;
	}

	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNewssrc() {
		return this.newssrc;
	}

	public void setNewssrc(String newssrc) {
		this.newssrc = newssrc;
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

	public Integer getOncliknums() {
		return this.oncliknums;
	}

	public void setOncliknums(Integer oncliknums) {
		this.oncliknums = oncliknums;
	}

	public String getNewstatic() {
		return this.newstatic;
	}

	public void setNewstatic(String newstatic) {
		this.newstatic = newstatic;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}