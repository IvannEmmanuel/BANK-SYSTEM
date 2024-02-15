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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;

public class loanFrame extends JFrame implements ActionListener{
	
	static Connection con;
	PreparedStatement pst;
	ResultSet rs;

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String loggedInAccountNumber;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loanFrame frame = new loanFrame(null);
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
	public loanFrame(String loggedInAccountNumber) {
		this.loggedInAccountNumber = loggedInAccountNumber;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 408);
		setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Loan Frame");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon veroBankIcon = new ImageIcon (getClass().getResource("/veroBankImage/logosVero.png"));
		JLabel labelIcon = new JLabel(veroBankIcon);
		labelIcon.setBounds(238,11,96,65);
		contentPane.add(labelIcon);
		
		JButton btnTenThousand = new JButton("₱10000");
		btnTenThousand.setBackground(new Color(255, 255, 255));
		btnTenThousand.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnTenThousand.setBounds(31, 136, 102, 30);
		btnTenThousand.setActionCommand("TEN");
		contentPane.add(btnTenThousand);
		btnTenThousand.addActionListener(this);
		
		JButton lblTwentyThousand = new JButton("₱20000");
		lblTwentyThousand.setBackground(new Color(255, 255, 255));
		lblTwentyThousand.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblTwentyThousand.setBounds(165, 136, 102, 30);
		lblTwentyThousand.setActionCommand("TWENTY");
		contentPane.add(lblTwentyThousand);
		lblTwentyThousand.addActionListener(this);
		
		JButton lblThirtyThousand = new JButton("₱30000");
		lblThirtyThousand.setBackground(new Color(255, 255, 255));
		lblThirtyThousand.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblThirtyThousand.setBounds(302, 136, 102, 30);
		lblThirtyThousand.setActionCommand("THIRTY");
		contentPane.add(lblThirtyThousand);
		lblThirtyThousand.addActionListener(this);
		
		JButton lblFourtyThousand = new JButton("₱40000");
		lblFourtyThousand.setBackground(new Color(255, 255, 255));
		lblFourtyThousand.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFourtyThousand.setBounds(423, 136, 102, 30);
		lblFourtyThousand.setActionCommand("FOURTY");
		contentPane.add(lblFourtyThousand);
		lblFourtyThousand.addActionListener(this);
		
		JButton lblFiftyThousand = new JButton("₱50000");
		lblFiftyThousand.setBackground(new Color(255, 255, 255));
		lblFiftyThousand.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFiftyThousand.setActionCommand("FIFTY");
		lblFiftyThousand.setBounds(31, 193, 102, 30);
		contentPane.add(lblFiftyThousand);
		lblFiftyThousand.addActionListener(this);
		
		JButton lblSixtyThousand = new JButton("₱60000");
		lblSixtyThousand.setBackground(new Color(255, 255, 255));
		lblSixtyThousand.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSixtyThousand.setActionCommand("SIXTY");
		lblSixtyThousand.setBounds(165, 193, 102, 30);
		contentPane.add(lblSixtyThousand);
		lblSixtyThousand.addActionListener(this);
		
		JButton lblSeventyThousand = new JButton("₱70000");
		lblSeventyThousand.setBackground(new Color(255, 255, 255));
		lblSeventyThousand.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSeventyThousand.setActionCommand("SEVENTY");
		lblSeventyThousand.setBounds(302, 193, 102, 30);
		contentPane.add(lblSeventyThousand);
		lblSeventyThousand.addActionListener(this);
		
		JButton lblEigthyThousand = new JButton("₱80000");
		lblEigthyThousand.setBackground(new Color(255, 255, 255));
		lblEigthyThousand.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEigthyThousand.setActionCommand("EIGHTY");
		lblEigthyThousand.setBounds(423, 193, 102, 30);
		contentPane.add(lblEigthyThousand);
		lblEigthyThousand.addActionListener(this);
		
		JButton lblNinetyThousand = new JButton("₱90000");
		lblNinetyThousand.setBackground(new Color(255, 255, 255));
		lblNinetyThousand.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNinetyThousand.setActionCommand("NINETY");
		lblNinetyThousand.setBounds(165, 253, 102, 30);
		contentPane.add(lblNinetyThousand);
		lblNinetyThousand.addActionListener(this);
		
		JButton lblOneHundredThousand = new JButton("₱100000");
		lblOneHundredThousand.setBackground(new Color(255, 255, 255));
		lblOneHundredThousand.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOneHundredThousand.setActionCommand("ONE_HUNDRED");
		lblOneHundredThousand.setBounds(302, 253, 102, 30);
		contentPane.add(lblOneHundredThousand);
		lblOneHundredThousand.addActionListener(this);
		
		JButton btnBack = new JButton("BACK");
		btnBack.setBackground(new Color(39, 163, 59));
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Menu menu = new Menu(loggedInAccountNumber);
				menu.setVisible(true);
			}
		});
		btnBack.setBounds(423, 323, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblPickLoan = new JLabel("PICK LOAN");
		lblPickLoan.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPickLoan.setForeground(new Color(39, 163, 59));
		lblPickLoan.setBounds(242, 111, 95, 14);
		contentPane.add(lblPickLoan);
		
		JLabel lblVeroBank = new JLabel("VERO BANK");
		lblVeroBank.setForeground(new Color(0, 0, 0));
		lblVeroBank.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblVeroBank.setBounds(242, 86, 95, 14);
		contentPane.add(lblVeroBank);

		
		Connect();
	}
	
	public static void Connect() {
	    try {
	        Class.forName("com.mysql.jdbc.Driver");
	        con = DriverManager.getConnection("jdbc:mysql://localhost/bank_system", "root", "");
	    } catch (ClassNotFoundException | SQLException e) {
	        Logger.getLogger(nextRegistration.class.getName()).log(Level.SEVERE, null, e);
	    }
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        if ("TEN".equals(e.getActionCommand())) {
            try {
                String updateQuery = "UPDATE account SET Balance = Balance + 10000 WHERE Account_Number = ?";
                pst = con.prepareStatement(updateQuery);
                pst.setString(1, loggedInAccountNumber);
                con.setAutoCommit(false);
                
                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                	String loanQuery = "INSERT INTO loan (Account_Number, Amount) VALUES (?, ?)";
                    try (PreparedStatement pstLoan = con.prepareStatement(loanQuery)) {
                    	pstLoan.setString(1, loggedInAccountNumber);
                    	pstLoan.setInt(2, 10000);
                    	pstLoan.executeUpdate();

                        con.commit();
                        String message = "<html><body style='width: 200px; text-align: center;'>" +
                                "<h1 style='color: #008000; font-size: 15px;'>Loan Successful!</h1>" +
                                "<p style='font-size: 10px;'>Your loan application has been approved.</p>" +
                                "<hr>" +
                                "<p style='color: #888; font-size: 10px;'>Thank you for choosing our services.</p>" +
                                "</body></html>";

                        JOptionPane.showMessageDialog(null, message);
                        dispose();
                        Menu menu = new Menu(loggedInAccountNumber);
                        menu.setVisible(true);
                    }
                    catch (SQLException ex) {
                        con.rollback();
                        Logger.getLogger(DepositFrame.class.getName()).log(Level.SEVERE, null, ex);
                        String message = "<html><body style='width: 200px; text-align: center;'>" +
                                "<h1 style='color: #FF0000; font-size: 15px;'>Deposit Failed!</h1>" +
                                "<p style='font-size: 10px;'>Your attempt to deposit funds has failed.</p>" +
                                "<hr>" +
                                "<p style='color: #888; font-size: 10px;'>Please try again later or contact support.</p>" +
                                "</body></html>";

                        JOptionPane.showMessageDialog(null, message);
                    }
                } else {
                	String message = "<html><body style='width: 200px; text-align: center;'>" +
                            "<h1 style='color: #FF0000; font-size: 15px;'>Deposit Failed!</h1>" +
                            "<p style='font-size: 10px;'>Your attempt to deposit funds has failed.</p>" +
                            "<hr>" +
                            "<p style='color: #888; font-size: 10px;'>Please try again later or contact support.</p>" +
                            "</body></html>";

                    JOptionPane.showMessageDialog(null, message);
                }
            } catch (SQLException ex) {
                Logger.getLogger(loanFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if ("TWENTY".equals(e.getActionCommand())) {
        	try {
                String updateQuery = "UPDATE account SET Balance = Balance + 20000 WHERE Account_Number = ?";
                pst = con.prepareStatement(updateQuery);
                pst.setString(1, loggedInAccountNumber);
                con.setAutoCommit(false);
                
                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                	String loanQuery = "INSERT INTO loan (Account_Number, Amount) VALUES (?, ?)";
                    try (PreparedStatement pstLoan = con.prepareStatement(loanQuery)) {
                    	pstLoan.setString(1, loggedInAccountNumber);
                    	pstLoan.setInt(2, 20000);
                    	pstLoan.executeUpdate();

                        con.commit();
                        String message = "<html><body style='width: 200px; text-align: center;'>" +
                                "<h1 style='color: #008000; font-size: 15px;'>Loan Successful!</h1>" +
                                "<p style='font-size: 10px;'>Your loan application has been approved.</p>" +
                                "<hr>" +
                                "<p style='color: #888; font-size: 10px;'>Thank you for choosing our services.</p>" +
                                "</body></html>";

                        JOptionPane.showMessageDialog(null, message);

                        dispose();
                        Menu menu = new Menu(loggedInAccountNumber);
                        menu.setVisible(true);
                    }
                } else {
                	String message = "<html><body style='width: 200px; text-align: center;'>" +
                            "<h1 style='color: #FF0000; font-size: 15px;'>Deposit Failed!</h1>" +
                            "<p style='font-size: 10px;'>Your attempt to deposit funds has failed.</p>" +
                            "<hr>" +
                            "<p style='color: #888; font-size: 10px;'>Please try again later or contact support.</p>" +
                            "</body></html>";

                    JOptionPane.showMessageDialog(null, message);
                }
            } catch (SQLException ex) {
                Logger.getLogger(loanFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if ("THIRTY".equals(e.getActionCommand())) {
        	try {
                String updateQuery = "UPDATE account SET Balance = Balance + 30000 WHERE Account_Number = ?";
                pst = con.prepareStatement(updateQuery);
                pst.setString(1, loggedInAccountNumber);
                con.setAutoCommit(false);
                
                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                	String loanQuery = "INSERT INTO loan (Account_Number, Amount) VALUES (?, ?)";
                    try (PreparedStatement pstLoan = con.prepareStatement(loanQuery)) {
                    	pstLoan.setString(1, loggedInAccountNumber);
                    	pstLoan.setInt(2, 30000);
                    	pstLoan.executeUpdate();

                        con.commit();
                        String message = "<html><body style='width: 200px; text-align: center;'>" +
                                "<h1 style='color: #008000; font-size: 15px;'>Loan Successful!</h1>" +
                                "<p style='font-size: 10px;'>Your loan application has been approved.</p>" +
                                "<hr>" +
                                "<p style='color: #888; font-size: 10px;'>Thank you for choosing our services.</p>" +
                                "</body></html>";

                        JOptionPane.showMessageDialog(null, message);

                        dispose();
                        Menu menu = new Menu(loggedInAccountNumber);
                        menu.setVisible(true);
                    }
                } else {
                	String message = "<html><body style='width: 200px; text-align: center;'>" +
                            "<h1 style='color: #FF0000; font-size: 15px;'>Deposit Failed!</h1>" +
                            "<p style='font-size: 10px;'>Your attempt to deposit funds has failed.</p>" +
                            "<hr>" +
                            "<p style='color: #888; font-size: 10px;'>Please try again later or contact support.</p>" +
                            "</body></html>";

                    JOptionPane.showMessageDialog(null, message);
                }
            } catch (SQLException ex) {
                Logger.getLogger(loanFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if ("FOURTY".equals(e.getActionCommand())) {
        	try {
                String updateQuery = "UPDATE account SET Balance = Balance + 40000 WHERE Account_Number = ?";
                pst = con.prepareStatement(updateQuery);
                pst.setString(1, loggedInAccountNumber);
                con.setAutoCommit(false);
                
                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                	String loanQuery = "INSERT INTO loan (Account_Number, Amount) VALUES (?, ?)";
                    try (PreparedStatement pstLoan = con.prepareStatement(loanQuery)) {
                    	pstLoan.setString(1, loggedInAccountNumber);
                    	pstLoan.setInt(2, 30000);
                    	pstLoan.executeUpdate();

                        con.commit();
                        String message = "<html><body style='width: 200px; text-align: center;'>" +
                                "<h1 style='color: #008000; font-size: 15px;'>Loan Successful!</h1>" +
                                "<p style='font-size: 10px;'>Your loan application has been approved.</p>" +
                                "<hr>" +
                                "<p style='color: #888; font-size: 10px;'>Thank you for choosing our services.</p>" +
                                "</body></html>";

                        JOptionPane.showMessageDialog(null, message);

                        dispose();
                        Menu menu = new Menu(loggedInAccountNumber);
                        menu.setVisible(true);
                    }
                } else {
                	String message = "<html><body style='width: 200px; text-align: center;'>" +
                            "<h1 style='color: #FF0000; font-size: 15px;'>Deposit Failed!</h1>" +
                            "<p style='font-size: 10px;'>Your attempt to deposit funds has failed.</p>" +
                            "<hr>" +
                            "<p style='color: #888; font-size: 10px;'>Please try again later or contact support.</p>" +
                            "</body></html>";

                    JOptionPane.showMessageDialog(null, message);
                }
            } catch (SQLException ex) {
                Logger.getLogger(loanFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if("FIFTY".equals(e.getActionCommand())) {
        	try {
                String updateQuery = "UPDATE account SET Balance = Balance + 50000 WHERE Account_Number = ?";
                pst = con.prepareStatement(updateQuery);
                pst.setString(1, loggedInAccountNumber);
                con.setAutoCommit(false);
                
                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                	String loanQuery = "INSERT INTO loan (Account_Number, Amount) VALUES (?, ?)";
                    try (PreparedStatement pstLoan = con.prepareStatement(loanQuery)) {
                    	pstLoan.setString(1, loggedInAccountNumber);
                    	pstLoan.setInt(2, 50000);
                    	pstLoan.executeUpdate();

                        con.commit();
                        String message = "<html><body style='width: 200px; text-align: center;'>" +
                                "<h1 style='color: #008000; font-size: 15px;'>Loan Successful!</h1>" +
                                "<p style='font-size: 10px;'>Your loan application has been approved.</p>" +
                                "<hr>" +
                                "<p style='color: #888; font-size: 10px;'>Thank you for choosing our services.</p>" +
                                "</body></html>";

                        JOptionPane.showMessageDialog(null, message);

                        dispose();
                        Menu menu = new Menu(loggedInAccountNumber);
                        menu.setVisible(true);
                    }
                } else {
                	String message = "<html><body style='width: 200px; text-align: center;'>" +
                            "<h1 style='color: #FF0000; font-size: 15px;'>Deposit Failed!</h1>" +
                            "<p style='font-size: 10px;'>Your attempt to deposit funds has failed.</p>" +
                            "<hr>" +
                            "<p style='color: #888; font-size: 10px;'>Please try again later or contact support.</p>" +
                            "</body></html>";

                    JOptionPane.showMessageDialog(null, message);
                }
            } catch (SQLException ex) {
                Logger.getLogger(loanFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if("SIXTY".equals(e.getActionCommand())) {
        	try {
                String updateQuery = "UPDATE account SET Balance = Balance + 60000 WHERE Account_Number = ?";
                pst = con.prepareStatement(updateQuery);
                pst.setString(1, loggedInAccountNumber);
                con.setAutoCommit(false);
                
                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                	String loanQuery = "INSERT INTO loan (Account_Number, Amount) VALUES (?, ?)";
                    try (PreparedStatement pstLoan = con.prepareStatement(loanQuery)) {
                    	pstLoan.setString(1, loggedInAccountNumber);
                    	pstLoan.setInt(2, 60000);
                    	pstLoan.executeUpdate();

                        con.commit();
                        String message = "<html><body style='width: 200px; text-align: center;'>" +
                                "<h1 style='color: #008000; font-size: 15px;'>Loan Successful!</h1>" +
                                "<p style='font-size: 10px;'>Your loan application has been approved.</p>" +
                                "<hr>" +
                                "<p style='color: #888; font-size: 10px;'>Thank you for choosing our services.</p>" +
                                "</body></html>";

                        JOptionPane.showMessageDialog(null, message);

                        dispose();
                        Menu menu = new Menu(loggedInAccountNumber);
                        menu.setVisible(true);
                    }
                } else {
                	String message = "<html><body style='width: 200px; text-align: center;'>" +
                            "<h1 style='color: #FF0000; font-size: 15px;'>Deposit Failed!</h1>" +
                            "<p style='font-size: 10px;'>Your attempt to deposit funds has failed.</p>" +
                            "<hr>" +
                            "<p style='color: #888; font-size: 10px;'>Please try again later or contact support.</p>" +
                            "</body></html>";

                    JOptionPane.showMessageDialog(null, message);
                }
            } catch (SQLException ex) {
                Logger.getLogger(loanFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if("SEVENTY".equals(e.getActionCommand())) {
        	try {
                String updateQuery = "UPDATE account SET Balance = Balance + 70000 WHERE Account_Number = ?";
                pst = con.prepareStatement(updateQuery);
                pst.setString(1, loggedInAccountNumber);
                con.setAutoCommit(false);
                
                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                	String loanQuery = "INSERT INTO loan (Account_Number, Amount) VALUES (?, ?)";
                    try (PreparedStatement pstLoan = con.prepareStatement(loanQuery)) {
                    	pstLoan.setString(1, loggedInAccountNumber);
                    	pstLoan.setInt(2, 70000);
                    	pstLoan.executeUpdate();

                        con.commit();
                        String message = "<html><body style='width: 200px; text-align: center;'>" +
                                "<h1 style='color: #008000; font-size: 15px;'>Loan Successful!</h1>" +
                                "<p style='font-size: 10px;'>Your loan application has been approved.</p>" +
                                "<hr>" +
                                "<p style='color: #888; font-size: 10px;'>Thank you for choosing our services.</p>" +
                                "</body></html>";

                        JOptionPane.showMessageDialog(null, message);

                        dispose();
                        Menu menu = new Menu(loggedInAccountNumber);
                        menu.setVisible(true);
                    }
                } else {
                	String message = "<html><body style='width: 200px; text-align: center;'>" +
                            "<h1 style='color: #FF0000; font-size: 15px;'>Deposit Failed!</h1>" +
                            "<p style='font-size: 10px;'>Your attempt to deposit funds has failed.</p>" +
                            "<hr>" +
                            "<p style='color: #888; font-size: 10px;'>Please try again later or contact support.</p>" +
                            "</body></html>";

                    JOptionPane.showMessageDialog(null, message);
                }
            } catch (SQLException ex) {
                Logger.getLogger(loanFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if("EIGHTY".equals(e.getActionCommand())) {
        	try {
                String updateQuery = "UPDATE account SET Balance = Balance + 80000 WHERE Account_Number = ?";
                pst = con.prepareStatement(updateQuery);
                pst.setString(1, loggedInAccountNumber);
                con.setAutoCommit(false);
                
                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                	String loanQuery = "INSERT INTO loan (Account_Number, Amount) VALUES (?, ?)";
                    try (PreparedStatement pstLoan = con.prepareStatement(loanQuery)) {
                    	pstLoan.setString(1, loggedInAccountNumber);
                    	pstLoan.setInt(2, 80000);
                    	pstLoan.executeUpdate();

                        con.commit();
                        String message = "<html><body style='width: 200px; text-align: center;'>" +
                                "<h1 style='color: #008000; font-size: 15px;'>Loan Successful!</h1>" +
                                "<p style='font-size: 10px;'>Your loan application has been approved.</p>" +
                                "<hr>" +
                                "<p style='color: #888; font-size: 10px;'>Thank you for choosing our services.</p>" +
                                "</body></html>";

                        JOptionPane.showMessageDialog(null, message);

                        dispose();
                        Menu menu = new Menu(loggedInAccountNumber);
                        menu.setVisible(true);
                    }
                } else {
                	String message = "<html><body style='width: 200px; text-align: center;'>" +
                            "<h1 style='color: #FF0000; font-size: 15px;'>Deposit Failed!</h1>" +
                            "<p style='font-size: 10px;'>Your attempt to deposit funds has failed.</p>" +
                            "<hr>" +
                            "<p style='color: #888; font-size: 10px;'>Please try again later or contact support.</p>" +
                            "</body></html>";

                    JOptionPane.showMessageDialog(null, message);
                }
            } catch (SQLException ex) {
                Logger.getLogger(loanFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if("NINETY".equals(e.getActionCommand())) {
        	try {
                String updateQuery = "UPDATE account SET Balance = Balance + 90000 WHERE Account_Number = ?";
                pst = con.prepareStatement(updateQuery);
                pst.setString(1, loggedInAccountNumber);
                con.setAutoCommit(false);
                
                int rowsAffected = pst.executeUpdate();

                if (rowsAffected > 0) {
                	String loanQuery = "INSERT INTO loan (Account_Number, Amount) VALUES (?, ?)";
                    try (PreparedStatement pstLoan = con.prepareStatement(loanQuery)) {
                    	pstLoan.setString(1, loggedInAccountNumber);
                    	pstLoan.setInt(2, 90000);
                    	pstLoan.executeUpdate();

                        con.commit();
                        String message = "<html><body style='width: 200px; text-align: center;'>" +
                                "<h1 style='color: #008000; font-size: 15px;'>Loan Successful!</h1>" +
                                "<p style='font-size: 10px;'>Your loan application has been approved.</p>" +
                                "<hr>" +
                                "<p style='color: #888; font-size: 10px;'>Thank you for choosing our services.</p>" +
                                "</body></html>";

                        JOptionPane.showMessageDialog(null, message);

                        dispose();
                        Menu menu = new Menu(loggedInAccountNumber);
                        menu.setVisible(true);
                    }
                } else {
                	String message = "<html><body style='width: 200px; text-align: center;'>" +
                            "<h1 style='color: #FF0000; font-size: 15px;'>Deposit Failed!</h1>" +
                            "<p style='font-size: 10px;'>Your attempt to deposit funds has failed.</p>" +
                            "<hr>" +
                            "<p style='color: #888; font-size: 10px;'>Please try again later or contact support.</p>" +
                            "</body></html>";

                    JOptionPane.showMessageDialog(null, message);
                }
            } catch (SQLException ex) {
                Logger.getLogger(loanFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if("ONE_HUNDRED".equals(e.getActionCommand())) {
        	try {
                String updateQuery = "UPDATE account SET Balance = Balance + 100000 WHERE Account_Number = ?";
                pst = con.prepareStatement(updateQuery);
                pst.setString(1, loggedInAccountNumber);
                con.setAutoCommit(false);
                
                int rowsAffected = pst.executeUpdate();
                
                if (rowsAffected > 0) {
                	String loanQuery = "INSERT INTO loan (Account_Number, Amount) VALUES (?, ?)";
                    try (PreparedStatement pstLoan = con.prepareStatement(loanQuery)) {
                    	pstLoan.setString(1, loggedInAccountNumber);
                    	pstLoan.setInt(2, 100000);
                    	pstLoan.executeUpdate();

                        con.commit();
                        String message = "<html><body style='width: 200px; text-align: center;'>" +
                                "<h1 style='color: #008000; font-size: 15px;'>Loan Successful!</h1>" +
                                "<p style='font-size: 10px;'>Your loan application has been approved.</p>" +
                                "<hr>" +
                                "<p style='color: #888; font-size: 10px;'>Thank you for choosing our services.</p>" +
                                "</body></html>";

                        JOptionPane.showMessageDialog(null, message);

                        dispose();
                        Menu menu = new Menu(loggedInAccountNumber);
                        menu.setVisible(true);
                    }
                } else {
                	String message = "<html><body style='width: 200px; text-align: center;'>" +
                            "<h1 style='color: #FF0000; font-size: 15px;'>Deposit Failed!</h1>" +
                            "<p style='font-size: 10px;'>Your attempt to deposit funds has failed.</p>" +
                            "<hr>" +
                            "<p style='color: #888; font-size: 10px;'>Please try again later or contact support.</p>" +
                            "</body></html>";

                    JOptionPane.showMessageDialog(null, message);
                }
            } catch (SQLException ex) {
                Logger.getLogger(loanFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	}
}
