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
	public int updatePayMember(String MEMBERID) {
		// TODO Auto-generated method stub
		return sqlSession.update(NS+"memberPayUpdate", MEMBERID);
	}

	//������ ��� ��������
	@Override
	public List<Lib> selectLib() {
		// TODO Auto-generated method stub
		return sqlSession.selectList(NS+"librarySelect");
	}

	//Admin���� ��������
	@Override
	public Admin selectAdmin(String ADMINID) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"adminSelect",ADMINID);
	}
	//rent ��� ���� ��������
	@Override
	public Member rentMemberSelect(String MEMBERID) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne(NS+"rentMemberSelect",MEMBERID);
	}
	
	

}