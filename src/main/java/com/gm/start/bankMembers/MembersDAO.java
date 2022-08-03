package com.gm.start.bankMembers;

import java.util.ArrayList;

public interface MembersDAO {

	// bankMembers 회원가입
	public int setJoin(BankMembersDTO bankMembersDTO) throws Exception;
	
	// 검색어를 입력해서 abc순으로 ID 찾기
	public ArrayList<BankMembersDTO> getSearchById(String search) throws Exception;

}
