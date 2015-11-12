package com.nongzi.vo;

import java.sql.Timestamp;

/**
 * NewstableZhuanti entity. @author MyEclipse Persistence Tools
 */

public class NewstableZhuanti implements java.io.Serializable {

	// Fields

	private String zhuantiid;
	private String zhuantiname;
	private String center;
	private String imgsrc;
	private String keywords;
	private Timestamp addtime;
	private Integer ishot;
	private Integer onclicknum;
	private Integer status;
	private Integer htmlid;

	// Constructors

	/** default constructor */
	public NewstableZhuanti() {
	}

	/** minimal constructor */
	public NewstableZhuanti(String zhuantiname, Timestamp addtime,
			Integer ishot, Integer onclicknum, Integer status, Integer htmlid) {
		this.zhuantiname = zhuantiname;
		this.addtime = addtime;
		this.ishot = ishot;
		this.onclicknum = onclicknum;
		this.status = status;
		this.htmlid = htmlid;
	}

	/** full constructor */
	public NewstableZhuanti(String zhuantiname, String center, String imgsrc,
			String keywords, Timestamp addtime, Integer ishot,
			Integer onclicknum, Integer status, Integer htmlid) {
		this.zhuantiname = zhuantiname;
		this.center = center;
		this.imgsrc = imgsrc;
		this.keywords = keywords;
		this.addtime = addtime;
		this.ishot = ishot;
		this.onclicknum = onclicknum;
		this.status = status;
		this.htmlid = htmlid;
	}

	// Property accessors

	public String getZhuantiid() {
		return this.zhuantiid;
	}

	public void setZhuantiid(String zhuantiid) {
		this.zhuantiid = zhuantiid;
	}

	public String getZhuantiname() {
		return this.zhuantiname;
	}

	public void setZhuantiname(String zhuantiname) {
		this.zhuantiname = zhuantiname;
	}

	public String getCenter() {
		return this.center;
	}

	public void setCenter(String center) {
		this.center = center;
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

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Integer getIshot() {
		return this.ishot;
	}

	public void setIshot(Integer ishot) {
		this.ishot = ishot;
	}

	public Integer getOnclicknum() {
		return this.onclicknum;
	}

	public void setOnclicknum(Integer onclicknum) {
		this.onclicknum = onclicknum;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getHtmlid() {
		return this.htmlid;
	}

	public void setHtmlid(Integer htmlid) {
		this.htmlid = htmlid;
	}

}