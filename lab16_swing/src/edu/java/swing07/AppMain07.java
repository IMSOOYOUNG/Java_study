package edu.java.swing07;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AppMain07 {

    private JFrame frame;
    private final ButtonGroup buttonGroup = new ButtonGroup();
    private JRadioButton rbPrivate;
    private JRadioButton rbPackage;
    private JRadioButton rbProtected;
    private JRadioButton rbPublic;
    private JCheckBox cbabstract;
    private JCheckBox cbFinal;
    private JCheckBox cbstatic;
    private JTextPane textArea;
    private JComboBox comboBox;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain07 window = new AppMain07();
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
    public AppMain07() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        rbPrivate = new JRadioButton("Private ");
        rbPrivate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbPrivate);
        rbPrivate.setFont(new Font("궁서", Font.PLAIN, 18));
        rbPrivate.setBounds(8, 6, 135, 79);
        frame.getContentPane().add(rbPrivate);
        
        rbPackage = new JRadioButton("package");
        rbPackage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbPackage);
        rbPackage.setFont(new Font("궁서", Font.PLAIN, 18));
        rbPackage.setBounds(147, 6, 135, 79);
        frame.getContentPane().add(rbPackage);
        
        rbProtected = new JRadioButton("protected");
        rbProtected.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbProtected);
        rbProtected.setFont(new Font("궁서", Font.PLAIN, 18));
        rbProtected.setBounds(286, 6, 135, 79);
        frame.getContentPane().add(rbProtected);
        
        rbPublic = new JRadioButton("public");
        rbPublic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printRadioButtonStatus(e);
            }
        });
        buttonGroup.add(rbPublic);
        rbPublic.setFont(new Font("궁서", Font.PLAIN, 18));
        rbPublic.setBounds(425, 6, 135, 79);
        frame.getContentPane().add(rbPublic);
        
        cbabstract = new JCheckBox("abstract");
        cbabstract.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printCheckBoxStatus(e);
            }
        });
        cbabstract.setFont(new Font("궁서", Font.PLAIN, 18));
        cbabstract.setBounds(8, 103, 135, 51);
        frame.getContentPane().add(cbabstract);
        
        cbFinal = new JCheckBox("final");
        cbFinal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printCheckBoxStatus(e);
            }
        });
        cbFinal.setFont(new Font("궁서", Font.PLAIN, 18));
        cbFinal.setBounds(147, 103, 135, 51);
        frame.getContentPane().add(cbFinal);
        
        cbstatic = new JCheckBox("static");
        cbstatic.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printCheckBoxStatus(e);
            }
        });
        
        cbstatic.setFont(new Font("궁서", Font.PLAIN, 18));
        cbstatic.setBounds(286, 103, 135, 51);
        frame.getContentPane().add(cbstatic);
        
        comboBox = new JComboBox();
        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selected = (String) comboBox.getSelectedItem();
                textArea.setText(selected + " 선택");
            }
        });
        
        comboBox.setFont(new Font("궁서", Font.PLAIN, 18));
        final String[] items = {"naver.com", "kakao.com", "gmail.com", "msn.com"};
        ComboBoxModel<String> model = new DefaultComboBoxModel<>(items);
        comboBox.setModel(model);
        
        //comboBox.setModel(new DefaultComboBoxModel(new String[] {"naver.com", "kakao.com", "gmail.com", "hotmail.com"}));
        comboBox.setBounds(8, 160, 274, 51);
        frame.getContentPane().add(comboBox);
        
        JButton btnShowInfo = new JButton("확인");
        btnShowInfo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printInfo();
            }
        });
        btnShowInfo.setFont(new Font("궁서", Font.PLAIN, 18));
        btnShowInfo.setBounds(8, 221, 274, 51);
        frame.getContentPane().add(btnShowInfo);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(8, 282, 552, 319);
        frame.getContentPane().add(scrollPane);
        
        textArea = new JTextPane();
        textArea.setFont(new Font("궁서", Font.PLAIN, 14));
        scrollPane.setViewportView(textArea);
    }

    private void printInfo() {
        // RadioButton, CheckBox, ComboBox의 상태를 TextArea에 출력.
        StringBuilder buffer = new StringBuilder(); // TextArea에 출력할 문자열을 만들기 위한
    
        // 라디오버튼들 중에서 어떤 버튼이 선택됐는 지
        if (rbPrivate.isSelected()) {
            buffer.append(rbPrivate.getText());
        } else if (rbPackage.isSelected()) {
            buffer.append(rbPackage.getText());
        }  else if (rbProtected.isSelected()) {
            buffer.append(rbProtected.getText());
        } else if (rbPublic.isSelected()) {
            buffer.append(rbPublic.getText());
        }
        buffer.append(" 라디오 버튼 선택\n");
                
        // 체크박스들 중에서 어떤 체크박스들이 선택됐는 지
        if (cbabstract.isSelected()) {
            buffer.append(cbabstract.getText()).append(" ");
        }
        if (cbFinal.isSelected()) {
            buffer.append(cbFinal.getText()).append(" ");
        }
        if (cbstatic.isSelected()) {
            buffer.append(cbstatic.getText()).append(" ");
        }
        buffer.append("체크박스 선택\n");
        
        // ComboBox의 아이템들 중에서 어떤 아이템이 선택됐는 지
        String item = (String) comboBox.getSelectedItem();
        buffer.append(item).append(" 콤보박스 아이템 선택\n");
        
        // 버퍼의 내용을 TextArea에 출력
        textArea.setText(buffer.toString());
    }

    private void printCheckBoxStatus(ActionEvent e) {
        JCheckBox checkBoxBtn = (JCheckBox) e.getSource();
        String btnText = checkBoxBtn.getText();
        boolean selected = checkBoxBtn.isSelected();
        textArea.setText(btnText + " : " + selected);
    }

    private void printRadioButtonStatus(ActionEvent e) {
        JRadioButton radioBtn = (JRadioButton) e.getSource(); // 이벤트가 발생한 라디오 버튼
        String btnText = radioBtn.getText(); // 라디오 버튼의 텍스트
        boolean selected = radioBtn.isSelected(); // 라디오 버튼의 선택/해제 여부
        textArea.setText(btnText + " : " + selected);
    }
}
