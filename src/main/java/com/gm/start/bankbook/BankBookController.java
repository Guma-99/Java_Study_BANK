package com.gm.start.bankbook;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@RequestMapping(value = "/bankbook/*")
@Controller
public class BankBookController {

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(Model model) throws Exception {
		System.out.println("리스트 Get 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		ArrayList<BankBookDTO> ar = bankBookDAO.getList();
		model.addAttribute("list", ar);
		
		return "bankbook/list";
	}

	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDTO bankBookDTO) throws Exception{
		ModelAndView mv = new ModelAndView();
		System.out.println("디테일 Get 실행");
		System.out.println(bankBookDTO.getBooknum());

		BankBookDAO bankBookDAO = new BankBookDAO();
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);

		//return "bankbook/detail";
		mv.setViewName("bankbook/detail");
		mv.addObject("dto", bankBookDTO);
		
		return mv;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() { 
		System.out.println("에드 Get 실행");
		
		return "bankbook/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("에드 Post 실행");
		BankBookDAO bankBookDAO = new BankBookDAO();
		
		int result = bankBookDAO.setBankBook(bankBookDTO);
		System.out.println(result == 1);
		
		// 상품등록 후 list페이지로 이동 
		ModelAndView mv = new ModelAndView();
		
		mv.setViewName("redirect:./list");
		
		
		return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.GET)
	public void update(BankBookDTO bankBookDTO, Model model) throws Exception{
		System.out.println("업데이트 Get 실행");
		System.out.println(bankBookDTO.getBooknum());
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
		//ModelAndView mv = new ModelAndView();
		
		model.addAttribute("dto", bankBookDTO);

		//mv.setViewName("bankbook/update");
		//mv.addObject("dto", bankBookDTO);
		
		//return mv;
	}
	
	@RequestMapping(value = "update", method = RequestMethod.POST)
	public String update(BankBookDTO bankBookDTO) throws Exception {
		System.out.println("업데이트 Post 실행");
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		//BankBookDTO bankBookDTO = new BankBookDTO();
		
		int result = bankBookDAO.setUpdate(bankBookDTO);
		
		
		
		System.out.println(result == 1);
		
		return "redirect:./detail?booknum=" + bankBookDTO.getBooknum();

	}
	
	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public ModelAndView Delete(BankBookDTO bankBookDTO, Model model) throws Exception {
		System.out.println("딜리트 Get 실행");
		
		BankBookDAO bankBookDAO = new BankBookDAO();
		ModelAndView mv = new ModelAndView();

		int result = bankBookDAO.setDelete(bankBookDTO);
		
		mv.setViewName("redirect:./list");
		
		System.out.println(result == 1);
		
		return mv;
		
	}

}
