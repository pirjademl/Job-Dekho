package com.job.services;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.jobdekho.dao.DashboardOperations;

import java.awt.Color;
import javax.swing.JTable;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;

public class EmployerDashboard extends JFrame {

	private JPanel contentPane;
	private JTable emps;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployerDashboard frame = new EmployerDashboard();
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
	public EmployerDashboard() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1283, 640);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 12));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(31, 30, 199, 89);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("");
		menuBar.add(mnNewMenu);
		mnNewMenu.setIcon(new ImageIcon("C:\\Users\\Magdum\\Downloads\\profile (1).png"));
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Profile ");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfilePage pf = new ProfilePage();
				pf.setVisible(true);
				setVisible(true);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("View who Applied for  job ");
		
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Log out");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployerLogin emp = new EmployerLogin();
				emp.setVisible(true);
				setVisible(false);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JLabel lblNewLabel = new JLabel("Welcome");
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		lblNewLabel.setBounds(583, 10, 104, 72);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = 	new JScrollPane();
		scrollPane.setBounds(91, 143, 1111, 431);
		contentPane.add(scrollPane);
		
		emps = new JTable();
		scrollPane.setViewportView(emps);
		
		JLabel lblViewWhoApplied = new JLabel("view who applied");
		lblViewWhoApplied.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		lblViewWhoApplied.setBounds(250, 61, 205, 72);
		contentPane.add(lblViewWhoApplied);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		textField.setBounds(445, 61, 308, 65);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton go = new JButton("View");
		go.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String job =textField.getText();
				DashboardOperations db = new DashboardOperations();
				ResultSet rs = db.getwhoApplied(job);
				if(rs==null) {
					JOptionPane.showMessageDialog(null, "Invalid Company name entered");
				}
				try {
//					System.out.println("HEllo");
//					JOptionPane.showMessageDialog(null,rs.getString(2));
					ResultSetMetaData rsmd =rs.getMetaData();
					DefaultTableModel  model = (DefaultTableModel) emps.getModel();
					int col=rsmd.getColumnCount();
					String [] colname= new String[col];
					for(int i=0;i<col;i++) {
//						JOptionPane.showMessageDialog(null, "Hello");
						colname[i]=rsmd.getColumnName(i+1);
						model.setColumnIdentifiers(colname);
						String fullname,mobile,Email,status,education,course,University;
						while(rs.next()) {
							fullname=rs.getString(1);
							mobile=rs.getString(2);
									
							Email=rs.getString(3);
		status=rs.getString(4);
		education=rs.getString(5);
	course=rs.getString(6);
			University=rs.getString(7);
			String row[] = {fullname,mobile,Email,status,education,course,University};
			model.addRow(row);
//		mobile=rs.getString(8);
						}
					}
					textField.setText("");
					
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				
				try {
					while(rs.next()){
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				
				
			
				
			}
			
			
		});
		go.setBackground(new Color(46, 139, 87));
		go.setBorderPainted(false);
		go.setFont(new Font("Tahoma", Font.BOLD, 17));
		go.setBounds(788, 61, 205, 65);
		contentPane.add(go);
		
		
	}
}
