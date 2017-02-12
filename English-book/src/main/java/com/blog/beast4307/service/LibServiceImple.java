package com.blog.beast4307.service;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
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
			String returnExpectDay = nYear+"-"+nMonth+"-"+nDay;
			
		returnBooks.setReturnExpectDay(returnExpectDay);
		
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

	Rental rental= new Rental();
	//�뿩���� ���
	@Override
	public int rentalInsert(ReceiveRentData receiveRentData) {
		
		rental.setBookCode(receiveRentData.getBookCode());
		rental.setMemberId(receiveRentData.getMemberId());
		rental.setRentalStartDay(receiveRentData.getRentalStartDay());
		rental.setReturnExpectDay(receiveRentData.getRentalFinishDay());
		rental.setReturnStatus("N");
		logger.info(rental.toString());
		return dao.rentalInsert(rental);
	}

	//�������� ���
	@Override
	public int paymentInsert(ReceiveRentData receiveRentData) {
		Payment payment = new Payment();
		payment.setMemberId(receiveRentData.getMemberId());
		payment.setPaymentPrice(receiveRentData.getPaymentPrice());
		if(receiveRentData.getPaymentPrice()==0){
			payment.setPaymentStatus('N');
		}else{
			payment.setPaymentStatus('Y');
		}
		payment.setRentalCode(rental.getRentalCode());
		logger.info(payment.toString());
		return dao.paymentInsert(payment);
	}
	
	//�ݳ��������� ��������
	@Override
	public Books returnBookSelect(int bookCode) throws ParseException {
		System.out.println("Serviceimpl bookCode : "+bookCode);
		Books returnBook = dao.returnBookSelect(bookCode);
		logger.info("enter : "+returnBook.toString());
		
		//������¥ ���
		String rentalStartDay = returnBook.getRentalStartDay();				//rental������
		String rentalFinishDay = returnBook.getReturnExpectDay();			//rental�ݳ���
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");	//yyyy-MM-dd ������ simpleDateFormat ����	
		 
	    Date beginDate = formatter.parse(rentalStartDay);					//String ������ ��¥�� Date �������� ��ȯ
	    Date endDate = formatter.parse(rentalFinishDay);
	 
	    long diff = endDate.getTime() - beginDate.getTime();				//Date������ ��¥�� �ʷ� ���� �� -> �ݳ��ϰ� �������� ���� ����
	    int diffDays = (int)(diff / (24 * 60 * 60 * 1000));					//����� ���(��)�� ��¥�� �ٲپ���
	 
	    System.out.println("diffDays == RentalDays : "+diffDays);
	    returnBook.setRentalDays(diffDays);
		logger.info("exit : "+returnBook.toString());
		return returnBook;
	}
	//�ݳ� ���� ���� ��������
	@Override
	public Payment returnPaymentSelect(int bookCode) {
		
		return dao.returnPaymentSelect(bookCode);
	}
	//���� �� payment/rental ������Ʈ 
	@Override
	public int payRentUpdate(int paymentCode) {
		// TODO Auto-generated method stub
		return dao.payRentUpdate(paymentCode);
	}

	//������ books ������Ʈ
	@Override
	public int returnBookUpdate(ReceiveRentData receiveRentData) {
		//ù �뿩 ��¥ ���� ��������
		Books firstRental=dao.firstRentalSelect(receiveRentData.getBookCode());
		Books returnBooks = new Books();
		
		//returnBook�� �ٽ� ����
		returnBooks.setBookCode(receiveRentData.getBookCode());
		returnBooks.setRentalDays(receiveRentData.getRentalDays());
		if(firstRental.getFirstRentalDay()==null){
			System.out.println("FirstrentalDay : "+firstRental.getFirstRentalDay());
			returnBooks.setFirstRentalDay(receiveRentData.getRentalStartDay());
		}
		returnBooks.setRentalCount(firstRental.getRentalCount()+1);
		returnBooks.setRentalDays(firstRental.getRentalDays()+receiveRentData.getRentalDays());
		logger.info(returnBooks.toString());
		
		return dao.returnBookUpdate(returnBooks);
	}


}