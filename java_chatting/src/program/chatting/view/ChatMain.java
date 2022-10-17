package program.chatting.view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import program.chatting.controller.MemberDaoImpl;
import program.chatting.model.Member;

import java.awt.BorderLayout;
import java.awt.Component;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.SpringLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Color;

public class ChatMain {

    private static final String[] COLUME_NAMES = {"아이디","닉네임"};
    
    private DefaultTableModel model;
    private JFrame frame;
    private JLabel lblUser;
    
    private JTable table;
    private JButton btnSearch;
    private JButton btnReadFriend;
    private JButton btnReadAll;
    
    private MemberDaoImpl dao;
    private Component parent;
    
    private int member_no;
    private String nickname;
    private String userId;
    
    
    private JPanel panel;
    private JTextField textSearch;
    private JPanel panel_1;
    private JButton btnAddFriend;
    private JButton btnDeleteFriend;
    private JButton btnChatting;
    

    /**
     * Launch the application.
     */
    public static void newMainFrame(Component parent, String userId) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChatMain window = new ChatMain(parent, userId);
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
    public ChatMain(Component parent, String userId) {
        this.dao = MemberDaoImpl.getInstance();
        this.parent = parent;
        this.userId = userId;        
        
        initialize();
        // 상단 이름 설정
        List<Member> list = dao.selecIdentityname(userId);
        for (Member m : list) {
            lblUser.setText("<" + m.getNickname() + ">님");
            
            this.nickname = m.getNickname();
            this.member_no = m.getMember_no();
        }
        
        initializeTable();
    }

    private void initializeTable() {
        model = new DefaultTableModel(null, COLUME_NAMES);

        List<Member> list = dao.select();
        for(Member m : list) {
            Object[] row = {m.getIdentity(), m.getNickname()};
            model.addRow(row);
        }
        
        table.setModel(model);
    }
    
    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        
        int x = parent.getX();
        int y = parent.getY();
        
        frame.setBounds(x, y, 450, 403);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        lblUser = new JLabel("???");
        lblUser.setBounds(324, 10, 98, 15);
        lblUser.setHorizontalAlignment(SwingConstants.RIGHT);
        
        panel = new JPanel();
        panel.setBounds(153, 35, 269, 32);
        frame.getContentPane().add(panel);
        panel.setLayout(null);
        
        textSearch = new JTextField();
        textSearch.setBounds(12, 7, 151, 23);
        panel.add(textSearch);
        textSearch.setColumns(10);
        
        btnSearch = new JButton("닉네임 검색");
        btnSearch.setBounds(166, 7, 103, 23);
        panel.add(btnSearch);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                userSearch();
            }
        });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(12, 77, 410, 32);
        
        btnReadAll = new JButton("모든 사용자");
        btnReadAll.setBackground(new Color(255, 255, 255));
        btnReadAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                readAll();
            }
        });
        buttonPanel.setLayout(new GridLayout(0, 2, 0, 0));
        buttonPanel.add(btnReadAll);
        
        btnReadFriend = new JButton("친구 목록");
        btnReadFriend.setBackground(new Color(240, 240, 240));
        btnReadFriend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                friendList();
            }
        });
        buttonPanel.add(btnReadFriend);
        frame.getContentPane().setLayout(null);
        frame.getContentPane().add(lblUser);
        frame.getContentPane().add(buttonPanel);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 109, 410, 196);
        frame.getContentPane().add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        
        panel_1 = new JPanel();
        panel_1.setBounds(12, 315, 410, 39);
        frame.getContentPane().add(panel_1);
        
        btnAddFriend = new JButton("친구 추가");
        btnAddFriend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFriend();
            }
        });
        
        btnDeleteFriend = new JButton("친구 삭제");
        btnDeleteFriend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        btnChatting = new JButton("채팅하기");
        btnChatting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            }
        });
        panel_1.setLayout(new GridLayout(0, 3, 0, 0));
        panel_1.add(btnAddFriend);
        panel_1.add(btnDeleteFriend);
        panel_1.add(btnChatting);
    }

    private void addFriend() { // 친구 추가
        
    }

    private void userSearch() { // 검색
        String text = textSearch.getText();
        if (text.equals("")) {
            JOptionPane.showMessageDialog(frame, "닉네임을 입력해주세요.");
            return;
        }
        
        btnReadAll.setBackground(new Color(240, 240, 240));
        btnReadFriend.setBackground(new Color(240, 240, 240));
        
        model = new DefaultTableModel(null, COLUME_NAMES);
        
        List<Member> member = dao.selectNickname(text);
        for (Member m : member) {
            Object[] row = {m.getIdentity(), m.getNickname()};
            model.addRow(row);
        }
        table.setModel(model);
        
        textSearch.setText("");
    }
    
    private void readAll() { // 전체 검색
        initializeTable();
        btnReadAll.setBackground(new Color(255, 255, 255));
        btnReadFriend.setBackground(new Color(240, 240, 240));
    }
    
    private void friendList() { // 친구 목록
        List<Member> member = dao.select_to_memberFriend(member_no);

        model = new DefaultTableModel(null, COLUME_NAMES);
        
        for(Member m : member) {
            Object[] row = {m.getIdentity(), m.getNickname()};
            model.addRow(row);
        }
        table.setModel(model);
        
        btnReadFriend.setBackground(new Color(255, 255, 255));
        btnReadAll.setBackground(new Color(240, 240, 240));
    }
    
    
}
