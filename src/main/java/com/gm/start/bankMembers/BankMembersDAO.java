package com.gm.start.bankMembers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.gm.start.util.DBConnector;

public class BankMembersDAO implements MembersDAO {

	@Override
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		// 1. DB 연결
		Connection con = DBConnector.getConnection();

		// 2. SQL문 생성
		String sql = "INSERT INTO BANKMEMBERS VALUES(?,?,?,?,?)";

		// 3. 미리 보내기
		PreparedStatement st = con.prepareStatement(sql);

		// 4. ? 세팅
		st.setString(1, bankMembersDTO.getUsername());
		st.setString(2, bankMembersDTO.getPassword());
		st.setString(3, bankMembersDTO.getName());
		st.setString(4, bankMembersDTO.getEmail());
		st.setString(5, bankMembersDTO.getPhone());

		// 5. 최종 전송 후 결과 처리
		int result = st.executeUpdate();

		// 6. 연결 해제
		return result;
	}

	@Override
	public ArrayList<BankMembersDTO> getSearchByID(String search) throws Exception {
		ArrayList<BankMembersDTO> ar = new ArrayList<BankMembersDTO>();
		
		// 1. DB 연결
		Connection con = DBConnector.getConnection();

		// 2. SQL문 생성
		String sql = "SELECT * FROM BANKMEMBERS WHERE USERNAME LIKE ? order by username ASC";
		
		// 3. 미리 보내기
		PreparedStatement st = con.prepareStatement(sql);

		// 4. ? 세팅
		st.setString(1, "%"+search+"%");

		// 5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();
		
		while(rs.next()) {
			BankMembersDTO bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUsername(rs.getString("USERNAME"));
			bankMembersDTO.setPassword(rs.getString("PASSWORD"));
			bankMembersDTO.setName(rs.getString("NAME"));
			bankMembersDTO.setEmail(rs.getString("EMAIL"));
			bankMembersDTO.setPhone(rs.getString("PHONE"));
			ar.add(bankMembersDTO);
		}

		// 6. 연결 해제
		return ar;
	}

}