package com.gm.start.bankMembers;

import java.lang.reflect.Parameter;
import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.gm.start.bankbook.BankBookDTO;

//Controller 역할, container에게 이 클래스의객체를 생성
@Controller
@RequestMapping(value="/member/*")
public class MemberController {

	// annotation
	// @ : 설명 + 실행
	
	// Login /member/login
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(BankMembersDTO bankMembersDTO) {
		System.out.println("DBd에 로그인 실행");
		
		// "Redirect: 다시접속할URL주소(절대경로, 상대경로)"
		return "redirect:../";
		
		//return "home";
	}
	
	// Join /member/join Get
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		System.out.println("조인 Get 실행");
		
		return "member/join";
	}
	
	// Post
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception {
		System.out.println("조인 Post 실행");
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		
//		//String username = request.getParameter("username");
//		bankMembersDTO.setUsername(username);
//		bankMembersDTO.setPassword(password);
//		bankMembersDTO.setName(name);
//		bankMembersDTO.setEmail(email);
//		bankMembersDTO.setPhone(phone);
		
		int result = bankMembersDAO.setJoin(bankMembersDTO);
		System.out.println(result ==1);
		
		
//		BankMembersDAO bankMembersDAO = new BankMembersDAO();
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		
//		bankMembersDTO.setUsername(request.getParameter("username"));
//		bankMembersDTO.setPassword(request.getParameter("password"));
//		bankMembersDTO.setName(request.getParameter("name"));
//		bankMembersDTO.setEmail(request.getParameter("email"));
//		bankMembersDTO.setPhone(request.getParameter("phone"));
		
		
		return "redirect:../member/login";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String getSearchByID() { 
		System.out.println("써치 Get 실행");
		
		return "member/search";
	}
	
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public ModelAndView getSearchByID(String search) throws Exception {
		System.out.println("써치 Post 실행");
		BankMembersDAO bankMembersDAO = new BankMembersDAO();
		ArrayList<BankMembersDTO> ar = bankMembersDAO.getSearchByID(search);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/list");
		mv.addObject("list", ar);

		return mv;
	}
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list() { 
		System.out.println("리스트 Get 실행");
		
		return "member/list";
	}
}
