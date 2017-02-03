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
	
	//ȸ������
	@Override
	public int insertMember(Member member) {
		//��ȭ��ȣ �Է� : ������ �Է������� ���� ��ȣ�� �ϳ��� ��ħ
		member.setMemberPhone(member.getPhone1()+member.getPhone2()+member.getPhone3());
		//ȸ�� ���� ���� : �����ϸ� N���� �ʱ�ȭ �ϰ� �Ա� Ȯ�� �� Y�� ����
		member.setMemberPaymentStatus('N');
		//�뿩Ƚ�� : ���Խ� 0���� �ʱ�ȭ
		member.setRentalCount(0);
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
		books.setLibCode(0001);
		//���Ⱑ�ɿ��� ���� : ������� �ϸ� �ٷ� ������ ����
		books.setCurrentStatus("Y");
		//�뿩Ƚ�� : ó�� ����̱⿡ 0���� �ʱ�ȭ
		books.setRentalCount(0);
		//�뿩��¥ : ó�� ����̱⿡ 0���� �ʱ�ȭ
		books.setRentalDays(0);
		
		return dao.insertBook(books);
	}

	//��� ���(�����)��������
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

	//ȸ�� ���� ������Ʈ(ȸ�� Ȯ�� �� ����)
	@Override
	public int updatePayMember(String[] memberId) {
		int result=0;
		for(int i=0;i<memberId.length;i++){
			result=dao.updatePayMember(memberId[i]);
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
		logger.info(admin.toString());
		Admin returnAdmin = new Admin();
		//�Է� ���̵� ���
		String loginId = admin.getAdminId();
		String loginPw = admin.getAdminPw();
		System.out.println("�Է� ���̵� : "+ loginId+"�Է� ���: "+loginPw);
		//db���� ��������
		Admin getAdmin = dao.selectAdmin(loginId);
		String dbId = getAdmin.getAdminId();
		String dbPw = getAdmin.getAdminPw();
		int libCode = getAdmin.getLibCode();
		logger.info(getAdmin.toString());
		if(dbId.equals(loginId)){
			if(dbPw.equals(loginPw)){
				//���̵� ��� ������ ������ ������ admin���� ����
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
	//rent ��� ���� ��������
	@Override
	public Member rentMemberSelect(String memberId) {
		// TODO Auto-generated method stub
		return dao.rentMemberSelect(memberId);
	}
	//rent ���� ���� ��������
	@Override
	public Books rentBookSelect(int bookCode) {
		
		Books returnBooks = dao.rentBookSelect(bookCode);
		//�뿩������ : ������ ��¥
		int nYear;
		int nMonth;
		int nDay;
		Calendar calendar = new GregorianCalendar(Locale.KOREA);
			nYear = calendar.get(Calendar.YEAR);
		    nMonth = calendar.get(Calendar.MONTH) + 1;
		    nDay = calendar.get(Calendar.DAY_OF_MONTH);
		    String nowDate = nYear+"-"+nMonth+"-"+nDay;
		    
		    returnBooks.setRentalStartDay(nowDate);
		    
		//�뿩 ������ : ���� ��¥ +3
			calendar.add(Calendar.DAY_OF_MONTH, 3);
			nYear = calendar.get(Calendar.YEAR);
			nMonth = calendar.get(Calendar.MONTH) + 1;
			nDay = calendar.get(Calendar.DAY_OF_MONTH);
			String finishDate = nYear+"-"+nMonth+"-"+nDay;
			
		returnBooks.setRentalFinishDay(finishDate);
		
		return returnBooks;
	}
	//���� ��� ���
	@Override
	public int discardInsert(Books books) {
		// TODO Auto-generated method stub
		return dao.discardInsert(books);
	}
	
	//���� ��� �� ���� ������Ʈ
	@Override
	public int bookStatusUpdate(int bookCode) {
		// TODO Auto-generated method stub
		return dao.bookStatusUpdate(bookCode);
	}

	//ȸ��/��ȸ�� �������� ��������
	@Override
	public Cost costSelect() {
		// TODO Auto-generated method stub
		return dao.costSelect();
	}

	//�뿩���� ���
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

	//�������� ���
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