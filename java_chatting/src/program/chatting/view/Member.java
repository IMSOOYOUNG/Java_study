package program.chatting.view;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Member extends JFrame {

    private JPanel contentPane;
    
    private Component parent;
    private JTextField textNickName;
    private JTextField textIdentity;
    private JButton btnIdCheck;
    private JLabel lblPassword;
    private JTextField textPassword;
    private JButton btnJoin;

    /**
     * Launch the application.
     */
    public static void newMemberFrame(Component parent) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Member frame = new Member(parent);
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
    public Member(Component parent) {
        this.parent = parent;
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

    private void memberJoinCheck() {
        
        
    }
    
    
}
