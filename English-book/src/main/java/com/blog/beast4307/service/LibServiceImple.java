package com.blog.beast4307.service;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibServiceImple implements LibService {

	@Autowired
	private LibDao dao;
	
	//회원가입
	@Override
	public int insertMember(Member member) {
		//전화번호 입력 : 세개의 입력폼으로 받은 번호를 하나로 합침
		member.setMemberPhone(member.getPhone1()+member.getPhone2()+member.getPhone3());
		//회비 납부 여부 : 가입하면 N으로 초기화 하고 입금 확인 후 Y로 변경
		member.setMemberPaymentStatus('N');
		//대여횟수 : 가입시 0으로 초기화
		member.setRentalCount(0);
		return dao.insertMember(member);
	}
	
	//도서관등록
	@Override
	public int insertLib(Lib lib) {

		return dao.insertLib(lib);
	}
	
	//도서 추가
	@Override
	public int insertBook(Books books) {
		//도서관 코드 추가->세션 추가 후 수정할것
		books.setLibCode(0001);
		//대출가능여부 설정 : 도서등록 하면 바로 빌릴수 있음
		books.setCurrentStatus("Y");
		//대여횟수 : 처음 등록이기에 0으로 초기화
		books.setRentalCount(0);
		//대여날짜 : 처음 등록이기에 0으로 초기화
		books.setRentalDays(0);
		
		return dao.insertBook(books);
	}

	//멤버 목록(비승인)가져오기
	@Override
	public List<Member> selectMember() {
		List<Member> list =dao.selectMember();
		for(int i=0;i<list.size();i++){
			Member member=list.get(i);
			member.setPhone1(member.getMemberPhone().substring(0, 3));
			member.setPhone2(member.getMemberPhone().substring(3, 7));
			member.setPhone3(member.getMemberPhone().substring(7, 11));
		}
		return list;
	}

	//회원 상태 업데이트(회비 확인 후 승인)
	@Override
	public int updatePayMember(String[] memberId) {
		int result=0;
		for(int i=0;i<memberId.length;i++){
			result=dao.updatePayMember(memberId[i]);
		}
		
		return result;
	}

	//도서관 목록 가져오기
	@Override
	public List<Lib> selectLibrary() {
		// TODO Auto-generated method stub
		return dao.selectLib();
	}
	
	//Admin 정보가져오기 & 아이디 비번체크
	@Override
	public Admin selectAdmin(Admin admin) {
		logger.info(admin.toString());
		Admin returnAdmin = new Admin();
		//입력 아이디 비번
		String loginId = admin.getAdminId();
		String loginPw = admin.getAdminPw();
		System.out.println("입력 아이디 : "+ loginId+"입력 비번: "+loginPw);
		//db에서 가져오기
		Admin getAdmin = dao.selectAdmin(loginId);
		String dbId = getAdmin.getAdminId();
		String dbPw = getAdmin.getAdminPw();
		int libCode = getAdmin.getLibCode();
		logger.info(getAdmin.toString());
		if(dbId.equals(loginId)){
			if(dbPw.equals(loginPw)){
				//아이디 비번 같으면 리턴할 변수에 admin정보 셋팅
				returnAdmin.setAdminId(dbId);
				returnAdmin.setLibCode(libCode);
				returnAdmin.setResult(1);
			}else{
				returnAdmin.setResult(2);
			}
		}else{
			returnAdmin.setResult(3);
		}

		return returnAdmin;
	}
	//rent 멤버 정보 가져오기
	@Override
	public Member rentMemberSelect(String memberId) {
		// TODO Auto-generated method stub
		return dao.rentMemberSelect(memberId);
	}
	//rent 도서 정보 가져오기
	@Override
	public Books rentBookSelect(int bookCode) {
		
		Books returnBooks = dao.rentBookSelect(bookCode);
		//대여시작일 : 현재의 날짜
		int nYear;
		int nMonth;
		int nDay;
		Calendar calendar = new GregorianCalendar(Locale.KOREA);
			nYear = calendar.get(Calendar.YEAR);
		    nMonth = calendar.get(Calendar.MONTH) + 1;
		    nDay = calendar.get(Calendar.DAY_OF_MONTH);
		    String nowDate = nYear+"-"+nMonth+"-"+nDay;
		    
		    returnBooks.setRentalStartDay(nowDate);
		    
		//대여 종료일 : 현재 날짜 +3
			calendar.add(Calendar.DAY_OF_MONTH, 3);
			nYear = calendar.get(Calendar.YEAR);
			nMonth = calendar.get(Calendar.MONTH) + 1;
			nDay = calendar.get(Calendar.DAY_OF_MONTH);
			String finishDate = nYear+"-"+nMonth+"-"+nDay;
			
		returnBooks.setRentalFinishDay(finishDate);
		
		return returnBooks;
	}
	//도서 폐기 등록
	@Override
	public int discardInsert(Books books) {
		// TODO Auto-generated method stub
		return dao.discardInsert(books);
	}
	
	//도서 폐기 후 도서 업데이트
	@Override
	public int bookStatusUpdate(int bookCode) {
		// TODO Auto-generated method stub
		return dao.bookStatusUpdate(bookCode);
	}

	//회원/비회원 가격정보 가져오기
	@Override
	public Cost costSelect() {
		// TODO Auto-generated method stub
		return dao.costSelect();
	}

	//대여정보 등록
	@Override
	public int rentalInsert(ReceiveRentData receiveRentData) {
		Rental rental= new Rental();
		rental.setBookCode(receiveRentData.getBookCode());
		rental.setMemberId(receiveRentData.getMemberId());
		rental.setRentalStartDay(receiveRentData.getRentalStartDay());
		rental.setReturnExpectDay(receiveRentData.getRentalFinishDay());
		rental.setReturnStatus("N");
		logger.info("rental"+rental.toString());
		return dao.rentalInsert(rental);
	}

	//결제정보 등록
	@Override
	public int paymentInsert(ReceiveRentData receiveRentData) {
		Payment payment = new Payment();
		payment.setMemberId(receiveRentData.getMemberId());
		payment.setPaymentPrice(receiveRentData.getPaymentPrice());
		if(receiveRentData.getPaymentPrice()==0){
			payment.setPaymentStatus("N");
		}else{
			payment.setPaymentStatus("Y");
		}
//		payment.setRentalCode(dao.rentalCodeSelect());
		logger.info("payment"+payment.toString());
		return dao.paymentInsert(payment);
	}

}