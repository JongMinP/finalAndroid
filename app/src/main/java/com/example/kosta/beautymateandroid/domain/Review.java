package com.example.kosta.beautymateandroid.domain;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

public class Review implements Serializable{

	private int reviewNo;
	private String reviewTitle;
	private String reviewContent;
	private String image;
	private List<Reply> replys;
	private Customer customer;
	private Cosmetic cosmetic;
	private Recommend recommend;
	private Integer listCount; // 전체개수를 알아오기 위해
//	private Date regdate;
	
	private String[] files;
	
	
	
//	public Date getRegdate() {
//		return regdate;
//	}
//
//	public void setRegdate(Date regdate) {
//		this.regdate = regdate;
//	}

	public String[] getFiles() {
		return files;
	}

	public void setFiles(String[] files) {
		this.files = files;
	}

	public void setListCount(Integer listCount) {
		this.listCount = listCount;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}

	public Review() {
	}

	public Review(int reviewNo, String reviewTitle, String reviewContent, String image, List<Reply> replys,
			Customer customer, Cosmetic cosmetic, Recommend recommend) {
		super();
		this.reviewNo = reviewNo;
		this.reviewTitle = reviewTitle;
		this.reviewContent = reviewContent;
		this.image = image;
		this.replys = replys;
		this.customer = customer;
		this.cosmetic = cosmetic;
		this.recommend = recommend;
	}

	public int getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(int reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getReviewTitle() {
		return reviewTitle;
	}

	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Reply> getReplys() {
		return replys;
	}

	public void setReplys(List<Reply> replys) {
		this.replys = replys;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Cosmetic getCosmetic() {
		return cosmetic;
	}

	public void setCosmetic(Cosmetic cosmetic) {
		this.cosmetic = cosmetic;
	}

	public Recommend getRecommend() {
		return recommend;
	}

	public void setRecommend(Recommend recommend) {
		this.recommend = recommend;
	}

	@Override
	public String toString() {
		return "Review [reviewNo=" + reviewNo + ", reviewTitle=" + reviewTitle + ", reviewContent=" + reviewContent
				+ ", image=" + image + ", replys=" + replys + ", customer=" + customer + ", cosmetic=" + cosmetic
				+ ", recommend=" + recommend + ", listCount=" + listCount + ", files=" + Arrays.toString(files) + "]";
	}

//	@Override
//	public String toString() {
//		return "Review [reviewNo=" + reviewNo + ", reviewTitle=" + reviewTitle + ", reviewContent=" + reviewContent
//				+ ", image=" + image + ", replys=" + replys + ", customer=" + customer + ", cosmetic=" + cosmetic
//				+ ", recommend=" + recommend + ", listCount=" + listCount + ", regdate=" + regdate + ", files="
//				+ Arrays.toString(files) + "]";
//	}
	

	

}
