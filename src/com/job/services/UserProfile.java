package com.job.services;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.jobdekho.dao.DashboardOperations;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class UserProfile extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JTextField fullname;
	private JTextField mobileno;
	private JTextField status;
	private JTextField city;
	private JTextField Education;
	private JTextField course;
	private JTextField university;
	private JButton btnNewButton;
	private JButton btnOk;
	private JTextField eml;
	private JLabel email;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserProfile frame = new UserProfile();
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
	public UserProfile() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1344, 621);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		username = new JTextField();
		username.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		username.setBounds(447, 10, 357, 49);
		contentPane.add(username);
		username.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Enter your Username ");
		lblNewLabel.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		lblNewLabel.setBounds(161, 10, 245, 49);
		contentPane.add(lblNewLabel);
		
		fullname = new JTextField();
		fullname.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		fullname.setColumns(10);
		fullname.setBounds(161, 143, 357, 49);
		contentPane.add(fullname);
		
		JLabel fn = new JLabel("Full Name ");
		fn.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		fn.setBounds(10, 138, 245, 49);
		contentPane.add(fn);
		
		JLabel mb = new JLabel("Mobile No");
		mb.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		mb.setBounds(10, 236, 245, 49);
		contentPane.add(mb);
		
		JLabel sts = new JLabel("Work Status");
		sts.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		sts.setBounds(590, 462, 245, 49);
		contentPane.add(sts);
		
		JLabel cn = new JLabel("CIty Name");
		cn.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		cn.setBounds(10, 473, 245, 49);
		contentPane.add(cn);
		
		mobileno = new JTextField();
		mobileno.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		mobileno.setColumns(10);
		mobileno.setBounds(148, 241, 357, 49);
		contentPane.add(mobileno);
		
		status = new JTextField();
		status.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		status.setColumns(10);
		status.setBounds(913, 467, 357, 49);
		contentPane.add(status);
		
		city = new JTextField();
		city.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		city.setColumns(10);
		city.setBounds(161, 478, 357, 49);
		contentPane.add(city);
		
		Education = new JTextField();
		Education.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		Education.setColumns(10);
		Education.setBounds(913, 143, 357, 49);
		contentPane.add(Education);
		
		course = new JTextField();
		course.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		course.setColumns(10);
		course.setBounds(913, 241, 357, 49);
		contentPane.add(course);
		
		university = new JTextField();
		university.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		university.setColumns(10);
		university.setBounds(913, 338, 357, 49);
		contentPane.add(university);
		
		JLabel ed = new JLabel("Education");
		ed.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		ed.setBounds(608, 138, 245, 49);
		contentPane.add(ed);
		ed.setVisible(false);
		
		JLabel crse = new JLabel("course");
		crse.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		crse.setBounds(608, 236, 245, 49);
		contentPane.add(crse);
		crse.setVisible(false);
		
		JLabel unsty = new JLabel("University");
		unsty.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		unsty.setBounds(608, 338, 245, 49);
		contentPane.add(unsty);
		
		btnNewButton = new JButton("GO");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String Email=username.getText();
				DashboardOperations db = new DashboardOperations();
				ArrayList<String > al = new ArrayList<String >();
				
				
			al=	db.getUserProfile(Email);
			fn.setVisible(true);
			ed.setVisible(true);
			crse.setVisible(true);
			unsty.setVisible(true);
			sts.setVisible(true);
			System.out.println(al.get(6));
			
			fullname.setVisible(true);
			fullname.setText(al.get(0));
			fullname.setEditable(false);
			
			mobileno.setVisible(true);
			mobileno.setText(al.get(1));
			mobileno.setEditable(false);
			eml.setVisible(true);
			
			eml.setText(al.get(2));
			eml.setEditable(false);
			status.setVisible(true);
			
			status.setText(al.get(3));
			status.setEditable(false);
			city.setVisible(true);
			city.setText(al.get(4));
			city.setEditable(false);
			
			Education.setVisible(true);
			Education.setText(al.get(5));
			Education.setEditable(false);
			course.setVisible(true);
			course.setText(al.get(6));
			course.setEditable(false);
			university.setVisible(true);
			university.setText(al.get(7));
			university.setEditable(false);

			
			
				
				
			}
		});
		btnNewButton.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(0, 191, 255));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBounds(838, 10, 210, 49);
		contentPane.add(btnNewButton);
		
		btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.setFont(new Font("Segoe UI Historic", Font.BOLD, 21));
		btnOk.setBorder(new LineBorder(new Color(0, 0, 0), 4));
		btnOk.setBorderPainted(false);
		btnOk.setBackground(new Color(0, 250, 154));
		btnOk.setBounds(593, 525, 210, 49);
		contentPane.add(btnOk);
		
		eml = new JTextField();
		eml.setFont(new Font("Segoe UI Symbol", Font.BOLD, 20));
		eml.setColumns(10);
		eml.setBounds(161, 361, 357, 49);
		contentPane.add(eml);
		
		email = new JLabel("email");
		email.setFont(new Font("Segoe UI Semilight", Font.BOLD, 20));
		email.setBounds(0, 356, 245, 49);
		contentPane.add(email);
		unsty.setVisible(false);
	}
}
