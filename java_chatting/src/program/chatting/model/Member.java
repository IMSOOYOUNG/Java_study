package program.chatting.model;

public class Member {
	
	public interface Entity {
		String TBL_MEMBER		= "MEMBER";
		String COL_MEMBER_NO 	= "MEMBER_NO";
		String COL_NICKNAME 	= "NICKNAME";
		String COL_IDENTITY 	= "IDENTITY";
		String COL_PASSWORD 	= "PASSWORD";
		String COL_PORT_NO		= "PORT_NO";
	}
	
	private int member_no;
	private String nickname;
	private String identity;
	private String password;
	private int port_no;
	
	public Member() {}
	
	public Member(int member_no, String nickname, String identity, String password, int port_no) {
		this.member_no = member_no;
		this.nickname = nickname;
		this.identity = identity;
		this.password = password;
		this.port_no = port_no;
	}
	
	public int getMember_no() {
		return this.member_no;
	}

	public String getNickname() {
		return nickname;
	}

	public String getIdentity() {
		return identity;
	}

	public String getPassword() {
		return password;
	}

	public int getPort_no() {
		return port_no;
	}

}
