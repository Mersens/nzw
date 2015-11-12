package com.nongzi.vo;

import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Zhanhui entity. @author MyEclipse Persistence Tools
 */

public class Zhanhui implements java.io.Serializable {

	// Fields

	private String zhanhuiid;
	private String title;
	private String image;
	private String address;
	private Date starttime;
	private Date endtime;
	private String lianxiren;
	private String lianxidianhua;
	private String description;
	private String center;
	private Integer ishot;
	private Integer status;
	private Timestamp addtime;
	private Integer htmlid;
	private Set zhanhuinewses = new HashSet(0);
	private Set zhanhuiorchanpins = new HashSet(0);
	private Set zhanhuiordianpus = new HashSet(0);

	// Constructors

	/** default constructor */
	public Zhanhui() {
	}

	/** minimal constructor */
	public Zhanhui(String title, String image, String address, Date starttime,
			Date endtime, String lianxiren, String lianxidianhua,
			String center, Integer ishot, Integer status, Timestamp addtime,
			Integer htmlid) {
		this.title = title;
		this.image = image;
		this.address = address;
		this.starttime = starttime;
		this.endtime = endtime;
		this.lianxiren = lianxiren;
		this.lianxidianhua = lianxidianhua;
		this.center = center;
		this.ishot = ishot;
		this.status = status;
		this.addtime = addtime;
		this.htmlid = htmlid;
	}

	/** full constructor */
	public Zhanhui(String title, String image, String address, Date starttime,
			Date endtime, String lianxiren, String lianxidianhua,
			String description, String center, Integer ishot, Integer status,
			Timestamp addtime, Integer htmlid, Set zhanhuinewses,
			Set zhanhuiorchanpins, Set zhanhuiordianpus) {
		this.title = title;
		this.image = image;
		this.address = address;
		this.starttime = starttime;
		this.endtime = endtime;
		this.lianxiren = lianxiren;
		this.lianxidianhua = lianxidianhua;
		this.description = description;
		this.center = center;
		this.ishot = ishot;
		this.status = status;
		this.addtime = addtime;
		this.htmlid = htmlid;
		this.zhanhuinewses = zhanhuinewses;
		this.zhanhuiorchanpins = zhanhuiorchanpins;
		this.zhanhuiordianpus = zhanhuiordianpus;
	}

	// Property accessors

	public String getZhanhuiid() {
		return this.zhanhuiid;
	}

	public void setZhanhuiid(String zhanhuiid) {
		this.zhanhuiid = zhanhuiid;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getStarttime() {
		return this.starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}

	public Date getEndtime() {
		return this.endtime;
	}

	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}

	public String getLianxiren() {
		return this.lianxiren;
	}

	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}

	public String getLianxidianhua() {
		return this.lianxidianhua;
	}

	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCenter() {
		return this.center;
	}

	public void setCenter(String center) {
		this.center = center;
	}

	public Integer getIshot() {
		return this.ishot;
	}

	public void setIshot(Integer ishot) {
		this.ishot = ishot;
	}

	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public Set getZhanhuinewses() {
		return this.zhanhuinewses;
	}

	public void setZhanhuinewses(Set zhanhuinewses) {
		this.zhanhuinewses = zhanhuinewses;
	}

	public Set getZhanhuiorchanpins() {
		return this.zhanhuiorchanpins;
	}

	public void setZhanhuiorchanpins(Set zhanhuiorchanpins) {
		this.zhanhuiorchanpins = zhanhuiorchanpins;
	}

	public Set getZhanhuiordianpus() {
		return this.zhanhuiordianpus;
	}

	public void setZhanhuiordianpus(Set zhanhuiordianpus) {
		this.zhanhuiordianpus = zhanhuiordianpus;
	}

}