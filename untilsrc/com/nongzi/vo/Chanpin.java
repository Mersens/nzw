package com.nongzi.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.nongzi.dao.BaseVo;

/**
 * Chanpin entity. @author MyEclipse Persistence Tools
 */

public class Chanpin extends BaseVo implements java.io.Serializable {

	// Fields

	private String chanpinid;
	private Dianpu dianpu;
	private Chanpinpinpai chanpinpinpai;
	private User user;
	private Gongsi gongsi;
	private String offerDetail;
	private String title;
	private String unit;
	private Double jiage;
	private String keyword;
	private String miaoshu;
	private Integer xinxiststic;
	private Timestamp addtime;
	private Integer htmlid;
	private Set chanpinorchengfens = new HashSet(0);
	private Set chanpinimgs = new HashSet(0);
	private Set histories = new HashSet(0);
	private Set guesthistories = new HashSet(0);
	private Set zhanhuiorchanpins = new HashSet(0);
	private Set chanpinoryongtus = new HashSet(0);
	private Set chanpinorleimus = new HashSet(0);
	private Set chanpinshuxings = new HashSet(0);

	// Constructors

	/** default constructor */
	public Chanpin() {
	}

	/** minimal constructor */
	public Chanpin(Dianpu dianpu, Chanpinpinpai chanpinpinpai, User user,
			Gongsi gongsi, String offerDetail, String title, String unit,
			Double jiage, Integer xinxiststic, Timestamp addtime, Integer htmlid) {
		this.dianpu = dianpu;
		this.chanpinpinpai = chanpinpinpai;
		this.user = user;
		this.gongsi = gongsi;
		this.offerDetail = offerDetail;
		this.title = title;
		this.unit = unit;
		this.jiage = jiage;
		this.xinxiststic = xinxiststic;
		this.addtime = addtime;
		this.htmlid = htmlid;
	}

	/** full constructor */
	public Chanpin(Dianpu dianpu, Chanpinpinpai chanpinpinpai, User user,
			Gongsi gongsi, String offerDetail, String title, String unit,
			Double jiage, String keyword, String miaoshu, Integer xinxiststic,
			Timestamp addtime, Integer htmlid, Set chanpinorchengfens,
			Set chanpinimgs, Set histories, Set guesthistories,
			Set zhanhuiorchanpins, Set chanpinoryongtus, Set chanpinorleimus,
			Set chanpinshuxings) {
		this.dianpu = dianpu;
		this.chanpinpinpai = chanpinpinpai;
		this.user = user;
		this.gongsi = gongsi;
		this.offerDetail = offerDetail;
		this.title = title;
		this.unit = unit;
		this.jiage = jiage;
		this.keyword = keyword;
		this.miaoshu = miaoshu;
		this.xinxiststic = xinxiststic;
		this.addtime = addtime;
		this.htmlid = htmlid;
		this.chanpinorchengfens = chanpinorchengfens;
		this.chanpinimgs = chanpinimgs;
		this.histories = histories;
		this.guesthistories = guesthistories;
		this.zhanhuiorchanpins = zhanhuiorchanpins;
		this.chanpinoryongtus = chanpinoryongtus;
		this.chanpinorleimus = chanpinorleimus;
		this.chanpinshuxings = chanpinshuxings;
	}

	// Property accessors

	public String getChanpinid() {
		return this.chanpinid;
	}

	public void setChanpinid(String chanpinid) {
		this.chanpinid = chanpinid;
	}

	public Dianpu getDianpu() {
		return this.dianpu;
	}

	public void setDianpu(Dianpu dianpu) {
		this.dianpu = dianpu;
	}

	public Chanpinpinpai getChanpinpinpai() {
		return this.chanpinpinpai;
	}

	public void setChanpinpinpai(Chanpinpinpai chanpinpinpai) {
		this.chanpinpinpai = chanpinpinpai;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Gongsi getGongsi() {
		return this.gongsi;
	}

	public void setGongsi(Gongsi gongsi) {
		this.gongsi = gongsi;
	}

	public String getOfferDetail() {
		return this.offerDetail;
	}

	public void setOfferDetail(String offerDetail) {
		this.offerDetail = offerDetail;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Double getJiage() {
		return this.jiage;
	}

	public void setJiage(Double jiage) {
		this.jiage = jiage;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getMiaoshu() {
		return this.miaoshu;
	}

	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
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

	public Integer getHtmlid() {
		return this.htmlid;
	}

	public void setHtmlid(Integer htmlid) {
		this.htmlid = htmlid;
	}

	public Set getChanpinorchengfens() {
		return this.chanpinorchengfens;
	}

	public void setChanpinorchengfens(Set chanpinorchengfens) {
		this.chanpinorchengfens = chanpinorchengfens;
	}

	public Set getChanpinimgs() {
		return this.chanpinimgs;
	}

	public void setChanpinimgs(Set chanpinimgs) {
		this.chanpinimgs = chanpinimgs;
	}

	public Set getHistories() {
		return this.histories;
	}

	public void setHistories(Set histories) {
		this.histories = histories;
	}

	public Set getGuesthistories() {
		return this.guesthistories;
	}

	public void setGuesthistories(Set guesthistories) {
		this.guesthistories = guesthistories;
	}

	public Set getZhanhuiorchanpins() {
		return this.zhanhuiorchanpins;
	}

	public void setZhanhuiorchanpins(Set zhanhuiorchanpins) {
		this.zhanhuiorchanpins = zhanhuiorchanpins;
	}

	public Set getChanpinoryongtus() {
		return this.chanpinoryongtus;
	}

	public void setChanpinoryongtus(Set chanpinoryongtus) {
		this.chanpinoryongtus = chanpinoryongtus;
	}

	public Set getChanpinorleimus() {
		return this.chanpinorleimus;
	}

	public void setChanpinorleimus(Set chanpinorleimus) {
		this.chanpinorleimus = chanpinorleimus;
	}

	public Set getChanpinshuxings() {
		return this.chanpinshuxings;
	}

	public void setChanpinshuxings(Set chanpinshuxings) {
		this.chanpinshuxings = chanpinshuxings;
	}

}