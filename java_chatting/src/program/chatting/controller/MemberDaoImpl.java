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
import static program.chatting.model.MemberFriend.Entity.*;


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
				stmt = conn.prepareStatement(SELECT_NICKNAME);
			} else if (type == 2) {
				stmt = conn.prepareStatement(SELECT_IDNETITY);
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

	@Override
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
	public List<Member> select() {
	    List<Member> list = new ArrayList<>();
	    
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	   
	    try {
	        DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
           
            stmt = conn.prepareStatement(SQL_SELECT_ALL);
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                int member_no = rs.getInt(COL_MEMBER_NO);
                String nickname = rs.getString(COL_NICKNAME);
                String identity = rs.getString(COL_IDENTITY);
                String password = rs.getString(COL_PASSWORD);
                int port_no = rs.getInt(COL_PORT_NO);
                
                Member member = new Member(member_no, nickname, identity, password, port_no);
                
                list.add(member);
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
	    
	    return list;
	}
	
	@Override
	public List<Member> selectNickname(String text, String id) {
	    List<Member> list = new ArrayList<>();
	    
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    
	    try {
	        DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            stmt = conn.prepareStatement(SELECT_BY_NICKNAME);
            stmt.setString(1, "%" + text + "%");
            stmt.setString(2, id);

            rs = stmt.executeQuery();
            while (rs.next()) {
                int member_no = rs.getInt(COL_MEMBER_NO);
                String nickname = rs.getString(COL_NICKNAME);
                String identity = rs.getString(COL_IDENTITY);
                String password = rs.getString(COL_PASSWORD);
                int port_no = rs.getInt(COL_PORT_NO);
                
                Member member = new Member(member_no, nickname, identity, password, port_no);
                list.add(member);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
	    
	    return list;
	}
	
	@Override
	public List<Member> selecIdentityname(String text) {
	    List<Member> list = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            stmt = conn.prepareStatement(SELECT_BY_IDENTITY);
            stmt.setString(1, "%" + text + "%");

            rs = stmt.executeQuery();
            while (rs.next()) {
                int member_no = rs.getInt(COL_MEMBER_NO);
                String nickname = rs.getString(COL_NICKNAME);
                String identity = rs.getString(COL_IDENTITY);
                String password = rs.getString(COL_PASSWORD);
                int port_no = rs.getInt(COL_PORT_NO);
                
                Member member = new Member(member_no, nickname, identity, password, port_no);
                list.add(member);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return list;
	}
	

    @Override
    public List<Member> select_to_memberFriend(String text) {
        List<Member> list = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            stmt = conn.prepareStatement(SELECT_BY_MEMBER_NO);
            stmt.setString(1, text);
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                int member_no   = rs.getInt(COL_MEMBER_NO);
                String nickname = rs.getString(COL_NICKNAME);
                String identity = rs.getString(COL_IDENTITY);
                String password = rs.getString(COL_PASSWORD);
                int port_no     = rs.getInt(COL_PORT_NO);
                
                Member member = new Member(member_no, nickname, identity, password, port_no);
                list.add(member);
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
        
        return list;
    }

   
    @Override
    public int select_member_nickname(String text1, String text2) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            stmt = conn.prepareStatement(SELECT_MEMBER_NICKNAME_BY_FRIEND_NICKNAME);
            stmt.setString(1, text1);
            stmt.setString(2, text2);
            
            rs = stmt.executeQuery();
            if (rs.next()) {
                result = 1;
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return result;
    }

    
    @Override
    public int insert_friend(String text1, String text2) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            stmt = conn.prepareStatement(INSERT_FRIEND);

            System.out.println(INSERT_FRIEND);
            System.out.println(text1);
            System.out.println(text2);
            stmt.setString(1, text1);
            stmt.setString(2, text2);
            
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
    public int delete_friend(String text1, String text2) {
        int result = 0;
        
        Connection conn = null;
        PreparedStatement stmt = null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            
            stmt = conn.prepareStatement(DELETE_FRIEND);
            stmt.setString(1, text1);
            stmt.setString(2, text2);
            
            result = stmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return result;
    }

   
    @Override
    public List<Member> select_all_execept_user(String text) {
        List<Member> list = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            stmt = conn.prepareStatement(SELECT_ALL_EXECEPT_USER);
            stmt.setString(1, text);
            
            rs = stmt.executeQuery();
            while (rs.next()) {
                int member_no   = rs.getInt(COL_MEMBER_NO);
                String nickname = rs.getString(COL_NICKNAME);
                String identity = rs.getString(COL_IDENTITY);
                String password = rs.getString(COL_PASSWORD);
                int port_no     = rs.getInt(COL_PORT_NO);
                
                Member member = new Member(member_no, nickname, identity, password, port_no);
                
                list.add(member);
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        
        return list;
    }
	
	
	
    
    
    
}

