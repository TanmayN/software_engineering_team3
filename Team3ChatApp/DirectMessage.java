package Team3ChatApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;

public class DirectMessage extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DirectMessage frame = new DirectMessage();
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
	public DirectMessage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea chatTextArea = new JTextArea();
		chatTextArea.setBounds(19, 30, 396, 150);
		contentPane.add(chatTextArea);
		
		JLabel lblChats = new JLabel("Chats");
		lblChats.setBounds(157, 6, 61, 16);
		contentPane.add(lblChats);
		
		JTextArea messageTextArea = new JTextArea();
		messageTextArea.setBounds(19, 192, 325, 40);
		contentPane.add(messageTextArea);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.setBounds(145, 244, 61, 16);
		contentPane.add(lblMessage);
		
		JButton btnSend = new JButton("Send");
		btnSend.setBounds(356, 192, 74, 40);
		contentPane.add(btnSend);
	}

}
