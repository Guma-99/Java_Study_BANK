package com.gm.start.bankAccount;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gm.start.bankMembers.BankMembersDTO;

@Controller
@RequestMapping("/bankaccount/*")
public class BankAcoountController {
	
	private BankAccountDAO bankAccountDAO;
	
	public BankAcoountController() {
		this.bankAccountDAO = new BankAccountDAO();
	}
	
	
	@RequestMapping(value = "add.gm", method = RequestMethod.GET)
	public String add(BankAccountDTO bankAccountDTO, HttpSession session) throws Exception {
		System.out.println("BankAccount add Get 실행");
		System.out.println(bankAccountDTO.getBookNum());
		BankMembersDTO bankMembersDTO = (BankMembersDTO)session.getAttribute("member");
		bankAccountDTO.setUserName(bankMembersDTO.getUserName());
		
		// DTO : username, banknum
		int result = this.bankAccountDAO.add(bankAccountDTO);
		
		return "redirect:../bankbook/list.gm";
		
	}
}
