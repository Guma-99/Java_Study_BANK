package com.gm.start.bankMembers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gm.start.util.DBConnector;

@Repository("myDAO")
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
		st.setString(1, bankMembersDTO.getUserName());
		st.setString(2, bankMembersDTO.getPassWord());
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
		st.setString(1, "%" + search + "%");

		// 5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();

		while (rs.next()) {
			BankMembersDTO bankMembersDTO = new BankMembersDTO();
			bankMembersDTO.setUserName(rs.getString("userName"));
			bankMembersDTO.setPassWord(rs.getString("passWord"));
			bankMembersDTO.setName(rs.getString("name"));
			bankMembersDTO.setEmail(rs.getString("email"));
			bankMembersDTO.setPhone(rs.getString("phone"));
			ar.add(bankMembersDTO);
		}

		// 6. 연결 해제
		return ar;
	}
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.gm.start.bankMembers.BankMembersDAO.";

	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {
		
		

		return sqlSession.selectOne(NAMESPACE+"getLogin", bankMembersDTO);
		
		
	}

}
