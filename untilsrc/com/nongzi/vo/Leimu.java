package com.nongzi.vo;

import java.util.HashSet;
import java.util.Set;

/**
 * Leimu entity. @author MyEclipse Persistence Tools
 */

public class Leimu implements java.io.Serializable {

	// Fields

	private String categoryId;
	private String name;
	private String parentId;
	private Integer isshow;
	private Set leimuorchengfens = new HashSet(0);
	private Set chanpinorleimus = new HashSet(0);
	private Set leimuorpinpais = new HashSet(0);
	private Set leimuorshuxings = new HashSet(0);
	private Set dianpuleimus = new HashSet(0);
	private Set leimuoryongtus = new HashSet(0);

	// Constructors

	/** default constructor */
	public Leimu() {
	}

	/** minimal constructor */
	public Leimu(String name, String parentId, Integer isshow) {
		this.name = name;
		this.parentId = parentId;
		this.isshow = isshow;
	}

	/** full constructor */
	public Leimu(String name, String parentId, Integer isshow,
			Set leimuorchengfens, Set chanpinorleimus, Set leimuorpinpais,
			Set leimuorshuxings, Set dianpuleimus, Set leimuoryongtus) {
		this.name = name;
		this.parentId = parentId;
		this.isshow = isshow;
		this.leimuorchengfens = leimuorchengfens;
		this.chanpinorleimus = chanpinorleimus;
		this.leimuorpinpais = leimuorpinpais;
		this.leimuorshuxings = leimuorshuxings;
		this.dianpuleimus = dianpuleimus;
		this.leimuoryongtus = leimuoryongtus;
	}

	// Property accessors

	public String getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentId() {
		return this.parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public Integer getIsshow() {
		return this.isshow;
	}

	public void setIsshow(Integer isshow) {
		this.isshow = isshow;
	}

	public Set getLeimuorchengfens() {
		return this.leimuorchengfens;
	}

	public void setLeimuorchengfens(Set leimuorchengfens) {
		this.leimuorchengfens = leimuorchengfens;
	}

	public Set getChanpinorleimus() {
		return this.chanpinorleimus;
	}

	public void setChanpinorleimus(Set chanpinorleimus) {
		this.chanpinorleimus = chanpinorleimus;
	}

	public Set getLeimuorpinpais() {
		return this.leimuorpinpais;
	}

	public void setLeimuorpinpais(Set leimuorpinpais) {
		this.leimuorpinpais = leimuorpinpais;
	}

	public Set getLeimuorshuxings() {
		return this.leimuorshuxings;
	}

	public void setLeimuorshuxings(Set leimuorshuxings) {
		this.leimuorshuxings = leimuorshuxings;
	}

	public Set getDianpuleimus() {
		return this.dianpuleimus;
	}

	public void setDianpuleimus(Set dianpuleimus) {
		this.dianpuleimus = dianpuleimus;
	}

	public Set getLeimuoryongtus() {
		return this.leimuoryongtus;
	}

	public void setLeimuoryongtus(Set leimuoryongtus) {
		this.leimuoryongtus = leimuoryongtus;
	}

}