package com.example.kosta.beautymateandroid.domain;

import java.util.List;

public class Cosmetic {
	
	private int cosmeticNo;
	private String cosmeticName;
	private String volume;
	private int cost;
	private String img;
	private String brand;
	private CosmeticCategory category;
	private String ingredients;
	private List<Review> reviews;
	private int averageGrade;
	
	public Cosmetic(){}

	public Cosmetic(int cosmeticNo, String cosmeticName, String volume, int cost, String img, String brand,
			CosmeticCategory category, String ingredients, List<Review> reviews, int averageGrade) {
		super();
		this.cosmeticNo = cosmeticNo;
		this.cosmeticName = cosmeticName;
		this.volume = volume;
		this.cost = cost;
		this.img = img;
		this.brand = brand;
		this.category = category;
		this.ingredients = ingredients;
		this.reviews = reviews;
		this.averageGrade = averageGrade;
	}

	public int getCosmeticNo() {
		return cosmeticNo;
	}

	public void setCosmeticNo(int cosmeticNo) {
		this.cosmeticNo = cosmeticNo;
	}

	public String getCosmeticName() {
		return cosmeticName;
	}

	public void setCosmeticName(String cosmeticName) {
		this.cosmeticName = cosmeticName;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public CosmeticCategory getCategory() {
		return category;
	}

	public void setCategory(CosmeticCategory category) {
		this.category = category;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public int getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(int averageGrade) {
		this.averageGrade = averageGrade;
	}

	@Override
	public String toString() {
		return "Cosmetic [cosmeticNo=" + cosmeticNo + ", cosmeticName=" + cosmeticName + ", volume=" + volume
				+ ", cost=" + cost + ", img=" + img + ", brand=" + brand + ", category=" + category + ", ingredients="
				+ ingredients + ", reviews=" + reviews + ", averageGrade=" + averageGrade + "]";
	}
	
	
	


}
