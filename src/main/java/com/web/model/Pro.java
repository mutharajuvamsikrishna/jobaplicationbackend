package com.web.model;

import javax.persistence.*;

@Entity
@Table(name = "Pro")
public class Pro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long regno;
	private String id;
	private String email;
	private String expy;
	private String lwd;
	private String rexpy;
	private String immi;
	private String sdate;
	private String edate;
	private String notice;
	private String domain;
	private String expertise;
	private String pskills;
	private String cuctc;
	private String expctc;
	private String link;
	private String culocation;
	private String prelocaion;
	private String languages;
	private String frameworks;
	private String tools;
	private String databases1;
	private String servers;
	private String cloud;
	private String val5;
	private String coun;
	private String citi;
	private String onciti;
	private String onciticli;
	private String prevCompanyName;
	private String id1;
	private String prevEmployeeName;
	private String location;
	private String workedYears;
	private String prevFromDate;
	private String prevToDate;
	private String role;
	private String designation;
	private String ctc;
	private String prevCompanyName1;
	private String id11;
	private String prevEmployeeName1;
	private String location1;
	private String workedYears1;
	private String prevFromDate1;
	private String prevToDate1;
	private String role1;
	private String designation1;
	private String ctc1;

	private String prevCompanyName2;
	private String id12;
	private String prevEmployeeName2;
	private String location2;
	private String workedYears2;
	private String prevFromDate2;
	private String prevToDate2;
	private String role2;
	private String designation2;
	private String ctc2;

	public Pro() {

	}

	public Long getRegno() {
		return regno;
	}

	public void setRegno(Long regno) {
		this.regno = regno;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExpy() {
		return expy;
	}

	public void setExpy(String expy) {
		this.expy = expy;
	}

	public String getLwd() {
		return lwd;
	}

	public void setLwd(String lwd) {
		this.lwd = lwd;
	}

	public String getRexpy() {
		return rexpy;
	}

	public void setRexpy(String rexpy) {
		this.rexpy = rexpy;
	}

	public String getImmi() {
		return immi;
	}

	public void setImmi(String immi) {
		this.immi = immi;
	}

	public String getSdate() {
		return sdate;
	}

	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	public String getEdate() {
		return edate;
	}

	public void setEdate(String edate) {
		this.edate = edate;
	}

	public String getNotice() {
		return notice;
	}

	public void setNotice(String notice) {
		this.notice = notice;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public String getExpertise() {
		return expertise;
	}

	public void setExpertise(String expertise) {
		this.expertise = expertise;
	}

	public String getPskills() {
		return pskills;
	}

	public void setPskills(String pskills) {
		this.pskills = pskills;
	}

	public String getCuctc() {
		return cuctc;
	}

	public void setCuctc(String cuctc) {
		this.cuctc = cuctc;
	}

	public String getExpctc() {
		return expctc;
	}

	public void setExpctc(String expctc) {
		this.expctc = expctc;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public String getCulocation() {
		return culocation;
	}

	public void setCulocation(String culocation) {
		this.culocation = culocation;
	}

	public String getPrelocaion() {
		return prelocaion;
	}

	public void setPrelocaion(String prelocaion) {
		this.prelocaion = prelocaion;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getFrameworks() {
		return frameworks;
	}

	public void setFrameworks(String frameworks) {
		this.frameworks = frameworks;
	}

	public String getTools() {
		return tools;
	}

	public void setTools(String tools) {
		this.tools = tools;
	}

	public String getDatabases1() {
		return databases1;
	}

	public void setDatabases1(String databases1) {
		this.databases1 = databases1;
	}

	public String getServers() {
		return servers;
	}

	public void setServers(String servers) {
		this.servers = servers;
	}

	public String getCloud() {
		return cloud;
	}

	public void setCloud(String cloud) {
		this.cloud = cloud;
	}

	public String getVal5() {
		return val5;
	}

	public void setVal5(String val5) {
		this.val5 = val5;
	}

	public String getCoun() {
		return coun;
	}

	public void setCoun(String coun) {
		this.coun = coun;
	}

	public String getCiti() {
		return citi;
	}

	public void setCiti(String citi) {
		this.citi = citi;
	}

	public String getOnciti() {
		return onciti;
	}

	public void setOnciti(String onciti) {
		this.onciti = onciti;
	}

	public String getOnciticli() {
		return onciticli;
	}

	public void setOnciticli(String onciticli) {
		this.onciticli = onciticli;
	}

	public String getPrevCompanyName() {
		return prevCompanyName;
	}

	public void setPrevCompanyName(String prevCompanyName) {
		this.prevCompanyName = prevCompanyName;
	}

	public String getId1() {
		return id1;
	}

	public void setId1(String id1) {
		this.id1 = id1;
	}

	public String getPrevEmployeeName() {
		return prevEmployeeName;
	}

	public void setPrevEmployeeName(String prevEmployeeName) {
		this.prevEmployeeName = prevEmployeeName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getWorkedYears() {
		return workedYears;
	}

	public void setWorkedYears(String workedYears) {
		this.workedYears = workedYears;
	}

	public String getPrevFromDate() {
		return prevFromDate;
	}

	public void setPrevFromDate(String prevFromDate) {
		this.prevFromDate = prevFromDate;
	}

	public String getPrevToDate() {
		return prevToDate;
	}

	public void setPrevToDate(String prevToDate) {
		this.prevToDate = prevToDate;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getCtc() {
		return ctc;
	}

	public void setCtc(String ctc) {
		this.ctc = ctc;
	}

	public String getPrevCompanyName1() {
		return prevCompanyName1;
	}

	public void setPrevCompanyName1(String prevCompanyName1) {
		this.prevCompanyName1 = prevCompanyName1;
	}

	public String getId11() {
		return id11;
	}

	public void setId11(String id11) {
		this.id11 = id11;
	}

	public String getPrevEmployeeName1() {
		return prevEmployeeName1;
	}

	public void setPrevEmployeeName1(String prevEmployeeName1) {
		this.prevEmployeeName1 = prevEmployeeName1;
	}

	public String getLocation1() {
		return location1;
	}

	public void setLocation1(String location1) {
		this.location1 = location1;
	}

	public String getWorkedYears1() {
		return workedYears1;
	}

	public void setWorkedYears1(String workedYears1) {
		this.workedYears1 = workedYears1;
	}

	public String getPrevFromDate1() {
		return prevFromDate1;
	}

	public void setPrevFromDate1(String prevFromDate1) {
		this.prevFromDate1 = prevFromDate1;
	}

	public String getPrevToDate1() {
		return prevToDate1;
	}

	public void setPrevToDate1(String prevToDate1) {
		this.prevToDate1 = prevToDate1;
	}

	public String getRole1() {
		return role1;
	}

	public void setRole1(String role1) {
		this.role1 = role1;
	}

	public String getDesignation1() {
		return designation1;
	}

	public void setDesignation1(String designation1) {
		this.designation1 = designation1;
	}

	public String getCtc1() {
		return ctc1;
	}

	public void setCtc1(String ctc1) {
		this.ctc1 = ctc1;
	}

	public String getPrevCompanyName2() {
		return prevCompanyName2;
	}

	public void setPrevCompanyName2(String prevCompanyName2) {
		this.prevCompanyName2 = prevCompanyName2;
	}

	public String getId12() {
		return id12;
	}

	public void setId12(String id12) {
		this.id12 = id12;
	}

	public String getPrevEmployeeName2() {
		return prevEmployeeName2;
	}

	public void setPrevEmployeeName2(String prevEmployeeName2) {
		this.prevEmployeeName2 = prevEmployeeName2;
	}

	public String getLocation2() {
		return location2;
	}

	public void setLocation2(String location2) {
		this.location2 = location2;
	}

	public String getWorkedYears2() {
		return workedYears2;
	}

	public void setWorkedYears2(String workedYears2) {
		this.workedYears2 = workedYears2;
	}

	public String getPrevFromDate2() {
		return prevFromDate2;
	}

	public void setPrevFromDate2(String prevFromDate2) {
		this.prevFromDate2 = prevFromDate2;
	}

	public String getPrevToDate2() {
		return prevToDate2;
	}

	public void setPrevToDate2(String prevToDate2) {
		this.prevToDate2 = prevToDate2;
	}

	public String getRole2() {
		return role2;
	}

	public void setRole2(String role2) {
		this.role2 = role2;
	}

	public String getDesignation2() {
		return designation2;
	}

	public void setDesignation2(String designation2) {
		this.designation2 = designation2;
	}

	public String getCtc2() {
		return ctc2;
	}

	public void setCtc2(String ctc2) {
		this.ctc2 = ctc2;
	}

	@Override
	public String toString() {
		return "Pro [regno=" + regno + ", id=" + id + ", email=" + email + ", expy=" + expy + ", lwd=" + lwd
				+ ", rexpy=" + rexpy + ", immi=" + immi + ", sdate=" + sdate + ", edate=" + edate + ", notice=" + notice
				+ ", domain=" + domain + ", expertise=" + expertise + ", pskills=" + pskills + ", cuctc=" + cuctc
				+ ", expctc=" + expctc + ", link=" + link + ", culocation=" + culocation + ", prelocaion=" + prelocaion
				+ ", languages=" + languages + ", frameworks=" + frameworks + ", tools=" + tools + ", databases1="
				+ databases1 + ", servers=" + servers + ", cloud=" + cloud + ", val5=" + val5 + ", coun=" + coun
				+ ", citi=" + citi + ", onciti=" + onciti + ", onciticli=" + onciticli + ", prevCompanyName="
				+ prevCompanyName + ", id1=" + id1 + ", prevEmployeeName=" + prevEmployeeName + ", location=" + location
				+ ", workedYears=" + workedYears + ", prevFromDate=" + prevFromDate + ", prevToDate=" + prevToDate
				+ ", role=" + role + ", designation=" + designation + ", ctc=" + ctc + ", prevCompanyName1="
				+ prevCompanyName1 + ", id11=" + id11 + ", prevEmployeeName1=" + prevEmployeeName1 + ", location1="
				+ location1 + ", workedYears1=" + workedYears1 + ", prevFromDate1=" + prevFromDate1 + ", prevToDate1="
				+ prevToDate1 + ", role1=" + role1 + ", designation1=" + designation1 + ", ctc1=" + ctc1
				+ ", prevCompanyName2=" + prevCompanyName2 + ", id12=" + id12 + ", prevEmployeeName2="
				+ prevEmployeeName2 + ", location2=" + location2 + ", workedYears2=" + workedYears2 + ", prevFromDate2="
				+ prevFromDate2 + ", prevToDate2=" + prevToDate2 + ", role2=" + role2 + ", designation2=" + designation2
				+ ", ctc2=" + ctc2 + ", getRegno()=" + getRegno() + ", getId()=" + getId() + ", getEmail()="
				+ getEmail() + ", getExpy()=" + getExpy() + ", getLwd()=" + getLwd() + ", getRexpy()=" + getRexpy()
				+ ", getImmi()=" + getImmi() + ", getSdate()=" + getSdate() + ", getEdate()=" + getEdate()
				+ ", getNotice()=" + getNotice() + ", getDomain()=" + getDomain() + ", getExpertise()=" + getExpertise()
				+ ", getPskills()=" + getPskills() + ", getCuctc()=" + getCuctc() + ", getExpctc()=" + getExpctc()
				+ ", getLink()=" + getLink() + ", getCulocation()=" + getCulocation() + ", getPrelocaion()="
				+ getPrelocaion() + ", getLanguages()=" + getLanguages() + ", getFrameworks()=" + getFrameworks()
				+ ", getTools()=" + getTools() + ", getDatabases1()=" + getDatabases1() + ", getServers()="
				+ getServers() + ", getCloud()=" + getCloud() + ", getVal5()=" + getVal5() + ", getCoun()=" + getCoun()
				+ ", getCiti()=" + getCiti() + ", getOnciti()=" + getOnciti() + ", getOnciticli()=" + getOnciticli()
				+ ", getPrevCompanyName()=" + getPrevCompanyName() + ", getId1()=" + getId1()
				+ ", getPrevEmployeeName()=" + getPrevEmployeeName() + ", getLocation()=" + getLocation()
				+ ", getWorkedYears()=" + getWorkedYears() + ", getPrevFromDate()=" + getPrevFromDate()
				+ ", getPrevToDate()=" + getPrevToDate() + ", getRole()=" + getRole() + ", getDesignation()="
				+ getDesignation() + ", getCtc()=" + getCtc() + ", getPrevCompanyName1()=" + getPrevCompanyName1()
				+ ", getId11()=" + getId11() + ", getPrevEmployeeName1()=" + getPrevEmployeeName1()
				+ ", getLocation1()=" + getLocation1() + ", getWorkedYears1()=" + getWorkedYears1()
				+ ", getPrevFromDate1()=" + getPrevFromDate1() + ", getPrevToDate1()=" + getPrevToDate1()
				+ ", getRole1()=" + getRole1() + ", getDesignation1()=" + getDesignation1() + ", getCtc1()=" + getCtc1()
				+ ", getPrevCompanyName2()=" + getPrevCompanyName2() + ", getId12()=" + getId12()
				+ ", getPrevEmployeeName2()=" + getPrevEmployeeName2() + ", getLocation2()=" + getLocation2()
				+ ", getWorkedYears2()=" + getWorkedYears2() + ", getPrevFromDate2()=" + getPrevFromDate2()
				+ ", getPrevToDate2()=" + getPrevToDate2() + ", getRole2()=" + getRole2() + ", getDesignation2()="
				+ getDesignation2() + ", getCtc2()=" + getCtc2() + "]";
	}

}