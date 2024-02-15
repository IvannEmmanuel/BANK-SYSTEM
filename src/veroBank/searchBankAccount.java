package veroBank;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.sql.*;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class searchBankAccount extends JFrame {

	
	static Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JComboBox<String> Employee_ID;
	private JLabel lblFirst_Name;
	private JTextField First_Name;
	private JLabel lblLast_Name;
	private JTextField Last_Name;
	private JLabel lblAge;
	private JTextField Age;
	private JTextField Gender;
	private JLabel lblStatus;
	private JTextField Status;
	private JTextField Birthday;
	private JLabel lblOccupation;
	private JTextField Occupation;
	private JLabel lblEmail;
	private JTextField Email;
	private JLabel lblPhone;
	private JTextField Phone;
	private JLabel lblNationality;
	private JTextField Nationality;
	private JLabel lblPin;
	private JTextField Pin;
	private JLabel lblAddress;
	private JTextField Address;
	private JLabel lblAccountnumber;
	private JTextField Account_Number;
	private JLabel lblAccounttype;
	private JTextField Account_Type;
	private JLabel lblBalance;
	private JTextField Balance;
	private JButton btnBack;
	private JPanel panel;
	private JLabel lblSearch;
	private JLabel lblAccount;
	private JLabel lblVeroBank;
	private JPanel panel_1;
	public LineBorder BorderField = new LineBorder(new Color(215,215,215),1);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					searchBankAccount frame = new searchBankAccount();
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
	public searchBankAccount() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 800);
		setResizable(false);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 252, 252));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ImageIcon veroBankIcon = new ImageIcon (getClass().getResource("/veroBankImage/logosVero.png"));
		
		lblFirst_Name = new JLabel("First Name");
		lblFirst_Name.setForeground(new Color(60, 60, 60));
		lblFirst_Name.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblFirst_Name.setBounds(14, 169, 86, 20);
		contentPane.add(lblFirst_Name);
		
		First_Name = new JTextField();
		First_Name.setEditable(false);
		First_Name.setBackground(new Color(242, 242, 242));
		First_Name.setFont(new Font("Tahoma", Font.BOLD, 13));
		First_Name.setBounds(14, 190, 246, 23);
		contentPane.add(First_Name);
		First_Name.setColumns(10);
		
		lblLast_Name = new JLabel("Last Name");
		lblLast_Name.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblLast_Name.setForeground(new Color(60, 60, 60));
		lblLast_Name.setBounds(270, 173, 85, 14);
		contentPane.add(lblLast_Name);
		
		Last_Name = new JTextField();
		Last_Name.setEditable(false);
		Last_Name.setBackground(new Color(242, 242, 242));
		Last_Name.setFont(new Font("Tahoma", Font.BOLD, 13));
		Last_Name.setColumns(10);
		Last_Name.setBounds(270, 190, 270, 23);
		contentPane.add(Last_Name);
		
		lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(60, 60, 60));
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAge.setBounds(14, 305, 77, 20);
		contentPane.add(lblAge);
		
		Age = new JTextField();
		Age.setEditable(false);
		Age.setBackground(new Color(242, 242, 242));
		Age.setFont(new Font("Tahoma", Font.BOLD, 13));
		Age.setColumns(10);
		Age.setBounds(14, 329, 144, 23);
		contentPane.add(Age);
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setForeground(new Color(60, 60, 60));
		lblBirthday.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblBirthday.setBounds(270, 266, 77, 16);
		contentPane.add(lblBirthday);
		
		Birthday = new JTextField();
		Birthday.setEditable(false);
		Birthday.setBackground(new Color(242, 242, 242));
		Birthday.setFont(new Font("Tahoma", Font.BOLD, 13));
		Birthday.setBounds(270, 283, 270, 23);
		contentPane.add(Birthday);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(60, 60, 60));
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblGender.setBounds(14, 265, 77, 14);
		contentPane.add(lblGender);
		
		Gender = new JTextField();
		Gender.setEditable(false);
		Gender.setBackground(new Color(242, 242, 242));
		Gender.setForeground(new Color(0, 0, 0));
		Gender.setBounds(14, 283, 144, 23);
		contentPane.add(Gender);
		Gender.setFont(new Font("Tahoma", Font.BOLD, 13));
		
		lblStatus = new JLabel("Status");
		lblStatus.setForeground(new Color(60, 60, 60));
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblStatus.setBounds(270, 309, 77, 14);
		contentPane.add(lblStatus);
		
		Status = new JTextField();
		Status.setEditable(false);
		Status.setBackground(new Color(242, 242, 242));
		Status.setFont(new Font("Tahoma", Font.BOLD, 13));
		Status.setBounds(270, 329, 270, 23);
		Status.setForeground(new Color(0, 0, 0));
        contentPane.add(Status);
        
        lblOccupation = new JLabel("Occupation");
        lblOccupation.setForeground(new Color(60, 60, 60));
        lblOccupation.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblOccupation.setBounds(14, 354, 90, 14);
        contentPane.add(lblOccupation);
        
        Occupation = new JTextField();
        Occupation.setEditable(false);
        Occupation.setBackground(new Color(242, 242, 242));
        Occupation.setFont(new Font("Tahoma", Font.BOLD, 13));
        Occupation.setBounds(14, 372, 526, 23);
        Occupation.setForeground(new Color(0, 0, 0));
        contentPane.add(Occupation);
        
        lblEmail = new JLabel("Email");
        lblEmail.setForeground(new Color(60, 60, 60));
        lblEmail.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblEmail.setBounds(14, 396, 77, 15);
        contentPane.add(lblEmail);
        
        Email = new JTextField();
        Email.setEditable(false);
        Email.setBackground(new Color(242, 242, 242));
        Email.setFont(new Font("Tahoma", Font.BOLD, 13));
        Email.setBounds(14, 413, 526, 23);
        Email.setForeground(new Color(0, 0, 0));
        contentPane.add(Email);
        
        lblPhone = new JLabel("Phone");
        lblPhone.setForeground(new Color(60, 60, 60));
        lblPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblPhone.setBounds(14, 439, 77, 14);
        contentPane.add(lblPhone);
        
        Phone = new JTextField();
        Phone.setEditable(false);
        Phone.setBackground(new Color(242, 242, 242));
        Phone.setForeground(Color.BLACK);
        Phone.setFont(new Font("Tahoma", Font.BOLD, 13));
        Phone.setBounds(14, 456, 526, 23);
        contentPane.add(Phone);
        
        lblNationality = new JLabel("Nationality");
        lblNationality.setForeground(new Color(60, 60, 60));
        lblNationality.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNationality.setBounds(14, 520, 90, 14);
        contentPane.add(lblNationality);
        
        Nationality = new JTextField();
        Nationality.setEditable(false);
        Nationality.setBackground(new Color(242, 242, 242));
        Nationality.setForeground(Color.BLACK);
        Nationality.setFont(new Font("Tahoma", Font.BOLD, 13));
        Nationality.setBounds(14, 536, 526, 23);
        contentPane.add(Nationality);
        
        lblPin = new JLabel("Pin");
        lblPin.setForeground(new Color(60, 60, 60));
        lblPin.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblPin.setBounds(14, 562, 77, 14);
        contentPane.add(lblPin);
        
        Pin = new JTextField();
        Pin.setEditable(false);
        Pin.setBackground(new Color(242, 242, 242));
        Pin.setForeground(Color.BLACK);
        Pin.setFont(new Font("Tahoma", Font.BOLD, 13));
        Pin.setBounds(14, 581, 526, 23);
        contentPane.add(Pin);
        
        lblAddress = new JLabel("Address");
        lblAddress.setForeground(new Color(60, 60, 60));
        lblAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblAddress.setBounds(14, 219, 77, 14);
        contentPane.add(lblAddress);
        
        Address = new JTextField();
        Address.setEditable(false);
        Address.setBackground(new Color(242, 242, 242));
        Address.setForeground(Color.BLACK);
        Address.setFont(new Font("Tahoma", Font.BOLD, 13));
        Address.setBounds(14, 237, 526, 23);
        contentPane.add(Address);
        
        lblAccountnumber = new JLabel("Account_Number");
        lblAccountnumber.setForeground(new Color(60, 60, 60));
        lblAccountnumber.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblAccountnumber.setBounds(14, 479, 140, 14);
        contentPane.add(lblAccountnumber);
        
        Account_Number = new JTextField();
        Account_Number.setEditable(false);
        Account_Number.setBackground(new Color(242, 242, 242));
        Account_Number.setForeground(Color.BLACK);
        Account_Number.setFont(new Font("Tahoma", Font.BOLD, 13));
        Account_Number.setBounds(14, 496, 526, 23);
        contentPane.add(Account_Number);
        
        lblAccounttype = new JLabel("Account_Type");
        lblAccounttype.setForeground(new Color(60, 60, 60));
        lblAccounttype.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblAccounttype.setBounds(14, 609, 120, 14);
        contentPane.add(lblAccounttype);
        
        Account_Type = new JTextField();
        Account_Type.setEditable(false);
        Account_Type.setBackground(new Color(242, 242, 242));
        Account_Type.setForeground(Color.BLACK);
        Account_Type.setFont(new Font("Tahoma", Font.BOLD, 13));
        Account_Type.setBounds(14, 628, 526, 23);
        contentPane.add(Account_Type);
        
        lblBalance = new JLabel("Balance");
        lblBalance.setForeground(new Color(60, 60, 60));
        lblBalance.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblBalance.setBounds(14, 655, 70, 14);
        contentPane.add(lblBalance);
        
        Balance = new JTextField();
        Balance.setEditable(false);
        Balance.setBackground(new Color(242, 242, 242));
        Balance.setForeground(Color.BLACK);
        Balance.setFont(new Font("Tahoma", Font.BOLD, 13));
        Balance.setBounds(14, 673, 526, 23);
        contentPane.add(Balance);
        
        btnBack = new JButton("BACK");
        btnBack.setFont(new Font("MS UI Gothic", Font.BOLD, 13));
        btnBack.setBackground(new Color(255, 255, 255));
        btnBack.setForeground(new Color(0, 0, 0));
        btnBack.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		adminMenu menu = new adminMenu();
        		menu.setVisible(true);
        	}
        });
        btnBack.setBounds(450, 715, 89, 23);
        contentPane.add(btnBack);
        
        panel = new JPanel();
        panel.setBackground(new Color(255, 252, 252));
        panel.setBounds(0, 0, 550, 84);
        panel.setBorder(BorderField);
        contentPane.add(panel);
        panel.setLayout(null);
        
        lblSearch = new JLabel("SEARCH");
        lblSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblSearch.setBounds(27, 36, 80, 14);
        panel.add(lblSearch);
        
        lblAccount = new JLabel("ACCOUNT");
        lblAccount.setForeground(new Color(39, 163, 59));
        lblAccount.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblAccount.setBounds(109, 36, 96, 14);
        panel.add(lblAccount);
        
        JLabel labelIcon = new JLabel(veroBankIcon);
        labelIcon.setBounds(337, 11, 96, 65);
        panel.add(labelIcon);
        
        lblVeroBank = new JLabel("VERO BANK");
        lblVeroBank.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblVeroBank.setBounds(421, 36, 106, 14);
        panel.add(lblVeroBank);
        
        panel_1 = new JPanel();
        panel_1.setBackground(new Color(245, 245, 245));
        panel_1.setBounds(0, 80, 550, 76);
        panel_1.setBorder(BorderField);
        contentPane.add(panel_1);
        panel_1.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Employee ID");
        lblNewLabel.setForeground(new Color(60, 60, 60));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
        lblNewLabel.setBounds(20, 11, 115, 22);
        panel_1.add(lblNewLabel);
        
        Employee_ID = new JComboBox<String>();
        Employee_ID.setBackground(new Color(255, 252, 252));
        Employee_ID.setBounds(20, 32, 115, 33);
        panel_1.add(Employee_ID);
        
        EmployeeNo();
        
        JButton btnSearch = new JButton("SEARCH");
        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 15));
        btnSearch.setBackground(new Color(39, 163, 59));
        btnSearch.setBounds(156, 33, 121, 30);
        panel_1.add(btnSearch);
        btnSearch.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			String eid = Employee_ID.getSelectedItem().toString(); //81
        			
        			pst = con.prepareStatement("SELECT e.First_Name, e.Last_Name, e.Age, e.Birthday, e.Gender, e.Status, e.Occupation, e.Email, e.Phone, e.Nationality, e.Pin, e.Address, a.Account_Number, a.Account_Type, a.Balance FROM employee e JOIN account a ON e.Employee_ID = a.Employee_ID WHERE e.Employee_ID = ?");
        			pst.setString(1, eid); //81
        			rs = pst.executeQuery();
        			
        			if (rs.next()) {
        				First_Name.setText(rs.getString(1));
        				Last_Name.setText(rs.getString(2));
        				Age.setText(rs.getString(3));
        				Birthday.setText(rs.getString(4));
        				Gender.setText(rs.getString(5));
        				Status.setText(rs.getString(6));
        				Occupation.setText(rs.getString(7));
        				Email.setText(rs.getString(8));
        				Phone.setText(rs.getString(9));
        				Nationality.setText(rs.getString(10));
        				Pin.setText(rs.getString(11));
        				Address.setText(rs.getString(12));
        				Account_Number.setText(rs.getString(13));
        				Account_Type.setText(rs.getString(14));
        				Balance.setText(rs.getString(15));
        				
        			}else {
        				JOptionPane.showMessageDialog(null, "No record found!");
        			}
        			
        		}catch(SQLException ex) {
        			ex.printStackTrace();
        		}
        	}
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
	public void EmployeeNo() {
		Connect();
		try {
			pst = con.prepareStatement("SELECT Employee_ID FROM employee");
			rs = pst.executeQuery();
			Employee_ID.removeAllItems();
			while(rs.next()) {
				Employee_ID.addItem(rs.getString(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
