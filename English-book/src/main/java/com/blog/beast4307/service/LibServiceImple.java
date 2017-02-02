package com.blog.beast4307.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitterReturnValueHandler;

import com.sun.org.apache.bcel.internal.generic.ReturnaddressType;

@Service
public class LibServiceImple implements LibService {

	@Autowired
	private LibDao dao;
	
	//회원가입
	@Override
	public int insertMember(Member member) {
		//전화번호 입력 : 세개의 입력폼으로 받은 번호를 하나로 합침
		member.setMEMBERPHONE(member.getPHONE1()+member.getPHONE2()+member.getPHONE3());
		//회비 납부 여부 : 가입하면 N으로 초기화 하고 입금 확인 후 Y로 변경
		member.setMEMBERPAYMENTSTATUS('N');
		//대여횟수 : 가입시 0으로 초기화
		member.setRENTALCOUNT(0);
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
		books.setLIBCODE(0001);
		//대출가능여부 설정 : 도서등록 하면 바로 빌릴수 있음
		books.setCURRENTSTATUS("Y");
		//대여횟수 : 처음 등록이기에 0으로 초기화
		books.setRENTALCOUNT(0);
		//대여날짜 : 처음 등록이기에 0으로 초기화
		books.setRENTALDAYS(0);
		
		return dao.insertBook(books);
	}

	//멤버 목록(비승인)가져오기
	@Override
	public List<Member> selectMember() {
		List<Member> list =dao.selectMember();
		for(int i=0;i<list.size();i++){
			Member member=list.get(i);
			member.setPHONE1(member.getMEMBERPHONE().substring(0, 3));
			member.setPHONE2(member.getMEMBERPHONE().substring(3, 7));
			member.setPHONE3(member.getMEMBERPHONE().substring(7, 11));
		}
		return list;
	}

	//회원 상태 업데이트(회비 확인 후 승인)
	@Override
	public int updatePayMember(String[] MEMBERID) {
		int result=0;
		for(int i=0;i<MEMBERID.length;i++){
			result=dao.updatePayMember(MEMBERID[i]);
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
		Admin returnAdmin = new Admin();
		//입력 아이디 비번
		String loginId = admin.getADMINID();
		String loginPw = admin.getADMINPW();
		//db에서 가져오기
		Admin getAdmin = dao.selectAdmin(loginId);
		if(getAdmin.getADMINID().equals(loginId)){
			if(getAdmin.getADMINPW().equals(loginPw)){
				//아이디 비번 같으면 리턴할 변수에 admin정보 셋팅
				returnAdmin.setADMINID(getAdmin.getADMINID());
				returnAdmin.setLIBCODE(getAdmin.getLIBCODE());
				returnAdmin.setRESULT(1);
			}else{
				returnAdmin.setRESULT(2);
			}
		}else{
			returnAdmin.setRESULT(3);
		}

		return returnAdmin;
	}
	//rent 멤버 정보 가져오기
	@Override
	public Member rentMemberSelect(String MEMBERID) {
		// TODO Auto-generated method stub
		return dao.rentMemberSelect(MEMBERID);
	}

}