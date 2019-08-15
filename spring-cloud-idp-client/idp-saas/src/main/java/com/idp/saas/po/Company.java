package com.idp.saas.po;

import java.util.Date;

public class Company {
	private Integer id;

	private String name;

	private Date registerDay;

	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name == null ? null : name.trim();
	}

	public Date getRegisterDay() {
		return registerDay;
	}

	public void setRegisterDay(Date registerDay) {
		this.registerDay = registerDay;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}
}