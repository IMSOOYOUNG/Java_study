package edu.java.ojdbc.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.ojdbc.controller.BlogDaoImpl;
import edu.java.ojdbc.model.Blog;
import edu.java.ojdbc.view.BlogCreateFrame.OnBlogInsertListener;
import edu.java.ojdbc.view.BlogDetailFrame.OnBlogUpdateListener;

import static edu.java.ojdbc.controller.JdbcSql. *;
import static edu.java.ojdbc.model.Blog.Entity.*;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class BlogMain implements OnBlogInsertListener, OnBlogUpdateListener {
    // 메인 화면에서 보여줄 JTable의 컬럼 이름들
    private static final String[] COLUMN_NAMES = {
            COL_BLOG_NO, COL_TITLE, COL_AUTHOR, COL_MODIFIED_DATE            
    };
    
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    private JComboBox<String> comboBox;

    private BlogDaoImpl dao;
    private JTextField textKeyword;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BlogMain window = new BlogMain();
                    window.frame.setVisible(true);
                } catch (Exception e) { 
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public BlogMain() {
        initialize(); // UI 컴포넌트 생성, 초기화
        dao = BlogDaoImpl.getInstance(); 
        initializeTable(); // 메인 화면에서의 JTable 데이터 초기화
    }

    private void initializeTable() {
        // 데이터는 없는, 컬럼 이름들만 설정된 테이블 모델 객체를 생성. -> 데이터 초기화.
        model = new DefaultTableModel(null, COLUMN_NAMES);
        
        // 테이블에 모든 객체를 설정.
        table.setModel(model);
        
        // DB에서 데이터를 검색.
        List<Blog> list = dao.select();
        for (Blog b : list) {
            Object[] row = {
                    b.getBlogNo(), b.getTitle(), b.getAuthor(), b.getModifiedDate()
            };
            model.addRow(row); // 테이블 모델에 행(row) 데이터로 추가.
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 565, 478);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setTitle("블로그 메인");
        
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        
        JButton btnCreate = new JButton("새 글 작성");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 새 블로그 글 작성 Frame 만들기.
                BlogCreateFrame.newBlogCreateFrame(frame, BlogMain.this);
            }
        });
        
        JButton btnReadAll = new JButton("전체 보기");
        btnReadAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initializeTable();
            }
        });
        btnReadAll.setFont(new Font("굴림", Font.PLAIN, 14));
        buttonPanel.add(btnReadAll);
        btnCreate.setFont(new Font("굴림", Font.PLAIN, 14));
        buttonPanel.add(btnCreate);
        
        JButton btnRead = new JButton("상세보기");
        btnRead.addActionListener(new ActionListener() {            
            @Override
            public void actionPerformed(ActionEvent e) {
                showDetailFrame();               
            }
        });
        btnRead.setFont(new Font("굴림", Font.PLAIN, 14));
        buttonPanel.add(btnRead);
        
        JButton btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteBlog();
            }
        });
        btnDelete.setFont(new Font("굴림", Font.PLAIN, 14));
        buttonPanel.add(btnDelete);
        
        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();        
        scrollPane.setViewportView(table);
        
        JPanel searchPanel = new JPanel();
        frame.getContentPane().add(searchPanel, BorderLayout.SOUTH);
        
        comboBox = new JComboBox<>();
        String[] comboBoxItems = {"제목", "내용", "제목 + 내용", "작성자"};
        DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(comboBoxItems);
        comboBox.setModel(comboBoxModel);
        comboBox.setSelectedIndex(0);
//        comboBox.setModel(new DefaultComboBoxModel(new String[] {"제목", "내용", "제목 + 내용", "작성자"}));  위의 세줄로 변경
        searchPanel.add(comboBox);
        
        textKeyword = new JTextField();
        searchPanel.add(textKeyword);
        textKeyword.setColumns(10);
        
        JButton btnSearch = new JButton("검색");
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                searchBlogsByKeyword();
            }
        });
        searchPanel.add(btnSearch);
    }
    
    private void searchBlogsByKeyword() {
        String keyword = textKeyword.getText();        
        if (keyword.equals("") ) { // 검색어 JTextField가 비어 있으면
            JOptionPane.showMessageDialog(frame, // parentComponent
                    "검색어를 입력하세요.", // message
                    "Warning", // title
                    JOptionPane.WARNING_MESSAGE); // messageType            
            return;
        }        
        
        int type = comboBox.getSelectedIndex();
        System.out.println("type = " + type + ", keyword = " + keyword);
        
        // TODO: DAO에 검색 타입과 검색어를 argument로 갖는 검색 메서드 호출.
        List<Blog> list = dao.select(type, keyword);
        
        model = new DefaultTableModel(null, COLUMN_NAMES);
        table.setModel(model);
        for(Blog b : list) {
            Object[] row = {b.getBlogNo(), b.getTitle(), b.getAuthor(), b.getModifiedDate()};
            model.addRow(row);
        }
        
    }

    private void showDetailFrame() {
       int row = table.getSelectedRow();
       if (row == -1) {
           JOptionPane.showMessageDialog(frame, // parentComponent
                   "테이블의 행을 먼저 선택하세요.", // message
                   "Error", // title
                   JOptionPane.ERROR_MESSAGE); // messageType
           return;
       }
        
       Integer blogNo = (Integer) model.getValueAt(row, 0);
       System.out.println("blogNo = " + blogNo);
       
       BlogDetailFrame.newBlogDetailFrame(frame, blogNo, BlogMain.this); // BlogMain.this = this 
    }

    private void deleteBlog() {
        int row = table.getSelectedRow(); // 테이블에서 선택된 행 인덱스
        if (row == -1) { // JTable에서 선택된 행이 없는 경우,
            JOptionPane.showMessageDialog(frame, // parentComponent
                    "삭제하려는 행을 먼저", // message
                    "Error", // title
                    JOptionPane.ERROR_MESSAGE); // messageType
            return; // 메서드 종료.
        }
        
        // 선택된 행에서 인덱스 0번 컬럼의 값(BLOG_NO)을 읽음.
        Integer blogNo = (Integer) model.getValueAt(row, 0);
        System.out.println("blogNo= " + blogNo);
        
        int confirm = JOptionPane.showConfirmDialog(frame, // parentComponet
                blogNo + "번 블로그 글을 정말 삭제할까요?", // message
                "삭제 확인", // title
                JOptionPane.YES_NO_CANCEL_OPTION); // 확인 버튼 종류
        
        if (confirm == JOptionPane.YES_OPTION) {
            // Dao 객체의 delete 메서드를 사용해서 DB에서 삭제.
            int result = dao.delete(blogNo);
            if (result == 1) {
                JOptionPane.showMessageDialog(frame, blogNo + " 블로그 글 삭제 성공");
                initializeTable(); // 테이블 갱신
            } else {
                JOptionPane.showMessageDialog(frame,
                        "블로그 글 삭제 실패",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    @Override // BlogCreateFrame.OnBlogInsertListener 인터페이스의 메서드 구현
    public void onBlogInserted() {
        initializeTable();
    }

    @Override // BlogCreateFrame.OnBlogUpdateListener 인터페이스 메서드 구현
    public void OnBlogUpdated() {
        initializeTable();
    }

}
