package com.nongzi.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.nongzi.dao.BaseVo;

/**
 * Gongsi entity. @author MyEclipse Persistence Tools
 */

public class Gongsi extends BaseVo implements java.io.Serializable {

	// Fields

	private String gongsiid;
	private Province province;
	private Area area;
	private City city;
	private String gslogo;
	private String gongsinama;
	private String jiancheng;
	private String miaoshu;
	private String dizhi;
	private String jingweidu;
	private String dianhua;
	private String chuanzhen;
	private String lianxiren;
	private String lianxirendianhua;
	private String yingyezhizhao;
	private String shuiwudengji;
	private String jigoudaima;
	private Integer islock;
	private Timestamp addtime;
	private Integer htmlid;
	private Set guesthistories = new HashSet(0);
	private Set histories = new HashSet(0);
	private Set users = new HashSet(0);
	private Set chanpins = new HashSet(0);
	private Set dianpus = new HashSet(0);
	private Set sysmessages = new HashSet(0);

	// Constructors

	/** default constructor */
	public Gongsi() {
	}

	/** minimal constructor */
	public Gongsi(Province province, Area area, City city, String dizhi,
			String jingweidu, Integer islock, Timestamp addtime, Integer htmlid) {
		this.province = province;
		this.area = area;
		this.city = city;
		this.dizhi = dizhi;
		this.jingweidu = jingweidu;
		this.islock = islock;
		this.addtime = addtime;
		this.htmlid = htmlid;
	}

	/** full constructor */
	public Gongsi(Province province, Area area, City city, String gslogo,
			String gongsinama, String jiancheng, String miaoshu, String dizhi,
			String jingweidu, String dianhua, String chuanzhen,
			String lianxiren, String lianxirendianhua, String yingyezhizhao,
			String shuiwudengji, String jigoudaima, Integer islock,
			Timestamp addtime, Integer htmlid, Set guesthistories,
			Set histories, Set users, Set chanpins, Set dianpus, Set sysmessages) {
		this.province = province;
		this.area = area;
		this.city = city;
		this.gslogo = gslogo;
		this.gongsinama = gongsinama;
		this.jiancheng = jiancheng;
		this.miaoshu = miaoshu;
		this.dizhi = dizhi;
		this.jingweidu = jingweidu;
		this.dianhua = dianhua;
		this.chuanzhen = chuanzhen;
		this.lianxiren = lianxiren;
		this.lianxirendianhua = lianxirendianhua;
		this.yingyezhizhao = yingyezhizhao;
		this.shuiwudengji = shuiwudengji;
		this.jigoudaima = jigoudaima;
		this.islock = islock;
		this.addtime = addtime;
		this.htmlid = htmlid;
		this.guesthistories = guesthistories;
		this.histories = histories;
		this.users = users;
		this.chanpins = chanpins;
		this.dianpus = dianpus;
		this.sysmessages = sysmessages;
	}

	// Property accessors

	public String getGongsiid() {
		return this.gongsiid;
	}

	public void setGongsiid(String gongsiid) {
		this.gongsiid = gongsiid;
	}

	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public Area getArea() {
		return this.area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getGslogo() {
		return this.gslogo;
	}

	public void setGslogo(String gslogo) {
		this.gslogo = gslogo;
	}

	public String getGongsinama() {
		return this.gongsinama;
	}

	public void setGongsinama(String gongsinama) {
		this.gongsinama = gongsinama;
	}

	public String getJiancheng() {
		return this.jiancheng;
	}

	public void setJiancheng(String jiancheng) {
		this.jiancheng = jiancheng;
	}

	public String getMiaoshu() {
		return this.miaoshu;
	}

	public void setMiaoshu(String miaoshu) {
		this.miaoshu = miaoshu;
	}

	public String getDizhi() {
		return this.dizhi;
	}

	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}

	public String getJingweidu() {
		return this.jingweidu;
	}

	public void setJingweidu(String jingweidu) {
		this.jingweidu = jingweidu;
	}

	public String getDianhua() {
		return this.dianhua;
	}

	public void setDianhua(String dianhua) {
		this.dianhua = dianhua;
	}

	public String getChuanzhen() {
		return this.chuanzhen;
	}

	public void setChuanzhen(String chuanzhen) {
		this.chuanzhen = chuanzhen;
	}

	public String getLianxiren() {
		return this.lianxiren;
	}

	public void setLianxiren(String lianxiren) {
		this.lianxiren = lianxiren;
	}

	public String getLianxirendianhua() {
		return this.lianxirendianhua;
	}

	public void setLianxirendianhua(String lianxirendianhua) {
		this.lianxirendianhua = lianxirendianhua;
	}

	public String getYingyezhizhao() {
		return this.yingyezhizhao;
	}

	public void setYingyezhizhao(String yingyezhizhao) {
		this.yingyezhizhao = yingyezhizhao;
	}

	public String getShuiwudengji() {
		return this.shuiwudengji;
	}

	public void setShuiwudengji(String shuiwudengji) {
		this.shuiwudengji = shuiwudengji;
	}

	public String getJigoudaima() {
		return this.jigoudaima;
	}

	public void setJigoudaima(String jigoudaima) {
		this.jigoudaima = jigoudaima;
	}

	public Integer getIslock() {
		return this.islock;
	}

	public void setIslock(Integer islock) {
		this.islock = islock;
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

	public Set getGuesthistories() {
		return this.guesthistories;
	}

	public void setGuesthistories(Set guesthistories) {
		this.guesthistories = guesthistories;
	}

	public Set getHistories() {
		return this.histories;
	}

	public void setHistories(Set histories) {
		this.histories = histories;
	}

	public Set getUsers() {
		return this.users;
	}

	public void setUsers(Set users) {
		this.users = users;
	}

	public Set getChanpins() {
		return this.chanpins;
	}

	public void setChanpins(Set chanpins) {
		this.chanpins = chanpins;
	}

	public Set getDianpus() {
		return this.dianpus;
	}

	public void setDianpus(Set dianpus) {
		this.dianpus = dianpus;
	}

	public Set getSysmessages() {
		return this.sysmessages;
	}

	public void setSysmessages(Set sysmessages) {
		this.sysmessages = sysmessages;
	}

}