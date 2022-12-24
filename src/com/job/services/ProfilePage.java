package com.job.services;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.jobdekho.dao.DashboardOperations;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ProfilePage extends JFrame {

	private JPanel contentPane;
	private JTextField Emailfld;
	private JTextField Email;
	private JTextField name;
	private JTextField companywebsite;
	private JTextField no;
	private JTextField location;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilePage frame = new ProfilePage();
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
	public ProfilePage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1241, 657);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(230, 230, 250));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 15));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel fullnamelbl = new JLabel("Enter Username ");
		fullnamelbl.setFont(new Font("Segoe UI Semilight", Font.BOLD, 17));
		fullnamelbl.setBounds(71, 56, 166, 49);
		contentPane.add(fullnamelbl);
		
		Emailfld = new JTextField();
		Emailfld.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		Emailfld.setBounds(305, 52, 234, 53);
		contentPane.add(Emailfld);
		Emailfld.setColumns(10);
		
		JLabel emaillbl = new JLabel("Your Email id ");
		emaillbl.setFont(new Font("Segoe UI Semilight", Font.BOLD, 17));
		emaillbl.setBounds(71, 157, 166, 49);
		contentPane.add(emaillbl);
		emaillbl.setVisible(false);
		
		JLabel Namelbl = new JLabel("Name of your company");
		Namelbl.setFont(new Font("Segoe UI Semilight", Font.BOLD, 17));
		Namelbl.setBounds(54, 260, 214, 49);
		contentPane.add(Namelbl);
		Namelbl.setVisible(false);
		
		JLabel Websitelbl = new JLabel("Website of your company");
		Websitelbl.setFont(new Font("Segoe UI Semilight", Font.BOLD, 17));
		Websitelbl.setBounds(556, 56, 214, 49);
		contentPane.add(Websitelbl);
	Websitelbl.setVisible(false);
		
		Email = new JTextField();
		Email.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		Email.setColumns(10);
		Email.setBounds(305, 153, 234, 53);
		contentPane.add(Email);
		Email.setVisible(false);
		
		
		name = new JTextField();
		name.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		name.setColumns(10);
		name.setBounds(305, 261, 234, 53);
		contentPane.add(name);
		name.setVisible(false);
		
		companywebsite = new JTextField();
		companywebsite.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		companywebsite.setColumns(10);
		companywebsite.setBounds(780, 57, 234, 53);
		contentPane.add(companywebsite);
		companywebsite.setVisible(false);
		
		JLabel nolbl = new JLabel("No of Employees ");
		nolbl.setFont(new Font("Segoe UI Semilight", Font.BOLD, 17));
		nolbl.setBounds(562, 157, 184, 49);
		contentPane.add(nolbl);
		nolbl.setVisible(false);
		
		JLabel locationlbl = new JLabel("Location of your company");
		locationlbl.setFont(new Font("Segoe UI Semilight", Font.BOLD, 17));
		locationlbl.setBounds(570, 260, 214, 49);
		contentPane.add(locationlbl);
		locationlbl.setVisible(false);
		
		no = new JTextField();
		no.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		no.setColumns(10);
		no.setBounds(780, 158, 234, 53);
		contentPane.add(no);
		no.setVisible(false);
		
		location = new JTextField();
		location.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		location.setColumns(10);
		location.setBounds(780, 261, 234, 53);
		contentPane.add(location);
		location.setVisible(false);
		
		JButton view = new JButton("view Profile");
		view.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList <String > al = new ArrayList<String>();
				DashboardOperations db = new DashboardOperations();
				String Username =Emailfld.getText();
				al=db.getProfile(Username );
				fullnamelbl.setText("Full Name ");
				Emailfld.setText(al.get(0));
				Emailfld.setEditable(false);
				
//				emai
				emaillbl.setVisible(true);
				Email.setText(al.get(1));
				Email.setVisible(true);
				Email.setEditable(false);
				Namelbl.setVisible(true);
				name.setText(al.get(2));
				name.setVisible(true);
				name.setEditable(false);
				Websitelbl.setVisible(true);
				companywebsite.setText(al.get(3));
				companywebsite.setEditable(false);
				companywebsite.setVisible(true);
				nolbl.setVisible(true);
				no.setText(al.get(4));
				no.setVisible(true);
				no.setEditable(false);
				locationlbl.setVisible(true);
				location.setText(al.get(4));
				location.setEditable(false);
				location.setVisible(true);
				
				
				
				
				
				
				view.setText("OK");
				
			}
		});
		view.setBackground(new Color(124, 252, 0));
		view.setBorderPainted(false);
		view.setFont(new Font("Segoe UI Semilight", Font.BOLD, 17));
		view.setBounds(463, 451, 166, 65);
		contentPane.add(view);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployerDashboard db = new EmployerDashboard();
				db.setVisible(true);
				setVisible(false);
				
				
			}
		});
		btnCancel.setBackground(new Color(210, 180, 140));
		btnCancel.setBorderPainted(false);
		btnCancel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 17));
		btnCancel.setBounds(651, 451, 166, 65);
		contentPane.add(btnCancel);
	}
}
