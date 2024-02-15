package veroBank;
	
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.sql.*;
	
public class LoginFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usertextField;
	private JPasswordField passwordField;
	public String loggedInAccountNumber;
	private boolean isPasswordVisible = false;
	private JButton btnShowHidePassword;
	private ImageIcon showIcon = new ImageIcon(getClass().getResource("/veroBankImage/show.png"));
	private ImageIcon hideIcon = new ImageIcon(getClass().getResource("/veroBankImage/hide.png"));
	public LineBorder BorderField = new LineBorder(new Color(215,215,215),1);
	
	
	static Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	
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
		ImageIcon frameIcon = new ImageIcon(getClass().getClassLoader().getResource("veroBankImage/veroBankPic.png"));
        setIconImage(frameIcon.getImage());
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 637, 690);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("VERO BANK");
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
		btnLogin.setBounds(208, 566, 229, 39);
		btnLogin.setBackground(new Color(39, 163, 59));
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnLogin.addActionListener(e -> btnLoginActionPerformed(usertextField.getText(), new String(passwordField.getPassword())));
		panel.add(btnLogin);

		JLabel lblUsername = new JLabel("Account Number");
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

		JLabel lblPassword = new JLabel("PIN");
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
		btnShowHidePassword.setBounds(495, 440, 40, 30);
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

		JButton btnClear = new JButton("CLEAR");
		btnClear.setBounds(328, 518, 109, 30);
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usertextField.setText("");
				passwordField.setText("");
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnClear.setBackground(Color.WHITE);
		panel.add(btnClear);

		JButton btnSignUp = new JButton("SIGN UP");
		btnSignUp.setBounds(209, 518, 109, 30);
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration register = new Registration();
				dispose();
				register.setVisible(true);
			}
		});
		btnSignUp.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnSignUp.setBackground(Color.WHITE);
		panel.add(btnSignUp);

		JLabel lblLogin = new JLabel("USER LOGIN");
		lblLogin.setBounds(232, 280, 166, 39);
		lblLogin.setForeground(new Color(96, 96, 96));
		lblLogin.setFont(new Font("Candara", Font.BOLD, 30));
		panel.add(lblLogin);

		JButton btnAdminAccount = new JButton("ADMIN ACCOUNT");
		btnAdminAccount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminLogin Alogin = new adminLogin();
				dispose();
				Alogin.setVisible(true);
			}
		});
		btnAdminAccount.setForeground(new Color(0, 0, 0));
		btnAdminAccount.setBackground(new Color(255, 255, 255));
		btnAdminAccount.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdminAccount.setBounds(481, 601, 129, 39);
		panel.add(btnAdminAccount);
		btnAdminAccount.setBorder(BorderField);
	}
	public static void Connect() {
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost/bank_system", "root", "");
	    } catch (ClassNotFoundException | SQLException e) {
	        Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, e);
	    }
	}
	private void btnLoginActionPerformed(String inputUsernameText, String inputPasswordText) {
	    Connect();
	    if (con != null) {
	    	try {
	    		String query = "SELECT a.Account_Number, e.Pin " +
	                    "FROM bank_system.account AS a " +
	                    "CROSS JOIN bank_system.employee AS e " +
	                    "WHERE a.Account_Number = ? AND e.Pin = ?";
	    		pst = con.prepareStatement(query);
	            pst.setString(1, inputUsernameText);
	            pst.setString(2, inputPasswordText);
	            rs = pst.executeQuery();

	            if (rs.next()) {
	                loggedInAccountNumber = rs.getString("Account_Number");
	                String sucMessage = "<html><body>" +
	                         "<h1 style='color: #28a745;'>Login Successful</h1>" +
	                         "<p>Welcome, <span style='color: #27A33B;'><i><b>to VERO BANK!</b></i></span></p>" +
	                         "<p style='font-style: italic;'>You have successfully logged in.</p>" +
	                         "<hr>" +
	                         "<p style='color: #888;'>Enjoy your experience!</p>" +
	                         "</body></html>";
	                JOptionPane.showMessageDialog(null, sucMessage);
	                dispose();
	                Menu menu = new Menu(loggedInAccountNumber);
	                menu.setVisible(true);
	            } else {
	            	String message = "<html><body>" +
	                         "<h1 style='color: #007bff;'>Error!</h1>" +
	                         "<p style='font-size: 14px;'>Invalid Account Number or Pin</p>" +
	                         "<p style='font-style: italic;'>Please check your credentials and try again.</p>" +
	                         "<hr>" +
	                         "<p style='color: #888;'>Contact support for assistance.</p>" +
	                         "<ul>" +
	                         "   <li>Phone: 1-150-200-4004</li>" +
	                         "   <li>Email: ivandadacay5@gmail.com</li>" +
	                         "</ul>" +
	                         "</body></html>";
	            	JOptionPane.showMessageDialog(null, message);
	            } 
	        } catch (SQLException ex) {
	            Logger.getLogger(LoginFrame.class.getName()).log(Level.SEVERE, null, ex);
	        }
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