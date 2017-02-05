package com.blog.beast4307.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.blog.beast4307.service.Rental;
import com.blog.beast4307.service.Admin;
import com.blog.beast4307.service.Books;
import com.blog.beast4307.service.Cost;
import com.blog.beast4307.service.Lib;
import com.blog.beast4307.service.LibService;
import com.blog.beast4307.service.Member;
import com.blog.beast4307.service.ReceiveRentData;

@Controller
public class LibController {
	private static final Logger logger = LoggerFactory.getLogger(LibController.class);
	@Autowired
	private LibService libService;
	Lib lib = new Lib();
	
	
	//���� �뿩 �� �̵�
	@RequestMapping(value="/rentbook")
	public String rentBook(){
		return "RentBook";
	}
	
	//���� �뿩 �׼�
	@RequestMapping(value="/rentbook", method=RequestMethod.POST)
	public String rentBook(ReceiveRentData receiveRentData){
		logger.info(receiveRentData.toString());
		//�뿩 ���
		libService.rentalInsert(receiveRentData);
		//���� ���
		libService.paymentInsert(receiveRentData);
		//���� ���� ������Ʈ(Y->N)
		//libService.bookStatusUpdate(receiveRentData.getBookCode());
		return "redirect:rentbook";
	}
	//rent ���� ���� ��ȸ
	@RequestMapping(value="/selectbook", method=RequestMethod.POST)
	public @ResponseBody Books selectRentBook(@RequestParam("bookCode") int bookCode){
		logger.info("select book");
		Books returnBook = libService.rentBookSelect(bookCode);
		logger.info(returnBook.toString());
		return returnBook;
	}
	
	//rent ��� ���� ��ȸ
	@RequestMapping(value="/rentmember", method=RequestMethod.POST)
	public @ResponseBody Member selectRentMember(@RequestParam("memberId") String memberId){
		logger.info("rentmember");
		Member returnMember = libService.rentMemberSelect(memberId);
		logger.info(returnMember.toString());
		return returnMember;
	}
	
	//ȸ��/��ȸ�� �������� ��������
	@RequestMapping(value="/costselect", method=RequestMethod.POST)
	public @ResponseBody Cost costSelect(){
		logger.info("costselect");
		Cost returnCost = libService.costSelect();
		return returnCost;
	}
	//���� �ݳ� �� �̵�
	@RequestMapping(value="/returnbook")
	public String returnBook(){
		return "ReturnBook";
	}
		
	//���� �ݳ� �׼�
	@RequestMapping(value="/returnbook", method=RequestMethod.POST)
	public String returnBook(Books books){
			
		return "redirect:ReturnBook";
	}
	//������� �� �̵�
	@RequestMapping(value="/deletebook")
	public String deleteBook(){
		logger.info("delete form");
		return "DeleteBook";
	}
		
	//���� ��� �׼�
	@RequestMapping(value="/deletebook", method=RequestMethod.POST)
	public String deleteBook(Books books){
		logger.info("delete process");
		logger.info("books tostring: "+books.toString());
		int bookCode = books.getBookCode();
		libService.discardInsert(books);	//���� ��� ���
		libService.bookStatusUpdate(bookCode);	//���� ���� N�� ������Ʈ
		return "redirect:deletebook";
	}
	
	//ȸ�� ��� ��������(ȸ�� �ȳ� ȸ��)
	@RequestMapping(value="/approval")
	public String selectMember(Model model){
		List<Member> list = libService.selectMember();
		model.addAttribute("list",list);
		logger.info(list.toString());
		return "ApprovalMember";
	}
	//ȸ�� ��� ������Ʈ(ȸ�� ��)
	@RequestMapping(value="/approval", method=RequestMethod.POST)
	public String updatePayMember(@RequestParam(value="memberId") String[] memberId){
		libService.updatePayMember(memberId);
		return "redirect:approval";
	}
	
	//���� �߰� �� �̵�
	@RequestMapping(value="/addbook")
	public String addBook(){
		return "AddBook";
	}
	//���� �߰� �� �׼�
	@RequestMapping(value="/addbook", method=RequestMethod.POST)
	public String addBook(Books books){
		libService.insertBook(books);
		return "AddBook";
	}
	
	//������ ��� �� �̵�
	@RequestMapping(value="/addlib")
	public String addLib(){
		return "AddLibrary";
	}
	//������ ��� �׼�
	@RequestMapping(value="/addlib", method=RequestMethod.POST)
	public String addLib(Lib lib){
		libService.insertLib(lib);
		return "AddLibrary";
	}
	
	//�α��� �� �̵�
	@RequestMapping(value="/login")
	public String login(){
		return "login";
	}
	//�α��� �׼�
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(Admin admin, HttpSession session){
		logger.info(admin.toString());
		String result="";
		Admin resultAdmin = libService.selectAdmin(admin);
		logger.info(resultAdmin.toString());
		//���ϰ� 1: ����, 2: �������ġ, 3: ���̵� ����ġ
		if(resultAdmin.getResult()==1){
			session.setAttribute("adminId", resultAdmin.getAdminId());
			session.setAttribute("libCode", resultAdmin.getLibCode());
			session.setAttribute("result", resultAdmin.getResult());
			result="AddLibrary";
		}else{
			result="redirect:login";
		}
		return result;

		
	}
	
	//�α׾ƿ�
	@RequestMapping(value="/logout")
	public String logoutAction(HttpSession session){
		session.invalidate();
		return "login";
	}
	
	//index�� �̵�(ȸ������)
	@RequestMapping(value="/index")
	public String index(Model model){
		//������ ���
		List<Lib> list= libService.selectLibrary();
		model.addAttribute("library",list);
		logger.info(list.toString());
		return "index";
	}
	//ȸ������ �׼� �� index�� �̵�
	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String inserMember(Member member){
		libService.insertMember(member);
		return "index";
	}
}
