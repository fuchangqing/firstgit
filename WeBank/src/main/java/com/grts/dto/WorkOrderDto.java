package com.grts.dto;

import com.grts.pojo.WorkOrderBean;

public class WorkOrderDto extends UserDto{

	private WorkOrderBean wo=new WorkOrderBean();
	private String agingtime;
	private String problemtypename;
	private String handlegroupname;
	private String username;
	private String urgencylevelname;
	private String creatdateStr;
	public WorkOrderBean getWo() {
		return wo;
	}
	public void setWo(WorkOrderBean wo) {
		this.wo = wo;
	}
	public String getAgingtime() {
		return agingtime;
	}
	public void setAgingtime(String agingtime) {
		this.agingtime = agingtime;
	}
	public String getProblemtypename() {
		return problemtypename;
	}
	public void setProblemtypename(String problemtypename) {
		this.problemtypename = problemtypename;
	}
	public String getHandlegroupname() {
		return handlegroupname;
	}
	public void setHandlegroupname(String handlegroupname) {
		this.handlegroupname = handlegroupname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUrgencylevelname() {
		return urgencylevelname;
	}
	public void setUrgencylevelname(String urgencylevelname) {
		this.urgencylevelname = urgencylevelname;
	}
	public String getCreatdateStr() {
		return creatdateStr;
	}
	public void setCreatdateStr(String creatdateStr) {
		this.creatdateStr = creatdateStr;
	}
	@Override
	public String toString() {
		return "WorkOrderDto [wo=" + wo + ", agingtime=" + agingtime + ", problemtypename=" + problemtypename
				+ ", handlegroupname=" + handlegroupname + ", username=" + username + ", urgencylevelname="
				+ urgencylevelname + ", creatdateStr=" + creatdateStr + "]";
	}
	
}
