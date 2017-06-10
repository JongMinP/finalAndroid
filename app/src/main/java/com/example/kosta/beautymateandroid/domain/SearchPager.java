package com.example.kosta.beautymateandroid.domain;

public class SearchPager extends Pager {

	private String searchType;
	private String keyword;

	public String getSearchType() {
		return searchType;
	}

	public void setSearchType(String searchType) {
		this.searchType = searchType;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	@Override
	public String toString() {
		return "SearchPager [searchType=" + searchType + ", keyword=" + keyword + ", page=" + page + ", perPageNum="
				+ perPageNum + ", pagStart=" + pagStart + ", pagEnd=" + pagEnd + "]";
	}

}
