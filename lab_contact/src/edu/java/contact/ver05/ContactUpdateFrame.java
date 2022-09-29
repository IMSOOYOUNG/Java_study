package edu.java.contact.ver05;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import edu.java.contact.ver04.Contact;
import edu.java.contact.ver04.ContactDaoImpl;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactUpdateFrame extends JFrame {
    
    @FunctionalInterface
    public interface ContactUpdateListener {
        void contactUpdateNotify();
    }
    
    private Component parent; // 업데이트 창을 실행시킨 부모 컴포넌트
    private int index; // 수정할 연락처의 인덱스
    private ContactDaoImpl dao; // 연락처 검색(read), 업데이트(update), ...
    
    private JPanel contentPane;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;
    private ContactUpdateListener listener;

    /**
     * Launch the application.
     */
    public static void newContactUpdateFrame(Component parent, int index, ContactUpdateListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                ContactUpdateFrame frame = new ContactUpdateFrame(parent, index, listener);
                frame.setVisible(true);
            }
        });
    }

    /**
     * Create the frame.
     */
    public ContactUpdateFrame(Component parent, int index, ContactUpdateListener listener) {
        this.parent = parent; // 부모 컴포넌트를 초기화.
        this.index = index; // 수정할 연락처의 인덱스를 멤버로 저장.
        this.dao = ContactDaoImpl.getInstance(); // DAO 싱글턴 객체를 가져옴.
        this.listener = listener;  // 업데이트 창을 만든 메인 창의 주소를 저장.
        
        initialize(); // UI 컴포넌트들을 생성, 초기화.
        
        initializeContactInfo(); // 수정하려는 인덱스의 연락처 정보를 JTextField에 채움.
    }
    void initializeContactInfo() {
        Contact contact = dao.read(index); // 수정하려는 연락처 정보
        
        // 각 JTextField에 연락처 정보를 씀.
        textName.setText(contact.getName());
        textPhone.setText(contact.getPhone());
        textEmail.setText(contact.getEmail());
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
        
        JButton btnSave = new JButton("업데이트");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateContact();
            }
        });        
        
        btnSave.setBounds(22, 178, 97, 59);
        contentPane.add(btnSave);
        
        JButton btnCancel = new JButton("취소");
        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnCancel.setBounds(134, 178, 97, 59);
        contentPane.add(btnCancel);
    }

    private void updateContact() {
        // 각 JTextField에 입력된 내용을 읽음.
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        // Contact 타입 객체 생성
        Contact contact = new Contact(name, phone, email);
        
        // DAO의 메서드를 사용해서 연락처 정보(파일) 업데이트.
        dao.update(index, contact);
        
        // 창 닫기 
        dispose();
        
        // 메인 창(window)에게 연락처 정보 업데이트됐다고 알려줌.
        listener.contactUpdateNotify();
    }

}
