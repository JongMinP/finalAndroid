package com.example.kosta.beautymateandroid.domain;

public class Pager {

	protected int page; // 페이지 개수
	protected int perPageNum; // 몇개씩 보여줄지
	protected int pagStart;
	protected int pagEnd;

	public Pager() {
		this.page = 1; // 초기값
		this.perPageNum = 10; // 10개씩 보여주기
		this.pagStart = 1;
		this.pagEnd = 10;
	}

	public void setPagStart(int pagStart) {
		this.pagStart = pagStart;
	}

	public void setPagEnd(int pagEnd) {
		this.pagEnd = pagEnd;
	}

	public int getPage() {
		return page;
	}

	public int getPagStart() {
		return pagStart;
	}

	public int getPagEnd() {
		return pagEnd;
	}

	public void setPage(int page) {

		if (page <= 0) {
			this.page = 1; // 0보다 작은값 나올 경우 1로
			return;
		}

		pagStart = page * 10 - 9;
		pagEnd = page * 10;

		this.page = page;
	}

	// mybatis sql mapper
	public int getPerPageNum() {

		return this.perPageNum;
	}

	public void setPerPageNum(int perPageNum) {

		if (perPageNum <= 0 || perPageNum > 100) {
			this.perPageNum = 10; // 10으로 고정
			return;
		}

		this.perPageNum = perPageNum;
	}

	// mybatis sql mapper
	public int getPageStart() {

		return (this.page - 1) * perPageNum;
	}

	@Override
	public String toString() {
		return "pager [page=" + page + ", perPageNum=" + perPageNum + "]";
	}

}
