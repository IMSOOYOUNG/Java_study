package edu.java.swing02;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain02 {

    private JFrame frame;
    private JTextField textInput;
    private JLabel lblresult;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain02 window = new AppMain02();
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
    public AppMain02() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null); // absolute layout
        
        lblresult = new JLabel("New label");
        lblresult.setBounds(12, 23, 410, 54);
        frame.getContentPane().add(lblresult);
        
        textInput = new JTextField();
        textInput.setFont(new Font("궁서", Font.PLAIN, 17));
        textInput.setBounds(12, 87, 410, 73);
        frame.getContentPane().add(textInput); // JTextField가 화면에 추가.
        textInput.setColumns(10);
        
        JButton btnInput = new JButton("입력");
        // 버튼에 이벤트 핸들러를 설정 - 이벤트가 발생했을 때 그 이벤트를 처리할 수 있는 객체를 정의.
        btnInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 버튼이 클릭됐을 때 할 일을 정의.
                // 1) JTextField에 입력된 내용을 읽음.
                String input = textInput.getText();
                // 2) 그 내용을 JLable에 씀.
                lblresult.setText(input);
            }
        });
        btnInput.setBounds(12, 170, 410, 68);
        frame.getContentPane().add(btnInput); // JButton을 화면에 추가.
    }
}
