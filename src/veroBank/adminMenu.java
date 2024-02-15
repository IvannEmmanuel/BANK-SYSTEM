package veroBank;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Vector;

public class adminMenu extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    int q,i;
	
	private JPanel contentPane;
    private JTable table;
	public LineBorder BorderField = new LineBorder(new Color(228,228,228),1);
    
    public adminMenu() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Admin Menu");
        setSize(1200, 600);
        setLocationRelativeTo(null);
        setResizable(false);

        contentPane = new JPanel();
        setContentPane(contentPane);
		
		JPanel headerPanel = new JPanel();
        headerPanel.setBounds(0, 0, 1200, 413);
        headerPanel.setBackground(Color.WHITE);
        headerPanel.setLayout(null);

        JLabel titleLabel = new JLabel("VERO BANK");
        titleLabel.setBounds(444, 53, 172, 44);
        titleLabel.setForeground(new Color(96, 96, 96));
        titleLabel.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 35));
        headerPanel.add(titleLabel);

        ImageIcon veroBankIcon = new ImageIcon(getClass().getResource("/veroBankImage/logoBank.png"));
        contentPane.setLayout(null);
        JLabel logoLabel = new JLabel(veroBankIcon);
        logoLabel.setBounds(626, 10, 130, 130);
        headerPanel.add(logoLabel);
        contentPane.add(headerPanel);
        
		ImageIcon deleteIcon = new ImageIcon (getClass().getResource("/veroBankImage/bankDeletes.png"));
		contentPane.setLayout(null);
        
        JPanel deletePanel = new JPanel();
        deletePanel.setBounds(176, 277, 324, 99);
        deletePanel.setBackground(new Color(255, 255, 255));
        deletePanel.setBorder(BorderField);
        deletePanel.setLayout(null);
        JButton delete = new JButton(deleteIcon);
        delete.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		deleteBank dltBank = new deleteBank();
        		dltBank.setVisible(true);
        	}
        });
        delete.setBounds(38, 0, 87, 95);
        deletePanel.add(delete);
        delete.setBackground(new Color(255, 255, 255));
        delete.setBorderPainted(false);
        delete.setFocusPainted(false);
        delete.setContentAreaFilled(false);
        
        JLabel lblDelete = new JLabel("DELETE ACCOUNT");
        lblDelete.setBounds(135, 40, 161, 14);
        deletePanel.add(lblDelete);
        lblDelete.setForeground(new Color(96, 96, 96));
        lblDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
        deletePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                delete.doClick();
            }
        });
        
		ImageIcon addBank = new ImageIcon (getClass().getResource("/veroBankImage/bankAdds.png"));
		contentPane.setLayout(null);
        
        JPanel addPanel = new JPanel();
        addPanel.setBounds(176, 167, 324, 99);
        headerPanel.add(addPanel);
        addPanel.setBackground(new Color(255, 255, 255));
        addPanel.setBorder(BorderField);
        addPanel.setLayout(null);
        JLabel lblAdd = new JLabel("ADD ACCOUNT");
        lblAdd.setBounds(158, 43, 133, 14);
        addPanel.add(lblAdd);
        lblAdd.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblAdd.setForeground(new Color(96, 96, 96));
        JButton add = new JButton(addBank);
        add.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		adminRegister aReg = new adminRegister();
        		aReg.setVisible(true);
        	}
        });
        
        add.setBounds(32, 0, 116, 99);
        addPanel.add(add);
        
        add.setBackground(new Color(255, 255, 255));
        add.setBorderPainted(false);
        add.setFocusPainted(false);
        add.setContentAreaFilled(false);
        
        addPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	add.doClick();
            }
        });
        headerPanel.add(deletePanel);
        
        ImageIcon updateIcon = new ImageIcon (getClass().getResource("/veroBankImage/bankUpdate.png"));
		contentPane.setLayout(null);
        
        JPanel updatePanel = new JPanel();
        updatePanel.setBounds(700, 167, 324, 99);
        headerPanel.add(updatePanel);
        updatePanel.setBackground(new Color(255, 255, 255));
        updatePanel.setBorder(BorderField);
        updatePanel.setLayout(null);
        
		JLabel lblUpdate = new JLabel("UPDATE ACCOUNT");
        lblUpdate.setBounds(135, 44, 176, 14);
        updatePanel.add(lblUpdate);
        lblUpdate.setForeground(new Color(96, 96, 96));
        lblUpdate.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        JButton update = new JButton(updateIcon);
        update.setBounds(0, 11, 125, 85);
        updatePanel.add(update);
        update.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		updateBank updBank = new updateBank();
        		updBank.setVisible(true);
        	}
        });
        update.setBackground(new Color(255, 255, 255));
        update.setBorderPainted(false);
        update.setFocusPainted(false);
        update.setContentAreaFilled(false);
        updatePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	update.doClick();
            }
        });
        
        ImageIcon searchIcon = new ImageIcon (getClass().getResource("/veroBankImage/bankSearchs.png"));
		contentPane.setLayout(null);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBounds(700, 277, 324, 99);
        headerPanel.add(searchPanel);
        searchPanel.setBackground(new Color(255, 255, 255));
        searchPanel.setBorder(BorderField);
        searchPanel.setLayout(null);
        
        JLabel lblSearch = new JLabel("SEARCH ACCOUNT");
        lblSearch.setBounds(135, 44, 176, 14);
        searchPanel.add(lblSearch);
        lblSearch.setForeground(new Color(96, 96, 96));
        lblSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
        
        JButton search = new JButton(searchIcon);
        search.setBounds(0, 11, 125, 85);
        searchPanel.add(search);
        search.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		searchBankAccount searchBank = new searchBankAccount();
        		searchBank.setVisible(true);
        	}
        });
        search.setBackground(new Color(255, 255, 255));
        search.setBorderPainted(false);
        search.setFocusPainted(false);
        search.setContentAreaFilled(false);
        searchPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	search.doClick();
            }
        });
        headerPanel.add(searchPanel);
		
        table = new JTable();
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(0, 414, 1200, 147);
        scrollPane.setViewportView(table);
        contentPane.add(scrollPane);

        connectAndPopulateTable();
    }

    public void connectAndPopulateTable() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/bank_system", "root", "");

            pst = con.prepareStatement("SELECT e.*, Account_Number, Account_Type, Balance FROM employee e JOIN account a ON e.employee_id = a.employee_id");
            rs = pst.executeQuery();

            ResultSetMetaData metaData = rs.getMetaData();
            int q = metaData.getColumnCount();

            DefaultTableModel model = new DefaultTableModel();

            for (int i = 1; i <= q; i++) {
                model.addColumn(metaData.getColumnName(i));
            }

            table.setModel(model);

            while (rs.next()) {
                Object[] rowData = new Object[q];

                for (int i = 1; i <= q; i++) {
                    rowData[i - 1] = rs.getObject(i);
                }

                model.addRow(rowData);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

	 public void refreshTable() {
	        DefaultTableModel model = (DefaultTableModel) table.getModel();
	        model.setRowCount(0);

	        connectAndPopulateTable();
	    }
	 public void upDateDB() {
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			 con = DriverManager.getConnection("jdbc:mysql://localhost/bank_system", "root", "");
			 pst = con.prepareStatement("SELECT * FROM bank_system");
			 
			 rs = pst.executeQuery();
			 ResultSetMetaData stData = rs.getMetaData();
			 
			 q = stData.getColumnCount();
			 
			 DefaultTableModel RecordTable = (DefaultTableModel) table.getModel();
			 RecordTable.setRowCount(0);
			 
			 while(rs.next()) {
				 Vector<String> columnData = new Vector<String>();
				 
				 for(i=1;i <= q; i++) {
					 columnData.add(rs.getString("Employee_ID"));
					 columnData.add(rs.getString("First_Name"));
					 columnData.add(rs.getString("Last_Name"));
					 columnData.add(rs.getString("Age"));
					 columnData.add(rs.getString("Birthday"));
					 columnData.add(rs.getString("Gender"));
					 columnData.add(rs.getString("Status"));
					 columnData.add(rs.getString("Occupation"));
					 columnData.add(rs.getString("Phone"));
					 columnData.add(rs.getString("Nationality"));
					 columnData.add(rs.getString("Pin"));
					 columnData.add(rs.getString("Address"));
					 columnData.add(rs.getString("Account_Number"));
					 columnData.add(rs.getString("Account_Type"));
					 columnData.add(rs.getString("Balance"));
				 }
				 RecordTable.addRow(columnData);
			 }
		 }catch(Exception ex) {
			 JOptionPane.showMessageDialog(null, ex);
		 }
	 }
	 
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            adminMenu frame = new adminMenu();
            frame.setVisible(true);
        });
    }
}