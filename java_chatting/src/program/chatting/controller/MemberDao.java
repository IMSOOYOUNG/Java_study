package program.chatting.controller;

import java.util.List;

import program.chatting.model.Member;

public interface MemberDao {
	
	/**
	 * 회원가입 중복체크 
	 * @param type nickname은 1, identity는 2
	 * @param keyword 조회할 값
	 * @return
	 */
	int select(int type, String keyword); // SELECT_BY_TYPE
	
	/**
	 * 회원가입 
	 * @param member
	 * @return
	 */
	int insert(Member member); // SQL_INSERT
	
	/**
	 * 로그인시 아이디 비밀번호 조회
	 * @param id
	 * @param pw
	 * @return 아이디 있으면 1, 없으면 0을 리턴
	 */
	int select(String id, String pw); // SQL_SELECT_ID_PW
}
