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
	
	/**
	 * 전체 검색
	 * @return
	 */
	List<Member> select();  
	
	/**
	 * 닉네임 컬럼 조회
	 * @param 조회하고 싶은 값
	 * @return
	 */
	List<Member> selectNickname(String text, String id);
	
	/**
     * 아이디 컬럼 조회
     * @param 조회하고 싶은 값
     * @return
     */
    List<Member> selecIdentityname(String text);
    
    /**
     * 친구 목록 조회
     * @param nickname
     * @return
     */
    List<Member> select_to_memberFriend(String text);
    
    /**
     * 파라미터의 닉네임이 친구목록에 있는지
     * @param text1 사용자의 nickname
     * @param text2 검색할 nickname
     * @return
     */
    int select_member_nickname(String text1, String text2);
    
    /**
     * 테이블에 친구 등록하기  
     * @param text1 member_nickname 값
     * @param text2 member_friend_nickname 값
     * @return
     */
    int insert_friend(String text1, String text2);
    
    /**
     * 테이블에 친구 삭제하기 
     * @param text1 삭제하고 싶은 member_nickname 값
     * @param text2 삭제하고 싶은 member_friend_nickname 값 
     * @return
     */
    int delete_friend(String text1, String text2);
    
    /**
     * 접속한 아이디를 제외하고 전체 검색
     * @param text 접속한 아이디
     * @return
     */
    List<Member> select_all_execept_user(String text);
    
    /**
     * 상대방 request 컬럼에 사용자의 포트번호 넣기
     * @param port_no 포트 번호
     * @param member_friend 상대방의 닉네임
     * @return
     */
    int update_request_to_friend_port(int port_no, String member_nickname);
    
    /**
     * 로그인 유저의 아이디 값으로 request값 확인
     * @param identity 로그인 유저의 id
     * @return
     */
    Member select_request(String identity);
    
    /**
     * 해당 아이디의 request의 값을 비움
     * @param identity
     * @return
     */
    int update_request_to_null(String identity);
    
    
    /**
     * 포트 넘버로 조회
     * @param port_no 검색하고 싶은 포터 번호
     * @return
     */
    Member select_port_no(int port_no);
    
    
}
