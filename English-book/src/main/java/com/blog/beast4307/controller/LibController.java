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

import com.blog.beast4307.service.Admin;
import com.blog.beast4307.service.Books;
import com.blog.beast4307.service.Lib;
import com.blog.beast4307.service.LibService;
import com.blog.beast4307.service.Member;

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
	public String rentBook(Books books){
		
		return "redirect:RentBook";
	}
	
	//rent ��� ���� ��ȸ
	@RequestMapping(value="/rentmember", method=RequestMethod.POST)
	public @ResponseBody Member selectRentMember(@RequestParam("MEMBERID") String MEMBERID){
		System.out.println(MEMBERID+"**********************************");
		Member returnMember = libService.rentMemberSelect(MEMBERID);
		logger.info(returnMember.toString());
		return returnMember;
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
		return "DeleteBook";
	}
		
	//���� ��� �׼�
	@RequestMapping(value="/deletebook", method=RequestMethod.POST)
	public String deleteBook(Books books){
			
		return "redirect:DeleteBook";
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
	public String updatePayMember(@RequestParam(value="MEMBERID") String[] MEMBERID){
		libService.updatePayMember(MEMBERID);
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
		String result="";
		Admin resultAdmin = libService.selectAdmin(admin);
		//���ϰ� 1: ����, 2: �������ġ, 3: ���̵� ����ġ
		if(resultAdmin.getRESULT()==1){
			session.setAttribute("ADMINID", resultAdmin.getADMINID());
			session.setAttribute("LIBCODE", resultAdmin.getLIBCODE());
			session.setAttribute("COMMENT", resultAdmin.getRESULT());
			result="AddLibrary";
		}else{
			result="login";
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
