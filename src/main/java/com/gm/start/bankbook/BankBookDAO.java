package com.gm.start.bankBook;

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

		st.setInt(1, bankBookDTO.getBookNum());
		st.setString(2, bankBookDTO.getBookName());
		st.setDouble(3, bankBookDTO.getBookRate());
		st.setInt(4, bankBookDTO.getBookSale());

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
			bankBookDTO.setBookNum(rs.getInt("bookNum"));
			bankBookDTO.setBookName(rs.getString("bookName"));
			bankBookDTO.setBookRate(rs.getDouble("bookRate"));
			bankBookDTO.setBookSale(rs.getInt("bookSale"));
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
		String sql = "UPDATE BANKBOOK SET BOOKSALE = 1 WHERE BOOKNUM = ?";

		// 3. 미리 보내기
		PreparedStatement st = con.prepareStatement(sql);

		// 4. ? 세팅
		st.setInt(1, bankBookDTO.getBookSale());

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
		st.setInt(1, bankBookDTO.getBookNum());

		// 5. 최종 전송 후 결과 처리
		// int result = st.executeUpdate();
		ResultSet rs = st.executeQuery();

		// 6. 연결 해제
		// return result;
		if (rs.next()) {
			bankBookDTO2 = new BankBookDTO();
			bankBookDTO2.setBookNum(rs.getInt("bookNum"));
			bankBookDTO2.setBookName(rs.getString("bookName"));
			bankBookDTO2.setBookRate(rs.getDouble("bookRate"));
			bankBookDTO2.setBookSale(rs.getInt("bookSale"));
		}
		return bankBookDTO2;

	}

	@Override
	public int setUpdate(BankBookDTO bankBookDTO) throws Exception {
		// 1. DB 연결
		Connection con = DBConnector.getConnection();

		// 2. SQL문 생성
		String sql = "UPDATE BANKBOOK SET BOOKNAME = ?, BOOKRATE = ?  WHERE BOOKNUM = ?";

		// 3. 미리 보내기
		PreparedStatement st = con.prepareStatement(sql);

		// 4. ? 세팅
		st.setString(1, bankBookDTO.getBookName());
		st.setDouble(2, bankBookDTO.getBookRate());
		st.setInt(3, bankBookDTO.getBookNum());

		// 5. 최종 전송 후 결과 처리
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);

		// 6. 연결 해제
		return result;
	}

	@Override
	public int setDelete(BankBookDTO bankBookDTO) throws Exception {
		// 1. DB 연결
		Connection con = DBConnector.getConnection();

		// 2. SQL문 생성
		String sql = "DELETE BANKBOOK WHERE BOOKNUM = ?";

		// 3. 미리 보내기
		PreparedStatement st = con.prepareStatement(sql);

		// 4. ? 세팅
		st.setInt(1, bankBookDTO.getBookNum());

		// 5. 최종 전송 후 결과 처리
		int result = st.executeUpdate();
		DBConnector.disConnect(st, con);

		// 6. 연결 해제
		return result;
	}

}
