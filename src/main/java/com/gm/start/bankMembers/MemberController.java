package com.gm.start.bankMembers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

//Controller 역할, container에게 이 클래스의객체를 생성
@Controller
@RequestMapping(value="/member/*")
public class MemberController {
	
	@Autowired
	//@Qualifier("myDAO")
	//private MembersDAO bankMembersDAO;
	private BankMembersService bankMembersService;
	
//	@Autowired
//	public MemberController(BankMembersDAO bankMembersDAO) {
//		this.bankMembersDAO = bankMembersDAO;
//	}
	

	// annotation
	// @ : 설명 + 실행
	
	// Login /member/login
	@RequestMapping(value = "login.gm", method = RequestMethod.GET)
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login";
	}
	
	@RequestMapping(value = "login.gm", method = RequestMethod.POST)
	public String login(HttpServletRequest request, BankMembersDTO bankMembersDTO, Model model) throws Exception{
		System.out.println("DBd에 로그인 실행");
		bankMembersDTO = bankMembersService.getLogin(bankMembersDTO);
		System.out.println(bankMembersDTO);
		
		HttpSession session = request.getSession();
		session.setAttribute("member", bankMembersDTO);
		//model.addAttribute("member", bankMembersDTO);
		
		// "Redirect: 다시접속할URL주소(절대경로, 상대경로)"
		return "redirect:../";
		
		//return "home";
	}
	
	@RequestMapping(value = "logout.gm", method = RequestMethod.GET)
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		
		return "redirect:../";
	}
	
	
	// Join /member/join Get
	@RequestMapping(value = "join.gm", method = RequestMethod.GET)
	public String join() {
		System.out.println("조인 Get 실행");
		
		return "member/join";
	}
	
	// Post
	@RequestMapping(value = "join.gm", method = RequestMethod.POST)
	public String join(BankMembersDTO bankMembersDTO) throws Exception {
		System.out.println("조인 Post 실행");
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		
//		//String username = request.getParameter("username");
//		bankMembersDTO.setUsername(username);
//		bankMembersDTO.setPassword(password);
//		bankMembersDTO.setName(name);
//		bankMembersDTO.setEmail(email);
//		bankMembersDTO.setPhone(phone);
		
		int result = bankMembersService.setJoin(bankMembersDTO);
		System.out.println(result ==1);
		
		
//		BankMembersDAO bankMembersDAO = new BankMembersDAO();
//		BankMembersDTO bankMembersDTO = new BankMembersDTO();
//		
//		bankMembersDTO.setUsername(request.getParameter("username"));
//		bankMembersDTO.setPassword(request.getParameter("password"));
//		bankMembersDTO.setName(request.getParameter("name"));
//		bankMembersDTO.setEmail(request.getParameter("email"));
//		bankMembersDTO.setPhone(request.getParameter("phone"));
		
		
		return "redirect:../member/login.gm";
	}
	
	@RequestMapping(value = "search.gm", method = RequestMethod.GET)
	public String getSearchByID() { 
		System.out.println("써치 Get 실행");
		
		return "member/search";
	}
	
	
	@RequestMapping(value = "search.gm", method = RequestMethod.POST)
	public ModelAndView getSearchByID(String search) throws Exception {
		System.out.println("써치 Post 실행");
		List<BankMembersDTO> ar = bankMembersService.getSearchByID(search);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("member/list");
		mv.addObject("list", ar);

		return mv;
	}
	
	@RequestMapping(value = "list.gm", method = RequestMethod.GET)
	public String list() { 
		System.out.println("리스트 Get 실행");
		
		return "member/list";
	}
}
