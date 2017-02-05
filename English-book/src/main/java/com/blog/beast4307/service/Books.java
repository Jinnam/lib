package com.blog.beast4307.service;

public class Books {
	private int bookCode;					//도서코드
	private int libCode;					//도서관코드
	private String bookName;				//도서이름
	private String writer;					//저자
	private String publisher;				//출판사
	private String category;				//카테고리
	private String genre;					//장르
	private String bookLocation;			//책 위치
	private String currentStatus;			//도서 상태(N/Y)
	private String firstRentalDay;			//처음 대여한날
	private int rentalCount;				//대여 카운트
	private int rentalDays;					//대여 날짜 카운트
	private String rentalStartDay;			//대여시작일
	private String returnExpectDay;			//반납 예정일
	
	private String discardReason;			//폐기 이유
	private String discardRegistrationDate;	//폐기 날짜

	
	
	
	public String getDiscardRegistrationDate() {
		return discardRegistrationDate;
	}
	public void setDiscardRegistrationDate(String discardRegistrationDate) {
		this.discardRegistrationDate = discardRegistrationDate;
	}
	public String getDiscardReason() {
		return discardReason;
	}
	public void setDiscardReason(String discardReason) {
		this.discardReason = discardReason;
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
	public int getBookCode() {
		return bookCode;
	}
	public void setBookCode(int bookCode) {
		this.bookCode = bookCode;
	}
	public int getLibCode() {
		return libCode;
	}
	public void setLibCode(int libCode) {
		this.libCode = libCode;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getBookLocation() {
		return bookLocation;
	}
	public void setBookLocation(String bookLocation) {
		this.bookLocation = bookLocation;
	}
	public String getCurrentStatus() {
		return currentStatus;
	}
	public void setCurrentStatus(String currentStatus) {
		this.currentStatus = currentStatus;
	}
	public String getFirstRentalDay() {
		return firstRentalDay;
	}
	public void setFirstRentalDay(String firstRentalDay) {
		this.firstRentalDay = firstRentalDay;
	}
	public int getRentalCount() {
		return rentalCount;
	}
	public void setRentalCount(int rentalCount) {
		this.rentalCount = rentalCount;
	}
	public int getRentalDays() {
		return rentalDays;
	}
	public void setRentalDays(int rentalDays) {
		this.rentalDays = rentalDays;
	}
	@Override
	public String toString() {
		return "Books [bookCode=" + bookCode + ", libCode=" + libCode + ", bookName=" + bookName + ", writer=" + writer
				+ ", publisher=" + publisher + ", category=" + category + ", genre=" + genre + ", bookLocation="
				+ bookLocation + ", currentStatus=" + currentStatus + ", firstRentalDay=" + firstRentalDay
				+ ", rentalCount=" + rentalCount + ", rentalDays=" + rentalDays + ", rentalStartDay=" + rentalStartDay
				+ ", returnExpectDay=" + returnExpectDay + ", discardReason=" + discardReason
				+ ", discardRegistrationDate=" + discardRegistrationDate + "]";
	}

	
	
	
	
}
