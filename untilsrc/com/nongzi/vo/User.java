package com.nongzi.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import com.nongzi.dao.BaseVo;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User extends BaseVo implements java.io.Serializable {

	// Fields

	private String userid;
	private Gongsi gongsi;
	private String username;
	private String userpwd;
	private String userpwdStatic;
	private String userjiaoyipwd;
	private String userjiaoyipwdStatic;
	private String userphone;
	private Integer userislock;
	private String qq;
	private String xingming;
	private String touxiang;
	private Timestamp addtime;
	private Integer htmlid;
	private Set dianpuguanlis = new HashSet(0);
	private Set chanpins = new HashSet(0);
	private Set guesthistories = new HashSet(0);
	private Set usersessions = new HashSet(0);
	private Set histories = new HashSet(0);
	private Set newstables = new HashSet(0);
	private Set dianpus = new HashSet(0);
	private Set sysmessagesForUserid = new HashSet(0);
	private Set dianpulianxirens = new HashSet(0);
	private Set zaixianyijias = new HashSet(0);
	private Set dianpuleimus = new HashSet(0);
	private Set sysmessagesForFormuserid = new HashSet(0);
	private Set dianpunewses = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** minimal constructor */
	public User(String username, String userpwd, String userpwdStatic,
			String userjiaoyipwd, String userjiaoyipwdStatic, String userphone,
			Integer userislock, Timestamp addtime, Integer htmlid) {
		this.username = username;
		this.userpwd = userpwd;
		this.userpwdStatic = userpwdStatic;
		this.userjiaoyipwd = userjiaoyipwd;
		this.userjiaoyipwdStatic = userjiaoyipwdStatic;
		this.userphone = userphone;
		this.userislock = userislock;
		this.addtime = addtime;
		this.htmlid = htmlid;
	}

	/** full constructor */
	public User(Gongsi gongsi, String username, String userpwd,
			String userpwdStatic, String userjiaoyipwd,
			String userjiaoyipwdStatic, String userphone, Integer userislock,
			String qq, String xingming, String touxiang, Timestamp addtime,
			Integer htmlid, Set dianpuguanlis, Set chanpins,
			Set guesthistories, Set usersessions, Set histories,
			Set newstables, Set dianpus, Set sysmessagesForUserid,
			Set dianpulianxirens, Set zaixianyijias, Set dianpuleimus,
			Set sysmessagesForFormuserid, Set dianpunewses) {
		this.gongsi = gongsi;
		this.username = username;
		this.userpwd = userpwd;
		this.userpwdStatic = userpwdStatic;
		this.userjiaoyipwd = userjiaoyipwd;
		this.userjiaoyipwdStatic = userjiaoyipwdStatic;
		this.userphone = userphone;
		this.userislock = userislock;
		this.qq = qq;
		this.xingming = xingming;
		this.touxiang = touxiang;
		this.addtime = addtime;
		this.htmlid = htmlid;
		this.dianpuguanlis = dianpuguanlis;
		this.chanpins = chanpins;
		this.guesthistories = guesthistories;
		this.usersessions = usersessions;
		this.histories = histories;
		this.newstables = newstables;
		this.dianpus = dianpus;
		this.sysmessagesForUserid = sysmessagesForUserid;
		this.dianpulianxirens = dianpulianxirens;
		this.zaixianyijias = zaixianyijias;
		this.dianpuleimus = dianpuleimus;
		this.sysmessagesForFormuserid = sysmessagesForFormuserid;
		this.dianpunewses = dianpunewses;
	}

	// Property accessors

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Gongsi getGongsi() {
		return this.gongsi;
	}

	public void setGongsi(Gongsi gongsi) {
		this.gongsi = gongsi;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpwd() {
		return this.userpwd;
	}

	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}

	public String getUserpwdStatic() {
		return this.userpwdStatic;
	}

	public void setUserpwdStatic(String userpwdStatic) {
		this.userpwdStatic = userpwdStatic;
	}

	public String getUserjiaoyipwd() {
		return this.userjiaoyipwd;
	}

	public void setUserjiaoyipwd(String userjiaoyipwd) {
		this.userjiaoyipwd = userjiaoyipwd;
	}

	public String getUserjiaoyipwdStatic() {
		return this.userjiaoyipwdStatic;
	}

	public void setUserjiaoyipwdStatic(String userjiaoyipwdStatic) {
		this.userjiaoyipwdStatic = userjiaoyipwdStatic;
	}

	public String getUserphone() {
		return this.userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	public Integer getUserislock() {
		return this.userislock;
	}

	public void setUserislock(Integer userislock) {
		this.userislock = userislock;
	}

	public String getQq() {
		return this.qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getXingming() {
		return this.xingming;
	}

	public void setXingming(String xingming) {
		this.xingming = xingming;
	}

	public String getTouxiang() {
		return this.touxiang;
	}

	public void setTouxiang(String touxiang) {
		this.touxiang = touxiang;
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

	public Set getDianpuguanlis() {
		return this.dianpuguanlis;
	}

	public void setDianpuguanlis(Set dianpuguanlis) {
		this.dianpuguanlis = dianpuguanlis;
	}

	public Set getChanpins() {
		return this.chanpins;
	}

	public void setChanpins(Set chanpins) {
		this.chanpins = chanpins;
	}

	public Set getGuesthistories() {
		return this.guesthistories;
	}

	public void setGuesthistories(Set guesthistories) {
		this.guesthistories = guesthistories;
	}

	public Set getUsersessions() {
		return this.usersessions;
	}

	public void setUsersessions(Set usersessions) {
		this.usersessions = usersessions;
	}

	public Set getHistories() {
		return this.histories;
	}

	public void setHistories(Set histories) {
		this.histories = histories;
	}

	public Set getNewstables() {
		return this.newstables;
	}

	public void setNewstables(Set newstables) {
		this.newstables = newstables;
	}

	public Set getDianpus() {
		return this.dianpus;
	}

	public void setDianpus(Set dianpus) {
		this.dianpus = dianpus;
	}

	public Set getSysmessagesForUserid() {
		return this.sysmessagesForUserid;
	}

	public void setSysmessagesForUserid(Set sysmessagesForUserid) {
		this.sysmessagesForUserid = sysmessagesForUserid;
	}

	public Set getDianpulianxirens() {
		return this.dianpulianxirens;
	}

	public void setDianpulianxirens(Set dianpulianxirens) {
		this.dianpulianxirens = dianpulianxirens;
	}

	public Set getZaixianyijias() {
		return this.zaixianyijias;
	}

	public void setZaixianyijias(Set zaixianyijias) {
		this.zaixianyijias = zaixianyijias;
	}

	public Set getDianpuleimus() {
		return this.dianpuleimus;
	}

	public void setDianpuleimus(Set dianpuleimus) {
		this.dianpuleimus = dianpuleimus;
	}

	public Set getSysmessagesForFormuserid() {
		return this.sysmessagesForFormuserid;
	}

	public void setSysmessagesForFormuserid(Set sysmessagesForFormuserid) {
		this.sysmessagesForFormuserid = sysmessagesForFormuserid;
	}

	public Set getDianpunewses() {
		return this.dianpunewses;
	}

	public void setDianpunewses(Set dianpunewses) {
		this.dianpunewses = dianpunewses;
	}

}