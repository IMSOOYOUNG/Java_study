package edu.java.ojdbc.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import edu.java.ojdbc.model.Blog;
import oracle.jdbc.driver.OracleDriver;

import static edu.java.ojdbc.model.Blog.Entity.*;

import static edu.java.ojdbc.OracleJdbc.*;

import static edu.java.ojdbc.controller.JdbcSql.*;


public class BlogDaoImpl implements BlogDao {
    
    // Singleton 적용
    private static BlogDaoImpl instance = null;
    
    private BlogDaoImpl() {}
    
    public static BlogDaoImpl getInstance() {
        if (instance == null) {
            instance = new BlogDaoImpl();
        }
        
        return instance;
    } 

    @Override
    public List<Blog> select() {
        List<Blog> list = new ArrayList<>();
        
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            DriverManager.registerDriver(new OracleDriver());
            
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            String sql = SQL_SELECT_ALL;
            
            stmt = conn.prepareStatement(sql);
            
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Integer blogNo = rs.getInt(COL_BLOG_NO);
                String title = rs.getString(COL_TITLE);
                String content = rs.getString(COL_CONTENT);
                String author = rs.getString(COL_AUTHOR);
                LocalDateTime created = rs.getTimestamp(COL_CREATE_DATE).toLocalDateTime();
                LocalDateTime modified = rs.getTimestamp(COL_MODIFIED_DATE).toLocalDateTime();
                
                Blog blog = new Blog(blogNo, title, author, content, created, modified);
                list.add(blog);
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
    public Blog select(Integer blogNo) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int insert(Blog blog) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int update(Blog blog) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int delete(Integer blogNo) {
        // TODO Auto-generated method stub
        return 0;
    }

}
