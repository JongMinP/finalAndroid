package com.example.kosta.beautymateandroid.domain;

import java.util.List;

public class BeautyTip {
	
	private int beautyTipNo;
	private String beautyTipTitle;
	private String image;
	private String beautyTipContent;
	private String video;
	private Customer customer;
	private BeautyTipCategory category;
	private List<Reply> beautyTipReplys;
	
	public BeautyTip(){}
	
	public BeautyTip(int beautyTipNo, String beautyTipTitle, String image, String beautyTipContent, String video,
			Customer customer, BeautyTipCategory category, List<Reply> beautyTipReplys) {
		super();
		this.beautyTipNo = beautyTipNo;
		this.beautyTipTitle = beautyTipTitle;
		this.image = image;
		this.beautyTipContent = beautyTipContent;
		this.video = video;
		this.customer = customer;
		this.category = category;
		this.beautyTipReplys = beautyTipReplys;
	}
	
	public int getBeautyTipNo() {
		return beautyTipNo;
	}

	public void setBeautyTipNo(int beautyTipNo) {
		this.beautyTipNo = beautyTipNo;
	}

	public String getBeautyTipTitle() {
		return beautyTipTitle;
	}

	public void setBeautyTipTitle(String beautyTipTitle) {
		this.beautyTipTitle = beautyTipTitle;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getBeautyTipContent() {
		return beautyTipContent;
	}

	public void setBeautyTipContent(String beautyTipContent) {
		this.beautyTipContent = beautyTipContent;
	}

	public String getVideo() {
		return video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public BeautyTipCategory getCategory() {
		return category;
	}

	public void setCategory(BeautyTipCategory category) {
		this.category = category;
	}

	public List<Reply> getBeautyTipReplys() {
		return beautyTipReplys;
	}

	public void setBeautyTipReplys(List<Reply> beautyTipReplys) {
		this.beautyTipReplys = beautyTipReplys;
	}

	@Override
	public String toString() {
		return "BeautyTip [beautyTipNo=" + beautyTipNo + ", beautyTipTitle=" + beautyTipTitle + ", image=" + image
				+ ", beautyTipContent=" + beautyTipContent + ", video=" + video + ", customer=" + customer
				+ ", category=" + category + ", beautyTipReplys=" + beautyTipReplys + "]";
	}
	
	
	
	
	
	

}
