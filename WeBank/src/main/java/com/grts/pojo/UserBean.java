package com.grts.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserBean {
    
    private Integer userid;

    private String username;

    private String password;

    private String realname;

    private Integer did;

    private Integer jid;

    private Date opentime;

    private String sex;

    private String city;

    private String pid;

    private String telephone;

    private String email;

    private String mobile;

    private String address;

    private Integer married;

    private String salt;

    private List<Integer> rids=new ArrayList<>();
    
    public Integer getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.USERID
     *
     * @param userid the value for t_user.USERID
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.USERNAME
     *
     * @return the value of t_user.USERNAME
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.USERNAME
     *
     * @param username the value for t_user.USERNAME
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.PASSWORD
     *
     * @return the value of t_user.PASSWORD
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.PASSWORD
     *
     * @param password the value for t_user.PASSWORD
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.REALNAME
     *
     * @return the value of t_user.REALNAME
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public String getRealname() {
        return realname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.REALNAME
     *
     * @param realname the value for t_user.REALNAME
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.DID
     *
     * @return the value of t_user.DID
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public Integer getDid() {
        return did;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.DID
     *
     * @param did the value for t_user.DID
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public void setDid(Integer did) {
        this.did = did;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.JID
     *
     * @return the value of t_user.JID
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public Integer getJid() {
        return jid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.JID
     *
     * @param jid the value for t_user.JID
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public void setJid(Integer jid) {
        this.jid = jid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.OPENTIME
     *
     * @return the value of t_user.OPENTIME
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public Date getOpentime() {
        return opentime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.OPENTIME
     *
     * @param opentime the value for t_user.OPENTIME
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public void setOpentime(Date opentime) {
        this.opentime = opentime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.SEX
     *
     * @return the value of t_user.SEX
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.SEX
     *
     * @param sex the value for t_user.SEX
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.CITY
     *
     * @return the value of t_user.CITY
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public String getCity() {
        return city;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.CITY
     *
     * @param city the value for t_user.CITY
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.PID
     *
     * @return the value of t_user.PID
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public String getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.PID
     *
     * @param pid the value for t_user.PID
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public void setPid(String pid) {
        this.pid = pid == null ? null : pid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.TELEPHONE
     *
     * @return the value of t_user.TELEPHONE
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.TELEPHONE
     *
     * @param telephone the value for t_user.TELEPHONE
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.EMAIL
     *
     * @return the value of t_user.EMAIL
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public String getEmail() {
        return email;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.EMAIL
     *
     * @param email the value for t_user.EMAIL
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.MOBILE
     *
     * @return the value of t_user.MOBILE
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.MOBILE
     *
     * @param mobile the value for t_user.MOBILE
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.ADDRESS
     *
     * @return the value of t_user.ADDRESS
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.ADDRESS
     *
     * @param address the value for t_user.ADDRESS
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.MARRIED
     *
     * @return the value of t_user.MARRIED
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public Integer getMarried() {
        return married;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.MARRIED
     *
     * @param married the value for t_user.MARRIED
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public void setMarried(Integer married) {
        this.married = married;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column t_user.salt
     *
     * @return the value of t_user.salt
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public String getSalt() {
        return salt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column t_user.salt
     *
     * @param salt the value for t_user.salt
     *
     * @mbggenerated Wed Oct 31 10:26:41 CST 2018
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

	public List<Integer> getRids() {
		return rids;
	}

	public void setRids(List<Integer> rids) {
		this.rids = rids;
	}

	@Override
	public String toString() {
		return "UserBean [userid=" + userid + ", username=" + username + ", password=" + password + ", realname="
				+ realname + ", did=" + did + ", jid=" + jid + ", opentime=" + opentime + ", sex=" + sex + ", city="
				+ city + ", pid=" + pid + ", telephone=" + telephone + ", email=" + email + ", mobile=" + mobile
				+ ", address=" + address + ", married=" + married + ", salt=" + salt + ", rids=" + rids + "]";
	}
	
}