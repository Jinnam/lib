package com.blog.beast4307.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface LibDao {
	static final Logger logger = LoggerFactory.getLogger(LibDao.class);
	//������ books ������Ʈ
	int returnBookUpdate(Books books);	
	//FIRSTRENTALDAY��������
	Books firstRentalSelect(int bookCode);
	//���� �� payment/rental ������Ʈ 
	int payRentUpdate(int paymentCode);
	//�ݳ� ����������������
	Payment returnPaymentSelect(int bookCode);	
	//�ݳ� ����������������
	Books returnBookSelect(int bookCode);
	//�뿩���� ���
	int rentalInsert(Rental rental);
	//�������� ���
	int paymentInsert(Payment payment);
	//��������(�ݾ�)��������
	Cost costSelect();
	//���� ��� ���
	int discardInsert(Books books);
	//������� �� ���� ���� ������Ʈ
	int bookStatusUpdate(int bookCode);
	//rent �������� ��������
	Books rentBookSelect(int bookCode);
	//rent ȸ������ ��������
	Member rentMemberSelect(String memberId);
	//admin ������������
	Admin selectAdmin(String adminId);
	//ȸ������
	int insertMember(Member member);
	//���������
	int insertLib(Lib lib);
	//���� ���
	int insertBook(Books books);
	//ȸ�� ��� ��������
	List<Member> selectMember();
	//ȸ�� ���� ����(�Ա� Ȯ��)
	int updatePayMember(String memberId);
	//ȸ�����Խ� ������ ��� ��������
	List<Lib> selectLib();
}
