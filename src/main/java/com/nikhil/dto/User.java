package com.nikhil.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int uid;
	private String name;
	private String address;
	private BigDecimal phone;
	private Date dob;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User( String name, String address, BigDecimal phone, Date dob) {
		
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.dob = dob;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public BigDecimal getPhone() {
		return phone;
	}
	public void setPhone(BigDecimal phone) {
		this.phone = phone;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	
	
	

}
