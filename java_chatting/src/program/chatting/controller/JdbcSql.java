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
    String SELECT_BY_NICKNAME = String.format("select * from %s where %s like ? and %s != ?", TBL_MEMBER, COL_NICKNAME, COL_IDENTITY);
    
    // 아이디 검색
    String SELECT_BY_IDENTITY = String.format("select * from %s where %s like ?", TBL_MEMBER, COL_IDENTITY);
    
    // 친구 목록 닉네임으로 검색
    String SELECT_BY_MEMBER_NO = String.format
            ("select * from %s m"
                    + " left outer join %s f on m.nickname = f.member_friend_nickname"
                    + " where f.member_nickname = ?",
                    TBL_MEMBER, TBL_MEMBER_FRIEND);

	// 친구 테이블에 친구 검색
    String SELECT_MEMBER_NICKNAME_BY_FRIEND_NICKNAME =
            String.format("select * from %s where %s = ? and %s = ?", TBL_MEMBER_FRIEND, COL_MEMBER_NICKNAME, COL_MEMBER_FRIEND_NICKNAME);
    
    // 친구 테이블에 친구 추가
    String INSERT_FRIEND = String.format("insert into %s (%s, %s) values (?, ?)", TBL_MEMBER_FRIEND, COL_MEMBER_NICKNAME, COL_MEMBER_FRIEND_NICKNAME);
 
    // 친구 테이블에 친구 삭제
    String DELETE_FRIEND = String.format("delete from %s where %s = ? and %s = ?", TBL_MEMBER_FRIEND, COL_MEMBER_NICKNAME, COL_MEMBER_FRIEND_NICKNAME);
    
    // 아이디로 접속한 아이디 빼고 전체 검색
    String SELECT_ALL_EXECEPT_USER = String.format("select * from %s where %s != ?", TBL_MEMBER, COL_IDENTITY);
}





