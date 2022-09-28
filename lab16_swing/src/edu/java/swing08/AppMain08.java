package edu.java.swing08;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class AppMain08 {

    private JFrame frame;
    private JTextField textField;
    private JList<String> list;
    
    // JList의 원소들을 관리하는 객체:
    // JList에 
    private DefaultListModel<String> listModel;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain08 window = new AppMain08();
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
    public AppMain08() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        textField = new JTextField();
        textField.setFont(new Font("궁서", Font.PLAIN, 18));
        textField.setBounds(12, 10, 260, 36);
        frame.getContentPane().add(textField);
        textField.setColumns(10);
        
        JButton btnInput = new JButton("입력");
        btnInput.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addItemToList();
            }
        });
        btnInput.setBounds(284, 10, 138, 36);
        frame.getContentPane().add(btnInput);
        
        JButton btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteItemFromList();
            }
        });
        btnDelete.setBounds(284, 56, 138, 36);
        frame.getContentPane().add(btnDelete);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 67, 260, 184);
        frame.getContentPane().add(scrollPane);
        
        list = new JList<>(); // JLIst 객체 생성
        listModel = new DefaultListModel<>(); // JList의 원소들을 관리하는 ListModel 객체를 생성.
        list.setModel(listModel); // JList에 ListModel을 설정.
        scrollPane.setViewportView(list);
    }

    private void deleteItemFromList() {
        // JList에서 선택된 원소의 인덱스를 찾음.
        int index = list.getSelectedIndex();
        if (index == -1) {
            JOptionPane.showMessageDialog(
                    frame,
                    "리스트에서 삭제할 원소를 반드시 선택해 주세요.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        // 사용자에게 삭제 여부를 확인
        int confirm = JOptionPane.showConfirmDialog(frame,
                "정말 삭제할까요?",
                "삭제 확인",
                JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {        
            // DefaultListModel에서 특정 인덱스의 원소를 삭제하면 JList에서 그 원소가 자동으로 삭제
            listModel.remove(index);        
        }
    }

    private void addItemToList() {
        // JTextField에 입력된 내용을 읽음.
        String input = textField.getText();
        
        // JTextField에 입려된 내용이 없는 경우 getText() 메서드는 빈 문자열()을 리턴!
        if (input.equals("")) {
            JOptionPane.showMessageDialog(
                    frame,
                    "입력된 내용이 없습니다.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE);
            return; // addItemToList() 메서드를 종료
        }
        
        // JList에 새로운 원소를 추가
        listModel.addElement(input);
        
        // JTextField를 초기화 - 입력된 내용 지우기.
        textField.setText("");
    }
    
    
    
}
