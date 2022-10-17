package program.chatting.controller;

import static program.chatting.model.Member.Entity.*;
import static program.chatting.model.MemberFriend.Entity.*;

public interface JdbcSql {
	
	// 닉네임 검색
	String SELECT_NICKNAME = String.format("select * from %s where %s = ?", TBL_MEMBER, COL_NICKNAME);
	
	// 아이디 검색
	String SELECT_IDNETITY = String.format("select * from %s where %s = ?", TBL_MEMBER, COL_IDENTITY);
	
	// 회원 가입
	String SQL_INSERT = String.format("insert into %s (%s, %s, %s) values (?, ?, ?)", TBL_MEMBER, COL_NICKNAME, COL_IDENTITY, COL_PASSWORD);
	
	// 아이디와 비밀번호
	String SQL_SELECT_ID_AND_PW = String.format("select * from %s where %s = ? and %s = ?", TBL_MEMBER, COL_IDENTITY, COL_PASSWORD);
	
	// 전체 검색
	String SQL_SELECT_ALL = String.format("select * from %s", TBL_MEMBER);
	
	// 닉네임 검색
    String SELECT_BY_NICKNAME = String.format("select * from %s where %s like ?", TBL_MEMBER, COL_NICKNAME);
    
    // 아이디 검색
    String SELECT_BY_IDENTITY = String.format("select * from %s where %s like ?", TBL_MEMBER, COL_IDENTITY);
    
    // 친구 목록 검색
//    String SELECT_BY_MEMBER_NO = String.format("select * from %s where %s = ?", TBL_MEMBER_FRIEND, COL_MEMBER_NO_MEMBER_FRIEND);
    
    String SELECT_BY_MEMBER_NO = String.format
            ("select * from %s"
                    + " left outer join %s on %s.member_no = %s.friend_no"
                    + " where %s.member_no = ?",
                    TBL_MEMBER, TBL_MEMBER_FRIEND, TBL_MEMBER, TBL_MEMBER_FRIEND, TBL_MEMBER_FRIEND);

	
}
