package program.chatting.jdbc;

public interface OracleJdbc {
    
    // Oracle DB에 접속하는 주소(, 포트번호, SID)
    public static final String URL = "jdbc:oracle:thin:@192.168.20.28:1521:xe";
    
    // Oracle DB에 접속하는 사용자 계정
    public static final String USER = "scott";
    
    // Oracle DB에 접속하는 사용자 비밀번호
    public static final String PASSWORD = "tiger";
    
}
