package veroBank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class WithdrawFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    static Connection con;
    PreparedStatement pst;
    ResultSet rs;

    private JPanel contentPane;
    private JTextField amountField;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    WithdrawFrame frame = new WithdrawFrame(null);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     * @param loggedInAccountNumber 
     */
    public WithdrawFrame(String loggedInAccountNumber) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 545, 332);
        setLocationRelativeTo(null);
		setResizable(false);
		setTitle("Withdraw Frame");
        contentPane = new JPanel();
        contentPane.setBackground(new Color(255, 255, 255));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        ImageIcon veroBankIcon = new ImageIcon (getClass().getResource("/veroBankImage/logoVeros.png"));
		JLabel labelIcon = new JLabel(veroBankIcon);
		labelIcon.setBounds(210,3,96,82);
		contentPane.add(labelIcon);

        JLabel lblNewLabel = new JLabel("Enter Amount");
        lblNewLabel.setForeground(new Color(96, 96, 96));
        lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        lblNewLabel.setBounds(195, 120, 141, 29);
        contentPane.add(lblNewLabel);

        amountField = new JTextField();
        amountField.setBackground(new Color(242, 242, 242));
        amountField.setFont(new Font("Tahoma", Font.PLAIN, 18));
        amountField.setBounds(142, 154, 245, 34);
        contentPane.add(amountField);
        amountField.setColumns(10);

        JButton btnDeposit = new JButton("WITHDRAW");
        btnDeposit.setForeground(new Color(0, 0, 0));
        btnDeposit.setBackground(new Color(39, 163, 59));
        btnDeposit.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnDeposit.setBounds(142, 199, 112, 34);
        contentPane.add(btnDeposit);
        
        JButton btnClear = new JButton("CLEAR");
        btnClear.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		amountField.setText("");
        	}
        });
        btnClear.setBackground(new Color(255, 255, 255));
        btnClear.setForeground(new Color(0, 0, 0));
        btnClear.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnClear.setBounds(275, 199, 112, 34);
        contentPane.add(btnClear);
        
        JButton btnBack = new JButton("BACK");
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		Menu menu = new Menu(loggedInAccountNumber);
        		menu.setVisible(true);
        	}
        });
        btnBack.setBackground(new Color(255, 255, 255));
        btnBack.setForeground(new Color(0, 0, 0));
        btnBack.setFont(new Font("MS UI Gothic", Font.BOLD, 13));
        btnBack.setBounds(403, 242, 104, 29);
        contentPane.add(btnBack);
        
        JLabel lblNewLabel_1 = new JLabel("VERO BANK");
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblNewLabel_1.setBounds(208, 87, 112, 14);
        contentPane.add(lblNewLabel_1);
        btnDeposit.addActionListener(e -> {
            String amount = amountField.getText();
            btnDepositActionPerformed(amount, loggedInAccountNumber);
        });
    }
    private void btnDepositActionPerformed(String amount, String loggedInAccountNumber) {
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost/bank_system", "root", "")) {
            con.setAutoCommit(false);

            String updateQuery = "UPDATE account SET Balance = Balance - ? WHERE Account_Number = ?";
            
            try (PreparedStatement pst = con.prepareStatement(updateQuery)) {
                pst.setDouble(1, Double.parseDouble(amount));
                pst.setString(2, loggedInAccountNumber);

                int rowsAffected = pst.executeUpdate();
                

                if (rowsAffected > 0) {
                    String depositQuery = "INSERT INTO withdraw (Account_Number, Amount) VALUES (?, ?)";
                    try (PreparedStatement pstDeposit = con.prepareStatement(depositQuery)) {
                        pstDeposit.setString(1, loggedInAccountNumber);
                        pstDeposit.setDouble(2, Double.parseDouble(amount));
                        pstDeposit.executeUpdate();

                        con.commit();
                        String message = "<html><body style='width: 150px;'>" +
                                "<h1 style='color: #2E8B57; font-size: 15px;'>Withdrawal Successful!</h1>" +
                                "<p style='font-size: 10px;'>You have successfully withdrawn: <b>" + amount + "</b></p>" +
                                "<hr>" +
                                "<p style='color: #888; font-size: 10px;'>Thank you for using our services.</p>" +
                                "</body></html>";

                        JOptionPane.showMessageDialog(null, message);
                        dispose();
                        Menu menu = new Menu(loggedInAccountNumber);
                        menu.setVisible(true);
                    }
                    catch (SQLException ex) {
                        con.rollback();
                        Logger.getLogger(DepositFrame.class.getName()).log(Level.SEVERE, null, ex);
                        String message = "<html><body style='width: 150px;'>" +
                                "<h1 style='color: #FF6347; font-size: 15px;'>Withdrawal Failed!</h1>" +
                                "<p style='font-size: 10px;'>Your withdrawal was unsuccessful.</p>" +
                                "<hr>" +
                                "<p style='color: #888; font-size: 10px;'>Please try again later or contact support.</p>" +
                                "</body></html>";
                        JOptionPane.showMessageDialog(null, message);
                    }
                } else {
                	String message = "<html><body style='width: 150px;'>" +
                            "<h1 style='color: #FF6347; font-size: 15px;'>Withdrawal Failed!</h1>" +
                            "<p style='font-size: 10px;'>Your withdrawal was unsuccessful.</p>" +
                            "<hr>" +
                            "<p style='color: #888; font-size: 10px;'>Please try again later or contact support.</p>" +
                            "</body></html>";
                    JOptionPane.showMessageDialog(null, message);
                    con.rollback();
                }
            }
            catch (SQLException ex) {
                con.rollback();
                Logger.getLogger(DepositFrame.class.getName()).log(Level.SEVERE, null, ex);
                String message = "<html><body style='width: 150px;'>" +
                        "<h1 style='color: #FF6347; font-size: 15px;'>Withdrawal Failed!</h1>" +
                        "<p style='font-size: 10px;'>Your withdrawal was unsuccessful.</p>" +
                        "<hr>" +
                        "<p style='color: #888; font-size: 10px;'>Please try again later or contact support.</p>" +
                        "</body></html>";
                JOptionPane.showMessageDialog(null, message);
            }
        }
        catch (SQLException ex) {
            Logger.getLogger(DepositFrame.class.getName()).log(Level.SEVERE, null, ex);
            String message = "<html><body style='width: 150px;'>" +
                    "<h1 style='color: #FF6347; font-size: 15px;'>Withdrawal Failed!</h1>" +
                    "<p style='font-size: 10px;'>Your withdrawal was unsuccessful.</p>" +
                    "<hr>" +
                    "<p style='color: #888; font-size: 10px;'>Please try again later or contact support.</p>" +
                    "</body></html>";
            JOptionPane.showMessageDialog(null, message);
        }
    }
}