package com.blog.beast4307.service;

public class Payment {
	private int paymentCode;
	private int rentalCode;
	private String memberId;
	private String paymentDay;
	private int paymentPrice;
	private char paymentStatus;
	
	public int getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(int paymentCode) {
		this.paymentCode = paymentCode;
	}
	public int getRentalCode() {
		return rentalCode;
	}
	public void setRentalCode(int rentalCode) {
		this.rentalCode = rentalCode;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getPaymentDay() {
		return paymentDay;
	}
	public void setPaymentDay(String paymentDay) {
		this.paymentDay = paymentDay;
	}
	public int getPaymentPrice() {
		return paymentPrice;
	}
	public void setPaymentPrice(int paymentPrice) {
		this.paymentPrice = paymentPrice;
	}
	public char getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(char paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "Payment [paymentCode=" + paymentCode + ", rentalCode=" + rentalCode + ", memberId=" + memberId
				+ ", paymentDay=" + paymentDay + ", paymentPrice=" + paymentPrice + ", paymentStatus=" + paymentStatus
				+ "]";
	}
	
	
	
	
}
