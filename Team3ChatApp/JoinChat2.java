import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

public class JoinChatRoom extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private HashMap<String, Integer> chatRoomsInfo = new HashMap<String, Integer>();
	private static final String CHATROOM_INFO_FILE = "chatrooms.txt";
	private JPanel chatRoomPanel;
	private JRadioButton[] radios;
	private ButtonGroup group;
	private String chatRoomSelected;

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
		
		
		
		JButton btnNewButton = new JButton("Join");
		btnNewButton.setBounds(327, 129, 117, 29);
		contentPane.add(btnNewButton);
		
		chatRoomPanel = new JPanel(new GridLayout(0, 1));
		chatRoomPanel.setBorder(new LineBorder(new Color(0, 0, 0)));
		chatRoomPanel.setBounds(31, 48, 265, 203);
		contentPane.add(chatRoomPanel);
		

		radios = new JRadioButton[chatRoomsInfo.size()];
		//Group the radio buttons.
		group = new ButtonGroup();
		int index = 0;
		for (String roomName : chatRoomsInfo.keySet()) {
			radios[index] =  new JRadioButton(roomName + ":" + chatRoomsInfo.get(roomName));
			radios[index].setActionCommand(roomName + ":" + chatRoomsInfo.get(roomName));

			radios[index].addActionListener(this);
			group.add(radios[index]);

			chatRoomPanel.add(radios[index]);
			
			index++;
		}

		chatRoomPanel.validate();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(e.getActionCommand());
		chatRoomSelected  = e.getActionCommand();
	}
}
