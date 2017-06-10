package com.example.kosta.beautymateandroid.domain;

import java.util.List;

public class SkinType {
	
	private String baumanType;
	private String explanation;
	private String recommendedIngredient;
	private String bannedIngredient;
	private String recommendedFood;
	private String habit;
	private List<Cosmetic> recommendedCosmetics;
	
	public SkinType(){}


	public String getBaumanType() {
		return baumanType;
	}

	public void setBaumanType(String basicNameValuePair) {
		this.baumanType = basicNameValuePair;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public String getRecommendedIngredient() {
		return recommendedIngredient;
	}

	public void setRecommendedIngredient(String recommendedIngredient) {
		this.recommendedIngredient = recommendedIngredient;
	}

	public String getBannedIngredient() {
		return bannedIngredient;
	}

	public void setBannedIngredient(String bannedIngredient) {
		this.bannedIngredient = bannedIngredient;
	}

	public String getRecommendedFood() {
		return recommendedFood;
	}

	public void setRecommendedFood(String recommendedFood) {
		this.recommendedFood = recommendedFood;
	}

	public String getHabit() {
		return habit;
	}

	public void setHabit(String habit) {
		this.habit = habit;
	}

	public List<Cosmetic> getRecommendedCosmetics() {
		return recommendedCosmetics;
	}

	public void setRecommendedCosmetics(List<Cosmetic> recommendedCosmetics) {
		this.recommendedCosmetics = recommendedCosmetics;
	}

	public SkinType(String baumanType, String explanation, String recommendedIngredient, String bannedIngredient,
			String recommendedFood, String habit, List<Cosmetic> recommendedCosmetics) {
		super();
		this.baumanType = baumanType;
		this.explanation = explanation;
		this.recommendedIngredient = recommendedIngredient;
		this.bannedIngredient = bannedIngredient;
		this.recommendedFood = recommendedFood;
		this.habit = habit;
		this.recommendedCosmetics = recommendedCosmetics;
	}

	@Override
	public String toString() {
		return "SkinType [baumanType=" + baumanType + ", explanation=" + explanation + ", recommendedIngredient="
				+ recommendedIngredient + ", bannedIngredient=" + bannedIngredient + ", recommendedFood="
				+ recommendedFood + ", habit=" + habit + ", recommendedCosmetics=" + recommendedCosmetics + "]";
	}
}
