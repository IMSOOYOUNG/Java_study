package chat.practice;

import java.awt.EventQueue;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ChatClient extends JFrame {

    private JPanel contentPane;
    private JTextField textContent;
    private JTextArea textArea;

    /**
     * Launch the application.
     */
    public static void main() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ChatClient frame = new ChatClient();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ChatClient() {
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
        panel.add(btnSend);
    }
    
    
    public void setSocket() {
        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;
                
        try {
            socket = new Socket("localhost", 9999);
            textArea.append(">> 연결 완료! \n");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            
            while(true) {
                textArea.append("보내기 >>");
                String inMessage = in.readLine();
                textArea.append("" + inMessage);
                
                if (inMessage.equalsIgnoreCase("bye")) {
                    out.write(inMessage + "\n");
                    out.flush();
                    break;
                }
                
                // 정상 메세지인 경우
                out.write(inMessage + "\n");
                out.flush();
                
                String inMsg = in.readLine();
                textArea.append("[서버] >> : " + inMessage);
                
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
