package com.gm.start.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gm.start.util.DBConnector;

@Service
public class BankBookService {
	@Autowired
	private BankBookDAO bankBookDAO;

	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {

		return bankBookDAO.setUpdate(bankBookDTO);
	};

	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {

		return bankBookDAO.setBankBook(bankBookDTO);
	};
	// 북넘: 현재시간을 밀리세컨즈로 변환하여 입력
	// 북세일: 1 -판매

	public ArrayList<BankBookDTO> getList() throws Exception {

		return bankBookDAO.getList();
	};
	// 뱅크북 모든 데이터 조회 최신순으로

	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.setChangeSale(bankBookDTO);

	};
	// Sale 컬럼 수정

	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		return bankBookDAO.getDetail(bankBookDTO);
	}

	public int setDelete(BankBookDTO bankBookDTO) throws Exception {

		return bankBookDAO.setDelete(bankBookDTO);
	}
}
