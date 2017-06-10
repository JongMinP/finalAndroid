package com.example.kosta.beautymateandroid.domain;

import java.util.Date;

public class Customer {
	
	private int customerNo;
	private String id;
	private String password;
	private String name;
	private String gender;
	 
	private Date birth;
	private String email;
	private String skinType;
	
	public Customer(){}
	
	public Customer(int customerNo){
		this.customerNo = customerNo;
	}
	
	public Customer(int customerNo, String id, String password, String name, String gender, Date birth, String email,
			String skinType) {
		super();
		this.customerNo = customerNo;
		this.id = id;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.birth = birth;
		this.email = email;
		this.skinType = skinType;
	}

	public int getCustomerNo() {
		return customerNo;
	}

	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSkinType() {
		return skinType;
	}

	public void setSkinType(String skinType) {
		this.skinType = skinType;
	}

	@Override
	public String toString() {
		return "Customer [customerNo=" + customerNo + ", id=" + id + ", password=" + password + ", name=" + name
				+ ", gender=" + gender + ", birth=" + birth + ", email=" + email + ", skinType=" + skinType + "]";
	}
	
	
	

}
