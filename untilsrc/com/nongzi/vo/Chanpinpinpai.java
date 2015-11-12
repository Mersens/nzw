package com.nongzi.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Chanpinpinpai entity. @author MyEclipse Persistence Tools
 */

public class Chanpinpinpai implements java.io.Serializable {

	// Fields

	private String pinpaiid;
	private String pinpainame;
	private Timestamp addtime;
	private Set leimuorpinpais = new HashSet(0);
	private Set chanpins = new HashSet(0);

	// Constructors

	/** default constructor */
	public Chanpinpinpai() {
	}

	/** minimal constructor */
	public Chanpinpinpai(String pinpainame, Timestamp addtime) {
		this.pinpainame = pinpainame;
		this.addtime = addtime;
	}

	/** full constructor */
	public Chanpinpinpai(String pinpainame, Timestamp addtime,
			Set leimuorpinpais, Set chanpins) {
		this.pinpainame = pinpainame;
		this.addtime = addtime;
		this.leimuorpinpais = leimuorpinpais;
		this.chanpins = chanpins;
	}

	// Property accessors

	public String getPinpaiid() {
		return this.pinpaiid;
	}

	public void setPinpaiid(String pinpaiid) {
		this.pinpaiid = pinpaiid;
	}

	public String getPinpainame() {
		return this.pinpainame;
	}

	public void setPinpainame(String pinpainame) {
		this.pinpainame = pinpainame;
	}

	public Timestamp getAddtime() {
		return this.addtime;
	}

	public void setAddtime(Timestamp addtime) {
		this.addtime = addtime;
	}

	public Set getLeimuorpinpais() {
		return this.leimuorpinpais;
	}

	public void setLeimuorpinpais(Set leimuorpinpais) {
		this.leimuorpinpais = leimuorpinpais;
	}

	public Set getChanpins() {
		return this.chanpins;
	}

	public void setChanpins(Set chanpins) {
		this.chanpins = chanpins;
	}

}