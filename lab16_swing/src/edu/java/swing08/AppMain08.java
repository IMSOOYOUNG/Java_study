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
                addInfo();
            }
        });
        btnInput.setBounds(284, 10, 138, 36);
        frame.getContentPane().add(btnInput);
        
        JButton btnDelete = new JButton("삭제");
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                deleteInfo();
            }
        });
        btnDelete.setBounds(284, 56, 138, 36);
        frame.getContentPane().add(btnDelete);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 67, 260, 184);
        frame.getContentPane().add(scrollPane);
        
        list = new JList<>();
        listModel = new DefaultListModel<>();
        list.setModel(listModel);
        
//        list.setModel(new AbstractListModel() {
//            String[] values = new String[] {"Aaa", "Bbb", "Ccc"};
//            public int getSize() {
//                return values.length;
//            }
//            public Object getElementAt(int index) {
//                return values[index];
//            }
//        });
        
        scrollPane.setViewportView(list);
    }

    private void deleteInfo() {
        int result = JOptionPane.showConfirmDialog(frame, "선택한 파일을 삭제할까요?", "삭제 확인", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        if (result == 0) {
            listModel.remove(list.getSelectedIndex());
        }
    }

    private void addInfo() {
        listModel.add(listModel.size(), textField.getText());
        System.out.println(listModel.size());
    }
    
    
    
}
