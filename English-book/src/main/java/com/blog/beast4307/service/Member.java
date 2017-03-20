package com.blog.beast4307.service;

public class Member {
	private String memberId;
	private String memberPw;
	private String memberName;
	private int memberBirthDay;
	private String memberPhone;
	private String phone1;
	private String phone2;
	private String phone3;
	private int postNum;
	private String memberAddr;
	private String memberAddr2;
	private String joinDay;
	private int libCode;
	private int rentalCount;
	private char memberPaymentStatus;
	
	
	public int getPostNum() {
		return postNum;
	}
	public void setPostNum(int postNum) {
		this.postNum = postNum;
	}
	public String getMemberAddr2() {
		return memberAddr2;
	}
	public void setMemberAddr2(String memberAddr2) {
		this.memberAddr2 = memberAddr2;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPw() {
		return memberPw;
	}
	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public int getMemberBirthDay() {
		return memberBirthDay;
	}
	public void setMemberBirthDay(int memberBirthDay) {
		this.memberBirthDay = memberBirthDay;
	}
	public String getMemberPhone() {
		return memberPhone;
	}
	public void setMemberPhone(String memberPhone) {
		this.memberPhone = memberPhone;
	}
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public String getMemberAddr() {
		return memberAddr;
	}
	public void setMemberAddr(String memberAddr) {
		this.memberAddr = memberAddr;
	}
	public String getJoinDay() {
		return joinDay;
	}
	public void setJoinDay(String joinDay) {
		this.joinDay = joinDay;
	}
	public int getLibCode() {
		return libCode;
	}
	public void setLibCode(int libCode) {
		this.libCode = libCode;
	}
	public int getRentalCount() {
		return rentalCount;
	}
	public void setRentalCount(int rentalCount) {
		this.rentalCount = rentalCount;
	}
	public char getMemberPaymentStatus() {
		return memberPaymentStatus;
	}
	public void setMemberPaymentStatus(char memberPaymentStatus) {
		this.memberPaymentStatus = memberPaymentStatus;
	}
	@Override
	public String toString() {
		return "Member [memberId=" + memberId + ", memberPw=" + memberPw + ", memberName=" + memberName
				+ ", memberBirthDay=" + memberBirthDay + ", memberPhone=" + memberPhone + ", phone1=" + phone1
				+ ", phone2=" + phone2 + ", phone3=" + phone3 + ", postNum=" + postNum + ", memberAddr=" + memberAddr
				+ ", memberAddr2=" + memberAddr2 + ", joinDay=" + joinDay + ", libCode=" + libCode + ", rentalCount="
				+ rentalCount + ", memberPaymentStatus=" + memberPaymentStatus + "]";
	}
	
	
}
