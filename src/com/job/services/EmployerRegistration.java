package com.job.services;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.jobdekho.dao.RegisterEmployer;

public class EmployerRegistration extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField namefield;
	private JTextField companyname;
	private JTextField website;
	private JTextField location;
	private JTextField emailfld;
	
	
	Pattern ptr;
	Matcher match;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
										public void run() {
				try {
					EmployerRegistration frame = new EmployerRegistration();
					frame.setVisible(true);
					} catch (Exception e) {
					e.printStackTrace();
					}
					}
					});
					}

	public EmployerRegistration() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1213, 743);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(471, 23, 196, 96);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Magdum\\Downloads\\theme (1).jpg"));
		lblNewLabel.setBounds(10, 10, 124, 76);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome !");
		lblNewLabel_1.setFont(new Font("Modern No. 20", Font.BOLD, 25));
		lblNewLabel_1.setBounds(506, 151, 132, 81);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Since this is  your first  job  posting ,lets setup your comapny account ");
		lblNewLabel_1_1.setFont(new Font("Modern No. 20", Font.BOLD, 25));
		lblNewLabel_1_1.setBounds(204, 196, 813, 81);
		contentPane.add(lblNewLabel_1_1);
		                               
		JLabel lblNewLabel_1_1_1 = new JLabel("Full name ");
		lblNewLabel_1_1_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(53, 260, 229, 42);
		contentPane.add(lblNewLabel_1_1_1);
		
		namefield = new JTextField();
		namefield.setFont(new Font("Tahoma", Font.PLAIN, 20));
		namefield.setBackground(new Color(255, 255, 255));
		namefield.setBounds(79, 309, 389, 42);
		contentPane.add(namefield);
		namefield.setColumns(10);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Comapny Name ");
		lblNewLabel_1_1_1_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1.setBounds(491, 260, 262, 42);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		companyname = new JTextField();
		companyname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		companyname.setColumns(10);
		companyname.setBackground(Color.WHITE);
		companyname.setBounds(501, 309, 389, 42);
		contentPane.add(companyname);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Comapny website (Optional )");
		lblNewLabel_1_1_1_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_1_1_1_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		lblNewLabel_1_1_1_2.setBounds(53, 378, 371, 42);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		website = new JTextField();
		website.setFont(new Font("Tahoma", Font.PLAIN, 20));
		website.setColumns(10);
		website.setBackground(Color.WHITE);
		website.setBounds(79, 425, 389, 42);
		contentPane.add(website);
		
		JLabel lblNewLabel_1_1_1_2_1 = new JLabel("Number of employees in your comapny");
		lblNewLabel_1_1_1_2_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		lblNewLabel_1_1_1_2_1.setBounds(491, 487, 389, 42);
		contentPane.add(lblNewLabel_1_1_1_2_1);
		
		ButtonGroup bg = new ButtonGroup();
		JRadioButton hundredto150 = new JRadioButton("100-150");
		hundredto150.setBounds(914, 535, 103, 33);
		contentPane.add(hundredto150);
		hundredto150.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		hundredto150.setBackground(new Color(176, 196, 222));
		bg.add(hundredto150);
		
		JRadioButton hundredto3 = new JRadioButton("150-300");
		hundredto3.setBounds(787, 535, 103, 33);
		contentPane.add(hundredto3);
		hundredto3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		hundredto3.setBackground(new Color(143, 188, 143));
		bg.add(hundredto3);
		
		JRadioButton notsure = new JRadioButton("Not sure");
		notsure.setBounds(669, 535, 103, 33);
		contentPane.add(notsure);
		notsure.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		notsure.setBackground(new Color(112, 128, 144));
		bg.add(notsure);
		
				JRadioButton onetofifty = new JRadioButton("0-50");
				onetofifty.setBounds(497, 538, 70, 33);
				contentPane.add(onetofifty);
					
						onetofifty.setFont(new Font("Times New Roman", Font.PLAIN, 20));
						onetofifty.setBackground(new Color(175, 238, 238));
						bg.add(onetofifty);
						
						JRadioButton fiftyto100= new JRadioButton("50-100");
						fiftyto100.setBounds(584, 535, 85, 33);
						contentPane.add(fiftyto100);
						fiftyto100.setFont(new Font("Times New Roman", Font.PLAIN, 20));
						fiftyto100.setBackground(new Color(245, 245, 220));
						bg.add(fiftyto100);
						
						JLabel err1 = new JLabel("Fullname is  required");
						err1.setForeground(new Color(255, 0, 0));
						err1.setFont(new Font("Tahoma", Font.BOLD, 13));
						err1.setBounds(137, 358, 176, 16);
						contentPane.add(err1);
						err1.setVisible(false);
		
		JLabel err2 = new JLabel(" *Company website  is required  *");
		err2.setForeground(new Color(220, 20, 60));
		err2.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		err2.setBounds(115, 464, 236, 33);
		contentPane.add(err2);
		err2.setVisible(false);

		JLabel err3 = new JLabel(" *Location is required  *");
		err3.setForeground(new Color(220, 20, 60));
		err3.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		err3.setBounds(129, 587, 196, 33);
		contentPane.add(err3);
err3.setVisible(false);		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Comapny Name ");
		lblNewLabel_1_1_1_1_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_2.setBounds(0, 0, 262, 42);
		contentPane.add(lblNewLabel_1_1_1_1_2);
		JLabel err6 = new JLabel("Fullname is  required");
		err6.setForeground(Color.RED);
		err6.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		err6.setBounds(549, 461, 223, 36);
		contentPane.add(err6);
		err6.setVisible(false);
		JLabel err4 = new JLabel("* Company name is required  *");
		err4.setForeground(new Color(220, 20, 60));
		err4.setFont(new Font("Segoe UI Semilight", Font.BOLD, 16));
		err4.setBounds(525, 351, 228, 33);
		contentPane.add(err4); 
		err4.setVisible(false);
		
		JButton btnNewButton = new JButton("Continue to post a job");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String FullName;
				String CompanyName;
				String CompanyLocation;
				String Mobileno;
				String Email =emailfld.getText();
				
				FullName=namefield.getText();
				CompanyName=companyname.getText();
				CompanyLocation=location.getText();
				String websiteName = website.getText();
				
//				 TextField Validation Code If user does not Enter in the fields 
				boolean isNameNull=namefield.getText().equals("");
				boolean isLocationNull=location.getText().equals("");
				boolean isCompanyNameNull=companyname.getText().equals("");
				boolean iswebsitenull =website.getText().equals("");
				boolean isEmailnull=emailfld.getText().equals("");	
				if(isNameNull) {
					err1.setVisible(true);
			
				}
				if(iswebsitenull) {
					err2.setVisible(true);
					
				}
				if (isLocationNull) {
					err3.setVisible(true);
				
				}
				if(isCompanyNameNull){
				err4.setVisible(true);	
				}
				if(isEmailnull) {
					err6.setVisible(true);
				}
if(isNameNull && isCompanyNameNull && iswebsitenull && isNameNull && isEmailnull) {
	JOptionPane.showMessageDialog(null, "Fill the required Fields to register ");
}	RegisterEmployer register = new RegisterEmployer();
			
			ptr = Pattern.compile("[a-zA-Z0-9.]{3,20}@[A-Za-z]{3,10}.(com|in)");
			match = ptr.matcher(emailfld.getText());
			boolean valEmail = (match.find() && match.group().equals(emailfld.getText()));
			boolean cond=!(isNameNull || isLocationNull || isCompanyNameNull  || isEmailnull );
			if(valEmail!=true) {
				err6.setText("Entuubeer Valid Email address");
				err6.setVisible(true);
			}
				if(cond  && valEmail) {
					if(onetofifty.isSelected())
					{
					boolean a =register.registerEmployer(FullName,Email, CompanyName, websiteName, "1-50", CompanyLocation);
					boolean n =register.CreateTable(CompanyName);
					
						JOptionPane.showMessageDialog(null, "Registered Succesfully ");
						EmployerLogin login = new EmployerLogin();
						login.setVisible(true);
						setVisible(false);
					
					}if(fiftyto100.isSelected()) {
						boolean a= register.registerEmployer(FullName,Email, CompanyName, websiteName, "50- 100", CompanyLocation);
						 boolean b =register.CreateTable(CompanyName);
						 
							 JOptionPane.showMessageDialog(null, "Registered Succesfully ");
							 EmployerLogin login = new EmployerLogin();
							 login.setVisible(true);
							 
							 setVisible(false);
						 
				}if(hundredto150.isSelected()) {
				register.registerEmployer(FullName,Email, CompanyName, websiteName, "50- 100", CompanyLocation);
				register.CreateTable(CompanyName);
					}if(notsure.isSelected()) {
						boolean a =register.registerEmployer(FullName, Email,CompanyName, websiteName, "Not Sure ",CompanyLocation);
					boolean b= 	register.CreateTable(CompanyName);
					JOptionPane.showMessageDialog(null, "Registered Succesfully ");
					
						JOptionPane.showMessageDialog(null, "Registered Succesfully ");
						EmployerLogin login = new EmployerLogin();
						login.setVisible(true);
						setVisible(false);
						
					
					}
					
				}
			}
		});
		btnNewButton.setBackground(new Color(124, 252, 0));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		btnNewButton.setBounds(471, 658, 282, 48);
		contentPane.add(btnNewButton);
		
		
		JLabel lblNewLabel_1_1_1_2_2 = new JLabel("Company Location");
		lblNewLabel_1_1_1_2_2.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		lblNewLabel_1_1_1_2_2.setBounds(53, 498, 371, 42);
		contentPane.add(lblNewLabel_1_1_1_2_2);
	
		location = new JTextField();
		location.setFont(new Font("Tahoma", Font.PLAIN, 20));
		location.setColumns(10);
		location.setBackground(Color.WHITE);
		location.setBounds(79, 538, 389, 42);
		contentPane.add(location);
		emailfld = new JTextField();
		emailfld.setFont(new Font("Tahoma", Font.PLAIN, 20));
		emailfld.setColumns(10);
		emailfld.setBackground(Color.WHITE);
		emailfld.setBounds(506, 414, 389, 42);
		contentPane.add(emailfld);
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Enter Email");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 20));
		lblNewLabel_1_1_1_1_1.setBounds(491, 378, 262, 42);
		contentPane.add(lblNewLabel_1_1_1_1_1);
	}
}
