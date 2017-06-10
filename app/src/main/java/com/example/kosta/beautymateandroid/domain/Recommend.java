package com.example.kosta.beautymateandroid.domain;

public class Recommend {
	
	private int recommendNo;
	private int cosmeticNo;
	private int grade;
	private int customerNo;
	
	
	public Recommend(){}


	public Recommend(int recommendNo, int cosmeticNo, int grade, int customerNo) {
		super();
		this.recommendNo = recommendNo;
		this.cosmeticNo = cosmeticNo;
		this.grade = grade;
		this.customerNo = customerNo;
	}


	public int getRecommendNo() {
		return recommendNo;
	}


	public void setRecommendNo(int recommendNo) {
		this.recommendNo = recommendNo;
	}


	public int getCosmeticNo() {
		return cosmeticNo;
	}


	public void setCosmeticNo(int cosmeticNo) {
		this.cosmeticNo = cosmeticNo;
	}


	public int getGrade() {
		return grade;
	}


	public void setGrade(int grade) {
		this.grade = grade;
	}


	public int getCustomerNo() {
		return customerNo;
	}


	public void setCustomerNo(int customerNo) {
		this.customerNo = customerNo;
	}


	@Override
	public String toString() {
		return "Recommend [recommendNo=" + recommendNo + ", cosmeticNo=" + cosmeticNo + ", grade=" + grade
				+ ", customerNo=" + customerNo + "]";
	}
	
	
	
	
	
	

}
