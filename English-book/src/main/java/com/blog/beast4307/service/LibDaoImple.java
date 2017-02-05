package com.blog.beast4307.service;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class LibDaoImple implements LibDao {
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	private final String NS="com.blog.beast4307.service.LibMapper.";
	
	//ȸ������
	@Override
	public int insertMember(Member member) {
				
		return sqlSession.insert(NS+"memberInsert",member);
	}

	//������ ���
	@Override
	public int insertLib(Lib lib) {

		return sqlSession.insert(NS+"libraryInsert",lib);
	}
	
	//���� ���
	@Override
	public int insertBook(Books books) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NS+"bookInsert",books);
	}

	//ȸ����� ��������(�Ա� Ȯ��)
	@Override
	public List<Member> selectMember() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS+"memberSelect");
	}

	//�Ա� Ȯ�� �� �Աݻ��� ������Ʈ
	@Override
	public int updatePayMember(String memberId) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"memberPayUpdate", memberId);
	}

	//������ ��� ��������
	@Override
	public List<Lib> selectLib() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS+"librarySelect");
	}

	//Admin���� ��������
	@Override
	public Admin selectAdmin(String adminId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"adminSelect",adminId);
	}
	//rent ��� ���� ��������
	@Override
	public Member rentMemberSelect(String memberId) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"rentMemberSelect",memberId);
	}

	//rent ���� ���� ��������
	@Override
	public Books rentBookSelect(int bookCode) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"rentBookSelect",bookCode);
	}
	//���� ��� ���
	@Override
	public int discardInsert(Books books) {
		// TODO Auto-generated method stub
		return sqlSession.insert(NS+"discardInsert",books);
	}
	//���� ��� ��� �� �������� ������Ʈ
	@Override
	public int bookStatusUpdate(int bookCode) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"bookStatusUpdate",bookCode);
	}

	//ȸ��/��ȸ�� �������� ��������
	@Override
	public Cost costSelect() {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"paymentSelecet");
	}

	//�뿩���� ���
	@Override
	public int rentalInsert(Rental rental) {
		System.out.println("dao rental : "+rental);
		int result = sqlSession.insert(NS+"rentalInsert", rental);
		return result;
	}
	
	//�������� ���
	@Override
	public int paymentInsert(Payment payment) {
		System.out.println("dao payment : "+payment);
		// TODO Auto-generated method stub
		return sqlSession.insert(NS+"paymentInsert", payment);
	}
	//�ݳ� ���� ���� ��������
	@Override
	public Books returnBookSelect(int bookCode) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"returnbookSelect",bookCode);
	}
	//�ݳ� ���� ���� ��������
	@Override
	public Payment returnPaymentSelect(int bookCode) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"paymentInfoSelect",bookCode);
	}
	//���� �� payment/rental ������Ʈ 
	@Override
	public int payRentUpdate(int paymentCode) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"payRentUpdate",paymentCode);
	}
	
	//FIRSTRENTALDAY��������
	@Override
	public Books firstRentalSelect(int bookCode) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"booksInfoSelect",bookCode);
	}

	//������ books ������Ʈ
	@Override
	public int returnBookUpdate(Books books) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"returnBookUpdate",books);
	}

	

	

}