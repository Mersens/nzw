package com.nongzi.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Area entity. @author MyEclipse Persistence Tools
 */

public class Area implements java.io.Serializable {

	// Fields

	private Integer areaid;
	private City city;
	private String area;
	private Set gongsis = new HashSet(0);

	// Constructors

	/** default constructor */
	public Area() {
	}

	/** minimal constructor */
	public Area(City city, String area) {
		this.city = city;
		this.area = area;
	}

	/** full constructor */
	public Area(City city, String area, Set gongsis) {
		this.city = city;
		this.area = area;
		this.gongsis = gongsis;
	}

	// Property accessors

	public Integer getAreaid() {
		return this.areaid;
	}

	public void setAreaid(Integer areaid) {
		this.areaid = areaid;
	}

	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public String getArea() {
		return this.area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public Set getGongsis() {
		return this.gongsis;
	}

	public void setGongsis(Set gongsis) {
		this.gongsis = gongsis;
	}

}