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

import chat.practice.ChatServer;

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
    
    private int user_member_no;
    private String user_nickname;
    private String userId;
    private int user_port_no;
    private int user_request;
    
    
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
        ChatMain window = new ChatMain(parent, userId);
//        window.frame.setVisible(true);
        
      
    }

    /**
     * Create the application.
     */
    public ChatMain(Component parent, String userId) {
        this.dao = MemberDaoImpl.getInstance();
        this.parent = parent;
        this.userId = userId;        
        
        initialize();
     
        // 상단에 이름 설정
        List<Member> list = dao.selecIdentityname(userId);
        for (Member m : list) {
            lblUser.setText("<" + m.getNickname() + ">님");
            this.user_member_no = m.getMember_no();
            this.user_nickname = m.getNickname();
            this.user_port_no = m.getPort_no();
            this.user_request = m.getRequest();
        }

        initializeTable();
        realTime();
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
                deleteFriend();
            }
        });
        
        btnChatting = new JButton("채팅하기");
        btnChatting.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatting();
            }
        });
        panel_1.setLayout(new GridLayout(0, 3, 0, 0));
        panel_1.add(btnAddFriend);
        panel_1.add(btnDeleteFriend);
        panel_1.add(btnChatting);
        
        frame.setVisible(true);
    }

    
    public void realTime() { // 5초에 한번씩 db에 request가 들어왔는지 확인하기
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    try {
                        Member m = dao.select_request(userId);
                        
                        if (m.getPort_no() != 0) {
                            initializeChat();
                        }
                        
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
          }).start();
    }
    
    private void initializeTable() {
        // 테이블 설정
        model = new DefaultTableModel(null, COLUME_NAMES);
        List<Member> list2 = dao.select_all_execept_user(userId);
        for(Member m : list2) {
            Object[] row = {m.getIdentity(), m.getNickname()};
            model.addRow(row);
        }
        table.setModel(model);
    }
    
    private void initializeChat() {
        // member 테이블에 접속한 유저의 request 조회
        Member member = dao.select_request(userId);
        int client_port = member.getRequest();
        
        // member client_port가 없으면 종료.
        if (client_port == 0) {
            return;
        }
        
        // 상대방이름 조회
        Member otherMember = dao.select_port_no(client_port);
        String nickname = otherMember.getNickname();
        
        // 채팅 요청 메세지 알림
        int confirm = JOptionPane.showConfirmDialog(
                frame,
                nickname + "님이 채팅을 수락하시겠습니까?",
                "채팅 요청",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.NO_OPTION) {
            dao.update_request_to_null(userId);
            return;
        }
        
        // 채팅창 열기
        ChatClientFrame.newChatClientFrame(client_port, nickname);
        
        // 클라이언트 채팅창 열린 후 request컬럼 비우기
        dao.update_request_to_null(userId);    
    }
    
    private void chatting() { // 채팅하기 버튼
        // 1. 선택한 행의 닉네임을 조회
        int row = table.getSelectedRow();
        String nickname = (String) model.getValueAt(row, 1);
        
        // 2. 닉네임이 내 친구 목록에 있는지 조회
        int result = dao.select_member_nickname(user_nickname, nickname);
        
        // 3. 없으면 친구가 아니라는 메세지 창을 띄움
        if (result == 0) {
            JOptionPane.showMessageDialog(frame, "친구가 아닙니다.");
            return;
        }
        
        // 4. 상대방의 request 컬럼에 내 포트 번호 넣기 
        int update_result = dao.update_request_to_friend_port(user_port_no, nickname);
        
        // 5. 채팅창 띄우기
        ChatServerFrame.newChatServerFrame(user_port_no, nickname);
    }
    

    private void deleteFriend() { // 친구 삭제
        // 1. 선택한 행의 닉네임을 조회
        int row = table.getSelectedRow();
        String nickname = (String) model.getValueAt(row, 1);
        
        // 2. 닉네임이 내 친구 목록에 있는지 조회
        int result = dao.select_member_nickname(user_nickname, nickname);
        
        // 3. 없으면 친구가 아니라는 메세지 창을 띄움
        if (result == 0) {
            JOptionPane.showMessageDialog(frame, "친구가 아닙니다.");
            return;
        }
        
        // 4. 있으면 삭제 여부 확인 후테이블에서 양쪽 모두 삭제
        int confirm = JOptionPane.showConfirmDialog(
                frame,
                "친구 목록에서 삭제하시겠습니까?",
                "친구 삭제",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.NO_OPTION) {
            return;
        }
        
        int delete_result1 = dao.delete_friend(user_nickname, nickname);
        int delete_result2 = dao.delete_friend(nickname, user_nickname);
        
        if (delete_result1 == 1 && delete_result2 == 1) {
            JOptionPane.showMessageDialog(frame, "삭제 성공");
            friendList();
        }
    }

    
    private void addFriend() { // 친구 추가
        // 1. 선택한 행의 닉네임을 조회
        int row = table.getSelectedRow();
        String nickname = (String) model.getValueAt(row, 1);
        
        // 2. 닉네임이 내 친구 목록에 있는지 조회 
        int result = dao.select_member_nickname(user_nickname, nickname);
        
        // 3. 있으면 이미 친구라는 알림을 띄우고 종료
        if (result == 1) {
            JOptionPane.showMessageDialog(frame, "등록된 친구입니다.");
            return;
        }
        
        int confirm = JOptionPane.showConfirmDialog(
                frame,
                "친구 등록하시겠습니까?",
                "친구 추가",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.NO_OPTION) {
            return;
        }
        
        // 4. 테이블에 insert하기 양쪽 다 <->
        int insert_result1 = dao.insert_friend(user_nickname, nickname);
        int insert_result2 = dao.insert_friend(nickname, user_nickname);
        if (insert_result1 == 1 && insert_result2 == 1) {
            JOptionPane.showMessageDialog(frame, "친구 목록에 추가 되었습니다.");
        }
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
        
        List<Member> member = dao.selectNickname(text, userId);
        for (Member m : member) {
            Object[] row = { m.getIdentity(), m.getNickname()};
            model.addRow(row);
        }
        table.setModel(model);
        
        textSearch.setText("");
    }
    
    
    private void readAll() { // 모든 사용자
        initializeTable();
        btnReadAll.setBackground(new Color(255, 255, 255));
        btnReadFriend.setBackground(new Color(240, 240, 240));
    }
    
    
    private void friendList() { // 친구 목록
        btnReadFriend.setBackground(new Color(255, 255, 255));
        btnReadAll.setBackground(new Color(240, 240, 240));
        
        model = new DefaultTableModel(null, COLUME_NAMES);
        
        List<Member> member = dao.select_to_memberFriend(user_nickname);
        
        for(Member m : member) {
            Object[] row = {m.getIdentity(), m.getNickname()};
            model.addRow(row);
        }
        table.setModel(model);
    }
    
    
}
