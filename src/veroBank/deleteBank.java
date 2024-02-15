package veroBank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class deleteBank extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Account_Number;
	
	static Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JLabel lblNewLabel;
	private JButton btnNewButton;
	private JTextField Employee_ID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteBank frame = new deleteBank();
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
	public deleteBank() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 576, 274);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 252, 252));
		contentPane.setForeground(new Color(195, 195, 195));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAccount_Number = new JLabel("Account_Number");
		lblAccount_Number.setForeground(new Color(60, 60, 60));
		lblAccount_Number.setBackground(new Color(0, 0, 0));
		lblAccount_Number.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAccount_Number.setBounds(41, 87, 147, 29);
		contentPane.add(lblAccount_Number);
		
		Account_Number = new JTextField();
		Account_Number.setBackground(new Color(242, 242, 242));
		Account_Number.setBounds(41, 127, 203, 29);
		contentPane.add(Account_Number);
		Account_Number.setColumns(10);
		
		JButton sbmtBtn = new JButton("DELETE");
		sbmtBtn.setForeground(new Color(0, 0, 0));
		sbmtBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		sbmtBtn.setBackground(new Color(39, 163, 59));
		sbmtBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				    con = DriverManager.getConnection("jdbc:mysql://localhost/bank_system", "root", "");
				    
				    String accountNumber = Account_Number.getText(); //68549
		            String employeeID = Employee_ID.getText(); //80
				    
		            if (accountNumber.isEmpty() || employeeID.isEmpty()) {
		                JOptionPane.showMessageDialog(null, "Please enter Account Number and Employee ID.");
		                return;
		            }
		            
		            String queryEmployeeID = "SELECT * FROM employee WHERE Employee_ID = ?"; //80
		            String queryAccountDetails = "SELECT * FROM account WHERE Account_Number = ?"; //68549

		            // Check if the entered values match the expected SQL queries
		            pst = con.prepareStatement(queryEmployeeID);
		            pst.setString(1, employeeID);
		            rs = pst.executeQuery();

		            if (!rs.next()) {
		                JOptionPane.showMessageDialog(null, "Invalid Employee ID or Account Number");
		                return;
		            }

		            pst = con.prepareStatement(queryAccountDetails);
		            pst.setString(1, accountNumber);
		            rs = pst.executeQuery();

		            if (!rs.next()) {
		                JOptionPane.showMessageDialog(null, "Invalid Employee ID or Account Number");
		                return;
		            }
				    
				    String deleteLoan = "DELETE FROM loan WHERE Account_Number = ?";
				    pst = con.prepareStatement(deleteLoan);
				    pst.setString(1, Account_Number.getText());
				    pst.executeUpdate();
				    
				    String deletePin = "DELETE FROM pinchange WHERE Account_Number = ?";
				    pst = con.prepareStatement(deletePin);
				    pst.setString(1, Account_Number.getText());
				    pst.executeUpdate();
				    
				    String deleteWithdraw = "DELETE FROM withdraw WHERE Account_Number = ?";
				    pst = con.prepareStatement(deleteWithdraw);
				    pst.setString(1, Account_Number.getText());
				    pst.executeUpdate();
				    
				    String deleteDeposits = "DELETE FROM deposit WHERE Account_Number = ?";
				    pst = con.prepareStatement(deleteDeposits);
				    pst.setString(1, Account_Number.getText());
				    pst.executeUpdate();
				    
				    String deleteAccount = "DELETE FROM account WHERE Account_Number = ?";
				    pst = con.prepareStatement(deleteAccount);
				    pst.setString(1, Account_Number.getText());
				    pst.executeUpdate();
				    
				    String deleteEmployee = "DELETE FROM employee WHERE Employee_ID = ?";
				    pst = con.prepareStatement(deleteEmployee);
				    pst.setString(1, Employee_ID.getText());
				    pst.executeUpdate();
				    
				    JOptionPane.showMessageDialog(null, "DELETE SUCCESSFULLY");
				    dispose();
				    adminMenu menu = new adminMenu();
				    menu.setVisible(true);
                   	}
                 	catch (SQLException ex) {
                 		Logger.getLogger(loanFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        sbmtBtn.setBounds(218, 167, 111, 29);
        contentPane.add(sbmtBtn);
        
        lblNewLabel = new JLabel("DELETE BANK");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel.setBounds(41, 26, 135, 14);
        contentPane.add(lblNewLabel);
        
        btnNewButton = new JButton("BACK");
        btnNewButton.setForeground(new Color(0, 0, 0));
        btnNewButton.setFont(new Font("MS UI Gothic", Font.BOLD, 13));
        btnNewButton.setBackground(new Color(255, 255, 255));
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		adminMenu admin = new adminMenu();
        		admin.setVisible(true);
        	}
        });
        btnNewButton.setBounds(448, 190, 89, 23);
        contentPane.add(btnNewButton);
        
        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 560, 76);
        contentPane.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel_1 = new JLabel("ACCOUNT");
        lblNewLabel_1.setForeground(new Color(39, 163, 59));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1.setBounds(176, 26, 96, 14);
        panel.add(lblNewLabel_1);
        
        ImageIcon veroBankIcon = new ImageIcon (getClass().getResource("/veroBankImage/logosVero.png"));
		JLabel labelIcon = new JLabel(veroBankIcon);
		labelIcon.setBounds(329,6,96,65);
		panel.add(labelIcon);
		
		JLabel lblVero = new JLabel("VERO BANK");
		lblVero.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		lblVero.setBounds(417, 33, 115, 14);
		panel.add(lblVero);
		
		JLabel lblEmployee_ID_1 = new JLabel("Employee ID");
		lblEmployee_ID_1.setForeground(new Color(60, 60, 60));
		lblEmployee_ID_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmployee_ID_1.setBackground(Color.BLACK);
		lblEmployee_ID_1.setBounds(303, 87, 111, 29);
		contentPane.add(lblEmployee_ID_1);
		
		Employee_ID = new JTextField();
		Employee_ID.setColumns(10);
		Employee_ID.setBackground(new Color(242, 242, 242));
		Employee_ID.setBounds(303, 127, 203, 29);
		contentPane.add(Employee_ID);
    }
}
