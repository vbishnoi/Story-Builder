package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginScreen extends JFrame {
	private JPanel contentPane;
	private JTextField txtUserName;
	private JPasswordField txtPassword;

	/**p
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Default frame = new Default();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame
	 */
	public LoginScreen() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 380, 261);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(57, 78, 61, 16);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(57, 124, 61, 16);
		contentPane.add(lblPassword);
		
		JLabel lblLoginToThe = new JLabel("Login to the system");
		lblLoginToThe.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblLoginToThe.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginToThe.setBounds(46, 23, 294, 16);
		contentPane.add(lblLoginToThe);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(130, 72, 154, 28);
		contentPane.add(txtUserName);
		txtUserName.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLogin.setBounds(132, 170, 117, 29);
		contentPane.add(btnLogin);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(130, 118, 154, 28);
		contentPane.add(txtPassword);
	}
}
