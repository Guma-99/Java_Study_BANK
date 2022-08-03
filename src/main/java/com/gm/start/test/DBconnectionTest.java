package com.gm.start.test;

import java.sql.Connection;

import com.gm.start.util.DBConnector;

public class DBconnectionTest {

	public static void main(String[] args) {
		try {
			Connection con = DBConnector.getConnection();
			System.out.println(con != null);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
