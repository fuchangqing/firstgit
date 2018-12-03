package com.grts.pojo;

import java.util.ArrayList;
import java.util.List;

public class RoleBean {

	private Integer rid;

	private String rolename;

	private String description;

	private Integer isdel;
	
	private List<Integer> mids=new ArrayList<Integer>();

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename == null ? null : rolename.trim();
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description == null ? null : description.trim();
	}

	public Integer getIsdel() {
		return isdel;
	}

	public void setIsdel(Integer isdel) {
		this.isdel = isdel;
	}

	public List<Integer> getMids() {
		return mids;
	}

	public void setMids(List<Integer> mids) {
		this.mids = mids;
	}

	@Override
	public String toString() {
		return "RoleBean [rid=" + rid + ", rolename=" + rolename + ", description=" + description + ", isdel=" + isdel
				+ ", mids=" + mids + "]";
	}
	
}