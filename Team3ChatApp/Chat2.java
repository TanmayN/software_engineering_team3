import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;

public class ChatRoom extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		btnSend.setBounds(265, 193, 97, 29);
		contentPane.add(btnSend);
		
		JButton btnDirectMessage = new JButton("DM");
		btnDirectMessage.setBounds(356, 28, 86, 21);
		contentPane.add(btnDirectMessage);
		
		JButton btnLeaveRoom = new JButton("Leave Room");
		btnLeaveRoom.setBounds(325, 245, 117, 29);
		contentPane.add(btnLeaveRoom);
		
		textField = new JTextField();
		textField.setBounds(364, 103, 61, 26);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnStartServer = new JButton("Start");
		btnStartServer.setBounds(356, 131, 86, 29);
		contentPane.add(btnStartServer);
		
		JLabel lblPort = new JLabel("Port");
		lblPort.setBounds(376, 84, 36, 16);
		contentPane.add(lblPort);
	}
}
