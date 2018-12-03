package com.grts.dto;

public class BaseUserRole {
	private int userid;
	private int rid;
	public BaseUserRole() {
		super();
	}
	public BaseUserRole(int userid, int rid) {
		super();
		this.userid = userid;
		this.rid = rid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getRid() {
		return rid;
	}
	public void setRid(int rid) {
		this.rid = rid;
	}
	
}
