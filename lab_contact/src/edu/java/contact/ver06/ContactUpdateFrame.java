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

public class ContactUpdateFrame extends JFrame {
    
    public interface OnContactUpdateListener {
        void OnContactUpdated();
    }
    
    
    private OnContactUpdateListener listener;
    private Component parent;
    private Integer contactNo;
    private ContactDaoImpl dao;
    
    private JPanel contentPane;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;

    /**
     * Launch the application.
     */
    public static void newContactUpdateFrame(Component parent, Integer contactNo, OnContactUpdateListener listener) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactUpdateFrame frame = new ContactUpdateFrame(parent, contactNo, listener);
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
    public ContactUpdateFrame(Component parent, Integer contactNo, OnContactUpdateListener listener) {
        this.parent = parent;
        this.contactNo = contactNo;
        this.dao = ContactDaoImpl.getInstance();
        this.listener = listener;
        
        initialize();
        initialiezable();
    }
    
    
    private void initialiezable() {
        Contact contact = dao.read(contactNo);
        
        if (contact != null) {
            textName.setText(contact.getName());
            textPhone.setText(contact.getPhone());
            textEmail.setText(contact.getEmail());
        }
        
        System.out.println(contact);
    }

    public void initialize() {
        setTitle("연락처 수정");
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        int x = parent.getX();
        int y = parent.getY();
        
        setBounds(x, y, 450, 457);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel lblName = new JLabel("이름");
        lblName.setFont(new Font("굴림", Font.PLAIN, 14));
        lblName.setBounds(12, 10, 410, 40);
        contentPane.add(lblName);
        
        textName = new JTextField();
        textName.setFont(new Font("굴림", Font.PLAIN, 14));
        textName.setBounds(12, 60, 410, 40);
        contentPane.add(textName);
        textName.setColumns(10);
        
        JLabel lblPhone = new JLabel("전화번호");
        lblPhone.setFont(new Font("굴림", Font.PLAIN, 14));
        lblPhone.setBounds(12, 110, 410, 40);
        contentPane.add(lblPhone);
        
        textPhone = new JTextField();
        textPhone.setFont(new Font("굴림", Font.PLAIN, 14));
        textPhone.setColumns(10);
        textPhone.setBounds(12, 160, 410, 40);
        contentPane.add(textPhone);
        
        JLabel lblEmail = new JLabel("이메일");
        lblEmail.setFont(new Font("굴림", Font.PLAIN, 14));
        lblEmail.setBounds(12, 210, 410, 40);
        contentPane.add(lblEmail);
        
        textEmail = new JTextField();
        textEmail.setFont(new Font("굴림", Font.PLAIN, 14));
        textEmail.setColumns(10);
        textEmail.setBounds(12, 260, 410, 40);
        contentPane.add(textEmail);
        
        JButton btnUpdate = new JButton("업데이트");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateContact();
            }
        });
        btnUpdate.setBounds(12, 310, 410, 55);
        contentPane.add(btnUpdate);
    }

    private void updateContact() {
        String name = textName.getText();
        String content = textPhone.getText();
        String email = textEmail.getText();
        if (name.equals("") || content.equals("")) {
            JOptionPane.showMessageDialog(this,
                    "제목과 내용은 반드시 입력되어야 합니다.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Contact contact = new Contact(contactNo, name, content, email);
        int result = dao.update(contact);
        if (result == 1) {
            JOptionPane.showMessageDialog(this, contactNo + "번 연락처 업데이트 성공");
            dispose();
            listener.OnContactUpdated();
        }
        
    }

}
