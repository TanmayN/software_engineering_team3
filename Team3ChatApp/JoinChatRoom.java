package Team3ChatApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class JoinChatRoom extends JFrame {
	
	private static String username;
	private static String password;

	private JPanel contentPane;
	private HashMap<String, Integer> chatRoomsInfo = new HashMap<String, Integer>();
	private static final String CHATROOM_INFO_FILE = "chatrooms.txt";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		username = args[0];
		password = args[1];
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JoinChatRoom frame = new JoinChatRoom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void loadChatRoomsInfo() {
		try {
			List<String> lines = Files.readAllLines(Paths.get(CHATROOM_INFO_FILE));
			
			for (String line : lines) {
				String[] info = line.split(",");
				chatRoomsInfo.put(info[0], Integer.valueOf(info[1]));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.err.println(CHATROOM_INFO_FILE + " was not fouund.");
		}
		
	}
	
	/**
	 * Create the frame.
	 */
	public JoinChatRoom() {
		
		loadChatRoomsInfo();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAvailableChatrooms = new JLabel("Available Chatrooms");
		lblAvailableChatrooms.setBounds(103, 20, 136, 16);
		contentPane.add(lblAvailableChatrooms);
		
		JTextArea chatRoomsTextArea = new JTextArea();
		chatRoomsTextArea.setBounds(18, 48, 301, 199);
		
		// add char room details from the map to the text area here.
		String info = "";
		for (String room : chatRoomsInfo.keySet()) {
			info = info + room + " : " + chatRoomsInfo.get(room);
			info = info + "\n";
		}
		chatRoomsTextArea.setText(info);
		
		
		contentPane.add(chatRoomsTextArea);
		
		JButton btnNewButton = new JButton("Join");
		btnNewButton.setBounds(327, 129, 117, 29);
		contentPane.add(btnNewButton);
	}
	
	
}
