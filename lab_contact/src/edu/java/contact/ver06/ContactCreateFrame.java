package edu.java.contact.ver06;

import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactCreateFrame extends JFrame {

    public interface OnContactCreateListener {
        void onContactCreated();
    }
    
    private Component parent;
    private ContactDaoImpl dao;
    private OnContactCreateListener listener;
    
    private JPanel contentPane;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;
    

    /**
     * Launch the application.
     */
    public static void newContactCreateFrame(Component parent, OnContactCreateListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactCreateFrame frame = new ContactCreateFrame(parent, listener);
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
    
    public ContactCreateFrame(Component parent , OnContactCreateListener listener) {
        this.parent = parent;
        this.listener = listener;
        dao = ContactDaoImpl.getInstance();
        initialiez();
    }
    
    public void initialiez() {
        setTitle("새 연락처 추가");
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int x = parent.getX();
        int y = parent.getY();
        
        setBounds(x, y, 450, 423);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblName = new JLabel("이름");
        lblName.setFont(new Font("굴림", Font.PLAIN, 14));
        lblName.setBounds(12, 10, 410, 42);
        contentPane.add(lblName);
        
        textName = new JTextField();
        textName.setFont(new Font("굴림", Font.PLAIN, 14));
        textName.setBounds(12, 62, 410, 42);
        contentPane.add(textName);
        textName.setColumns(10);
        
        JLabel lblPhone = new JLabel("전화번호");
        lblPhone.setFont(new Font("굴림", Font.PLAIN, 14));
        lblPhone.setBounds(12, 114, 410, 42);
        contentPane.add(lblPhone);
        
        textPhone = new JTextField();
        textPhone.setFont(new Font("굴림", Font.PLAIN, 14));
        textPhone.setColumns(10);
        textPhone.setBounds(12, 166, 410, 42);
        contentPane.add(textPhone);
        
        JLabel lblEmail = new JLabel("이메일");
        lblEmail.setFont(new Font("굴림", Font.PLAIN, 14));
        lblEmail.setBounds(12, 218, 410, 42);
        contentPane.add(lblEmail);
        
        textEmail = new JTextField();
        textEmail.setFont(new Font("굴림", Font.PLAIN, 14));
        textEmail.setColumns(10);
        textEmail.setBounds(12, 270, 410, 42);
        contentPane.add(textEmail);
        
        JButton btnSave = new JButton("저장");
        btnSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createNewContactPost();
            }
        });
        btnSave.setBounds(12, 322, 410, 52);
        contentPane.add(btnSave);
    }

    private void createNewContactPost() {
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        if (name.equals("") || phone.equals("") ) {
            JOptionPane.showMessageDialog(
                    this,
                    "제목, 내용, 작성자는 반드시 입력되어야 합니다!",
                    "ERROR", // title
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Contact contact = new Contact(null, name, phone, email);
        
        int result = dao.create(contact);
        if (result == 1) {
            JOptionPane.showMessageDialog(this, "새 연락처 추가 성공");
            dispose();
            listener.onContactCreated();
        }
        
    }
    
    
}
