package edu.java.swing05;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class AppMain05 {

    private JFrame frame;
    private JLabel lblImage;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AppMain05 window = new AppMain05();
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
    public AppMain05() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 480, 480);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);
        
        lblImage = new JLabel(new ImageIcon("images/flower1.jpg"));
        lblImage.setBounds(12, 10, 440, 275);
        frame.getContentPane().add(lblImage);
        
        JButton btnPrev = new JButton("Prev");
        btnPrev.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                prev();
            }
        });
        btnPrev.setBounds(44, 330, 127, 56);
        frame.getContentPane().add(btnPrev);
        
        JButton btnNext = new JButton("Next");
        btnNext.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                next();
            }
        });
        btnNext.setBounds(290, 330, 127, 56);
        frame.getContentPane().add(btnNext);
        
    }
    
    int i = 1;
    private void prev() {
        if(i == 1) { 
            i = 6;
        }
        i--;
        
        System.out.println(i);
        ImageIcon icon = new ImageIcon("images/flower"+i+".jpg");
        lblImage.setIcon(icon); 
    }
    
    private void next() {
        if(i == 5) { 
            i = 0;
        }
        i++;
        
        System.out.println(i);
        ImageIcon icon = new ImageIcon("images/flower"+i+".jpg");
        lblImage.setIcon(icon); 
        
    }
    
}
