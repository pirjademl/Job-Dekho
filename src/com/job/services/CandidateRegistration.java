package com.job.services;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import com.jobdekho.dao.*;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class CandidateRegistration extends JFrame {

	private JPanel contentPane;
	private JTextField fullnamefld;
	private JTextField mobilenofld;
	private JTextField emailfld;
	private JTextField course;
	private JPasswordField passfld;
	Pattern ptr;

	public static void main(String[] args) {
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//						LookAndFeel look= LookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
//					UIManager.setLookAndFeel();
//					UIManager.setL
					CandidateRegistration frame = new CandidateRegistration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static boolean EmailValidating(String Email) {
		return Email.matches("^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$");
	}
	public static boolean  phonenovalidating(String phone ) {
		Pattern ptrn=Pattern.compile("^(\\d{3}[-.]?){2}\\d{4}$");
		Matcher match=ptrn.matcher(phone);
		return(match.find() && match.group().equals(phone));
		
	}
	private static final String PASSWORD_PATTERN =
			"^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{8,20}$";

			private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);

			public static boolean isValid( final String password) {
			Matcher matcher = pattern.matcher(password);
			return matcher.matches();
}
			CandidateRegistration() {
				
				 ptr = Pattern.compile("[a-zA-Z0-9.]{3,20}@[A-Za-z]{3,10}.(com|in)");
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1487, 831);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 128, 128), 14));
		

		setContentPane(contentPane);
		contentPane.setLayout(null);
		JComboBox<String> University = new JComboBox<String>();
		University.addItem("Punyashlok Ahilyadevi Holkar University ");
		University.addItem("Karmaveer Bhaurao Patil University");
		University.addItem("Savitri bai phule Pune University");
		JLabel pwdlbl = new JLabel("Password");
		pwdlbl.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		pwdlbl.setBounds(400, 337, 87, 21);
		contentPane.add(pwdlbl);
		
		JRadioButton Fresher = new JRadioButton("Fresher");
		Fresher.setBounds(648, 440, 103, 21);
		contentPane.add(Fresher);
		
		JRadioButton Expirineced= new JRadioButton("Expirineced");
		
		Expirineced.setBounds(543, 440, 103, 21);
		contentPane.add(Expirineced);
		
		
		ButtonGroup workexp = new ButtonGroup();
		workexp.add(Fresher);
		workexp.add(Expirineced);
		
//		Creating labels to provide errors messages to  if user doesn't enter any info lets proceed
		JLabel err1 = new JLabel("* Full name is required *");
		err1.setForeground(new Color(255, 0, 0));
		err1.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		err1.setBounds(574, 157, 244, 26);
		contentPane.add(err1);
		err1.setVisible(false);
		
		JLabel err2 = new JLabel(" *Mobile no is required *");
		err2.setForeground(new Color(255, 0, 0));
		err2.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		err2.setBounds(564, 229, 244, 26);
		contentPane.add(err2);
		err2.setVisible(false);
		
		JLabel err3 = new JLabel(" * Email is required *");
		err3.setForeground(new Color(255, 0, 0));
		err3.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		err3.setBounds(574, 286, 244, 21);
		contentPane.add(err3);
		err3.setVisible(false);
		
		JLabel err4 = new JLabel("* Create a strong password  *");
		err4.setForeground(new Color(255, 0, 0));
		err4.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		err4.setBounds(574, 353, 244, 26);
		contentPane.add(err4);
		err4.setVisible(false);
		
		
		JLabel err5 = new JLabel("* Select you city *");
		err5.setForeground(Color.RED);
		err5.setFont(new Font("Segoe UI Black", Font.BOLD, 12));
		err5.setBounds(574, 503, 244, 26);
		contentPane.add(err5);err5.setVisible(false);
		err5.setVisible(false);
		
		JLabel Fullname = new JLabel("Full Name ");
//		Fullname.setForeground(new Color(50, 205, 50));
		Fullname.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		Fullname.setBounds(400, 136, 96, 26);
		contentPane.add(Fullname);
		Fullname.setForeground(Color.black);
		
		fullnamefld = new JTextField();
		fullnamefld.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
		fullnamefld.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				Fullname.setForeground(new Color(50, 205, 50));
			}
		});
		fullnamefld.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				Fullname.setForeground(new Color(220, 20, 60));
				
			}
		});
		fullnamefld.setBounds(564, 133, 244, 26);
		contentPane.add(fullnamefld);
		fullnamefld.setColumns(10);
		 
		JLabel no = new JLabel("Mobile No");
		no.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				no.setForeground(new Color(50, 205, 50));
				no.setText("Enter mobile no");
			}
		});
		no.setForeground(new Color(0, 0, 0));
		no.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		no.setBounds(403, 193, 96, 42);
		contentPane.add(no);
		
		
		JLabel Fullname_1_2_1 = new JLabel("University");
		Fullname_1_2_1.setForeground(Color.BLACK);
		Fullname_1_2_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		Fullname_1_2_1.setBounds(866, 282, 96, 26);
		contentPane.add(Fullname_1_2_1);
		
		
		mobilenofld = new JTextField();
		mobilenofld.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				no.setForeground(new Color(50, 205, 50));
				no.setText("Enter mobile no ");
				err3.setVisible(false);
			}
		});
		
		
		emailfld = new JTextField();
		emailfld.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				err3.setVisible(false);
			}
		});
		emailfld.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
		emailfld.setColumns(10);
		emailfld.setBounds(564, 265, 244, 26);
		contentPane.add(emailfld);
		
		mobilenofld.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
		mobilenofld.setColumns(10);
		mobilenofld.setBounds(564, 198, 244, 26);	
		contentPane.add(mobilenofld);
		
JComboBox<String > Education = new JComboBox<String >();

JComboBox<String> city = new JComboBox<String>();
city.addItem("Solapur");
city.addItem("Pune");
city.addItem("Mumbai");
city.addItem("Nashik");
city.addItem("Barshi");
city.addItem("Dhule");
city.addItem("Nagpur");
city.addItem("Beed");
city.addItem("Kolhapur");
city.addItem("Sindhudurg");
city.addItem("Thane");
city.addItem("Aurangabaad");
city.addItem("Nanded");
city.addItem("Latur");
city.addItem("Osmanabaad");
city.addItem("Dhule");
city.setBounds(543, 472, 247, 21);
		
		Education.setBounds(1040, 136, 247, 21);
		contentPane.add(Education);
		
		
		JButton submit = new JButton("Submit");
		submit.setFocusPainted(false);
		submit.setContentAreaFilled(false);
		submit.setBorder(new LineBorder(new Color(0, 255, 0), 4));
		submit.setBackground(new Color(47, 79, 79));
		submit.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		submit.setBorder(new EtchedBorder(10));
		submit.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				String Password=new String (passfld.getPassword());
				System.out.println("password is "+Password);
				String Fullname=fullnamefld.getText();
				String MobileNo=mobilenofld.getText();
				String Email=emailfld.getText();
//				String city = Cityfield.getText();
				String education=(String) Education.getSelectedItem();
				String Course =course.getText();
				String unvsty =(String) University.getSelectedItem();
				String nameOftheCity=(String) city.getSelectedItem();
				
				
		//   Getting the information of the user entered by user 
				if(fullnamefld.getText().equals("")) {
					
					err1.setText(" * Full name is required *");
					err1.setVisible(true);
				}
				if(mobilenofld.getText().equals("")) {
					err2.setText("* Mobile no is required *");
					err2.setVisible(true);
				}
				if(emailfld.getText().equals("")) {
					err3.setText("* Email id required *");
					err3.setVisible(true);				
					}
				if(passfld.getText().equals("")) {
					err4.setText("*Password is required*");
					err4.setVisible(true);
				}
				if(course.getText().equals("")) {
					JOptionPane.showMessageDialog(null,"Enter the course ");
				}
				if(Education.getSelectedIndex()==0) {
					JOptionPane.showMessageDialog(null,"Select the education first ");
				}
				
				
//			Validation  of the data entered by the user 
//				boolean validemail =EmailValidating(Email);
				boolean validphone=phonenovalidating(MobileNo);
				boolean validpassword=isValid(Password);
//				System.out.print(validemail);
//===================				Validation  Part   ================================================= 
				
				if(validpassword !=true) {
					err4.setText("* Enter Valid Password ");
					err4.setVisible(true);
					JOptionPane.showConfirmDialog(submit, "Password should be one uppercase and special symbol");
				}
				
//				validation code for the email
				
//				validation code for entered mobile no 
				if (validphone !=true) {
					err2.setText("*Enter valid Phone No ");
					err2.setVisible(true);
					
					
				}
boolean cond = validphone==true && validpassword==true;
System.out.print(cond);

//System.out.println(cond);/
				if(cond){
					RegisterCandi rg =new RegisterCandi();
					boolean valEmail=emailfld.getText().equals("");
						if (valEmail) {
							err3.setText("* Required");
							err3.setVisible(true);
						} else {
							
						Matcher	match = ptr.matcher(emailfld.getText());
						boolean 	valEmail2 = (match.find() && match.group().equals(emailfld.getText()));
						if(!(match.find() && match.group().equals(emailfld.getText()))) {
							err3.setText(" * Enter valid Email Address ");
							err3.setVisible(true);
						}
							if(valEmail2==true) {
								if(Fresher.isSelected()) {
									JOptionPane.showMessageDialog(submit, "Fresher selected ");
								
								boolean a =rg.registerCandidate(Fullname, MobileNo, Email, Password,"Fresher",  nameOftheCity, education, Course, unvsty );
								if(a) {
									JOptionPane.showMessageDialog(null, "registered Successfully");
								}
								}else {
									boolean a =rg.registerCandidate(Fullname, MobileNo, Email, Password, "Expirienced",nameOftheCity,  education,Course,unvsty);
									if(a) {
										JOptionPane.showMessageDialog(null, "Registered Successfully");
									}
								}
							}
				
						}
			}
											
			
						}
					
			
		});
		submit.setBounds(543, 726, 156, 42);
		contentPane.add(submit);
		
		JButton Reset = new JButton("Reset");
		Reset.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		Reset.setBackground(new Color(143, 188, 143));
		Reset.setOpaque(false);
		Reset.setFocusPainted(false);
		Reset.setContentAreaFilled(false);
		Reset.setBorder(new LineBorder(new Color(0, 255, 0), 4));
		Reset.setBounds(781, 723, 136, 49);
		contentPane.add(Reset);
		
		JLabel emaillbl = new JLabel("Email ID");
		emaillbl.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		emaillbl.setBounds(400, 245, 96, 62);
		contentPane.add(emaillbl);
		
		JLabel statuslbl = new JLabel("Work Status");
		statuslbl.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		statuslbl.setBounds(390, 406, 106, 42);
		contentPane.add(statuslbl);
		
		
		
		JLabel citylbl = new JLabel("Current City");
		citylbl.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		citylbl.setBounds(391, 465, 96, 32);
		contentPane.add(citylbl);
		citylbl.setVisible(false);
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Magdum\\Downloads\\graduate.png"));
		lblNewLabel_1.setBounds(655, 389, 49, 49);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon("C:\\Users\\Magdum\\Downloads\\briefcase (1).png"));
		lblNewLabel_1_1.setBounds(574, 389, 49, 49);
		contentPane.add(lblNewLabel_1_1);
		
		;
		if(Expirineced.isSelected())
		{
			JOptionPane.showConfirmDialog(null,"Show status");
//			fileChooser.setVisible(true);
		}
	
		JLabel lblNewLabel_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1.setIcon(new ImageIcon("C:\\Users\\Magdum\\eclipse-workspace\\Job_portal\\images\\jobdekho (1).jpg"));
		lblNewLabel_1_1_1.setBounds(21, 20, 164, 77);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel already = new JLabel("Already registered");
		already.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		already.setBounds(655, 10, 178, 62);
		contentPane.add(already);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CandidateLogin login = new CandidateLogin();
				login.setVisible(true);
				setVisible(false);
				
			}
		});
		
		btnLogin.setForeground(new Color(0, 255, 0));
		btnLogin.setEnabled(false);
		btnLogin.setOpaque(false);
		btnLogin.setFont(new Font("Segoe UI Semibold", Font.BOLD, 20));
		btnLogin.setFocusPainted(false);
		btnLogin.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		btnLogin.setBackground(new Color(143, 188, 143));
		btnLogin.setBounds(832, 20, 156, 42);
		contentPane.add(btnLogin);
		
		contentPane.add(city);
		JLabel lblNewLabel_1_1_1_1 = new JLabel("");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\Magdum\\Downloads\\register.jpg"));
		lblNewLabel_1_1_1_1.setBounds(21, 131, 367, 395);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblPersonalInformation = new JLabel("Personal Information");
		lblPersonalInformation.setForeground(Color.BLACK);
		lblPersonalInformation.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblPersonalInformation.setBounds(566, 71, 252, 26);
		contentPane.add(lblPersonalInformation);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(828, 84, 58, 513);
		contentPane.add(separator);
		
		JLabel Fullname_1_1 = new JLabel("Select Education");
		Fullname_1_1.setForeground(Color.BLACK);
		Fullname_1_1.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		Fullname_1_1.setBounds(866, 133, 164, 26);
		contentPane.add(Fullname_1_1);
		
		JLabel Fullname_1_2 = new JLabel("Course");
		Fullname_1_2.setForeground(Color.BLACK);
		Fullname_1_2.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		Fullname_1_2.setBounds(866, 209, 96, 26);
		contentPane.add(Fullname_1_2);
		
		course = new JTextField();
		course.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
		course.setColumns(10);
		course.setBounds(1043, 209, 244, 26);
		contentPane.add(course);
		
		JLabel lblEducationalDetails = new JLabel("Educational details");
		lblEducationalDetails.setForeground(Color.BLACK);
		lblEducationalDetails.setFont(new Font("Segoe UI Black", Font.BOLD, 15));
		lblEducationalDetails.setBounds(1035, 71, 252, 26);
		contentPane.add(lblEducationalDetails);
			
		passfld = new JPasswordField();
		passfld.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				err4.setVisible(false);
			}
		});
		passfld.setFont(new Font("Nirmala UI", Font.PLAIN, 17));
		passfld.setBounds(574, 334, 216, 21);
		contentPane.add(passfld);
		
		University.setBounds(1035, 287, 247, 21);
		contentPane.add(University);
		
		Education.addItem(" ");
		Education.addItem("Graduate/Diploma");
		Education.addItem("10 TH ");
		Education.addItem("12 TH ");
		Education.addItem("Below 10 TH ");
	
	}
}
