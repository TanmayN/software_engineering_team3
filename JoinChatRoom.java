import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class JoinChatRoom extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public JoinChatRoom() {
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
		contentPane.add(chatRoomsTextArea);
		
		JButton btnNewButton = new JButton("Join");
		btnNewButton.setBounds(327, 129, 117, 29);
		contentPane.add(btnNewButton);
	}
}
