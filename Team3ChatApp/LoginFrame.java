package Team3ChatApp;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField userNameTextField;
	private JTextField passwordTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(83, 77, 97, 23);
		contentPane.add(lblUsername);
		
		userNameTextField = new JTextField();
		userNameTextField.setBounds(192, 75, 130, 26);
		contentPane.add(userNameTextField);
		userNameTextField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(83, 120, 97, 23);
		contentPane.add(lblPassword);
		
		passwordTextField = new JTextField();
		passwordTextField.setColumns(10);
		passwordTextField.setBounds(192, 118, 130, 26);
		contentPane.add(passwordTextField);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(138, 177, 117, 29);
		contentPane.add(btnLogin);
	}

}
