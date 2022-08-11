package com.gm.start.test;

import com.gm.start.bankbook.BankBookDAO;
import com.gm.start.bankbook.BankBookDTO;

public class BankBookTestMain {

	public static void main(String[] args) {
		BankBookDAO bankBookDAO = new BankBookDAO();
		BankBookDTO bankBookDTO = new BankBookDTO();
//		bankBookDTO.setBooknum(111);
//		try {
//			bankBookDTO = bankBookDAO.getDetail(bankBookDTO);
//			
//			System.out.println(bankBookDTO != null);
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		try {
			bankBookDTO.setBookname("hii");
			bankBookDTO.setBookrate(2.5);
			bankBookDAO.setUpdate(bankBookDTO);
		} catch (Exception e) {
			// TODO Auto-generated catch block-
			e.printStackTrace();
		}
		System.out.println(bankBookDTO.getBookname() + " " + bankBookDTO.getBookrate());

	}

}
