package program.chatting.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import program.chatting.controller.MemberDaoImpl;
import program.chatting.model.Member;
import static program.chatting.model.Member.Entity.*;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class MemberJoin extends JFrame {
    
    private Component parent;
    private JTextField textNickName;
    private JTextField textIdentity;
    private JButton btnIdCheck;
    private JLabel lblPassword;
    private JTextField textPassword;
    private JButton btnJoin;
    
    private JPanel contentPane;
    private MemberDaoImpl dao;

    private String nickname_overlap_flag = "";
    private String identity_overlap_flag = "";
    
    /**
     * Launch the application.
     */
    public static void newMemberFrame(Component parent) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MemberJoin frame = new MemberJoin(parent);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public MemberJoin(Component parent) {
        this.parent = parent;
        this.dao = dao.getInstance();
        initialize();
    }
    
    public void initialize() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int x = parent.getX();
        int y = parent.getY();
        
        setBounds(x, y, 450, 474);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblNickName = new JLabel("사용할 닉네임");
        lblNickName.setBounds(12, 25, 95, 31);
        contentPane.add(lblNickName);
        
        textNickName = new JTextField();
        textNickName.setBounds(12, 66, 203, 31);
        contentPane.add(textNickName);
        textNickName.setColumns(10);
        
        JButton btnNickNameCheck = new JButton("중복 체크");
        btnNickNameCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nickname_overlap_check();
			}
		});
        btnNickNameCheck.setBounds(227, 66, 97, 31);
        contentPane.add(btnNickNameCheck);
        
        JLabel lbldentity = new JLabel("아이디");
        lbldentity.setBounds(12, 107, 95, 31);
        contentPane.add(lbldentity);
        
        textIdentity = new JTextField();
        textIdentity.setColumns(10);
        textIdentity.setBounds(12, 148, 203, 31);
        contentPane.add(textIdentity);
        
        btnIdCheck = new JButton("중복 체크");
        btnIdCheck.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		identity_overlap_check();
        	}
        });
        btnIdCheck.setBounds(227, 148, 97, 31);
        contentPane.add(btnIdCheck);
        
        lblPassword = new JLabel("비밀번호");
        lblPassword.setBounds(12, 189, 95, 31);
        contentPane.add(lblPassword);
        
        textPassword = new JTextField();
        textPassword.setColumns(10);
        textPassword.setBounds(12, 230, 203, 31);
        contentPane.add(textPassword);
        
        btnJoin = new JButton("가입하기");
        btnJoin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                memberJoinCheck();
            }
        });
        btnJoin.setBounds(10, 293, 314, 31);
        contentPane.add(btnJoin);
    }

	private void nickname_overlap_check() {	// 닉네임 중복체크 메서드
		String nickname = textNickName.getText();
		if (nickname.equals("")) {
			JOptionPane.showMessageDialog(this, "닉네임을 입력하세요.");
			return;
		}
		
		int result = dao.select(1, nickname);
		if (result == 0) {
			JOptionPane.showMessageDialog(this, "중복되는 닉네임.");
			return;
		} 
		
		JOptionPane.showMessageDialog(this, "사용 가능.");
		nickname_overlap_flag = textNickName.getText();
	}
	
	private void identity_overlap_check() { // 아이디 중복체크 메서드
		String identity = textIdentity.getText();
		if (identity.equals("")) {
			JOptionPane.showMessageDialog(this, "아이디를 입력하세요.");
			return;
		}
		
		int result = dao.select(2, identity);
		if (result == 0) {
			JOptionPane.showMessageDialog(this, "중복되는 아이디.");
			return;
		} 
		
		JOptionPane.showMessageDialog(this, "사용 가능.");
		identity_overlap_flag = textIdentity.getText();
	}

	private void memberJoinCheck() { // 가입하기 메서드
        String nickname = textNickName.getText();
        String identity = textIdentity.getText();
        String password = textPassword.getText();
        
        if (password.equals("")) {	// 비밀번호가 빈 값이라면 
        	JOptionPane.showMessageDialog(this, "비밀번호를 입력하세요.");
        	return;
        }
    	if (nickname_overlap_flag.equals("") || !nickname_overlap_flag.equals(nickname)) { // 닉네임이 빈 값이거나 중복검사된 값과 달라졌다면
    		JOptionPane.showMessageDialog(this, "닉네임의 중복 체크를 해주세요.");
    		return;
    	}
    	if (identity_overlap_flag.equals("") || !identity_overlap_flag.equals(identity)) { // 아이디가 빈 값이거나 중복검사된 값과 달라졌다면
    		JOptionPane.showMessageDialog(this, "아이디의 중복 체크를 해주세요.");
    		return;
    	}
    	
    	int confirm = JOptionPane.showConfirmDialog(
    			this,
    			"회원가입하시겠습니까?",
    			"회원가입",
    			JOptionPane.YES_NO_OPTION);
    	
        if (confirm == JOptionPane.YES_OPTION) {
        	Member member = new Member(0, nickname, identity, password, 0, 0);
        	
        	int result = dao.insert(member);
        	if (result == 0) {
        		JOptionPane.showMessageDialog(this, "가입 실패.");
        		return;
        	}
        	JOptionPane.showMessageDialog(this, "회원가입되었습니다.");
        	this.dispose();
        }
        
        
    } // end memberJoinCheck 메서드
    
    
}
