package program.chatting.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class ChatClientFrame extends JFrame {

    private JTextField textContent;
    private JTextArea textArea;
    private JPanel contentPane;
    
    Socket socket = null;
    BufferedReader in = null;
    BufferedWriter out = null;
    
    /**
     * Launch the application.
     */
    public static void newChatClientFrame(int port, String nickname) {
        
        ChatClientFrame frame = new ChatClientFrame();
        frame.setVisible(true);
        
        new Thread(new Runnable() {
            @Override
            public void run() {
                frame.setSocketClient(port, nickname);
            }
        }).start();
        
    }

    /**
     * Create the frame.
     */
    public ChatClientFrame() {
        initialize();
    }

    public void initialize() {
        setTitle("채팅");
        
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 450, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(12, 10, 410, 392);
        contentPane.add(scrollPane);
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        scrollPane.setViewportView(textArea);
        
        JPanel panel = new JPanel();
        panel.setBounds(12, 407, 410, 44);
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
    
    public void setSocketClient(int port, String nickname) {
        try {
            socket = new Socket("192.168.20.28", port);
            textArea.append("연결 완료! \n");
            
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            while(true) {
                String inMsg = in.readLine();
                textArea.append(nickname + " : " + inMsg + "\n");
            }
                        
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    
}
