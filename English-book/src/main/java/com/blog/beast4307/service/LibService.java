package com.blog.beast4307.service;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface LibService {
	static final Logger logger = LoggerFactory.getLogger(LibService.class);
	//결재후 books 업데이트
	int returnBookUpdate(ReceiveRentData receiveRentData);	
	//결재 후 payment/rental 업데이트 
	int payRentUpdate(int paymentCode);
	//반납 결제정보가져오기
	Payment returnPaymentSelect(int bookCode);	
	//반납 도서정보가져오기
	Books returnBookSelect(int bookCode) throws ParseException;
	//대여정보 등록
	int rentalInsert(ReceiveRentData receiveRentData);
	//결제정보 등록
	int paymentInsert(ReceiveRentData receiveRentData);
	//결제정보(금액)가져오기
	Cost costSelect();
	//도서 폐기 등록
	int discardInsert(Books books);
	//도서폐기 후 도서 상태 업데이트
	int bookStatusUpdate(int bookCode);
	//rent 도서정보 가져오기
	Books rentBookSelect(int bookCode);
	//rent 회원정보 가져오기
	Member rentMemberSelect(String memberId);
	//Admin정보 가져오기 && 아이디 비번체크
	Admin selectAdmin(Admin admin);
	//회원가입
	int insertMember(Member member);
	//도서관 등록
	int insertLib(Lib lib);
	//도서 등록
	int insertBook(Books book);
	//회원 목록
	List<Member> selectMember();
	//회원 목록 업데이트(회비 냄)
	int updatePayMember(String[] memberId);
	//도서관 목록 가져오기
	List<Lib> selectLibrary();
}