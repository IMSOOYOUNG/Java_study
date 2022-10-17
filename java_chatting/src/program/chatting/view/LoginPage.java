package program.chatting.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import program.chatting.controller.MemberDaoImpl;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage {

    private JFrame frame;
    private JTextField textIdentity;
    private JTextField textPassword;

    private MemberDaoImpl dao;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginPage window = new LoginPage();
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
    public LoginPage() {
        //
    	dao = MemberDaoImpl.getInstance();
    	
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(800, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblIdentity = new JLabel("아이디");
        lblIdentity.setBounds(211, 161, 57, 15);
        frame.getContentPane().add(lblIdentity);
        
        textIdentity = new JTextField();
        textIdentity.setBounds(270, 158, 116, 21);
        frame.getContentPane().add(textIdentity);
        textIdentity.setColumns(10);
        
        JLabel lblPassword = new JLabel("비밀번호");
        lblPassword.setBounds(211, 189, 57, 15);
        frame.getContentPane().add(lblPassword);
        
        textPassword = new JTextField();
        textPassword.setColumns(10);
        textPassword.setBounds(270, 186, 116, 21);
        frame.getContentPane().add(textPassword);
        
        JButton btnLogin = new JButton("로그인");
        btnLogin.addActionListener(new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		loginCheck();
        	}
        });
        btnLogin.setBounds(204, 214, 85, 23);
        frame.getContentPane().add(btnLogin);
        
        JButton btnMember = new JButton("회원가입");
        btnMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MemberJoin.newMemberFrame(frame);
            }
        });
        btnMember.setBounds(301, 214, 85, 23);
        frame.getContentPane().add(btnMember);
    }

	private void loginCheck() {
		String id = textIdentity.getText();
		String pw = textPassword.getText();
		
		if (id.equals("")) {
			JOptionPane.showMessageDialog(frame, "아이디를 입력하세요.");
			return;
		}
		if (pw.equals("")) {
			JOptionPane.showMessageDialog(frame, "비밀번호를 입력하세요");
			return;
		}
		
		int result = dao.select(id, pw);
		if(result == 0) {
			JOptionPane.showMessageDialog(frame, "아이디와 비밀번호를 다시 입력해 주세요.");
			return;
		}
		
		JOptionPane.showMessageDialog(frame, "로그인 성공");
		// TODO: 로그인 후 메인 창으로 넘어가기
	}
	
}
