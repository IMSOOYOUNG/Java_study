package program.chatting.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginPage {

    private JFrame frame;
    private JTextField textIdentity;
    private JTextField textPassword;

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
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
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
        btnLogin.setBounds(204, 214, 85, 23);
        frame.getContentPane().add(btnLogin);
        
        JButton btnMember = new JButton("회원가입");
        btnMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Member.newMemberFrame(frame);
            }
        });
        btnMember.setBounds(301, 214, 85, 23);
        frame.getContentPane().add(btnMember);
    }
}
