package program.chatting.controller;

import static program.chatting.model.Member.Entity.*;

public interface JdbcSql {

//	String SELECT_BY_TYPE = String.format("select * from %s where ? = ?", TBL_MEMBER);
	
	// 닉네임 검색
	String SELECT_BY_NICKNAME = String.format("select * from %s where %s = ?", TBL_MEMBER, COL_NICKNAME);
	
	// 아이디 검색
	String SELECT_BY_IDNETITY = String.format("select * from %s where %s = ?", TBL_MEMBER, COL_IDENTITY);
	
	// 회원 가입
	String SQL_INSERT = String.format("insert into %s (%s, %s, %s) values (?, ?, ?)", TBL_MEMBER, COL_NICKNAME, COL_IDENTITY, COL_PASSWORD);

	String SQL_SELECT_ID_AND_PW = String.format("select * from %s where %s = ? and %s = ?", TBL_MEMBER, COL_IDENTITY, COL_PASSWORD);
	
}
