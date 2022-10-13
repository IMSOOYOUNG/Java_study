package chat.practice;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChatServer extends JFrame {

    private JPanel contentPane;
    private JTextField textContent;
    private JTextArea textArea;

    private ServerSocket server = null;
    private Socket socket = null;
    private BufferedReader in = null;
    private BufferedWriter out = null;
    
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChatServer frame = new ChatServer();
                    frame.setVisible(true);
                    frame.setSocket();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ChatServer() {
        initialize();
    }
    
    public void initialize() {
        setTitle("채팅");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        contentPane.add(scrollPane, BorderLayout.CENTER);
        
        textArea = new JTextArea();
        scrollPane.setViewportView(textArea);
        
        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.SOUTH);
        
        textContent = new JTextField();
        panel.add(textContent);
        textContent.setColumns(10);
        
        JButton btnSend = new JButton("전송");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        panel.add(btnSend);
    }
    
    
    public void setSocket() {
        try {
            server = new ServerSocket(9999);
            textArea.append("연결 대기중...\n");
            
            socket = server.accept();
            textArea.append("연결 되었습니다.\n");
            
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            while(true) {
                String inMessage = in.readLine();
                
                if (inMessage.equalsIgnoreCase("bye")) {
                    textArea.append("클라이언트가 나갔습니다.\n");
                    break;
                }
                
                textArea.append("[클라이언트] : " + inMessage + "\n");
                textArea.append("보내기 >>");                
                
                String outMessage = textContent.getText();
                out.write(outMessage + "\n");
                out.flush();
            }
                        
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    

}
