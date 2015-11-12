package com.nongzi.vo;

/**
 * Roleitem entity. @author MyEclipse Persistence Tools
 */

public class Roleitem implements java.io.Serializable {

	// Fields

	private String roleitemid;
	private Role role;
	private Item item;

	// Constructors

	/** default constructor */
	public Roleitem() {
	}

	/** full constructor */
	public Roleitem(Role role, Item item) {
		this.role = role;
		this.item = item;
	}

	// Property accessors

	public String getRoleitemid() {
		return this.roleitemid;
	}

	public void setRoleitemid(String roleitemid) {
		this.roleitemid = roleitemid;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Item getItem() {
		return this.item;
	}

	public void setItem(Item item) {
		this.item = item;
	}

}