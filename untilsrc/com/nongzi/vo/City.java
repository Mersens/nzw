package com.nongzi.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * City entity. @author MyEclipse Persistence Tools
 */

public class City implements java.io.Serializable {

	// Fields

	private Integer cityid;
	private Province province;
	private String cityname;
	private Set areas = new HashSet(0);
	private Set gongsis = new HashSet(0);

	// Constructors

	/** default constructor */
	public City() {
	}

	/** minimal constructor */
	public City(Province province, String cityname) {
		this.province = province;
		this.cityname = cityname;
	}

	/** full constructor */
	public City(Province province, String cityname, Set areas, Set gongsis) {
		this.province = province;
		this.cityname = cityname;
		this.areas = areas;
		this.gongsis = gongsis;
	}

	// Property accessors

	public Integer getCityid() {
		return this.cityid;
	}

	public void setCityid(Integer cityid) {
		this.cityid = cityid;
	}

	public Province getProvince() {
		return this.province;
	}

	public void setProvince(Province province) {
		this.province = province;
	}

	public String getCityname() {
		return this.cityname;
	}

	public void setCityname(String cityname) {
		this.cityname = cityname;
	}

	public Set getAreas() {
		return this.areas;
	}

	public void setAreas(Set areas) {
		this.areas = areas;
	}

	public Set getGongsis() {
		return this.gongsis;
	}

	public void setGongsis(Set gongsis) {
		this.gongsis = gongsis;
	}

}