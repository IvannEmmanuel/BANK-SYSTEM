package veroBank;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.mysql.jdbc.Statement;

public class nextRegistration extends JFrame {
	private static final long serialVersionUID = 1L;
	
	static Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	private JPanel contentPane;
	private JTextField Phone;
	private JComboBox<String> Nationality;
	private JComboBox<String> Account_Type;
	private JTextField Pin;
	JTextField Balance;
	public LineBorder BorderField = new LineBorder(new Color(215,215,215),1);

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nextRegistration frame = new nextRegistration(null);
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
	public nextRegistration(Registration register) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 636, 701);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon backIcon = new ImageIcon (getClass().getResource("/veroBankImage/backs.png"));
		JButton back = new JButton(backIcon);
		back.setBackground(new Color(255, 255, 255));
		back.setBounds(519,10,83,64);
		back.setBorderPainted(false);
		back.setFocusPainted(false);
		back.setContentAreaFilled(false);
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration register = new Registration();
				dispose();
				register.setVisible(true);
			}
		});
		contentPane.add(back);
		
		JLabel lblAppForm = new JLabel("Application Form");
		lblAppForm.setBounds(31, 11, 251, 40);
		lblAppForm.setForeground(new Color(39, 163, 59));
		lblAppForm.setFont(new Font("Leelawadee UI", Font.BOLD, 30));
		contentPane.add(lblAppForm);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(31, 62, 115, 22);
		lblPhone.setForeground(new Color(96, 96, 96));
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblPhone);
		
		Phone = new JTextField();
		Phone.setBounds(31, 95, 560, 40);
		Phone.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Phone.setHorizontalAlignment(SwingConstants.LEFT);
		Phone.setBackground(new Color(242, 242, 242));
		contentPane.add(Phone);
		Phone.setColumns(10);
		Phone.setBorder(BorderField);
		
		JLabel lblNationality = new JLabel("Nationality");
		lblNationality.setBounds(31, 145, 115, 22);
		lblNationality.setForeground(new Color(96, 96, 96));
		lblNationality.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblNationality);
		
		Nationality = new JComboBox<String>();
		Nationality.setBounds(31, 181, 560, 39);
		Nationality.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Nationality.setBackground(new Color(242, 242, 242));
		Nationality.addItem("Philippines");
		Nationality.addItem("USA");
		Nationality.addItem("Japan");
		Nationality.addItem("United Kingdom");
		Nationality.addItem("Germany");
		contentPane.add(Nationality);
		
		JLabel lblPin = new JLabel("Pin");
		lblPin.setBounds(31, 236, 115, 22);
		lblPin.setForeground(new Color(96, 96, 96));
		lblPin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblPin);
		
		Pin = new JTextField();
		Pin.setBounds(31, 269, 560, 40);
		Pin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Pin.setBackground(new Color(242, 242, 242));
		Pin.setHorizontalAlignment(SwingConstants.LEFT);
		Pin.setColumns(10);
		contentPane.add(Pin);
		Pin.setBorder(BorderField);
		
		JLabel lblAccount = new JLabel("Account");
		lblAccount.setBounds(259, 350, 115, 30);
		lblAccount.setForeground(new Color(39, 163, 59));
		lblAccount.setFont(new Font("Leelawadee UI", Font.BOLD, 30));
		contentPane.add(lblAccount);
		
		JLabel lblAccount_Type = new JLabel("Account Type");
		lblAccount_Type.setBounds(31, 400, 160, 22);
		lblAccount_Type.setForeground(new Color(96, 96, 96));
		lblAccount_Type.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblAccount_Type);
		
		Account_Type = new JComboBox<String>();
		Account_Type.setBounds(31, 433, 560, 40);
		Account_Type.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Account_Type.addItem("Salary Account");
		Account_Type.addItem("Retirement Account");
		Account_Type.addItem("Basic Bank Account");
		Account_Type.addItem("Foreign Currency Account");
		Account_Type.addItem("Money Markey Account");
		contentPane.add(Account_Type);
		
		JLabel lblBalance = new JLabel("Balance");
		lblBalance.setBounds(31, 484, 160, 22);
		lblBalance.setForeground(new Color(96, 96, 96));
		lblBalance.setFont(new Font("Tahoma", Font.PLAIN, 18));
		contentPane.add(lblBalance);
		
		Balance = new JTextField();
		Balance.setBounds(31, 517, 560, 40);
		Balance.setBackground(new Color(242, 242, 242));
		Balance.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Balance.setHorizontalAlignment(SwingConstants.LEFT);
		Balance.setColumns(10);
		contentPane.add(Balance);
		Balance.setBorder(BorderField);
		
		
		java.util.Random r = new java.util.Random();
		int start = 10000;
		int end = 100000; //10000 - 100000
		int Account_Number = r.nextInt(end - start) + start;
		
		JButton sbmtBtn = new JButton("SUBMIT");
		sbmtBtn.setBounds(475, 606, 115, 30);
		sbmtBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		sbmtBtn.setForeground(new Color(0, 0, 0));
		sbmtBtn.setBackground(new Color(39, 163, 59));
		contentPane.add(sbmtBtn);
		sbmtBtn.addActionListener(e -> {
			String fName = register.First_Name.getText();
            String lName = register.Last_Name.getText();
            String age = register.Age.getText();
            
            if (!isValidAgeNumber(age)) {
            	JOptionPane.showMessageDialog(null, "Enter a numeric digits only for the age", "AGE", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String status = (String) register.Status.getSelectedItem();
            String occupation = register.Occupation.getText();
            String email = register.Email.getText();
            String address = register.Address.getText();
            String phone = Phone.getText();
            
            if (!isValidPhoneNumber(phone)) {
                JOptionPane.showMessageDialog(null, "Input exactly 11 numerical digits for the phone number.", "PHONE", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String nationality = (String) Nationality.getSelectedItem();
            String pin = Pin.getText();
            
            if (!isValidPinNumber(pin)) {
                JOptionPane.showMessageDialog(null, "Input exactly 4 numerical digits for the pin.", "PIN", JOptionPane.ERROR_MESSAGE);
                return;
            }
            
            String accountNumber = String.valueOf(Account_Number); //125415
            String accountType = (String) Account_Type.getSelectedItem();
            String balance = Balance.getText();
            
            if (!isValidBalanceNumber(balance)) {
            	JOptionPane.showMessageDialog(null, "Enter a numeric digits only for the Balance", "BALANCE", JOptionPane.ERROR_MESSAGE);
                return;
            }
		    
            String gender = (String) register.genderGroup.getSelectedItem();
            
            java.util.Date utilDate = register.Birthday.getDate();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            String birthday = sqlDate.toString();
		    					   //as	 //sds  //15
		    sbmtBtnActionPerformed(fName, lName, age, status, occupation, email, address, phone, nationality, pin, accountNumber, accountType, balance, gender, birthday);
		});
	}
	
	private boolean isValidPhoneNumber(String phone) {
	    return phone.matches("\\d{11}");
	}
	private boolean isValidAgeNumber(String age) {
	    return age.matches("\\d+");
	}
	private boolean isValidPinNumber(String pin) {
	    return pin.matches("\\d{4}");
	}
	private boolean isValidBalanceNumber(String balance) {
	    return balance.matches("\\d+");
	}
	
	public static void Connect() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/bank_system", "root", "");
        } catch (ClassNotFoundException | SQLException e) {
            Logger.getLogger(nextRegistration.class.getName()).log(Level.SEVERE, null, e);
        }
    }												//as	     //sds             //15
	private void sbmtBtnActionPerformed(String fNameText, String lNameText, String ageText, String statusText, String occupationText, String emailText, String addressText, String phoneText, String nationalityText, String pinText, String accountNumberText, String accountTypeText, String balanceText, String genderText, String birthdayText) {
		try {
            Connect(); // Establish the database connection
            pst = con.prepareStatement("SELECT * FROM Employee e INNER JOIN Account a ON e.Pin = a.Account_Number WHERE e.Pin = ? AND a.Account_Number = ?");
            pst.setString(1, pinText);
            pst.setString(2, accountNumberText); //1254125

            ResultSet resultSet = pst.executeQuery();

            if (resultSet.next()) {
                JOptionPane.showMessageDialog(null, "Account already exists!");
            } else {
            	String insertEmployeeQuery = "INSERT INTO Employee (First_Name, Last_Name, Age, Birthday, Gender, Status, Occupation, Email, Phone, Nationality, Pin, Address) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
                pst = con.prepareStatement(insertEmployeeQuery, Statement.RETURN_GENERATED_KEYS);
                pst.setString(1, fNameText); //as
                pst.setString(2, lNameText); //sds
                pst.setString(3, ageText); //15
                pst.setString(4, birthdayText);
                pst.setString(5, genderText);
                pst.setString(6, statusText);
                pst.setString(7, occupationText);
                pst.setString(8, emailText);
                pst.setString(9, phoneText);
                pst.setString(10, nationalityText);
                pst.setString(11, pinText);
                pst.setString(12, addressText);
	
	            int k = pst.executeUpdate();
	            
                if (k == 1) {
                	String message = "<html>Registered Successfully,<br>Account Number: <font color='red'>" + accountNumberText + "</font></html>";
                	JOptionPane.showMessageDialog(null, message);
	                Phone.setText("");
	                Pin.setText("");
	                Balance.setText("");
	                dispose();
	                LoginFrame login = new LoginFrame();
	                login.setVisible(true);
	            }
                
                int employeeId = -1;
                ResultSet generatedKeys = pst.getGeneratedKeys();
                if (generatedKeys.next()) {
                    employeeId = generatedKeys.getInt(1);
                }
                
                String insertAccountQuery = "INSERT INTO Account (Employee_ID, Account_Number, Account_Type, Balance) VALUES (?, ?, ?, ?)";
                pst = con.prepareStatement(insertAccountQuery);
                pst.setInt(1, employeeId); // Use the obtained Employee_ID as the foreign key
                pst.setString(2, accountNumberText);
                pst.setString(3, accountTypeText);
                pst.setString(4, balanceText);
                
                int j = pst.executeUpdate();
	            
                if (j == 1) {
                    Phone.setText("");
                    Pin.setText("");
                    Balance.setText("");
                    dispose();
                    LoginFrame login = new LoginFrame();
	                login.setVisible(true);
                }
	            
            }
        } catch (SQLException ex) {
            Logger.getLogger(nextRegistration.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } 
    }
}
