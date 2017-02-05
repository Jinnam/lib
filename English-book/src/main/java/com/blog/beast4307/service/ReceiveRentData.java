package com.blog.beast4307.service;

public class ReceiveRentData {
	private String memberId;			//회원 아이디
	private int bookCode;				//도서 코드
	private String rentalStartDay;		//대여 시작일
	private String rentalFinishDay;		//대여 종료일
	private int paymentPrice;			//결제금액
	private int totalPrice;				//받은금액
	private int paymentCode;			//결제코드
	private int rentalDays;				//빌려간 기간
	
	public int getPaymentCode() {
		return paymentCode;
	}
	public void setPaymentCode(int paymentCode) {
		this.paymentCode = paymentCode;
	}
	public int getRentalDays() {
		return rentalDays;
	}
	public void setRentalDays(int rentalDays) {
		this.rentalDays = rentalDays;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public int getBookCode() {
		return bookCode;
	}
	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}
	public String getRentalStartDay() {
		return rentalStartDay;
	}
	public void setRentalStartDay(String rentalStartDay) {
		this.rentalStartDay = rentalStartDay;
	}
	public String getRentalFinishDay() {
		return rentalFinishDay;
	}
	public void setRentalFinishDay(String rentalFinishDay) {
		this.rentalFinishDay = rentalFinishDay;
	}
	public int getPaymentPrice() {
		return paymentPrice;
	}
	public void setPaymentPrice(int paymentPrice) {
		this.paymentPrice = paymentPrice;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "ReceiveRentData [memberId=" + memberId + ", bookCode=" + bookCode + ", rentalStartDay=" + rentalStartDay
				+ ", rentalFinishDay=" + rentalFinishDay + ", paymentPrice=" + paymentPrice + ", totalPrice="
				+ totalPrice + ", paymentCode=" + paymentCode + ", rentalDays=" + rentalDays + "]";
	}
	
	
}
