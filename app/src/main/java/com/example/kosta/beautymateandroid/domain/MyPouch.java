package com.example.kosta.beautymateandroid.domain;

import java.util.List;

public class MyPouch {
	
	private List<Cosmetic> recomandedCosmetics;
	private List<Cosmetic> cosmetics;
	private List<BeautyTip> beautyTips;
	private String customerId;
	
	public MyPouch(){}

	public MyPouch(List<Cosmetic> recomandedCosmetics, List<Cosmetic> cosmetics, List<BeautyTip> beautyTips,
			String customerId) {
		super();
		this.recomandedCosmetics = recomandedCosmetics;
		this.cosmetics = cosmetics;
		this.beautyTips = beautyTips;
		this.customerId = customerId;
	}

	public List<Cosmetic> getRecomandedCosmetics() {
		return recomandedCosmetics;
	}

	public void setRecomandedCosmetics(List<Cosmetic> recomandedCosmetics) {
		this.recomandedCosmetics = recomandedCosmetics;
	}

	public List<Cosmetic> getCosmetics() {
		return cosmetics;
	}

	public void setCosmetics(List<Cosmetic> cosmetics) {
		this.cosmetics = cosmetics;
	}

	public List<BeautyTip> getBeautyTips() {
		return beautyTips;
	}

	public void setBeautyTips(List<BeautyTip> beautyTips) {
		this.beautyTips = beautyTips;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "MyPouch [recomandedCosmetics=" + recomandedCosmetics + ", cosmetics=" + cosmetics + ", beautyTips="
				+ beautyTips + ", customerId=" + customerId + "]";
	}
	
	
	

	

}
