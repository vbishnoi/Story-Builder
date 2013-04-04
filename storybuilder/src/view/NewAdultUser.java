package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class NewAdultUser extends JFrame {
	private JPanel contentPane;
	private JTextField txtEnterName;
	private JPasswordField pwdPassword;
	private JTextField txtEnterAge;

	/**
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
	 * Create the frame.
	 */
	public NewAdultUser() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.WEST);
		
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		panel.setPreferredSize(new Dimension(200, 200));
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 1;
		panel.add(lblName, gbc_lblName);
		
		txtEnterName = new JTextField();
		txtEnterName.setText("Enter name");
		GridBagConstraints gbc_txtEnterName = new GridBagConstraints();
		gbc_txtEnterName.insets = new Insets(0, 0, 5, 0);
		gbc_txtEnterName.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterName.gridx = 2;
		gbc_txtEnterName.gridy = 1;
		panel.add(txtEnterName, gbc_txtEnterName);
		txtEnterName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.EAST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 3;
		panel.add(lblPassword, gbc_lblPassword);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setText("Password");
		GridBagConstraints gbc_pwdPassword = new GridBagConstraints();
		gbc_pwdPassword.insets = new Insets(0, 0, 5, 0);
		gbc_pwdPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_pwdPassword.gridx = 2;
		gbc_pwdPassword.gridy = 3;
		panel.add(pwdPassword, gbc_pwdPassword);
		
		JLabel lblAge = new JLabel("Age:");
		GridBagConstraints gbc_lblAge = new GridBagConstraints();
		gbc_lblAge.anchor = GridBagConstraints.EAST;
		gbc_lblAge.insets = new Insets(0, 0, 5, 5);
		gbc_lblAge.gridx = 1;
		gbc_lblAge.gridy = 5;
		panel.add(lblAge, gbc_lblAge);
		
		txtEnterAge = new JTextField();
		txtEnterAge.setText("Enter age");
		GridBagConstraints gbc_txtEnterAge = new GridBagConstraints();
		gbc_txtEnterAge.insets = new Insets(0, 0, 5, 0);
		gbc_txtEnterAge.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtEnterAge.gridx = 2;
		gbc_txtEnterAge.gridy = 5;
		panel.add(txtEnterAge, gbc_txtEnterAge);
		txtEnterAge.setColumns(10);
		
		JButton btnRegister = new JButton("Register");
		GridBagConstraints gbc_btnRegister = new GridBagConstraints();
		gbc_btnRegister.gridx = 2;
		gbc_btnRegister.gridy = 7;
		panel.add(btnRegister, gbc_btnRegister);
		
		JLabel lblNewUserRegistration = new JLabel("New user registration");
		lblNewUserRegistration.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewUserRegistration, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		panel_1.setPreferredSize(new Dimension(100, 50));
		panel_1.setBorder(BorderFactory.createLineBorder(Color.black));
	}
}
