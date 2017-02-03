package com.blog.beast4307.service;

public class Rental {
	private int retalCode;
	private int bookCode;
	private String memberId;
	private String rentalStartDay;
	private String returnExpectDay;
	private String returnDay;
	private String returnStatus;
	public int getRetalCode() {
		return retalCode;
	}
	public void setRetalCode(int retalCode) {
		this.retalCode = retalCode;
	}
	public int getBookCode() {
		return bookCode;
	}
	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getRentalStartDay() {
		return rentalStartDay;
	}
	public void setRentalStartDay(String rentalStartDay) {
		this.rentalStartDay = rentalStartDay;
	}
	public String getReturnExpectDay() {
		return returnExpectDay;
	}
	public void setReturnExpectDay(String returnExpectDay) {
		this.returnExpectDay = returnExpectDay;
	}
	public String getReturnDay() {
		return returnDay;
	}
	public void setReturnDay(String returnDay) {
		this.returnDay = returnDay;
	}
	public String getReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}
	@Override
	public String toString() {
		return "Rental [retalCode=" + retalCode + ", bookCode=" + bookCode + ", memberId=" + memberId
				+ ", rentalStartDay=" + rentalStartDay + ", returnExpectDay=" + returnExpectDay + ", returnDay="
				+ returnDay + ", returnStatus=" + returnStatus + "]";
	}
	
	
}	
