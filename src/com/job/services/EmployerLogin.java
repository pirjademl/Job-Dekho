package com.job.services;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.job.otp.SendMail;
import com.jobdekho.dao.login;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class EmployerLogin extends JFrame {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField emailfld;
	private JTextField otpField;
	Matcher mac;
	Pattern ptr;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployerLogin frame = new EmployerLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

		Random rand = new Random();
			 int generatedotp=rand.nextInt(99999);
	
	
	public static boolean EmailValidating(String Email) {
		return Email.matches("^[a-zA-Z0-9.]{3,20}@[A-Za-z]{3,10}.(com|in)");
	}

	public EmployerLogin() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1257, 693);
		contentPane = new JPanel();
		contentPane.setFont(new Font("Segoe UI Black", Font.PLAIN, 16));
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.window);
		panel.setBounds(10, 0, 1211, 56);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel icon = new JLabel("");
		icon.setIcon(new ImageIcon("C:\\Users\\Magdum\\Downloads\\jobdekho (1).jpg"));
		icon.setBounds(0, 0, 159, 56);
		panel.add(icon);
		
		JButton employerLogin = new JButton("Employer Login");
		employerLogin.setForeground(Color.WHITE);
		employerLogin.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		employerLogin.setBorderPainted(false);
		employerLogin.setBackground(Color.CYAN);
		employerLogin.setBounds(987, 4, 202, 52);
		panel.add(employerLogin);
		
		JLabel candidateLabel = new JLabel("");
		candidateLabel.setIcon(new ImageIcon("C:\\Users\\Magdum\\Downloads\\daashboardimg1.jpg"));
		candidateLabel.setBounds(-56, 234, 672, 160);
		contentPane.add(candidateLabel);
		
		JLabel trustlabel = new JLabel("");
		trustlabel.setIcon(new ImageIcon("C:\\Users\\Magdum\\Downloads\\dasboardtrust.jpg"));
		trustlabel.setBounds(77, 475, 378, 41);
		contentPane.add(trustlabel);
		
		JLabel signpup  = new JLabel("");
		 signpup.setIcon(new ImageIcon("C:\\Users\\Magdum\\Downloads\\login.jpg"));
		 signpup.setBounds(829, 271, 329, 56);
		contentPane.add( signpup);
		
		JLabel emailError = new JLabel("please Enter a valid Email");
		emailError.setFont(new Font("Nirmala UI Semilight", Font.BOLD, 15));
		emailError.setForeground(new Color(255, 0, 0));
		emailError.setBounds(849, 369, 251, 25);
		contentPane.add(emailError);
		emailError.setVisible(false);
		
		
		JLabel otpverified = new JLabel("");
		otpverified.setIcon(new ImageIcon("C:\\Users\\Magdum\\Downloads\\check.png"));
		otpverified.setFont(new Font("Segoe UI Variable", Font.BOLD, 23));
		otpverified.setBounds(1119, 405, 38, 49);
		otpverified.setVisible(false);
		contentPane.add(otpverified);
		
		JLabel loginlbl = new JLabel("");
		loginlbl.setIcon(new ImageIcon("C:\\Users\\Magdum\\Downloads\\login (3).jpg"));
		loginlbl.setBounds(935, 160, 116, 101);
		contentPane.add(loginlbl);
		
		emailfld = new JTextField();
		emailfld.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				emailError.setVisible(false);
			}
		});
		
		emailfld.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 20));
		emailfld.setBounds(829, 322, 270, 49);
		contentPane.add(emailfld);
		emailfld.setColumns(10);
		

		JButton sendotp = new JButton("send otp");
		sendotp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String Email = emailfld.getText();
				
				SendMail ml = new SendMail();
				
				boolean emailisvalid=EmailValidating(Email);
				System.out.println("Result of the condition is "+emailisvalid);
					
					ptr = Pattern.compile("[a-zA-Z0-9.]{3,20}@[A-Za-z]{3,10}.(com|in)");
				mac = ptr.matcher(emailfld.getText());
				boolean valEmail = (mac.find() && mac.group().equals(emailfld.getText()));
//				if(valEmail!=true) {
//					JOptionPane.showMessageDialog(null, "Invalid Email Entered ");
//				}
					login lg = new login ();
					boolean a =lg.checkEmail(Email);
					if(a!=true) {
						JOptionPane.showMessageDialog(null, "Didnt find any user with entered Username ");
					}
		
					if(valEmail!=true) {
						JOptionPane.showMessageDialog(null,"Invalid Email Address");
					}else {
						if(a && valEmail) {
							ml.sendotp(Email, generatedotp);
							JOptionPane.showMessageDialog(null,"Otp sent successfully");
				}
			
			}
			}
				
			
		});
		System.out.println(generatedotp);
		sendotp.setForeground(new Color(240, 255, 255));
		sendotp.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		sendotp.setBorderPainted(false);
		sendotp.setBackground(new Color(50, 205, 50));
		sendotp.setBounds(1109, 322, 124, 41);
		contentPane.add(sendotp);
		
		
		JButton postbtn = new JButton("Login to post a job ");
		postbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(generatedotp);
				Pattern ptr;
				Matcher match;
			String Email = emailfld.getText();

			boolean emailisvalid =EmailValidating(Email);
			System.out.println(generatedotp);
		boolean	valEmail = emailfld.getText().equals("");
			if (valEmail) {
				emailError.setText("* Required");
				emailError.setVisible(true);
			} else {
				ptr = Pattern.compile("[a-zA-Z0-9.]{3,20}@[A-Za-z]{3,10}.(com|in)");
				match = ptr.matcher(emailfld.getText());
				valEmail = (match.find() && match.group().equals(emailfld.getText()));
//				System.out.println(valEmail);
				if (emailisvalid!=true) {
					emailError.setText("* Enter valid Email ID");
					emailError.setVisible(true);
				} else {
					emailError.setVisible(false);
				}
				if(otpField.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Invalid OTP Entered");
					
				}
				if(valEmail==true) {
					try {
					if(Integer.parseInt(otpField.getText())==generatedotp) {
						otpverified.setVisible(true);
						
						
						JOptionPane.showMessageDialog(null, "Login Succesfully");
						CandidateInfo cd = new CandidateInfo();
						cd.setVisible(true);
						
					}
					}catch(Exception exp ) {
						JOptionPane.showMessageDialog(null, "Invalid Otp Entered");
	
					}
					
					
				}
			}
				
			}
			
			
	
		});
		postbtn.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		postbtn.setForeground(new Color(240, 255, 255));
		postbtn.setBackground(new Color(50, 205, 50));
		postbtn.setBorderPainted(false);
		postbtn.setBounds(858, 475, 233, 41);
		contentPane.add(postbtn);
		
		otpField = new JTextField();
		otpField.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 20));
		otpField.setColumns(10);
		otpField.setBounds(829, 404, 270, 49);
		contentPane.add(otpField);
		
		JLabel enterOtp = new JLabel("Verify otp ");
		enterOtp.setFont(new Font("Segoe UI Variable", Font.BOLD, 23));
		enterOtp.setBounds(697, 398, 152, 56);
		contentPane.add(enterOtp);
		
		JLabel enterEmail = new JLabel("Enter Email");
		enterEmail.setFont(new Font("Segoe UI Symbol", Font.BOLD, 25));
		enterEmail.setBounds(692, 320, 152, 49);
		contentPane.add(enterEmail);
		
		JLabel lblDontHaveAccount = new JLabel("Don't have account ");
		lblDontHaveAccount.setFont(new Font("Segoe UI Symbol", Font.BOLD, 25));
		lblDontHaveAccount.setBounds(573, 597, 276, 49);
		contentPane.add(lblDontHaveAccount);
		
		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployerRegistration eg = new EmployerRegistration();
				eg.setVisible(true);
				setVisible(false);
			}
		});
		register.setForeground(new Color(240, 255, 255));
		register.setFont(new Font("Segoe UI Variable", Font.PLAIN, 20));
		register.setBorderPainted(false);
		register.setBackground(new Color(25, 25, 112));
		register.setBounds(829, 597, 185, 49);
		contentPane.add(register);
		
		
	
		
		
	
		
	}
}
