package veroBank;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class balanceFrame extends JFrame {
	
	static Connection con;
	PreparedStatement pst;
	ResultSet rs;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					balanceFrame frame = new balanceFrame(null);
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
	public balanceFrame(String loggedInAccountNumber) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 300);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Balance Frame");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon veroBankIcon = new ImageIcon (getClass().getResource("/veroBankImage/logoVer.png"));
		JLabel labelIcon = new JLabel(veroBankIcon);
		labelIcon.setBounds(120,11,96,102);
		contentPane.add(labelIcon);
		
		JLabel lblBalance = new JLabel("REMAINING BALANCE:");
		lblBalance.setForeground(new Color(39, 163, 59));
		lblBalance.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblBalance.setBounds(93, 140, 245, 23);
		contentPane.add(lblBalance);
		
		JButton backBtn = new JButton("BACK");
		backBtn.setBackground(new Color(255, 255, 255));
		backBtn.setFont(new Font("MS UI Gothic", Font.BOLD, 13));
		backBtn.setForeground(new Color(0, 0, 0));
		backBtn.setBounds(399, 206, 115, 27);
		contentPane.add(backBtn);
		
		JLabel lblNewLabel = new JLabel("VERO BANK");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(233, 49, 139, 23);
		contentPane.add(lblNewLabel);
		backBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu menu = new Menu(loggedInAccountNumber);
				menu.setVisible(true);
			}
		});
		
		displayBalance(loggedInAccountNumber);
	}
	
	public static void Connect() {
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost/bank_system", "root", "");
	    } catch (ClassNotFoundException | SQLException e) {
	        Logger.getLogger(nextRegistration.class.getName()).log(Level.SEVERE, null, e);
	    }
	}
	
	
	private void displayBalance(String loggedInAccountNumber) {
        try {
            Connect();
            String query = "SELECT Balance FROM account WHERE Account_Number = ?";
            pst = con.prepareStatement(query);
            pst.setString(1, loggedInAccountNumber);
            rs = pst.executeQuery();

            if (rs.next()) {
                int balanceValue = rs.getInt("Balance");
                JLabel balanceLabel = new JLabel(String.valueOf(balanceValue));
                balanceLabel.setForeground(new Color(0,0,0));
                balanceLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 20));
                balanceLabel.setBounds(340, 140, 226, 23);
                contentPane.add(balanceLabel);
            } else {
                
            }
        } catch (SQLException e) {
            Logger.getLogger(balanceFrame.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
