package veroBank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class Registration extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public JTextField First_Name;
	public JTextField Last_Name;
	public JTextField Age;
	public JComboBox<String> Status;
	public JTextField Occupation;
	public JTextField Email;
	private JButton nextBtn;
	public JTextField Address;
	public JComboBox<String> genderGroup;
	public JDateChooser Birthday;
	public LineBorder BorderField = new LineBorder(new Color(215,215,215),1);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
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
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 676);
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
				LoginFrame login = new LoginFrame();
				dispose();
				login.setVisible(true);
			}
		});
		contentPane.add(back);
		
		JLabel lblAppForm = new JLabel("Application Form");
		lblAppForm.setForeground(new Color(39, 163, 59));
		lblAppForm.setFont(new Font("Leelawadee UI", Font.BOLD, 30));
		lblAppForm.setBounds(31, 11, 251, 40);
		contentPane.add(lblAppForm);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 252, 252));
		panel.setBounds(-11, 85, 700, 564);
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		contentPane.add(panel);
		panel.setBorder(border);
		panel.setLayout(null);
		
		First_Name = new JTextField();
		First_Name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		First_Name.setBackground(new Color(242, 242, 242));
		First_Name.setBounds(36, 40, 252, 40);
		panel.add(First_Name);
		First_Name.setHorizontalAlignment(SwingConstants.LEFT);
		First_Name.setColumns(10);
		First_Name.setBorder(BorderField);
		
		JLabel lblFirst_Name = new JLabel("First Name");
		lblFirst_Name.setForeground(new Color(96, 96, 96));
		lblFirst_Name.setBounds(36, 12, 103, 22);
		panel.add(lblFirst_Name);
		lblFirst_Name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		Last_Name = new JTextField();
		Last_Name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Last_Name.setBackground(new Color(242, 242, 242));
		Last_Name.setBounds(366, 40, 252, 40);
		panel.add(Last_Name);
		Last_Name.setHorizontalAlignment(SwingConstants.LEFT);
		Last_Name.setColumns(10);
		Last_Name.setBorder(BorderField);
		
		JLabel lblLast_Name = new JLabel("Last Name");
		lblLast_Name.setForeground(new Color(96, 96, 96));
		lblLast_Name.setBounds(366, 12, 95, 22);
		panel.add(lblLast_Name);
		lblLast_Name.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(96, 96, 96));
		lblAge.setBounds(36, 242, 115, 22);
		panel.add(lblAge);
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		Age = new JTextField();
		Age.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Age.setBackground(new Color(242, 242, 242));
		Age.setBounds(36, 268, 131, 40);
		panel.add(Age);
		Age.setHorizontalAlignment(SwingConstants.LEFT);
		Age.setColumns(10);
		Age.setBorder(BorderField);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(96, 96, 96));
		lblAddress.setBounds(36, 91, 79, 22);
		panel.add(lblAddress);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		Address = new JTextField();
		Address.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Address.setBackground(new Color(242, 242, 242));
		Address.setBounds(36, 122, 582, 40);
		panel.add(Address);
		Address.setHorizontalAlignment(SwingConstants.LEFT);
		Address.setColumns(10);
		Address.setBorder(BorderField);
		
		Birthday = new JDateChooser();
		Birthday.setForeground(new Color(0, 0, 0));
		Birthday.setBackground(new Color(242, 242, 242));
		Birthday.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Birthday.setBounds(259, 197, 359, 40);
		panel.add(Birthday);
		Birthday.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		JLabel lblBirthday = new JLabel("Birthday");
		lblBirthday.setForeground(new Color(96, 96, 96));
		lblBirthday.setBounds(258, 173, 115, 22);
		panel.add(lblBirthday);
		lblBirthday.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setForeground(new Color(96, 96, 96));
		lblGender.setBounds(36, 173, 115, 22);
		panel.add(lblGender);
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		genderGroup = new JComboBox<>(new String[]{"Male", "Female"});
		genderGroup.setForeground(new Color(0, 0, 0));
		genderGroup.setBounds(36, 197, 131, 34);
		panel.add(genderGroup);
		genderGroup.setFont(new Font("Tahoma", Font.PLAIN, 16));
		genderGroup.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(new Color(96, 96, 96));
		lblStatus.setBounds(366, 242, 115, 22);
		panel.add(lblStatus);
		lblStatus.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		Status = new JComboBox<>(new String[]{"Single", "Married", "In a Relationship", "Widowed"});
		Status.setBackground(new Color(242, 242, 242));
		Status.setFont(new Font("Tahoma", Font.PLAIN, 16));
		Status.setBounds(366, 268, 252, 40);
        panel.add(Status);
        Status.setBorder(new EmptyBorder(0, 0, 0, 0));
		
		Occupation = new JTextField();
		Occupation.setHorizontalAlignment(SwingConstants.LEFT);
		Occupation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Occupation.setBackground(new Color(242, 242, 242));
		Occupation.setBounds(36, 344, 582, 40);
		panel.add(Occupation);
		Occupation.setColumns(10);
		Occupation.setBorder(BorderField);
		
		Email = new JTextField();
		Email.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Email.setBackground(new Color(242, 242, 242));
		Email.setBounds(36, 419, 582, 40);
		panel.add(Email);
		Email.setHorizontalAlignment(SwingConstants.LEFT);
		Email.setColumns(10);
		Email.setBorder(BorderField);
		
		nextBtn = new JButton("NEXT");
		nextBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		nextBtn.setForeground(new Color(0, 0, 0));
		nextBtn.setBackground(new Color(39, 163, 59));
		nextBtn.setBounds(500, 477, 115, 30);
		panel.add(nextBtn);
		nextBtn.setBorder(BorderField);
		
		JLabel lblOccupation = new JLabel("Occupation");
		lblOccupation.setForeground(new Color(96, 96, 96));
		lblOccupation.setBounds(36, 319, 115, 22);
		panel.add(lblOccupation);
		lblOccupation.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(96, 96, 96));
		lblEmail.setBounds(36, 395, 115, 22);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 18));
		nextBtn.addActionListener(this);
		
		JLabel lblNewLabel_1 = new JLabel("Already have account?");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(31, 53, 139, 14);
		contentPane.add(lblNewLabel_1);
		
		JButton btnConnectLogin = new JButton("Log in here!");
		btnConnectLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginFrame login = new LoginFrame();
				dispose();
				login.setVisible(true);
			}
		});
		btnConnectLogin.setBounds(170, 50, 111, 19);
		contentPane.add(btnConnectLogin);
		btnConnectLogin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnConnectLogin.setForeground(new Color(39, 163, 59));
		btnConnectLogin.setBorderPainted(false);
		btnConnectLogin.setFocusPainted(false);
		btnConnectLogin.setBackground(new Color(255, 255, 255));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == nextBtn) {
			String fName = First_Name.getText();
	        String lName = Last_Name.getText();
	        String age = Age.getText();
	        String status = (String) Status.getSelectedItem();
	        String occupation = Occupation.getText();
	        String email = Email.getText();
	        String address = Address.getText();
	        String selectedGender = (String) genderGroup.getSelectedItem();

	        if (fName.isEmpty() || lName.isEmpty() || age.isEmpty() || status == null
	                || occupation.isEmpty() || email.isEmpty() || address.isEmpty()
	                || selectedGender == null
	                || Birthday.getDate() == null) {
	            JOptionPane.showMessageDialog(this, "Please fill in all the fields", "Warning", JOptionPane.WARNING_MESSAGE);
	        } else {
	        	dispose();
	            nextRegistration next = new nextRegistration(this);
	            next.setVisible(true);
	        }
	    }
	}
}