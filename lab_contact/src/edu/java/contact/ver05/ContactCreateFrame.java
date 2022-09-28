package edu.java.contact.ver05;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import edu.java.contact.ver04.Contact;

public class ContactCreateFrame extends JFrame {
    
    @FunctionalInterface
    public interface ContactInsertListener {
        void contactInsertNotify(Contact c);
    }
    
    private ContactInsertListener listener;
    
    private JPanel contentPane;
    private Component parent;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;

    /**
     * Launch the application.
     */
    public static void newContactCreateFrame(Component parent, ContactInsertListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                ContactCreateFrame frame = new ContactCreateFrame(parent, listener);
                frame.setVisible(true);
            }
        });
    }

    /**
     * Create the frame.
     */
    public ContactCreateFrame(Component parent, ContactInsertListener listener) {
        this.parent = parent; // 부모 컴포넌트를 초기화.
        this.listener = listener; // contactInsertNotify() 메서드를 가지고 있는 객체를 초기화.
        initialize(); // UI 컴포넌트들을 생성, 초기화.
    }
    
    /**
     * Initialize UI components
     */
    private void initialize() {
        setTitle("새 연락처 추가");
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
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewContact();
            }
        });
        btnSave.setBounds(22, 178, 97, 59);
        contentPane.add(btnSave);
        
        JButton btnCancel = new JButton("취소");
        btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // 현재 창만 닫고, 부모 컴포넌트는 계속 실행.
            }
        });
        btnCancel.setBounds(134, 178, 97, 59);
        contentPane.add(btnCancel);
    }

    private void createNewContact() {
        // 3개의 JTextField의 입력된 문자열을 읽음.
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        // Contact 객체 생성
        Contact contact = new Contact(name, phone, email);
        
        // 새 연락처가 생성됐음을 알려줌. (ContactMain에게) 알려줌.
        listener.contactInsertNotify(contact);
        
        // 현재 창 닫기
        dispose();
    }

}
