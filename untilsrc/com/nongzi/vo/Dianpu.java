package com.nongzi.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.nongzi.dao.BaseVo;

/**
 * Dianpu entity. @author MyEclipse Persistence Tools
 */

public class Dianpu extends BaseVo implements java.io.Serializable {

	// Fields

	private String dianpuid;
	private Dianputype dianputype;
	private User user;
	private Gongsi gongsi;
	private String dianpuname;
	private String dianpujieshao;
	private Integer islock;
	private String initdomain;
	private String domain;
	private Timestamp updatetime;
	private Timestamp addtime;
	private Integer htmlid;
	private Set dianpunewses = new HashSet(0);
	private Set zaixianyijias = new HashSet(0);
	private Set chanpins = new HashSet(0);
	private Set histories = new HashSet(0);
	private Set guesthistories = new HashSet(0);
	private Set dianpuleimus = new HashSet(0);
	private Set dianpuguanlis = new HashSet(0);
	private Set dianpulianxirens = new HashSet(0);
	private Set zhanhuiordianpus = new HashSet(0);

	// Constructors

	/** default constructor */
	public Dianpu() {
	}

	/** minimal constructor */
	public Dianpu(Dianputype dianputype, User user, Gongsi gongsi,
			String dianpuname, Integer islock, Timestamp addtime, Integer htmlid) {
		this.dianputype = dianputype;
		this.user = user;
		this.gongsi = gongsi;
		this.dianpuname = dianpuname;
		this.islock = islock;
		this.addtime = addtime;
		this.htmlid = htmlid;
	}

	/** full constructor */
	public Dianpu(Dianputype dianputype, User user, Gongsi gongsi,
			String dianpuname, String dianpujieshao, Integer islock,
			String initdomain, String domain, Timestamp updatetime,
			Timestamp addtime, Integer htmlid, Set dianpunewses,
			Set zaixianyijias, Set chanpins, Set histories, Set guesthistories,
			Set dianpuleimus, Set dianpuguanlis, Set dianpulianxirens,
			Set zhanhuiordianpus) {
		this.dianputype = dianputype;
		this.user = user;
		this.gongsi = gongsi;
		this.dianpuname = dianpuname;
		this.dianpujieshao = dianpujieshao;
		this.islock = islock;
		this.initdomain = initdomain;
		this.domain = domain;
		this.updatetime = updatetime;
		this.addtime = addtime;
		this.htmlid = htmlid;
		this.dianpunewses = dianpunewses;
		this.zaixianyijias = zaixianyijias;
		this.chanpins = chanpins;
		this.histories = histories;
		this.guesthistories = guesthistories;
		this.dianpuleimus = dianpuleimus;
		this.dianpuguanlis = dianpuguanlis;
		this.dianpulianxirens = dianpulianxirens;
		this.zhanhuiordianpus = zhanhuiordianpus;
	}

	// Property accessors

	public String getDianpuid() {
		return this.dianpuid;
	}

	public void setDianpuid(String dianpuid) {
		this.dianpuid = dianpuid;
	}

	public Dianputype getDianputype() {
		return this.dianputype;
	}

	public void setDianputype(Dianputype dianputype) {
		this.dianputype = dianputype;
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

	public String getDianpuname() {
		return this.dianpuname;
	}

	public void setDianpuname(String dianpuname) {
		this.dianpuname = dianpuname;
	}

	public String getDianpujieshao() {
		return this.dianpujieshao;
	}

	public void setDianpujieshao(String dianpujieshao) {
		this.dianpujieshao = dianpujieshao;
	}

	public Integer getIslock() {
		return this.islock;
	}

	public void setIslock(Integer islock) {
		this.islock = islock;
	}

	public String getInitdomain() {
		return this.initdomain;
	}

	public void setInitdomain(String initdomain) {
		this.initdomain = initdomain;
	}

	public String getDomain() {
		return this.domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public Timestamp getUpdatetime() {
		return this.updatetime;
	}

	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
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

	public Set getDianpunewses() {
		return this.dianpunewses;
	}

	public void setDianpunewses(Set dianpunewses) {
		this.dianpunewses = dianpunewses;
	}

	public Set getZaixianyijias() {
		return this.zaixianyijias;
	}

	public void setZaixianyijias(Set zaixianyijias) {
		this.zaixianyijias = zaixianyijias;
	}

	public Set getChanpins() {
		return this.chanpins;
	}

	public void setChanpins(Set chanpins) {
		this.chanpins = chanpins;
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

	public Set getDianpuleimus() {
		return this.dianpuleimus;
	}

	public void setDianpuleimus(Set dianpuleimus) {
		this.dianpuleimus = dianpuleimus;
	}

	public Set getDianpuguanlis() {
		return this.dianpuguanlis;
	}

	public void setDianpuguanlis(Set dianpuguanlis) {
		this.dianpuguanlis = dianpuguanlis;
	}

	public Set getDianpulianxirens() {
		return this.dianpulianxirens;
	}

	public void setDianpulianxirens(Set dianpulianxirens) {
		this.dianpulianxirens = dianpulianxirens;
	}

	public Set getZhanhuiordianpus() {
		return this.zhanhuiordianpus;
	}

	public void setZhanhuiordianpus(Set zhanhuiordianpus) {
		this.zhanhuiordianpus = zhanhuiordianpus;
	}

}