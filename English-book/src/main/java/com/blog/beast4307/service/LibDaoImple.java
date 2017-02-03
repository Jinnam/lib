package com.blog.beast4307.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sun.istack.internal.logging.Logger;

@Repository
public class LibDaoImple implements LibDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS="com.blog.beast4307.service.LibMapper.";
	
	//회원가입
	@Override
	public int insertMember(Member member) {
				
		return sqlSession.insert(NS+"memberInsert",member);
	}

	//도서관 등록
	@Override
	public int insertLib(Lib lib) {

		return sqlSession.insert(NS+"libraryInsert",lib);
	}
	
	//도서 등록
	@Override
	public int insertBook(Books books) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NS+"bookInsert",books);
	}

	//회원목록 가져오기(입금 확인)
	@Override
	public List<Member> selectMember() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS+"memberSelect");
	}

	//입금 확인 후 입금상태 업데이트
	@Override
	public int updatePayMember(String memberId) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"memberPayUpdate", memberId);
	}

	//도서관 목록 가져오기
	@Override
	public List<Lib> selectLib() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS+"librarySelect");
	}

	//Admin정보 가져오기
	@Override
	public Admin selectAdmin(String adminId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"adminSelect",adminId);
	}
	//rent 멤버 정보 가져오기
	@Override
	public Member rentMemberSelect(String memberId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"rentMemberSelect",memberId);
	}

	//rent 도서 정보 가져오기
	@Override
	public Books rentBookSelect(int bookCode) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"rentBookSelect",bookCode);
	}
	//도서 폐기 등록
	@Override
	public int discardInsert(Books books) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NS+"discardInsert",books);
	}
	//도서 폐기 등록 후 도서상태 업데이트
	@Override
	public int bookStatusUpdate(int bookCode) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"bookStatusUpdate",bookCode);
	}

	//회원/비회원 가격정보 가져오기
	@Override
	public Cost costSelect() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"paymentSelecet");
	}

	//대여정보 등록
	@Override
	public int rentalInsert(Rental rental) {
		System.out.println("dao rental : "+rental);
		// TODO Auto-generated method stub
		return sqlSession.insert(NS+"rentalInsert", rental);
	}
	
	//결제정보 등록
	@Override
	public int paymentInsert(Payment payment) {
		System.out.println("dao payment : "+payment);
		// TODO Auto-generated method stub
		return sqlSession.insert(NS+"paymentInsert", payment);
	}

	@Override
	public int rentalCodeSelect() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"rentalcodeSelect");
	}
	
	

}