package Team3ChatApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ChatRoom extends JFrame {

	private JPanel contentPane;
	private Socket client = null;
	private InputStream server = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatRoom frame = new ChatRoom();
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
	public ChatRoom() {
		
		try {
			client = new Socket("127.0.0.1", 8765);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblChats = new JLabel("Chats");
		lblChats.setBounds(88, 6, 61, 16);
		contentPane.add(lblChats);
		
		JTextArea chatsTextArea = new JTextArea();
		chatsTextArea.setBounds(17, 29, 248, 144);
		contentPane.add(chatsTextArea);
		
		JTextArea membersTextArea = new JTextArea();
		membersTextArea.setBounds(277, 29, 67, 144);
		contentPane.add(membersTextArea);
		
		JLabel lblMembers = new JLabel("Members");
		lblMembers.setBounds(277, 6, 61, 16);
		contentPane.add(lblMembers);
		
		JTextArea messageTextArea = new JTextArea();
		messageTextArea.setBounds(18, 193, 248, 45);
		contentPane.add(messageTextArea); 
		
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(110, 250, 61, 16);
		contentPane.add(lblMessage);
		
		JButton btnSend = new JButton("Send");
		btnSend.setBounds(275, 209, 97, 29);
		contentPane.add(btnSend);
		
		btnSend.addActionListener((ActionListener) new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				PrintStream output = null;
				try {
					output = new PrintStream(client.getOutputStream());
					output.println("Placeholder nickname: " + messageTextArea.getText());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		});
		
		
		JButton btnDirectMessage = new JButton("DM");
		btnDirectMessage.setBounds(356, 72, 86, 21);
		contentPane.add(btnDirectMessage);
		
		try {
			new Thread(new ChatRoomReceivedMessagesHandler(client.getInputStream(), chatsTextArea)).start();
			server = client.getInputStream();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		/*Scanner s = new Scanner(server);
		while (s.hasNextLine()) {
			chatsTextArea.append(s.nextLine());
		//	System.out.println(s.nextLine());
		}*/
	//	s.close();
		/*
		

		String nickname = "placeholder";
		
		PrintStream output = new PrintStream(client.getOutputStream());*/
		/*while (sc.hasNextLine()) {
			output.println(nickname + ": " + sc.nextLine());
		}*/
		
	}

}

class ChatRoomReceivedMessagesHandler implements Runnable {

	private InputStream server;
	private JTextArea textArea;

	public ChatRoomReceivedMessagesHandler(InputStream server, JTextArea textArea) {
		this.server = server;
		this.textArea = textArea;
	}

	@Override
	public void run() {
		Scanner s = new Scanner(server);
		while (s.hasNextLine()) {
			textArea.append(s.nextLine());
		}
		s.close();
	}
}
