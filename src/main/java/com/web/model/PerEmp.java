package com.web.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PerEmp")
public class PerEmp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long regno;
	private String email;

	private String adhar;

	private String pan;
	private String val1;

	private String status1;
	private String passportnumber;
	private String exp1;

	private String val2;

	private String status2;
	private String visanumber;
	private String exp2;

	private String gender;
	private String date;
	private String adress;
	private String city;
	private String state;
	private String pinnumber;

	public PerEmp() {

	}

	public Long getRegno() {
		return regno;
	}

	public void setRegno(Long regno) {
		this.regno = regno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdhar() {
		return adhar;
	}

	public void setAdhar(String adhar) {
		this.adhar = adhar;
	}

	public String getPan() {
		return pan;
	}

	public void setPan(String pan) {
		this.pan = pan;
	}

	public String getVal1() {
		return val1;
	}

	public void setVal1(String val1) {
		this.val1 = val1;
	}

	public String getStatus1() {
		return status1;
	}

	public void setStatus1(String status1) {
		this.status1 = status1;
	}

	public String getPassportnumber() {
		return passportnumber;
	}

	public void setPassportnumber(String passportnumber) {
		this.passportnumber = passportnumber;
	}

	public String getExp1() {
		return exp1;
	}

	public void setExp1(String exp1) {
		this.exp1 = exp1;
	}

	public String getVal2() {
		return val2;
	}

	public void setVal2(String val2) {
		this.val2 = val2;
	}

	public String getStatus2() {
		return status2;
	}

	public void setStatus2(String status2) {
		this.status2 = status2;
	}

	public String getVisanumber() {
		return visanumber;
	}

	public void setVisanumber(String visanumber) {
		this.visanumber = visanumber;
	}

	public String getExp2() {
		return exp2;
	}

	public void setExp2(String exp2) {
		this.exp2 = exp2;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPinnumber() {
		return pinnumber;
	}

	public void setPinnumber(String pinnumber) {
		this.pinnumber = pinnumber;
	}

	@Override
	public String toString() {
		return "PerEmp [regno=" + regno + ", email=" + email + ", adhar=" + adhar + ", pan=" + pan + ", val1=" + val1
				+ ", status1=" + status1 + ", passportnumber=" + passportnumber + ", exp1=" + exp1 + ", val2=" + val2
				+ ", status2=" + status2 + ", visanumber=" + visanumber + ", exp2=" + exp2 + ", gender=" + gender
				+ ", date=" + date + ", adress=" + adress + ", city=" + city + ", state=" + state + ", pinnumber="
				+ pinnumber + ", getRegno()=" + getRegno() + ", getEmail()=" + getEmail() + ", getAdhar()=" + getAdhar()
				+ ", getPan()=" + getPan() + ", getVal1()=" + getVal1() + ", getStatus1()=" + getStatus1()
				+ ", getPassportnumber()=" + getPassportnumber() + ", getExp1()=" + getExp1() + ", getVal2()="
				+ getVal2() + ", getStatus2()=" + getStatus2() + ", getVisanumber()=" + getVisanumber() + ", getExp2()="
				+ getExp2() + ", getGender()=" + getGender() + ", getDate()=" + getDate() + ", getAdress()="
				+ getAdress() + ", getCity()=" + getCity() + ", getState()=" + getState() + ", getPinnumber()="
				+ getPinnumber() + "]";
	}

}