package veroBank;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Menu extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton deposit;
	private JButton withdraw;
	public String loggedInAccountNumber;
	public LineBorder BorderField = new LineBorder(new Color(228,228,228),1);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu(null);
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
	public Menu(String loggedInAccountNumber) {
		this.loggedInAccountNumber = loggedInAccountNumber; //88316
		ImageIcon frameIcon = new ImageIcon(getClass().getClassLoader().getResource("veroBankImage/veroBanks.png"));
        setIconImage(frameIcon.getImage());
        
        setTitle("MENU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 832, 661);
		setLocationRelativeTo(null);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		JLabel lblVeroBank = new JLabel("VERO BANK");
		lblVeroBank.setBounds(323, 141, 172, 44);
		lblVeroBank.setForeground(new Color(96, 96, 96));
		lblVeroBank.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 35));
		contentPane.add(lblVeroBank);
		
		ImageIcon veroBankIcon = new ImageIcon (getClass().getResource("/veroBankImage/logoBank.png"));
		contentPane.setLayout(null);
		JLabel labelIcon = new JLabel(veroBankIcon);
		labelIcon.setBounds(336,11,130,130);
		contentPane.add(labelIcon);
		
		ImageIcon depositIcon = new ImageIcon (getClass().getResource("/veroBankImage/deposit.png"));
		contentPane.setLayout(null);
		deposit = new JButton(depositIcon);
		deposit.setBackground(new Color(255, 255, 255));
		deposit.setBounds(110,182,103,96);
		deposit.setActionCommand("DEPOSIT");
		contentPane.add(deposit);
		deposit.setBorderPainted(false);
		deposit.setFocusPainted(false);
		deposit.setContentAreaFilled(false);
		deposit.addActionListener(this);
		
		JLabel lblDeposit = new JLabel("DEPOSIT");
		lblDeposit.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblDeposit.setForeground(new Color(96, 96, 96));
		lblDeposit.setBounds(223, 226, 82, 14);
		contentPane.add(lblDeposit);
		
		JPanel depositPanel = new JPanel();
		depositPanel.setBackground(new Color(255, 255, 255));
		depositPanel.setBounds(81, 182, 290, 102);
		contentPane.add(depositPanel);
		depositPanel.setBorder(BorderField);
		
		depositPanel.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        deposit.doClick();
		    }
		});
		
		ImageIcon pinIcon = new ImageIcon (getClass().getResource("/veroBankImage/Pin.png"));
		contentPane.setLayout(null);
		JButton pin = new JButton(pinIcon);
		pin.setBackground(new Color(255, 255, 255));
		pin.setBounds(110,299,103,96);
		pin.setActionCommand("PIN");
		contentPane.add(pin);
		pin.setBorderPainted(false);
		pin.setFocusPainted(false);
		pin.setContentAreaFilled(false);
		pin.addActionListener(this);
		
		JLabel lblPin = new JLabel("PIN CHANGE");
		lblPin.setForeground(new Color(96, 96, 96));
		lblPin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblPin.setBounds(223, 339, 116, 14);
		contentPane.add(lblPin);
		
		JPanel pinPanel = new JPanel();
		pinPanel.setBackground(new Color(255, 255, 255));
		pinPanel.setBounds(81, 295, 290, 113);
		contentPane.add(pinPanel);
		pinPanel.setBorder(BorderField);
		
		pinPanel.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        pin.doClick();
		    }
		});
		
		ImageIcon loanIcon = new ImageIcon (getClass().getResource("/veroBankImage/Loan.png"));
		contentPane.setLayout(null);
		JButton loan = new JButton(loanIcon);
		loan.setBackground(new Color(255, 255, 255));
		loan.setBounds(347,476,103,96);
		loan.setActionCommand("LOANS");
		contentPane.add(loan);
		loan.setBorderPainted(false);
		loan.setFocusPainted(false);
		loan.setContentAreaFilled(false);
		loan.addActionListener(this);
		
		JLabel lblLoan = new JLabel("LOAN");
		lblLoan.setForeground(new Color(96, 96, 96));
		lblLoan.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLoan.setBounds(371, 452, 50, 14);
		contentPane.add(lblLoan);
		
		JPanel loanPanel = new JPanel();
		loanPanel.setBackground(new Color(255, 255, 255));
		loanPanel.setBounds(259, 447, 290, 113);
		contentPane.add(loanPanel);
		loanPanel.setBorder(BorderField);
		
		loanPanel.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        loan.doClick();
		    }
		});
		
		ImageIcon withdrawIcon = new ImageIcon (getClass().getResource("/veroBankImage/Withdraw.png"));
		contentPane.setLayout(null);
		withdraw = new JButton(withdrawIcon);
		withdraw.setBackground(new Color(255, 255, 255));
		withdraw.setBounds(593,182,103,96);
		withdraw.setActionCommand("WITHDRAW");
		contentPane.add(withdraw);
		withdraw.addActionListener(this);
		withdraw.setBorderPainted(false);
		withdraw.setFocusPainted(false);
		withdraw.setContentAreaFilled(false);
		
		JLabel lblWithdraw = new JLabel("WITHDRAW");
		lblWithdraw.setForeground(new Color(96, 96, 96));
		lblWithdraw.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblWithdraw.setBounds(472, 226, 111, 14);
		contentPane.add(lblWithdraw);
		
		JPanel withdrawPanel = new JPanel();
		withdrawPanel.setBackground(new Color(255, 255, 255));
		withdrawPanel.setBounds(440, 182, 299, 102);
		contentPane.add(withdrawPanel);
		withdrawPanel.setBorder(BorderField);
		
		withdrawPanel.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        withdraw.doClick();
		    }
		});
		
		ImageIcon balanceIcon = new ImageIcon (getClass().getResource("/veroBankImage/Balance.png"));
		contentPane.setLayout(null);
		JButton balance = new JButton(balanceIcon);
		balance.setBackground(new Color(255, 255, 255));
		balance.setBounds(589,299,107,102);
		balance.setActionCommand("BALANCE");
		contentPane.add(balance);
		balance.setBorderPainted(false);
		balance.setFocusPainted(false);
		balance.setContentAreaFilled(false);
		balance.addActionListener(this);
		
		JLabel lblBalance = new JLabel("BALANCE");
		lblBalance.setForeground(new Color(96, 96, 96));
		lblBalance.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblBalance.setBounds(498, 339, 85, 14);
		contentPane.add(lblBalance);
		
		JPanel balancePanel = new JPanel();
		balancePanel.setBackground(new Color(255, 255, 255));
		balancePanel.setBounds(440, 295, 299, 113);
		contentPane.add(balancePanel);
		balancePanel.setBorder(BorderField);
		
		balancePanel.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		    	balance.doClick();
		    }
		});
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    if ("DEPOSIT".equals(e.getActionCommand())) {
	        dispose();
	        DepositFrame depo = new DepositFrame(loggedInAccountNumber); //88316
	        depo.setVisible(true);
	    }
	    else if("WITHDRAW".equals(e.getActionCommand())) {
	    	dispose();
	    	WithdrawFrame with = new WithdrawFrame(loggedInAccountNumber);
	    	with.setVisible(true);
	    }
	    else if("PIN".equals(e.getActionCommand())){
	    	dispose();
	    	pinChangeFrame pinChange = new pinChangeFrame(loggedInAccountNumber);
	    	pinChange.setVisible(true);
	    }
	    else if("BALANCE".equals(e.getActionCommand())) {
	    	dispose();
	    	balanceFrame bal = new balanceFrame(loggedInAccountNumber);
	    	bal.setVisible(true);
	    }
	    else if ("LOANS".equals(e.getActionCommand())) {
	    	dispose();
	    	loanFrame lown = new loanFrame(loggedInAccountNumber);
	    	lown.setVisible(true);
	    }
	}
}
