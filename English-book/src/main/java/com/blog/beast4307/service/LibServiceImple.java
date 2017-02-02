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
	
	//ȸ������
	@Override
	public int insertMember(Member member) {
		//��ȭ��ȣ �Է� : ������ �Է������� ���� ��ȣ�� �ϳ��� ��ħ
		member.setMEMBERPHONE(member.getPHONE1()+member.getPHONE2()+member.getPHONE3());
		//ȸ�� ���� ���� : �����ϸ� N���� �ʱ�ȭ �ϰ� �Ա� Ȯ�� �� Y�� ����
		member.setMEMBERPAYMENTSTATUS('N');
		//�뿩Ƚ�� : ���Խ� 0���� �ʱ�ȭ
		member.setRENTALCOUNT(0);
		return dao.insertMember(member);
	}
	
	//���������
	@Override
	public int insertLib(Lib lib) {

		return dao.insertLib(lib);
	}
	
	//���� �߰�
	@Override
	public int insertBook(Books books) {
		//������ �ڵ� �߰�->���� �߰� �� �����Ұ�
		books.setLIBCODE(0001);
		//���Ⱑ�ɿ��� ���� : ������� �ϸ� �ٷ� ������ ����
		books.setCURRENTSTATUS("Y");
		//�뿩Ƚ�� : ó�� ����̱⿡ 0���� �ʱ�ȭ
		books.setRENTALCOUNT(0);
		//�뿩��¥ : ó�� ����̱⿡ 0���� �ʱ�ȭ
		books.setRENTALDAYS(0);
		
		return dao.insertBook(books);
	}

	//��� ���(�����)��������
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

	//ȸ�� ���� ������Ʈ(ȸ�� Ȯ�� �� ����)
	@Override
	public int updatePayMember(String[] MEMBERID) {
		int result=0;
		for(int i=0;i<MEMBERID.length;i++){
			result=dao.updatePayMember(MEMBERID[i]);
		}
		
		return result;
	}

	//������ ��� ��������
	@Override
	public List<Lib> selectLibrary() {
		// TODO Auto-generated method stub
		return dao.selectLib();
	}
	
	//Admin ������������ & ���̵� ���üũ
	@Override
	public Admin selectAdmin(Admin admin) {
		Admin returnAdmin = new Admin();
		//�Է� ���̵� ���
		String loginId = admin.getADMINID();
		String loginPw = admin.getADMINPW();
		//db���� ��������
		Admin getAdmin = dao.selectAdmin(loginId);
		if(getAdmin.getADMINID().equals(loginId)){
			if(getAdmin.getADMINPW().equals(loginPw)){
				//���̵� ��� ������ ������ ������ admin���� ����
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
	//rent ��� ���� ��������
	@Override
	public Member rentMemberSelect(String MEMBERID) {
		// TODO Auto-generated method stub
		return dao.rentMemberSelect(MEMBERID);
	}

}