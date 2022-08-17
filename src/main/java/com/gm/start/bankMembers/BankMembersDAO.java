package com.gm.start.bankMembers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gm.start.util.DBConnector;

@Repository("myDAO")
public class BankMembersDAO implements MembersDAO {

	@Override
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception {
		
		return sqlSession.insert(NAMESPACE+"setJoin", bankMembersDTO);
	}

	@Override
	public List<BankMembersDTO> getSearchByID(String search) throws Exception {
		ArrayList<BankMembersDTO> ar = new ArrayList<BankMembersDTO>();

		return sqlSession.selectList(NAMESPACE+"getSearchByID", search);
	}
	
	@Autowired
	private SqlSession sqlSession;
	private final String NAMESPACE = "com.gm.start.bankMembers.BankMembersDAO.";

	public BankMembersDTO getLogin(BankMembersDTO bankMembersDTO) throws Exception {

		return sqlSession.selectOne(NAMESPACE+"getLogin", bankMembersDTO);
		
		
	}

}
