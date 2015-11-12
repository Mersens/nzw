package com.nongzi.vo;

/**
 * Chanpinoryongtu entity. @author MyEclipse Persistence Tools
 */

public class Chanpinoryongtu implements java.io.Serializable {

	// Fields

	private String chanpinoryongtuid;
	private Chanpin chanpin;
	private Chanpinyongtu chanpinyongtu;

	// Constructors

	/** default constructor */
	public Chanpinoryongtu() {
	}

	/** full constructor */
	public Chanpinoryongtu(Chanpin chanpin, Chanpinyongtu chanpinyongtu) {
		this.chanpin = chanpin;
		this.chanpinyongtu = chanpinyongtu;
	}

	// Property accessors

	public String getChanpinoryongtuid() {
		return this.chanpinoryongtuid;
	}

	public void setChanpinoryongtuid(String chanpinoryongtuid) {
		this.chanpinoryongtuid = chanpinoryongtuid;
	}

	public Chanpin getChanpin() {
		return this.chanpin;
	}

	public void setChanpin(Chanpin chanpin) {
		this.chanpin = chanpin;
	}

	public Chanpinyongtu getChanpinyongtu() {
		return this.chanpinyongtu;
	}

	public void setChanpinyongtu(Chanpinyongtu chanpinyongtu) {
		this.chanpinyongtu = chanpinyongtu;
	}

}