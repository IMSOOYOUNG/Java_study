package program.chatting.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import oracle.jdbc.driver.OracleDriver;
import program.chatting.model.Member;

import static program.chatting.jdbc.OracleJdbc.*;
import static program.chatting.controller.JdbcSql.*;
import static program.chatting.model.Member.Entity.*;


public class MemberDaoImpl implements MemberDao {

	private static MemberDaoImpl instance = null;
	
	private MemberDaoImpl() {};
	
	public static MemberDaoImpl getInstance() {
		if (instance == null) {
			instance = new MemberDaoImpl();
		}
		return instance;
	}
	
	@Override
	public int select(int type, String keyword) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			if (type == 1) {
				stmt = conn.prepareStatement(SELECT_BY_NICKNAME);
			} else if (type == 2) {
				stmt = conn.prepareStatement(SELECT_BY_IDNETITY);
			}
			
			stmt.setString(1, keyword);
	
			rs = stmt.executeQuery();
			if(rs.next()) {
				result = 0;
			}else {
				result = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
				
		return result;
	}

	public int insert(Member member) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			stmt = conn.prepareStatement(SQL_INSERT);
			stmt.setString(1, member.getNickname());
			stmt.setString(2, member.getIdentity());
			stmt.setString(3, member.getPassword());
			System.out.println(SQL_INSERT);
			
			result = stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

	@Override
	public int select(String id, String pw) {
		int result = 0;
		
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			DriverManager.registerDriver(new OracleDriver());
			conn = DriverManager.getConnection(URL, USER, PASSWORD);
			
			stmt = conn.prepareStatement(SQL_SELECT_ID_AND_PW);
			stmt.setString(1, id);
			stmt.setString(2, pw);
			
			rs = stmt.executeQuery();
			while(rs.next()) {
				result = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
		}
		
		return result;
	}
	
}
