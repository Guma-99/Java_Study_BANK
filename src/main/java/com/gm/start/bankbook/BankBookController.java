package com.gm.start.bankbook;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/bankbook/*")
@Controller
public class BankBookController {

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list() {
		System.out.println("리스트 Get 실행");

		return "bankbook/list";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(Long booknum) {
		System.out.println("디테일 Get 실행");
		System.out.println("booknum: " + booknum);

		return "bankbook/detail";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		System.out.println("에드 Get 실행");
		
		return "bankbook/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("에드 Post 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		
		int result = bankBookDAO.setBankBook(bankBookDTO);
		System.out.println(result == 1);
		
		return "bankbook/add";
	}

}
