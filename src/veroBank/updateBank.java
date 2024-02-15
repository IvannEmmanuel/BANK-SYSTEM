package veroBank;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.HeadlessException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
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
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;

public class updateBank extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField Employee_ID;
	private JTextField First_Name;
	private JTextField Last_Name;
	static Connection con;
	PreparedStatement pst;
	ResultSet rs;
	private JLabel lblVeroBank;
	private JLabel lblAge;
	private JTextField Age;
	private JLabel lblStatus;
	private JLabel lblOccupation;
	private JTextField Occupation;
	private JLabel lblEmail;
	private JTextField Email;
	private JLabel lblPhone;
	private JTextField Phone;
	private JLabel lblNationality;
	private JLabel lblPin;
	private JTextField Pin;
	private JLabel lblAddress;
	private JTextField Address;
	private JLabel lblAccounttype;
	private JLabel lblBalance;
	private JTextField Balance;
	private JComboBox<String> Gender;
	private JComboBox<String> Status;
	private JComboBox<String> Account_Type;
	private JComboBox<String> Nationality;
	private JDateChooser Birthday;
	private JButton btnBack;
	private JPanel panel;
	private JLabel lblAccount;
	private JLabel lblUpdate;
	public LineBorder BorderField = new LineBorder(new Color(215,215,215),1);
	
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateBank frame = new updateBank();
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
	public updateBank() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 780);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 252, 252));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFirst_Name = new JLabel("First_Name");
		lblFirst_Name.setBounds(19, 162, 102, 14);
		lblFirst_Name.setForeground(new Color(60, 60, 60));
		lblFirst_Name.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblFirst_Name);
		
		First_Name = new JTextField();
		First_Name.setForeground(new Color(0, 0, 0));
		First_Name.setFont(new Font("Tahoma", Font.BOLD, 13));
		First_Name.setBackground(new Color(242, 242, 242));
		First_Name.setBounds(19, 180, 240, 23);
		First_Name.setColumns(10);
		contentPane.add(First_Name);
		
		JLabel lblLast_Name = new JLabel("Last_Name");
		lblLast_Name.setBounds(266, 164, 96, 14);
		lblLast_Name.setForeground(new Color(60, 60, 60));
		lblLast_Name.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblLast_Name);
		
		Last_Name = new JTextField();
		Last_Name.setForeground(new Color(0, 0, 0));
		Last_Name.setFont(new Font("Tahoma", Font.BOLD, 13));
		Last_Name.setBackground(new Color(242, 242, 242));
		Last_Name.setBounds(265, 180, 270, 23);
		Last_Name.setColumns(10);
		contentPane.add(Last_Name);
		
		lblAge = new JLabel("Age");
		lblAge.setBounds(19, 300, 41, 18);
		lblAge.setForeground(new Color(60, 60, 60));
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblAge);
		
		Age = new JTextField();
		Age.setForeground(new Color(0, 0, 0));
		Age.setFont(new Font("Tahoma", Font.BOLD, 13));
		Age.setBackground(new Color(242, 242, 242));
		Age.setBounds(19, 321, 130, 23);
		Age.setColumns(10);
		contentPane.add(Age);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(19, 258, 71, 14);
		lblGender.setForeground(new Color(60, 60, 60));
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblGender);
		
		Gender = new JComboBox<>(new String[]{"Male", "Female"});
		Gender.setBackground(new Color(242, 242, 242));
		Gender.setBounds(19, 277, 130, 23);
		Gender.setForeground(new Color(0, 0, 0));
		contentPane.add(Gender);
		Gender.setFont(new Font("Tahoma", Font.BOLD, 13));
		Gender.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		lblStatus = new JLabel("Status");
		lblStatus.setBounds(266, 304, 71, 14);
		lblStatus.setForeground(new Color(60, 60, 60));
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(lblStatus);
		
		Status = new JComboBox<>(new String[]{"Single", "Married", "In a Relationship", "Widowed"});
		Status.setForeground(new Color(0, 0, 0));
		Status.setBounds(266, 321, 269, 23);
		Status.setBackground(new Color(242, 242, 242));
		Status.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(Status);
        Status.setBorder(new EmptyBorder(0, 0, 0, 0));
        
        lblOccupation = new JLabel("Occupation");
        lblOccupation.setBounds(19, 345, 102, 16);
        lblOccupation.setForeground(new Color(60, 60, 60));
        lblOccupation.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(lblOccupation);
        
        Occupation = new JTextField();
        Occupation.setForeground(new Color(0, 0, 0));
        Occupation.setFont(new Font("Tahoma", Font.BOLD, 13));
        Occupation.setBackground(new Color(242, 242, 242));
        Occupation.setBounds(19, 365, 516, 23);
        Occupation.setColumns(10);
        contentPane.add(Occupation);
        
        lblEmail = new JLabel("Email");
        lblEmail.setForeground(new Color(60, 60, 60));
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblEmail.setBounds(19, 525, 45, 14);
        contentPane.add(lblEmail);
        
        Email = new JTextField();
        Email.setForeground(new Color(0, 0, 0));
        Email.setFont(new Font("Tahoma", Font.BOLD, 13));
        Email.setBackground(new Color(242, 242, 242));
        Email.setBounds(19, 545, 516, 23);
        Email.setColumns(10);
        contentPane.add(Email);
        
        lblPhone = new JLabel("Phone");
        lblPhone.setForeground(new Color(60, 60, 60));
        lblPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblPhone.setBounds(19, 392, 60, 14);
        contentPane.add(lblPhone);
        
        Phone = new JTextField();
        Phone.setForeground(new Color(0, 0, 0));
        Phone.setFont(new Font("Tahoma", Font.BOLD, 13));
        Phone.setBackground(new Color(242, 242, 242));
        Phone.setBounds(19, 410, 516, 23);
        Phone.setColumns(10);
        contentPane.add(Phone);
        
        lblNationality = new JLabel("Nationality");
        lblNationality.setForeground(new Color(60, 60, 60));
        lblNationality.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNationality.setBounds(19, 435, 100, 16);
        contentPane.add(lblNationality);
        
        Nationality = new JComboBox<>(new String[]{"Philippines", "USA", "Japan", "United Kingdom", "Germany"});
        Nationality.setForeground(new Color(0, 0, 0));
        Nationality.setBounds(19, 455, 516, 23);
        Nationality.setBackground(new Color(242, 242, 242));
        Nationality.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(Nationality);
        Nationality.setBorder(new EmptyBorder(0, 0, 0, 0));
        
        lblPin = new JLabel("Pin");
        lblPin.setForeground(new Color(60, 60, 60));
        lblPin.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblPin.setBounds(19, 483, 30, 14);
        contentPane.add(lblPin);
        
        Pin = new JTextField();
        Pin.setForeground(new Color(0, 0, 0));
        Pin.setFont(new Font("Tahoma", Font.BOLD, 13));
        Pin.setBackground(new Color(242, 242, 242));
        Pin.setBounds(19, 500, 516, 23);
        Pin.setColumns(10);
        contentPane.add(Pin);
        
        lblAddress = new JLabel("Address");
        lblAddress.setBounds(19, 210, 72, 14);
        lblAddress.setForeground(new Color(60, 60, 60));
        lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(lblAddress);
        
        Address = new JTextField();
        Address.setForeground(new Color(0, 0, 0));
        Address.setFont(new Font("Tahoma", Font.BOLD, 13));
        Address.setBackground(new Color(242, 242, 242));
        Address.setBounds(19, 230, 516, 23);
        Address.setColumns(10);
        contentPane.add(Address);
        
        lblAccounttype = new JLabel("Account_Type");
        lblAccounttype.setForeground(new Color(60, 60, 60));
        lblAccounttype.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblAccounttype.setBounds(19, 570, 120, 18);
        contentPane.add(lblAccounttype);
        
        Account_Type = new JComboBox<>(new String[]{"Salary Account", "Retirement Account", "Basic Bank Account", "Foreign Currency Bank", "Money Market Account"});
        Account_Type.setForeground(new Color(0, 0, 0));
        Account_Type.setBounds(19, 590, 516, 23);
        Account_Type.setBackground(new Color(242, 242, 242));
        Account_Type.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(Account_Type);
        Account_Type.setBorder(new EmptyBorder(0, 0, 0, 0));
        
        lblBalance = new JLabel("Balance");
        lblBalance.setForeground(new Color(60, 60, 60));
        lblBalance.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblBalance.setBounds(19, 615, 70, 14);
        contentPane.add(lblBalance);
        
        Balance = new JTextField();
        Balance.setForeground(new Color(0, 0, 0));
        Balance.setFont(new Font("Tahoma", Font.BOLD, 13));
        Balance.setBackground(new Color(242, 242, 242));
        Balance.setBounds(19, 635, 516, 23);
        Balance.setColumns(10);
        contentPane.add(Balance);
        
        btnBack = new JButton("BACK");
        btnBack.setFont(new Font("MS UI Gothic", Font.BOLD, 13));
        btnBack.setBackground(new Color(255, 255, 255));
        btnBack.setForeground(new Color(0, 0, 0));
        btnBack.setBounds(432, 690, 100, 30);
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		adminMenu menu = new adminMenu();
        		menu.setVisible(true);
        	}
        });
        contentPane.add(btnBack);
        
        Birthday = new JDateChooser();
        Birthday.setForeground(new Color(0, 0, 0));
        Birthday.setBackground(new Color(242, 242, 242));
        Birthday.setBounds(266, 277, 269, 23);
        contentPane.add(Birthday);
        
        JLabel lblBirthday = new JLabel("Birthday");
        lblBirthday.setBounds(266, 260, 86, 14);
        lblBirthday.setForeground(new Color(60, 60, 60));
        lblBirthday.setFont(new Font("Tahoma", Font.BOLD, 15));
        contentPane.add(lblBirthday);
        
        panel = new JPanel();
        panel.setBounds(0, 0, 550, 73);
        panel.setBackground(new Color(255, 252, 252));
        contentPane.add(panel);
        panel.setBorder(BorderField);
        panel.setLayout(null);
        
        ImageIcon veroBankIcon = new ImageIcon (getClass().getResource("/veroBankImage/logosVero.png"));
        JLabel labelIcon = new JLabel(veroBankIcon);
        labelIcon.setBounds(321, 4, 96, 65);
        panel.add(labelIcon);
        
        lblAccount = new JLabel("ACCOUNT");
        lblAccount.setForeground(new Color(39, 163, 59));
        lblAccount.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblAccount.setBounds(106, 31, 96, 14);
        panel.add(lblAccount);
        
        lblUpdate = new JLabel("UPDATE");
        lblUpdate.setBounds(25, 31, 88, 14);
        panel.add(lblUpdate);
        lblUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        lblVeroBank = new JLabel("VERO BANK");
        lblVeroBank.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblVeroBank.setBounds(405, 31, 96, 14);
        panel.add(lblVeroBank);
        
        JPanel panel_1 = new JPanel();
        panel_1.setBounds(0, 73, 550, 79);
        panel_1.setBackground(new Color(255, 255, 255));
        panel_1.setBorder(BorderField);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblEmployee_ID = new JLabel("Employee_ID");
        lblEmployee_ID.setBounds(20, 15, 107, 19);
        lblEmployee_ID.setForeground(new Color(60, 60, 60));
        panel_1.add(lblEmployee_ID);
        lblEmployee_ID.setBackground(new Color(60, 60, 60));
        lblEmployee_ID.setFont(new Font("Tahoma", Font.BOLD, 15));
        
        Employee_ID = new JTextField();
        Employee_ID.setFont(new Font("Tahoma", Font.BOLD, 14));
        Employee_ID.setBackground(new Color(242, 242, 242));
        Employee_ID.setBounds(20, 38, 100, 30);
        panel_1.add(Employee_ID);
        Employee_ID.setColumns(10);
        
        JButton sbmtBtn = new JButton("UPDATE");
        sbmtBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
        sbmtBtn.setBounds(200, 680, 136, 30);
        sbmtBtn.setForeground(new Color(0, 0, 0));
        sbmtBtn.setBackground(new Color(39, 163, 59));
        contentPane.add(sbmtBtn);
        sbmtBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
                try {
                		con = DriverManager.getConnection("jdbc:mysql://localhost/bank_system", "root", "");
                		
                        String employeeCheckQuery = "SELECT * FROM employee WHERE Employee_ID = ?"; //81
                        pst = con.prepareStatement(employeeCheckQuery);
                        pst.setString(1, Employee_ID.getText()); //81
                        ResultSet rs = pst.executeQuery();

                        if (!rs.next()) {
                        	JOptionPane.showMessageDialog(null, "Employee not found");
                        }else {
                        	if (First_Name.getText().isEmpty() || Last_Name.getText().isEmpty() || Age.getText().isEmpty()
                                    || Occupation.getText().isEmpty() || Email.getText().isEmpty() || Phone.getText().isEmpty()
                                    || Pin.getText().isEmpty() || Address.getText().isEmpty() || Balance.getText().isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Please fill in all the fields!");
                            } else {
	                        String sqlEmployee = "UPDATE employee SET First_Name = ?, Last_Name = ?, Age = ?, Birthday = ?, Gender = ?, Status = ?, Occupation = ?, Email = ?, Phone = ?, Nationality = ?, Pin = ?, Address = ? WHERE Employee_ID = ?"; //81
	                        String sqlAccount = "UPDATE account SET Account_Type = ?, Balance = ? WHERE Employee_ID = ?";
                        
                        pst = con.prepareStatement(sqlEmployee);
                        pst.setString(1, First_Name.getText());
                        pst.setString(2, Last_Name.getText());
                        pst.setString(3, Age.getText());
                        java.util.Date selectedDate = Birthday.getDate();
                        java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
                        pst.setDate(4, sqlDate);
                        pst.setString(5, (String) Gender.getSelectedItem());
                        pst.setString(6, (String) Status.getSelectedItem());
                        pst.setString(7, Occupation.getText());
                        pst.setString(8, Email.getText());
                        pst.setString(9, Phone.getText());
                        pst.setString(10, (String) Nationality.getSelectedItem());
                        pst.setString(11, Pin.getText());
                        pst.setString(12, Address.getText());
                        pst.setString(13, Employee_ID.getText());
                        pst.executeUpdate();
                        
                        pst = con.prepareStatement(sqlAccount);
                        pst.setString(1, (String) Account_Type.getSelectedItem());
                        pst.setString(2, Balance.getText());
                        pst.setString(3, Employee_ID.getText());
                        pst.executeUpdate();
                        
                        JOptionPane.showMessageDialog(null, "UPDATE SUCCESSFULLY");
                        dispose();
                        adminMenu menu = new adminMenu();
                        menu.setVisible(true);
                    }
                 }
              }   
                 catch (SQLException | HeadlessException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
        	}
        });
	}
}
