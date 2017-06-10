package com.example.kosta.beautymateandroid.domain;

public class Report {
	
	private int reportNo;
	private int reportedNo;
	private String reason;
	private Customer reportCustomer;
	private ReportCategory reportCategory;
	
	public Report(){}

	public Report(int reportNo, int reportedNo, String reason, Customer reportCustomer, ReportCategory reportCategory) {
		super();
		this.reportNo = reportNo;
		this.reportedNo = reportedNo;
		this.reason = reason;
		this.reportCustomer = reportCustomer;
		this.reportCategory = reportCategory;
	}

	public int getReportNo() {
		return reportNo;
	}

	public void setReportNo(int reportNo) {
		this.reportNo = reportNo;
	}

	public int getReportedNo() {
		return reportedNo;
	}

	public void setReportedNo(int reportedNo) {
		this.reportedNo = reportedNo;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Customer getReportCustomer() {
		return reportCustomer;
	}

	public void setReportCustomer(Customer reportCustomer) {
		this.reportCustomer = reportCustomer;
	}

	public ReportCategory getReportCategory() {
		return reportCategory;
	}

	public void setReportCategory(ReportCategory reportCategory) {
		this.reportCategory = reportCategory;
	}

	@Override
	public String toString() {
		return "Report [reportNo=" + reportNo + ", reportedNo=" + reportedNo + ", reason=" + reason
				+ ", reportCustomer=" + reportCustomer + ", reportCategory=" + reportCategory + "]";
	}
	
	
	
	

}
