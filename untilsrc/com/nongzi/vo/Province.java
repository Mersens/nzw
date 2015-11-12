package com.nongzi.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Province entity. @author MyEclipse Persistence Tools
 */

public class Province implements java.io.Serializable {

	// Fields

	private Integer provinceid;
	private String province;
	private String domaintypeid;
	private Set gongsis = new HashSet(0);
	private Set cities = new HashSet(0);

	// Constructors

	/** default constructor */
	public Province() {
	}

	/** minimal constructor */
	public Province(String province, String domaintypeid) {
		this.province = province;
		this.domaintypeid = domaintypeid;
	}

	/** full constructor */
	public Province(String province, String domaintypeid, Set gongsis,
			Set cities) {
		this.province = province;
		this.domaintypeid = domaintypeid;
		this.gongsis = gongsis;
		this.cities = cities;
	}

	// Property accessors

	public Integer getProvinceid() {
		return this.provinceid;
	}

	public void setProvinceid(Integer provinceid) {
		this.provinceid = provinceid;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getDomaintypeid() {
		return this.domaintypeid;
	}

	public void setDomaintypeid(String domaintypeid) {
		this.domaintypeid = domaintypeid;
	}

	public Set getGongsis() {
		return this.gongsis;
	}

	public void setGongsis(Set gongsis) {
		this.gongsis = gongsis;
	}

	public Set getCities() {
		return this.cities;
	}

	public void setCities(Set cities) {
		this.cities = cities;
	}

}