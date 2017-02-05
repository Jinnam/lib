package com.blog.beast4307.service;

public class ReceiveRentData {
	private String memberId;			//ȸ�� ���̵�
	private int bookCode;				//���� �ڵ�
	private String rentalStartDay;		//�뿩 ������
	private String rentalFinishDay;		//�뿩 ������
	private int paymentPrice;			//�����ݾ�
	private int totalPrice;				//�����ݾ�
	private int paymentCode;			//�����ڵ�
	private int rentalDays;				//������ �Ⱓ
	
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
