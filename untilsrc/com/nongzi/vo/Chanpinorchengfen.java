package com.nongzi.vo;

/**
 * Chanpinorchengfen entity. @author MyEclipse Persistence Tools
 */

public class Chanpinorchengfen implements java.io.Serializable {

	// Fields

	private String cpcfid;
	private Chanpin chanpin;
	private Chanpinchengfen chanpinchengfen;

	// Constructors

	/** default constructor */
	public Chanpinorchengfen() {
	}

	/** full constructor */
	public Chanpinorchengfen(Chanpin chanpin, Chanpinchengfen chanpinchengfen) {
		this.chanpin = chanpin;
		this.chanpinchengfen = chanpinchengfen;
	}

	// Property accessors

	public String getCpcfid() {
		return this.cpcfid;
	}

	public void setCpcfid(String cpcfid) {
		this.cpcfid = cpcfid;
	}

	public Chanpin getChanpin() {
		return this.chanpin;
	}

	public void setChanpin(Chanpin chanpin) {
		this.chanpin = chanpin;
	}

	public Chanpinchengfen getChanpinchengfen() {
		return this.chanpinchengfen;
	}

	public void setChanpinchengfen(Chanpinchengfen chanpinchengfen) {
		this.chanpinchengfen = chanpinchengfen;
	}

}