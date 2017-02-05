package com.blog.beast4307.service;

public class Rental {
	private int rentalCode;
	private int bookCode;
	private String memberId;
	private String rentalStartDay;
	private String returnExpectDay;
	private String returnDay;
	private String returnStatus;
	
	public int getRentalCode() {
		return rentalCode;
	}
	public void setRentalCode(int rentalCode) {
		this.rentalCode = rentalCode;
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
		return "Rental [rentalCode=" + rentalCode + ", bookCode=" + bookCode + ", memberId=" + memberId
				+ ", rentalStartDay=" + rentalStartDay + ", returnExpectDay=" + returnExpectDay + ", returnDay="
				+ returnDay + ", returnStatus=" + returnStatus + "]";
	}
	
	
}	
