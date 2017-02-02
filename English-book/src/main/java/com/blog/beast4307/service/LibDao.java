package com.blog.beast4307.service;

import java.util.List;

public interface LibDao {
	
	//rent ȸ������ ��������
	Member rentMemberSelect(String MEMBERID);
	//admin ������������
	Admin selectAdmin(String ADMINID);
	//ȸ������
	int insertMember(Member member);
	//���������
	int insertLib(Lib lib);
	//���� ���
	int insertBook(Books books);
	//ȸ�� ��� ��������
	List<Member> selectMember();
	//ȸ�� ���� ����(�Ա� Ȯ��)
	int updatePayMember(String MEMBERID);
	//ȸ�����Խ� ������ ��� ��������
	List<Lib> selectLib();
}
