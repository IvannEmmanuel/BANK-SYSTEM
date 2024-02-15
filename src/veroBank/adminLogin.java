package veroBank;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

public class adminLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usertextField;
	private JPasswordField passwordField;
	private JLabel loginFailed;
	private boolean isPasswordVisible = false;
	private JButton btnShowHidePassword;
	private ImageIcon showIcon = new ImageIcon(getClass().getResource("/veroBankImage/show.png"));
	private ImageIcon hideIcon = new ImageIcon(getClass().getResource("/veroBankImage/hide.png"));
	public LineBorder BorderField = new LineBorder(new Color(215,215,215),1);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminLogin frame = new adminLogin();
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
	public adminLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 690);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 620, 651);
		contentPane.add(panel);
		panel.setLayout(null);
		
		ImageIcon backIcon = new ImageIcon (getClass().getResource("/veroBankImage/backs.png"));
		JButton back = new JButton(backIcon);
		back.setBackground(new Color(255, 255, 255));
		back.setBounds(10,11,83,64);
		back.setBorderPainted(false);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				LoginFrame lFrame = new LoginFrame();
				lFrame.setVisible(true);
			}
		});
		panel.add(back);
		
		JLabel lblVeroBank = new JLabel("VERO BANK");
		lblVeroBank.setBounds(238, 228, 154, 39);
		lblVeroBank.setForeground(new Color(96, 96, 96));
		lblVeroBank.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 30));
		panel.add(lblVeroBank);
		
		ImageIcon veroBankIcon = new ImageIcon (getClass().getResource("/veroBankImage/logoBank.png"));
		JLabel labelIcon = new JLabel(veroBankIcon);
		labelIcon.setBounds(208,63,196,170);
		panel.add(labelIcon);
		
		JButton btnLogin = new JButton("LOGIN");		
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setBounds(194, 501, 119, 34);
		btnLogin.setBackground(new Color(39, 163, 59));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogin.addActionListener(e -> btnLoginActionPerformed());
		panel.add(btnLogin);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(143, 336, 181, 14);
		lblUsername.setForeground(new Color(96, 96, 96));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblUsername);
		
		usertextField = new JTextField();
		usertextField.setBounds(143, 361, 346, 39);
		usertextField.setBackground(new Color(242, 242, 242));
		usertextField.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(usertextField);
		usertextField.setColumns(10);
		usertextField.setBorder(BorderField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(143, 410, 91, 14);
		lblPassword.setForeground(new Color(96, 96, 96));
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(143, 435, 346, 39);
		passwordField.setBackground(new Color(242, 242, 242));
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 18));
		panel.add(passwordField);
		passwordField.setBorder(BorderField);
		
		btnShowHidePassword = new JButton(showIcon);
		btnShowHidePassword.setBounds(495, 435, 40, 39);
		btnShowHidePassword.setBackground(Color.WHITE);
		btnShowHidePassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
		panel.add(btnShowHidePassword);
		btnShowHidePassword.setBorderPainted(false);
		btnShowHidePassword.setFocusPainted(false);

		btnShowHidePassword.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        togglePasswordVisibility();
		    }
		});
		
		loginFailed = new JLabel("");
		loginFailed.setBounds(227, 563, 205, 14);
		loginFailed.setForeground(new Color(96, 96, 96));
		loginFailed.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(loginFailed);
		
		JButton btnClear = new JButton("CLEAR");
		btnClear.setForeground(new Color(0, 0, 0));
		btnClear.setBounds(335, 502, 119, 34);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usertextField.setText("");
				passwordField.setText("");
				loginFailed.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClear.setBackground(new Color(39, 163, 59));
		panel.add(btnClear);
		
		JLabel lblAdmin = new JLabel("ADMIN USER");
		lblAdmin.setForeground(new Color(96, 96, 96));
		lblAdmin.setFont(new Font("Candara", Font.BOLD, 30));
		lblAdmin.setBounds(227, 278, 171, 39);
		panel.add(lblAdmin);
	}
	private void btnLoginActionPerformed() {
		String username = usertextField.getText(); //admin
		String password = new String (passwordField.getPassword()); //123
		
		if (username.equals("admin") && password.equals("123")) {
			adminMenu admin = new adminMenu();
			dispose();
			admin.setVisible(true);
		}
		else {
			JOptionPane.showMessageDialog(null, "Account not created");	
			}
	}
	private void togglePasswordVisibility() {
	    isPasswordVisible = !isPasswordVisible;

	    if (isPasswordVisible) {
	        passwordField.setEchoChar((char) 0); //show password
	        btnShowHidePassword.setIcon(hideIcon);
	    } else {
	        passwordField.setEchoChar('\u25CF'); //back to normal "*"
	        btnShowHidePassword.setIcon(showIcon);
	    }
	}
}
