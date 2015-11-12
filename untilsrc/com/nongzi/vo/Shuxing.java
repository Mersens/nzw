package com.nongzi.vo;

import java.util.HashSet;
import java.util.Set;

import com.nongzi.dao.BaseVo;

/**
 * Shuxing entity. @author MyEclipse Persistence Tools
 */

public class Shuxing extends BaseVo implements java.io.Serializable {

	// Fields

	private String shuxingid;
	private String shuxingname;
	private Set leimuorshuxings = new HashSet(0);
	private Set chanpinshuxings = new HashSet(0);

	// Constructors

	/** default constructor */
	public Shuxing() {
	}

	/** minimal constructor */
	public Shuxing(String shuxingname) {
		this.shuxingname = shuxingname;
	}

	/** full constructor */
	public Shuxing(String shuxingname, Set leimuorshuxings, Set chanpinshuxings) {
		this.shuxingname = shuxingname;
		this.leimuorshuxings = leimuorshuxings;
		this.chanpinshuxings = chanpinshuxings;
	}

	// Property accessors

	public String getShuxingid() {
		return this.shuxingid;
	}

	public void setShuxingid(String shuxingid) {
		this.shuxingid = shuxingid;
	}

	public String getShuxingname() {
		return this.shuxingname;
	}

	public void setShuxingname(String shuxingname) {
		this.shuxingname = shuxingname;
	}

	public Set getLeimuorshuxings() {
		return this.leimuorshuxings;
	}

	public void setLeimuorshuxings(Set leimuorshuxings) {
		this.leimuorshuxings = leimuorshuxings;
	}

	public Set getChanpinshuxings() {
		return this.chanpinshuxings;
	}

	public void setChanpinshuxings(Set chanpinshuxings) {
		this.chanpinshuxings = chanpinshuxings;
	}

}