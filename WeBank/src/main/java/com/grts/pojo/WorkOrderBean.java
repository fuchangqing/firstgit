package com.grts.pojo;

import java.util.Date;

public class WorkOrderBean {

	private String workorderid;

	private Integer customerid;

	private String customername;

	private String centificatenumber;

	private Integer aging;

	private Integer problemtype;

	private Integer handlegroup;

	private Integer handleperson;

	private Integer handleperson1;
	
	private Integer urgencylevel;

	private Integer status;

	private Date creatdate;

	private Integer hurrycount;

	private Date firstdate;

	public String getWorkorderid() {
		return workorderid;
	}

	public void setWorkorderid(String workorderid) {
		this.workorderid = workorderid == null ? null : workorderid.trim();
	}

	public Integer getCustomerid() {
		return customerid;
	}

	public void setCustomerid(Integer customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}

	public void setCustomername(String customername) {
		this.customername = customername == null ? null : customername.trim();
	}

	public String getCentificatenumber() {
		return centificatenumber;
	}

	public void setCentificatenumber(String centificatenumber) {
		this.centificatenumber = centificatenumber == null ? null : centificatenumber.trim();
	}

	public Integer getAging() {
		return aging;
	}

	public void setAging(Integer aging) {
		this.aging = aging;
	}

	public Integer getProblemtype() {
		return problemtype;
	}

	public void setProblemtype(Integer problemtype) {
		this.problemtype = problemtype;
	}

	public Integer getHandlegroup() {
		return handlegroup;
	}

	public void setHandlegroup(Integer handlegroup) {
		this.handlegroup = handlegroup;
	}

	public Integer getHandleperson() {
		return handleperson;
	}

	public void setHandleperson(Integer handleperson) {
		this.handleperson = handleperson;
	}

	

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatdate() {
		return creatdate;
	}

	public void setCreatdate(Date creatdate) {
		this.creatdate = creatdate;
	}

	public Integer getHurrycount() {
		return hurrycount;
	}

	public void setHurrycount(Integer hurrycount) {
		this.hurrycount = hurrycount;
	}

	public Date getFirstdate() {
		return firstdate;
	}

	public void setFirstdate(Date firstdate) {
		this.firstdate = firstdate;
	}

	public Integer getUrgencylevel() {
		return urgencylevel;
	}

	public void setUrgencylevel(Integer urgencylevel) {
		this.urgencylevel = urgencylevel;
	}

	@Override
	public String toString() {
		return "WorkOrderBean [workorderid=" + workorderid + ", customerid=" + customerid + ", customername="
				+ customername + ", centificatenumber=" + centificatenumber + ", aging=" + aging + ", problemtype="
				+ problemtype + ", handlegroup=" + handlegroup + ", handleperson=" + handleperson + ", urgencylevel="
				+ urgencylevel + ", status=" + status + ", creatdate=" + creatdate + ", hurrycount=" + hurrycount
				+ ", firstdate=" + firstdate + "]";
	}

	public Integer getHandleperson1() {
		return handleperson1;
	}

	public void setHandleperson1(Integer handleperson1) {
		this.handleperson1 = handleperson1;
	}
	
}