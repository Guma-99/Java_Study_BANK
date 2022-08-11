package com.gm.start.bankbook;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.gm.start.util.DBConnector;

public class BankBookDAO implements BookDAO {

	@Override
	public int setBankBook(BankBookDTO bankBookDTO) throws Exception {
		Connection con = DBConnector.getConnection();
		String sql = "INSERT INTO BANKBOOK(BOOKNUM, BOOKNAME, BOOKRATE, BOOKSALE) VALUES(?, ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, bankBookDTO.getBooknum());
		st.setString(2, bankBookDTO.getBookname());
		st.setDouble(3, bankBookDTO.getBookrate());
		st.setInt(4, bankBookDTO.getBooksale());
		
		int rs = st.executeUpdate();
		
		DBConnector.disConnect(st, con);
		
		return rs;
	}

	@Override
	public ArrayList<BankBookDTO> getList() throws Exception {
		ArrayList<BankBookDTO> ar = new ArrayList<BankBookDTO>();

		Connection con = DBConnector.getConnection();
		String sql = "SELECT * FROM BANKBOOK order by booknum desc";

		// 3. 미리 보내기
		PreparedStatement st = con.prepareStatement(sql);

		// 5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			BankBookDTO bankBookDTO = new BankBookDTO();
			bankBookDTO.setBooknum(rs.getInt("booknum"));
			bankBookDTO.setBookname(rs.getString("bookname"));
			bankBookDTO.setBookrate(rs.getDouble("bookrate"));
			bankBookDTO.setBooksale(rs.getInt("booksale"));
			ar.add(bankBookDTO);
		}

		// 6. 연결 해제
		return ar;
	}

	@Override
	public int setChangeSale(BankBookDTO bankBookDTO) throws Exception {
		// 1. DB 연결
		Connection con = DBConnector.getConnection();

		// 2. SQL문 생성
		String sql = "UPDATE BANKBOOK SET BOOKSALE = 0 WHERE BOOKNUM = ?";

		// 3. 미리 보내기
		PreparedStatement st = con.prepareStatement(sql);

		// 4. ? 세팅
		st.setInt(1, bankBookDTO.getBooksale());

		// 5. 최종 전송 후 결과 처리
		int result = st.executeUpdate();

		// 6. 연결 해제
		return result;
	}

	@Override
	public BankBookDTO getDetail(BankBookDTO bankBookDTO) throws Exception {
		BankBookDTO bankBookDTO2 = null;
		// 1. DB 연결
		Connection con = DBConnector.getConnection();

		// 2. SQL문 생성
		String sql = "SELECT * FROM BANKBOOK WHERE BOOKNUM = ?";

		// 3. 미리 보내기
		PreparedStatement st = con.prepareStatement(sql);

		// 4. ? 세팅
		st.setInt(1, bankBookDTO.getBooknum());
		
		// 5. 최종 전송 후 결과 처리
		//int result = st.executeUpdate();
		ResultSet rs = st.executeQuery();
		
		// 6. 연결 해제
		//return result;
		if(rs.next()) {
			bankBookDTO2 = new BankBookDTO();
			bankBookDTO2.setBooknum(rs.getInt("BOOKNUM"));
			bankBookDTO2.setBookname(rs.getString("BOOKNAME"));
			bankBookDTO2.setBookrate(rs.getDouble("BOOKRATE"));
			bankBookDTO2.setBooksale(rs.getInt("BOOKSALE"));
		} 
			return bankBookDTO2;

	}

}
