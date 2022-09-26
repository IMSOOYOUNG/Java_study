package edu.java.swing04;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class AppMain04 {

    private JFrame frame;
    private JTextField textNumber1;
    private JTextField textNumber2;
    private JButton btnPlus;
    private JButton btnMinus;
    private JButton btnMultiply;
    private JButton btnDivide;
    private JTextArea textArea;
    

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain04 window = new AppMain04();
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
    public AppMain04() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(00, 100, 450, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        JLabel lblNum1 = new JLabel("number 1");
        lblNum1.setOpaque(true);
        lblNum1.setBackground(new Color(192, 192, 192));
        lblNum1.setFont(new Font("궁서", Font.PLAIN, 14));
        lblNum1.setBounds(27, 23, 93, 33);
        frame.getContentPane().add(lblNum1);
        
        textNumber1 = new JTextField();
        textNumber1.setFont(new Font("궁서", Font.PLAIN, 14));
        textNumber1.setBounds(131, 23, 197, 33);
        frame.getContentPane().add(textNumber1);
        textNumber1.setColumns(10);
        
        JLabel lblNum2 = new JLabel("number2");
        lblNum2.setBackground(new Color(192, 192, 192));
        lblNum2.setOpaque(true);
        lblNum2.setFont(new Font("궁서", Font.PLAIN, 14));
        lblNum2.setBounds(27, 66, 93, 33);
        frame.getContentPane().add(lblNum2);
        
        textNumber2 = new JTextField();
        textNumber2.setFont(new Font("궁서", Font.PLAIN, 14));
        textNumber2.setColumns(10);
        textNumber2.setBounds(131, 66, 197, 33);
        frame.getContentPane().add(textNumber2);
        
        btnPlus = new JButton("+");
        btnPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 파라미터 ActionEvent e: 이벤트가 발생한 컴포넌트, 이벤트의 종류 등에 대한
                // ActionEvent.getSource(): 이벤트가 발생한 컴포넌트를 리턴.    
                System.out.println(e.getSource() == btnPlus);
                performCalculation(e);
            }
        });
        btnPlus.setFont(new Font("궁서", Font.PLAIN, 25));
        btnPlus.setBounds(27, 129, 50, 50);
        frame.getContentPane().add(btnPlus);
        
        btnMinus = new JButton("-");
        btnMinus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                performCalculation(e);
            }
        });
        btnMinus.setFont(new Font("궁서", Font.PLAIN, 25));
        btnMinus.setBounds(113, 129, 50, 50);
        frame.getContentPane().add(btnMinus);
        
        btnMultiply = new JButton("x");
        btnMultiply.addActionListener( e -> performCalculation(e) );
        btnMultiply.setFont(new Font("궁서", Font.PLAIN, 25));
        btnMultiply.setBounds(197, 129, 50, 50);
        frame.getContentPane().add(btnMultiply);
        
        btnDivide = new JButton("/");
        btnDivide.addActionListener( e -> performCalculation(e) );
        btnDivide.setFont(new Font("궁서", Font.PLAIN, 25));
        btnDivide.setBounds(278, 129, 50, 50);
        frame.getContentPane().add(btnDivide);
        
        textArea = new JTextArea();
        textArea.setBounds(24, 194, 304, 140);
        frame.getContentPane().add(textArea);
    }
    
    private void performCalculation(ActionEvent e) {
        // JTextFiled에 입력된 문자열을 읽고, double 타입으로 변환
        String s1 = textNumber1.getText();
        String s2 = textNumber2.getText();
        
        double number1 = 0;
        double number2 = 0;
        try {
            number1 = Double.parseDouble(s1);
            number2 = Double.parseDouble(s2);
        } catch (NumberFormatException ex) {
            textArea.setText("number1 또는 number2는 숫자 타입으로 입력하세요...");
            return; // 메서드 종료
        }
        
        double result = 0; // 산술 연산 결과를 저장하기 위한 변수.
        String op = " ";
        
        Object source = e.getSource(); // 이벤트가 발생한 컴포넌트.
        
        if(source == btnPlus) {
            result = number1 + number2;
            op = " + ";
        } else if (source == btnMinus) {
            result = number1 - number2;
            op = " - ";
        } else if (source == btnMultiply) {
            result = number1 * number2;
            op = " * ";
        } else if (source == btnDivide) {
            result = number1 / number2;
            op = " / ";
        }
        
        String output = String.format("%f %s %f = %f", number1, op, number2, result);
        textArea.setText(output);
    }

}
