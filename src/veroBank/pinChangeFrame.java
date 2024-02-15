package veroBank;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class pinChangeFrame extends JFrame{
	
	static Connection con;
	PreparedStatement pst;
	ResultSet rs;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nPin;
	private JTextField rPin;
	private JTextField Pin;
	private JButton sbmtBtn;
	private JButton btnBack;
	private boolean isPasswordVisible = false;
	private JButton btnShowHidePin;
	private JButton btnShowHideNewPin;
	private JButton btnShowHideRePin;
	private ImageIcon showIcon = new ImageIcon(getClass().getResource("/veroBankImage/showPin.png"));
	private ImageIcon hideIcon = new ImageIcon(getClass().getResource("/veroBankImage/hidePin.png"));

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pinChangeFrame frame = new pinChangeFrame(null);
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
	public pinChangeFrame(String loggedInAccountNumber) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 590, 400);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Pin Change Frame");
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
        ImageIcon veroBankIcon = new ImageIcon (getClass().getResource("/veroBankImage/logoVer.png"));
		JLabel labelIcon = new JLabel(veroBankIcon);
		labelIcon.setBounds(145,11,96,115);
		contentPane.add(labelIcon);
		
		JLabel lblTitle = new JLabel("PIN");
		lblTitle.setForeground(new Color(255, 0, 0));
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTitle.setBounds(265, 73, 40, 23);
		contentPane.add(lblTitle);
		
		JLabel lblOldPin = new JLabel("ENTER OLD PIN:");
		lblOldPin.setForeground(new Color(0, 0, 0));
		lblOldPin.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
        lblOldPin.setBounds(112, 157, 141, 14);
        contentPane.add(lblOldPin);

        Pin = new JPasswordField();
        Pin.setBackground(new Color(242, 242, 242));
        Pin.setFont(new Font("Tahoma", Font.PLAIN, 18));
        Pin.setColumns(10);
        Pin.setBounds(263, 150, 156, 30);
        contentPane.add(Pin);
        
        btnShowHidePin = new JButton(showIcon);
        btnShowHidePin.setBounds(422, 150, 27, 30);
        btnShowHidePin.setBackground(new Color(255, 255, 255));
        btnShowHidePin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        contentPane.add(btnShowHidePin);
        btnShowHidePin.setBorderPainted(false);
        btnShowHidePin.setFocusPainted(false);

        btnShowHidePin.addActionListener(e -> togglePinPasswordVisibility());
		
		JLabel lblNewPin = new JLabel("ENTER NEW PIN:");
		lblNewPin.setForeground(new Color(0, 0, 0));
		lblNewPin.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		lblNewPin.setBounds(106, 197, 141, 14);
		contentPane.add(lblNewPin);
		
		nPin = new JPasswordField();
		nPin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		nPin.setBackground(new Color(242, 242, 242));
		nPin.setBounds(263, 191, 156, 30);
		contentPane.add(nPin);
		nPin.setColumns(10);
		
		btnShowHideNewPin = new JButton(showIcon);
		btnShowHideNewPin.setBounds(422, 191, 27, 30);
		btnShowHideNewPin.setBackground(new Color(255, 255, 255));
		btnShowHideNewPin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        contentPane.add(btnShowHideNewPin);
        btnShowHideNewPin.setBorderPainted(false);
        btnShowHideNewPin.setFocusPainted(false);

        btnShowHideNewPin.addActionListener(e -> toggleNewPinPasswordVisibility());
		
		JLabel lblConfirmPin = new JLabel("CONFIRM PIN:");
		lblConfirmPin.setForeground(new Color(0, 0, 0));
		lblConfirmPin.setFont(new Font("Bookman Old Style", Font.BOLD, 15));
		lblConfirmPin.setBounds(128, 240, 119, 14);
		contentPane.add(lblConfirmPin);
		
		rPin = new JPasswordField();
		rPin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		rPin.setBackground(new Color(242, 242, 242));
		rPin.setColumns(10);
		rPin.setBounds(263, 232, 156, 30);
		contentPane.add(rPin);
		
		btnShowHideRePin = new JButton(showIcon);
		btnShowHideRePin.setBounds(422, 232, 27, 30);
		btnShowHideRePin.setBackground(new Color(255, 255, 255));
		btnShowHideRePin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 12));
        contentPane.add(btnShowHideRePin);
        btnShowHideRePin.setBorderPainted(false);
        btnShowHideRePin.setFocusPainted(false);

        btnShowHideRePin.addActionListener(e -> toggleRePinPasswordVisibility());
		
		sbmtBtn = new JButton("SUBMIT");
		sbmtBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		sbmtBtn.setForeground(new Color(0, 0, 0));
		sbmtBtn.setBackground(new Color(39, 163, 59));
		sbmtBtn.setBounds(263, 273, 156, 30);
		contentPane.add(sbmtBtn);
		
		btnBack = new JButton("BACK");
		btnBack.setFont(new Font("MS UI Gothic", Font.BOLD, 13));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu menu = new Menu(loggedInAccountNumber);
				menu.setVisible(true);
			}
		});
		btnBack.setBackground(new Color(255, 255, 255));
		btnBack.setBounds(456, 320, 108, 30);
		contentPane.add(btnBack);
		
		JLabel lblVeroBank = new JLabel("VERO BANK");
		lblVeroBank.setForeground(Color.BLACK);
		lblVeroBank.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblVeroBank.setBounds(263, 50, 130, 23);
		contentPane.add(lblVeroBank);
		
		JLabel lblChange = new JLabel("CHANGE");
		lblChange.setForeground(Color.BLACK);
		lblChange.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblChange.setBounds(305, 73, 84, 23);
		contentPane.add(lblChange);
		sbmtBtn.addActionListener(e -> {
			String oldpin = Pin.getText();
            String newpin = nPin.getText();
            String repin = rPin.getText();
            sbmtBtnActionPerformed(oldpin, newpin,repin, loggedInAccountNumber);
        });
    }
	
	public static void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/bank_system", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(nextRegistration.class.getName()).log(Level.SEVERE, null, e);
        }
    }

	private void sbmtBtnActionPerformed(String oldpin, String newpin, String repin, String loggedInAccountNumber) {
	    try {
	        Connect();
	        con.setAutoCommit(false);

	        String validateOldPinQuery = "SELECT * FROM employee WHERE Pin = ? AND employee_id = (SELECT employee_id FROM account WHERE Account_Number = ?)";

	        try (PreparedStatement pst = con.prepareStatement(validateOldPinQuery)) {
	            pst.setString(1, oldpin);
	            pst.setString(2, loggedInAccountNumber);

	            ResultSet rs = pst.executeQuery(); // Use executeQuery for SELECT queries
	            
	            if (rs.next()) {
	            	if (!repin.isEmpty() && newpin.equals(repin)) {
		                // If old PIN matches, proceed with updating the PIN...
		                String updatePinQuery = "UPDATE employee SET Pin = ? WHERE employee_id = (SELECT employee_id FROM account WHERE Account_Number = ?)";
	
		                try (PreparedStatement pstPin = con.prepareStatement(updatePinQuery)) {
		                    pstPin.setString(1, newpin);
		                    pstPin.setString(2, loggedInAccountNumber);
		                    pstPin.executeUpdate();
	
		                    con.commit();
		                    String message = "<html><body style='width: 150px; text-align: center;'>" +
	                                "<h1 style='color: #008000; font-size: 15px;'>Pin Change Successful!</h1>" +
	                                "<p style='font-size: 10px;'>Your PIN has been successfully changed.</p>" +
	                                "<hr>" +
	                                "<p style='color: #888; font-size: 10px;'>Thank you for using our services.</p>" +
	                                "</body></html>";

	                        JOptionPane.showMessageDialog(null, message);
		                    dispose();
		                    Menu menu = new Menu(loggedInAccountNumber);
		                    menu.setVisible(true);
		                    String insertPinQuery = "INSERT INTO bank_system.pinchange (newpin,repin,Account_Number) VALUES (?, ?, ?)";
		                    
		                    try(PreparedStatement pstInsert = con.prepareStatement(insertPinQuery)){
		                    	pstInsert.setString(1, newpin);
		                    	pstInsert.setString(2, repin);
		                    	pstInsert.setString(3, loggedInAccountNumber);
		                    	pstInsert.executeUpdate();
		                    	
		                    	con.commit();
		                    }
		                    catch (SQLException ex) {
		    	            Logger.getLogger(pinChangeFrame.class.getName()).log(Level.SEVERE, null, ex);
		                    }
		                } 
		                catch (SQLException ex) {
		                Logger.getLogger(pinChangeFrame.class.getName()).log(Level.SEVERE, null, ex);
		                String message = "<html><body style='width: 200px; text-align: center;'>" +
                                "<h1 style='color: #FF0000; font-size: 15px;'>Change Failed!</h1>" +
                                "<p style='font-size: 10px;'>Your attempt to change the PIN has failed.</p>" +
                                "<hr>" +
                                "<p style='color: #888; font-size: 10px;'>Please try again later or contact support.</p>" +
                                "</body></html>";

                        JOptionPane.showMessageDialog(null, message);
		                con.rollback();
		                }
	            	}else {
	            		String message = "<html><body style='width: 180px; text-align: center;'>" +
	                            "<h1 style='color: #FF0000; font-size: 15px;'>PIN Confirmation</h1>" +
	                            "<p style='font-size: 10px;'>New PIN and Confirm PIN do not match.</p>" +
	                            "<hr>" +
	                            "<p style='color: #888; font-size: 10px;'>Please ensure both PINs are identical.</p>" +
	                            "</body></html>";

	                    JOptionPane.showMessageDialog(null, message);
                        con.rollback();
	            	}
	            } else {
	            	String message = "<html><body style='width: 180px; text-align: center;'>" +
	                        "<h1 style='color: #FF0000; font-size: 15px;'>Error: PIN Mismatch</h1>" +
	                        "<p style='font-size: 10px;'>The entered old PIN doesn't match.</p>" +
	                        "<hr>" +
	                        "<p style='color: #888; font-size: 10px;'>Please verify the old PIN and try again.</p>" +
	                        "</body></html>";

	                JOptionPane.showMessageDialog(null, message);
	                con.rollback();
	            }
	        } catch (SQLException ex) {
	            Logger.getLogger(pinChangeFrame.class.getName()).log(Level.SEVERE, null, ex);
	            String message = "<html><body style='width: 200px; text-align: center;'>" +
	                    "<h1 style='color: #FF0000; font-size: 15px;'>Error: Old PIN Verification</h1>" +
	                    "<p style='font-size: 10px;'>There was an error while checking the old PIN.</p>" +
	                    "<hr>" +
	                    "<p style='color: #888; font-size: 10px;'>Please ensure the old PIN is correct.</p>" +
	                    "</body></html>";

	            JOptionPane.showMessageDialog(null, message);
	            con.rollback();
	        }
	    } catch (SQLException e) {
	        Logger.getLogger(nextRegistration.class.getName()).log(Level.SEVERE, null, e);
	    }
	}
	//FOR PIN SHOW/HIDE PASSWORD
	private void togglePinPasswordVisibility() {
        isPasswordVisible = !isPasswordVisible;

        if (isPasswordVisible) {
            ((JPasswordField) Pin).setEchoChar((char) 0);
            btnShowHidePin.setIcon(hideIcon);
        } else {
            ((JPasswordField) Pin).setEchoChar('\u25CF');
            btnShowHidePin.setIcon(showIcon);
        }
	}
	
	//FOR NEWPIN SHOW/HIDE PASSWORD
	private void toggleNewPinPasswordVisibility() {
        isPasswordVisible = !isPasswordVisible;

        if (isPasswordVisible) {
            ((JPasswordField) nPin).setEchoChar((char) 0);
            btnShowHideNewPin.setIcon(hideIcon);
        } else {
            ((JPasswordField) nPin).setEchoChar('\u25CF');
            btnShowHideNewPin.setIcon(showIcon);
        }
	}
	
	//FOR REPIN SHOW/HIDE PASSWORD
	private void toggleRePinPasswordVisibility() {
        isPasswordVisible = !isPasswordVisible;

        if (isPasswordVisible) {
            ((JPasswordField) rPin).setEchoChar((char) 0);
            btnShowHideRePin.setIcon(hideIcon);
        } else {
            ((JPasswordField) rPin).setEchoChar('\u25CF');
            btnShowHideRePin.setIcon(showIcon);
        }
	}
}
