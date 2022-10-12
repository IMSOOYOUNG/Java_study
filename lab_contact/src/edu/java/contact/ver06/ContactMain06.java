package edu.java.contact.ver06;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import edu.java.contact.ver06.ContactCreateFrame.OnContactCreateListener;
import edu.java.contact.ver06.ContactUpdateFrame.OnContactUpdateListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ContactMain06 implements OnContactCreateListener, OnContactUpdateListener{
    private static final String[] COLUME_NAMES = {"번호", "이름", "전화번호", "이메일"};
    
    private JFrame frame;
    private JTable table;
    private DefaultTableModel model;
    
    private ContactDaoImpl dao;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ContactMain06 window = new ContactMain06();
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
    public ContactMain06() {
        initialize();
        dao = ContactDaoImpl.getInstance();
        
        initializeable();
    }

    private void initializeable() {
        model = new DefaultTableModel(null, COLUME_NAMES);
        
        table.setModel(model);
        
        List<Contact> list = dao.read();
        
        for(Contact c : list) {
            Object[] row = {c.getCid(), c.getName(), c.getPhone(), c.getEmail()};
            model.addRow(row);
        }
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel buttonPanel = new JPanel();
        frame.getContentPane().add(buttonPanel, BorderLayout.NORTH);
        
        JButton btnCreate = new JButton("새 연락처");
        btnCreate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ContactCreateFrame.newContactCreateFrame(frame, ContactMain06.this);
            }
        });
        buttonPanel.add(btnCreate);
        
        JButton btnUpdate = new JButton("연락처 수정");
        btnUpdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateContact();
            }
        });
        buttonPanel.add(btnUpdate);
        
        JButton btnDelete = new JButton("연락처 삭제");
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteContact();
            }
        });
        buttonPanel.add(btnDelete);
        
        JButton btnSearch = new JButton("연락처 검색");
        buttonPanel.add(btnSearch);
        
        JScrollPane scrollPane = new JScrollPane();
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        model = new DefaultTableModel(null, COLUME_NAMES);
        table.setModel(model);
        scrollPane.setViewportView(table);
    }

    private void deleteContact() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(frame,
                    "테이블 행을 먼저 선택하세요.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Integer contactNo = (Integer) model.getValueAt(row, 0);
        
        int confirm = JOptionPane.showConfirmDialog(frame, 
                contactNo + "번 연락처를 정말 삭제할까요?",
                "삭제 확인",
                JOptionPane.YES_NO_CANCEL_OPTION);
        
        if (confirm == JOptionPane.YES_OPTION) {
            int result = dao.delete(contactNo);
            if (result == 1) {
                JOptionPane.showMessageDialog(frame, contactNo + " 연락처 삭제 성공");
                initializeable();
            }
        }
        
    }

    private void UpdateContact() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(frame,
                    "테이블의 행을 먼저 선택하세요.", 
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        Integer contactNo = (Integer) model.getValueAt(row, 0);
        
        ContactUpdateFrame.newContactUpdateFrame(frame, contactNo, this);
    }

    @Override
    public void onContactCreated() {
        initializeable();
        
    }

    @Override
    public void OnContactUpdated() {
        initializeable();        
    }

}
