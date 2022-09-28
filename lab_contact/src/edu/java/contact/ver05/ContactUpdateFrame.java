package edu.java.contact.ver05;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ContactUpdateFrame extends JFrame {

    private JPanel contentPane;
    private Component parent;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;

    /**
     * Launch the application.
     */
    public static void newContactUpdateFrame(Component parent) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                ContactUpdateFrame frame = new ContactUpdateFrame(parent);
                frame.setVisible(true);
            }
        });
    }

    /**
     * Create the frame.
     */
    public ContactUpdateFrame(Component parent) {
        this.parent = parent; // 부모 컴포넌트를 초기화.
        initialize(); // UI 컴포넌트들을 생성, 초기화.
    }
    
    /**
     * Initialize UI components
     */
    private void initialize() {
        setTitle("연락처 보기/수정");
        // 닫기 버튼을 클릭했을 때의 기본 동작 설정 - 현재 창만 닫기
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int x = parent.getX(); // 부모 컴포넌트의 x 좌표
        int y = parent.getY(); // 부모 컴포넌트의 y 좌표
        setBounds(x, y, 450, 300);
        
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lbName = new JLabel("이름");
        lbName.setHorizontalAlignment(SwingConstants.CENTER);
        lbName.setFont(new Font("궁서", Font.PLAIN, 14));
        lbName.setBounds(22, 25, 82, 41);
        contentPane.add(lbName);
        
        JLabel lbPhone = new JLabel("전화번호");
        lbPhone.setHorizontalAlignment(SwingConstants.CENTER);
        lbPhone.setFont(new Font("궁서", Font.PLAIN, 14));
        lbPhone.setBounds(22, 76, 82, 41);
        contentPane.add(lbPhone);
        
        JLabel lbEmail = new JLabel("이메일");
        lbEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lbEmail.setFont(new Font("궁서", Font.PLAIN, 14));
        lbEmail.setBounds(22, 127, 82, 41);
        contentPane.add(lbEmail);
        
        textName = new JTextField();
        textName.setFont(new Font("궁서", Font.PLAIN, 12));
        textName.setBounds(124, 25, 263, 41);
        contentPane.add(textName);
        textName.setColumns(10);
        
        textPhone = new JTextField();
        textPhone.setFont(new Font("궁서", Font.PLAIN, 12));
        textPhone.setColumns(10);
        textPhone.setBounds(124, 76, 263, 41);
        contentPane.add(textPhone);
        
        textEmail = new JTextField();
        textEmail.setFont(new Font("궁서", Font.PLAIN, 12));
        textEmail.setColumns(10);
        textEmail.setBounds(124, 127, 263, 41);
        contentPane.add(textEmail);
        
        JButton btnSave = new JButton("저장");
        btnSave.setBounds(22, 178, 97, 59);
        contentPane.add(btnSave);
        
        JButton btnCancel = new JButton("취소");
        btnCancel.setBounds(134, 178, 97, 59);
        contentPane.add(btnCancel);
    }

}
