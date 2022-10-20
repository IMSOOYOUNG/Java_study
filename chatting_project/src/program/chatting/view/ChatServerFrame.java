package program.chatting.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import program.chatting.controller.MemberDaoImpl;

import java.awt.event.ActionListener;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

public class ChatServerFrame extends JFrame {
    
    private JTextField textContent;
    private JTextArea textArea;
    private JPanel contentPane;
    
    private Component parent;
    private String nickname;
    
    boolean run = true;

    ServerSocket server = null;
    Socket socket = null;
    BufferedReader in = null;
    BufferedWriter out = null;
    
    /**
     * Launch the application.
     */
    public static void newChatServerFrame(Component parent, int port, String nickname) {
        ChatServerFrame frame = new ChatServerFrame(parent, nickname);
        frame.setVisible(true);
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                frame.setSocketServer(port, nickname);
            }
        }).start();
    }
    
    /**
     * Create the frame.
     */
    public ChatServerFrame(Component parent, String nickname) {
        this.parent = parent;
        this.nickname = nickname;
        initialize();
    }

    public void initialize() {
        setTitle("채팅");
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        int x = parent.getX();
        int y = parent.getY();
        
        setBounds(x, y, 450, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 10, 410, 343);
        contentPane.add(scrollPane);
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);
        
        JPanel panel = new JPanel();
        panel.setBounds(12, 363, 410, 44);
        contentPane.add(panel);
        panel.setLayout(null);
        
        textContent = new JTextField();
        textContent.setBounds(0, 1, 325, 32);
        panel.add(textContent);
        textContent.setColumns(10);
        
        JButton btnSend = new JButton("전송");
        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage();
            }
        });
        btnSend.setBounds(335, 0, 75, 32);
        panel.add(btnSend);
        
        JButton btnclose = new JButton("채팅 종료");
        btnclose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chatClose();
            }
        });
        btnclose.setBounds(12, 417, 410, 34);
        contentPane.add(btnclose);
    }

    private void chatClose() {
        if (socket == null) {
            try {
                
                MemberDaoImpl dao = MemberDaoImpl.getInstance();
                dao.update_request_to_friend_port(0, nickname);
                server.close();
                dispose();
                
                return;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        try {
            out.write("채팅방을 나갔습니다." + "\n");
            out.flush();
            
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
                socket.close();
                server.close();
                dispose();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    } 

    private void sendMessage() { // 전송
        try {
            String outMessage = textContent.getText();
            if (outMessage.equals("")) {
                return;
            }
            
            out.write(outMessage + "\n");
            out.flush();
            
            textArea.append("나 : " + outMessage + "\n");
            textContent.setText("");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void setSocketServer(int port, String nickname) {
        try {
            
            server = new ServerSocket(port);
            textArea.append("연결 대기중...\n");
            
            socket = server.accept();
            textArea.append("연결 되었습니다.\n");
            
            
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            while(run) {
                String inMessage = in.readLine();
                textArea.append(nickname + " : " + inMessage + "\n");
                
                if (inMessage.equals("채팅방을 나갔습니다.")) {
                    break;
                }
            }
                        
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
                in.close();
                socket.close();
                server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
    }
}
