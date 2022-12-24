package com.job.services;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import com.jobdekho.dao.login;

public class CandidateLogin extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CandidateLogin frame = new CandidateLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
//	Constructor to create the frame
//	Constructor(){
//		new Constructor();
//	}
	public CandidateLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1463, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(175, 238, 238), 20));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(119, 136, 153));
		panel.setForeground(new Color(119, 136, 153));
		panel.setBounds(513, 21, 910, 641);
		contentPane.add(panel);
		panel.setLayout(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel err1 = new JLabel("* Username is Required *");
		err1.setForeground(new Color(255, 0, 0));
		err1.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		err1.setBounds(328, 179, 259, 28);
		panel.add(err1);
		err1.setVisible(false);
		
		JLabel err2 = new JLabel("* Password is required *");
		err2.setForeground(new Color(255, 0, 0));
		err2.setFont(new Font("Segoe UI Semilight", Font.BOLD, 14));
		err2.setBounds(334, 279, 259, 28);
		panel.add(err2);
		err2.setVisible(false);
		
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String Username =username.getText();
				String Password=password.getText();
				login check = new login();
				boolean a =check.checkLogin(Username, Password);
				
			boolean isUsernameNull=username.getText().equals("");
			boolean ispassnull=password.getText().equals("");
			if(isUsernameNull) {
				err1.setVisible(true);
			}
			if(ispassnull) {
				err2.setVisible(true);
				
			}
				if(a) {
					JOptionPane.showMessageDialog(null, "Login Successfully");
					SearchJobs search = new SearchJobs();
					search.setVisible(true);
					setVisible(false);
					
				}else {
					JOptionPane.showMessageDialog(null, "Invalid Username or Password ");
				}
				
				

		
			}
		});
		btnLogin.setBounds(334, 383, 118, 35);
		btnLogin.setForeground(Color.WHITE);
		btnLogin.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		btnLogin.setBorderPainted(false);
		btnLogin.setBackground(Color.BLACK);
		panel.add(btnLogin);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				username.setText("");
				password.setText("");
			}
		});
		btnClear.setBounds(462, 383, 118, 35);
		panel.add(btnClear);
		btnClear.setBackground(new Color(0, 0, 0));
		btnClear.setBorderPainted(false);
		btnClear.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		btnClear.setForeground(new Color(255, 255, 255));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Magdum\\Downloads\\user.png"));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblNewLabel_1.setBounds(147, 148, 42, 47);
		panel.add(lblNewLabel_1);
		
		username = new JTextField();
		username.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		username.setBounds(328, 154, 259, 28);
		panel.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Username ");
		lblNewLabel.setBounds(184, 154, 113, 28);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		
		password = new JPasswordField();
		password.setFont(new Font("Segoe UI Semilight", Font.BOLD, 18));
		password.setBounds(328, 252, 259, 28);
		panel.add(password);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(184, 246, 113, 28);
		panel.add(lblPassword);
		lblPassword.setForeground(new Color(255, 255, 255));
		lblPassword.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\Magdum\\Downloads\\padlock.png"));
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(147, 233, 42, 47);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewUserRegister = new JLabel("New user register ");
		lblNewUserRegister.setForeground(Color.WHITE);
		lblNewUserRegister.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblNewUserRegister.setBounds(171, 530, 230, 28);
		panel.add(lblNewUserRegister);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CandidateRegistration cgr= new CandidateRegistration();
				cgr.setVisible(true);
				setVisible(false);
			}
		});
		btnRegister.setForeground(Color.WHITE);
		btnRegister.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		btnRegister.setBorderPainted(false);
		btnRegister.setBackground(Color.BLACK);
		btnRegister.setBounds(353, 523, 118, 35);
		panel.add(btnRegister);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Magdum\\Downloads\\login (1).png"));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblNewLabel_2.setBounds(386, 10, 155, 134);
		panel.add(lblNewLabel_2);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(112, 128, 144));
		panel_1.setBounds(22, 21, 493, 641);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblPassword_1 = new JLabel("");
		lblPassword_1.setIcon(new ImageIcon("C:\\Users\\Magdum\\Downloads\\politician.png"));
		lblPassword_1.setForeground(Color.WHITE);
		lblPassword_1.setFont(new Font("Segoe UI Variable", Font.BOLD, 20));
		lblPassword_1.setBounds(127, 99, 332, 343);
		panel_1.add(lblPassword_1);
		
		int v =ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
		int h= ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
	}
}
