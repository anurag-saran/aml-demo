package com.redhat.aml.model;

// Generated Aug 2, 2015 9:10:48 PM by Hibernate Tools 4.3.1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Accountdetails generated by hbm2java
 */
@Entity
//@Table(name = "accountdetails", catalog = "AMLDB")
@Table(name = "accountdetails")
public class AccountDB implements java.io.Serializable {

	private int accountNo;
	private String firstname;
	private String lastname;
	private String street;
	private String city;
	private String state;
	private long zipcode;
	private String occupation;
	private int age;
	private String sex;
	private String marritialstatus;
	private String accounttype;

	public AccountDB() {
	}

	public AccountDB(int accountNo, String firstname, String lastname,
			String street, String city, String state, long zipcode,
			String occupation, int age, String sex, String marritialstatus,
			String accounttype) {
		this.accountNo = accountNo;
		this.firstname = firstname;
		this.lastname = lastname;
		this.street = street;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.occupation = occupation;
		this.age = age;
		this.sex = sex;
		this.marritialstatus = marritialstatus;
		this.accounttype = accounttype;
	}

	@Id
	@Column(name = "accountNo", unique = true, nullable = false)
	public int getAccountNo() {
		return this.accountNo;
	}

	public void setAccountNo(int accountNo) {
		this.accountNo = accountNo;
	}

	@Column(name = "firstname", nullable = false, length = 100)
	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	@Column(name = "lastname", nullable = false, length = 100)
	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Column(name = "street", nullable = false, length = 100)
	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name = "city", nullable = false, length = 100)
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "state", nullable = false, length = 100)
	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name = "zipcode", nullable = false)
	public long getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(long zipcode) {
		this.zipcode = zipcode;
	}

	@Column(name = "occupation", nullable = false, length = 100)
	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Column(name = "age", nullable = false)
	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Column(name = "sex", nullable = false, length = 100)
	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	@Column(name = "marritialstatus", nullable = false, length = 100)
	public String getMarritialstatus() {
		return this.marritialstatus;
	}

	public void setMarritialstatus(String marritialstatus) {
		this.marritialstatus = marritialstatus;
	}

	@Column(name = "accounttype", nullable = false, length = 100)
	public String getAccounttype() {
		return this.accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

}
