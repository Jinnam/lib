package com.blog.beast4307.service;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public interface LibService {
	static final Logger logger = LoggerFactory.getLogger(LibService.class);
	//������ books ������Ʈ
	int returnBookUpdate(ReceiveRentData receiveRentData);	
	//���� �� payment/rental ������Ʈ 
	int payRentUpdate(int paymentCode);
	//�ݳ� ����������������
	Payment returnPaymentSelect(int bookCode);	
	//�ݳ� ����������������
	Books returnBookSelect(int bookCode) throws ParseException;
	//�뿩���� ���
	int rentalInsert(ReceiveRentData receiveRentData);
	//�������� ���
	int paymentInsert(ReceiveRentData receiveRentData);
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
	//Admin���� �������� && ���̵� ���üũ
	Admin selectAdmin(Admin admin);
	//ȸ������
	int insertMember(Member member);
	//������ ���
	int insertLib(Lib lib);
	//���� ���
	int insertBook(Books book);
	//ȸ�� ���
	List<Member> selectMember();
	//ȸ�� ��� ������Ʈ(ȸ�� ��)
	int updatePayMember(String[] memberId);
	//������ ��� ��������
	List<Lib> selectLibrary();
}