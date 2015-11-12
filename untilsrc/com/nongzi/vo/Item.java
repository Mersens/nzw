package com.nongzi.vo;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * Item entity. @author MyEclipse Persistence Tools
 */

public class Item implements java.io.Serializable {

	// Fields

	private String itemid;
	private String itemname;
	private String fatherid;
	private String url;
	private Timestamp adddate;
	private String note;
	private Set roleitems = new HashSet(0);

	// Constructors

	/** default constructor */
	public Item() {
	}

	/** minimal constructor */
	public Item(String itemname, String fatherid, String url,
			Timestamp adddate, String note) {
		this.itemname = itemname;
		this.fatherid = fatherid;
		this.url = url;
		this.adddate = adddate;
		this.note = note;
	}

	/** full constructor */
	public Item(String itemname, String fatherid, String url,
			Timestamp adddate, String note, Set roleitems) {
		this.itemname = itemname;
		this.fatherid = fatherid;
		this.url = url;
		this.adddate = adddate;
		this.note = note;
		this.roleitems = roleitems;
	}

	// Property accessors

	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return this.itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public String getFatherid() {
		return this.fatherid;
	}

	public void setFatherid(String fatherid) {
		this.fatherid = fatherid;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Timestamp getAdddate() {
		return this.adddate;
	}

	public void setAdddate(Timestamp adddate) {
		this.adddate = adddate;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Set getRoleitems() {
		return this.roleitems;
	}

	public void setRoleitems(Set roleitems) {
		this.roleitems = roleitems;
	}

}