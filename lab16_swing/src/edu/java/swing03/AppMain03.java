package edu.java.swing03;

import java.awt.EventQueue;
import java.awt.TextArea;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class AppMain03 {

    private JFrame frame;
    private JTextField textName;
    private JTextField textPhone;
    private JTextField textEmail;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain03 window = new AppMain03();
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
    public AppMain03() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblName = new JLabel("이름");
        lblName.setFont(new Font("궁서", Font.PLAIN, 14));
        lblName.setBounds(39, 33, 97, 39);
        frame.getContentPane().add(lblName);
        
        textName = new JTextField();
        textName.setFont(new Font("궁서", Font.PLAIN, 12));
        textName.setBounds(150, 33, 246, 39);
        frame.getContentPane().add(textName);
        textName.setColumns(10);
        
        JLabel lblPhone = new JLabel("전화번호");
        lblPhone.setFont(new Font("궁서", Font.PLAIN, 14));
        lblPhone.setBounds(39, 82, 97, 39);
        frame.getContentPane().add(lblPhone);

        textPhone = new JTextField();
        textPhone.setFont(new Font("궁서", Font.PLAIN, 12));
        textPhone.setColumns(10);
        textPhone.setBounds(150, 82, 246, 39);
        frame.getContentPane().add(textPhone);
        
        JLabel lblEmail = new JLabel("이메일");
        lblEmail.setFont(new Font("궁서", Font.PLAIN, 14));
        lblEmail.setBounds(39, 131, 97, 39);
        frame.getContentPane().add(lblEmail);
        
        textEmail = new JTextField();
        textEmail.setFont(new Font("궁서", Font.PLAIN, 12));
        textEmail.setColumns(10);
        textEmail.setBounds(150, 131, 246, 39);
        frame.getContentPane().add(textEmail);
        
        JButton btnNewButton = new JButton("입력");
        // 버튼의 이벤트 핸들러를 등록
        // 이벤트 핸들러: 이벤트가 발생됐을 때 자동으로 호출되는 메서드.
        btnNewButton.addActionListener(x -> printInfo() );
        btnNewButton.setBounds(39, 180, 357, 39);
        frame.getContentPane().add(btnNewButton);
        
        textArea = new JTextArea();
        textArea.setFont(new Font("궁서", Font.PLAIN, 14));
        textArea.setBounds(39, 231, 357, 101);
        frame.getContentPane().add(textArea);
        
    }
    
    // "입력" 버튼을 클릭했을 때 실행할 내용.
    private void printInfo() {
     // JTextField에 입력된 내용을 읽음.
        String name = textName.getText();
        String phone = textPhone.getText();
        String email = textEmail.getText();
        
        // JTextArea에 출력할 문자열 만들기
        StringBuilder buffer = new StringBuilder();
        buffer.append("이름: ").append(name).append("\n")
            .append("전화번호: ").append(phone).append("\n")
            .append("이메일").append(email);
        
        // 만들어진 문자열을 JTextArea에 출력
        textArea.setText(buffer.toString());
    }
    
}
