package com.job.services;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jobdekho.dao.DashboardOperations;
import com.jobdekho.dao.insertOperations;

import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

public class SearchJobs extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchJobs frame = new SearchJobs();
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
	public SearchJobs() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1234, 743);
		contentPane = new JPanel();
		
		contentPane.setForeground(new Color(0, 0, 255));
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setTitle("29450 Vacanies in india ");

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		JLabel label = new JLabel("");
//		label.setBounds(0, 10, 127, 41);
//		contentPane.add(label);
		JLabel lbl = new JLabel("");
		lbl.setIcon(new ImageIcon("C:\\Users\\Magdum\\Downloads\\jobdekho (1).jpg"));
		lbl.setBounds(0, 10, 180, 56);
		contentPane.add(lbl);
		
		JComboBox<String>  bytype = new JComboBox();
		bytype.setFont(new Font("Segoe Print", Font.BOLD, 15));
		bytype.setBounds(249, 10, 250, 29);
		bytype.addItem("Work from Home ");
		bytype.addItem("Work from office");
		contentPane.add(bytype);
		bytype.addItem("Search jobs by type ");
		bytype.addItem("Work From Home Jobs ");
		bytype.addItem("Freshers Jobs  ");
		bytype.addItem("Part time Jobs ");
		bytype.addItem("Woman jobs");
//		bytype.addItem("Night shift  Jobs");
		bytype.addItem("Full time  Jobs ");

bytype.setSelectedIndex(0);


		
	
		
		JComboBox <String >jobtype = new JComboBox<String>();
		jobtype.setFont(new Font("Segoe Print", Font.BOLD, 20));
		jobtype.setBounds(614, 10, 250, 29);
		contentPane.add(jobtype);
		jobtype.addItem("Computer Operator");
		jobtype.addItem("Software Engineer  ");
		jobtype.addItem("Java Devloper  ");
		jobtype.addItem("Php Devloper  ");
		jobtype.addItem("Acconting ");
		jobtype.addItem("Database Engineer");
		jobtype.addItem("computer operator ");
		jobtype.addItem("computer operator ");
		jobtype.addItem("computer operator ");
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 255, 255));
		panel.setBounds(25, 169, 556, 236);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel firstlbl = new JLabel("");
		firstlbl.setHorizontalAlignment(SwingConstants.LEFT);
		firstlbl.setBounds(10, 10, 176, 37);
		panel.add(firstlbl);
		
		JLabel secondlbl = new JLabel("");
		secondlbl.setHorizontalAlignment(SwingConstants.LEFT);
		secondlbl.setBounds(185, 10, 194, 37);
		panel.add(secondlbl);
		
		JLabel thirdlbl = new JLabel("");
		thirdlbl.setHorizontalAlignment(SwingConstants.LEFT);
		thirdlbl.setBounds(352, 10, 194, 37);
		panel.add(thirdlbl);
		
		JLabel fourlbl = new JLabel("");
		fourlbl.setHorizontalAlignment(SwingConstants.LEFT);
		fourlbl.setBounds(10, 69, 115, 37);
		panel.add(fourlbl);
		
		JLabel fifthlbl = new JLabel("");
		fifthlbl.setHorizontalAlignment(SwingConstants.LEFT);
		fifthlbl.setBounds(196, 69, 167, 37);
		panel.add(fifthlbl);
		
		JLabel sixthlbl = new JLabel("");
		sixthlbl.setHorizontalAlignment(SwingConstants.LEFT);
		sixthlbl.setBackground(new Color(245, 245, 245));
		sixthlbl.setBounds(373, 69, 167, 37);
		panel.add(sixthlbl);
		
		JButton btnNewButton = new JButton("Apply");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String password=	JOptionPane.showInputDialog("Enter Your Password ");
			System.out.println(password);
			DashboardOperations get = new DashboardOperations();
			ArrayList <String > al = new ArrayList<String>();
			
			
			al=get.getUser(password);
			
			String fullname=al.get(0);
			String mobile=al.get(1);
			String Email=al.get(3);
			String status=al.get(4);
			String ed=al.get(5);
			String course=al.get(6);
			String unvsty=al.get(7);
			String name=firstlbl.getText();
			
			insertOperations ir = new insertOperations();
//			ir.insertCandi(name, fullname, mobile, Email, status, name, ed, course, unvsty);
			
			 ir.insertCandi(name, fullname, mobile, Email, status, name, ed, course, unvsty);
			
			
			
		
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(34, 139, 34));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBounds(162, 186, 199, 40);
		panel.add(btnNewButton);
		
		JLabel seven = new JLabel("");
		seven.setHorizontalAlignment(SwingConstants.LEFT);
		seven.setBackground(new Color(245, 245, 245));
		seven.setBounds(10, 127, 115, 37);
		panel.add(seven);
		
		JLabel eigth = new JLabel("");
		eigth.setHorizontalAlignment(SwingConstants.LEFT);
		eigth.setBackground(new Color(245, 245, 245));
		eigth.setBounds(187, 127, 176, 37);
		panel.add(eigth);
		
		JLabel nine = new JLabel("");
		nine.setHorizontalAlignment(SwingConstants.LEFT);
		nine.setBackground(new Color(245, 245, 245));
		nine.setBounds(364, 127, 176, 37);
		panel.add(nine);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 255, 240));
		panel_1.setBounds(600, 169, 556, 236);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("Apply");
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setBackground(new Color(34, 139, 34));
		btnNewButton_2.setBounds(156, 175, 199, 40);
		panel_1.add(btnNewButton_2);
		
		JLabel eight1 = new JLabel("");
		eight1.setBackground(new Color(245, 245, 245));
		eight1.setBounds(10, 10, 167, 37);
		panel_1.add(eight1);
		
		JLabel eigth2 = new JLabel("");
		eigth2.setBackground(new Color(245, 245, 245));
		eigth2.setBounds(188, 10, 167, 37);
		panel_1.add(eigth2);
		
		JLabel eigth3 = new JLabel("");
		eigth3.setBackground(new Color(245, 245, 245));
		eigth3.setBounds(365, 10, 167, 37);
		panel_1.add(eigth3);
		
		JLabel eigth4 = new JLabel("");
		eigth4.setBackground(new Color(245, 245, 245));
		eigth4.setBounds(10, 80, 167, 37);
		panel_1.add(eigth4);
		
		JLabel eigth5 = new JLabel("");
		eigth5.setBackground(new Color(245, 245, 245));
		eigth5.setBounds(188, 80, 167, 37);
		panel_1.add(eigth5);
		
		JLabel eigth6 = new JLabel("");
		eigth6.setBackground(new Color(245, 245, 245));
		eigth6.setBounds(379, 80, 167, 37);
		panel_1.add(eigth6);
		
		JLabel eigth7 = new JLabel("");
		eigth7.setBackground(new Color(245, 245, 245));
		eigth7.setBounds(32, 127, 167, 37);
		panel_1.add(eigth7);
		
		JLabel eigth9 = new JLabel("");
		eigth9.setBackground(new Color(245, 245, 245));
		eigth9.setBounds(365, 127, 167, 37);
		panel_1.add(eigth9);
		
		JLabel eigth8 = new JLabel("");
		eigth8.setBounds(209, 127, 132, 37);
		panel_1.add(eigth8);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(240, 255, 240));
		panel_2.setBounds(25, 435, 556, 220);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBounds(10, 10, 132, 37);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4_1 = new JLabel("");
		lblNewLabel_4_1.setBounds(10, 10, 378, 37);
		panel_2.add(lblNewLabel_4_1);
		
		JButton btnNewButton_1 = new JButton("Apply");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(new Color(34, 139, 34));
		btnNewButton_1.setBounds(157, 170, 199, 40);
		panel_2.add(btnNewButton_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("");
		lblNewLabel_2_1.setBounds(175, 10, 132, 37);
		panel_2.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("");
		lblNewLabel_2_2.setBounds(359, 10, 132, 37);
		panel_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("");
		lblNewLabel_2_3.setBounds(10, 72, 132, 37);
		panel_2.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("");
		lblNewLabel_2_4.setBounds(175, 72, 132, 37);
		panel_2.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("");
		lblNewLabel_2_5.setBounds(334, 72, 132, 37);
		panel_2.add(lblNewLabel_2_5);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(240, 255, 240));
		panel_3.setBounds(600, 435, 556, 220);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 10, 378, 37);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4_2 = new JLabel("");
		lblNewLabel_4_2.setBounds(10, 10, 378, 37);
		panel_3.add(lblNewLabel_4_2);
		
		JButton btnNewButton_3 = new JButton("Apply");
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setBackground(new Color(34, 139, 34));
		btnNewButton_3.setBounds(154, 170, 199, 40);
		panel_3.add(btnNewButton_3);
		
		JLabel lblNewLabel_2_6 = new JLabel("");
		lblNewLabel_2_6.setBounds(10, 10, 132, 37);
		panel_3.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_7 = new JLabel("");
		lblNewLabel_2_7.setBounds(170, 10, 132, 37);
		panel_3.add(lblNewLabel_2_7);
		
		JLabel lblNewLabel_2_8 = new JLabel("");
		lblNewLabel_2_8.setBounds(341, 10, 132, 37);
		panel_3.add(lblNewLabel_2_8);
		
		JLabel lblNewLabel_2_9 = new JLabel("");
		lblNewLabel_2_9.setBounds(10, 76, 132, 37);
		panel_3.add(lblNewLabel_2_9);
		
		JLabel lblNewLabel_2_10 = new JLabel("");
		lblNewLabel_2_10.setBounds(154, 76, 132, 37);
		panel_3.add(lblNewLabel_2_10);
		
		JLabel lblNewLabel_2_11 = new JLabel("");
		lblNewLabel_2_11.setBounds(322, 76, 132, 37);
		panel_3.add(lblNewLabel_2_11);
		
		JButton go1 = new JButton("Go");
		go1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String search =  (String) bytype.getSelectedItem();
			DashboardOperations get= new DashboardOperations();
		ResultSet rs =	get.getJobs(search);
		int i=0;
		System.out.println("Hello");
		try {
			while(rs.next()) {
				JOptionPane.showMessageDialog(null, "Hello");
				
				String name=rs.getString(1);
				String jobname=rs.getString(2);
				String type=rs.getString(3);
				String no =rs.getString(4);
				String location=rs.getString(5);
				String qual=rs.getString(6);
				String mnsalary=rs.getString(7);
				String mxsalary=rs.getString(8);
				String skills=rs.getString("skillsRequired");
//				firstlbl.setText(name);
				if(i==0) {
					firstlbl.setText(name);
					secondlbl.setText(jobname);
					thirdlbl.setText(type);
					fourlbl.setText(no);
					fifthlbl.setText(location);
					sixthlbl.setText(qual);
					seven.setText(mnsalary);
					eigth.setText(mxsalary);
					nine.setText(skills);
				}
				if(i==1) {
					eight1.setText(name);
					eigth2.setText(jobname);
					eigth3.setText(type);
					eigth4.setText(no);
					eigth5.setText(location);
					eigth6.setText(qual);
					eigth7.setText(mnsalary);
					eigth8.setText(mxsalary);
				
					eigth9.setText(skills);
			
				}if(i==2) {
					eight1.setText(name);
					eigth2.setText(jobname);
					eigth3.setText(type);
					eigth4.setText(no);
					eigth5.setText(location);
					eigth6.setText(qual);
					eigth7.setText(mnsalary);
					eigth8.setText(mxsalary);
			
				}
				
				
				i++;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
		
			
			}
		});
		go1.setForeground(Color.WHITE);
		go1.setBorderPainted(false);
		go1.setBackground(new Color(34, 139, 34));
		go1.setBounds(279, 49, 174, 40);
		contentPane.add(go1);
		
		JButton go2 = new JButton("Go");
		go2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String search =  (String)jobtype.getSelectedItem();
				System.out.println(search);
				DashboardOperations get= new DashboardOperations();
			ResultSet rs =	get.getJobsbytype(search);
			int i=0;
			System.out.println("Hello");
			
				try {
					while(rs.next()) {
						
						JOptionPane.showMessageDialog(null, "Hello");
						
						String name=rs.getString(1);
						String jobname=rs.getString(2);
						String type=rs.getString(3);
						String no =rs.getString(4);
						String location=rs.getString(5);
						String qual=rs.getString(6);
						String mnsalary=rs.getString(7);
						String mxsalary=rs.getString(8);
						String skills=rs.getString("skillsRequired");
//					firstlbl.setText(name);
						if(i==0) {
							firstlbl.setText(name);
							secondlbl.setText(jobname);
							thirdlbl.setText(type);
							fourlbl.setText(no);
							fifthlbl.setText(location);
							sixthlbl.setText(qual);
							seven.setText(mnsalary);
							eigth.setText(mxsalary);
							nine.setText(skills);
						}
						if(i==1) {
							eight1.setText(name);
							eigth2.setText(jobname);
							eigth3.setText(type);
							eigth4.setText(no);
							eigth5.setText(location);
							eigth6.setText(qual);
							eigth7.setText(mnsalary);
							eigth8.setText(mxsalary);
						
							eigth9.setText(skills);
					
						}if(i==2) {
							eight1.setText(name);
							eigth2.setText(jobname);
							eigth3.setText(type);
							eigth4.setText(no);
							eigth5.setText(location);
							eigth6.setText(qual);
							eigth7.setText(mnsalary);
							eigth8.setText(mxsalary);
					
						}
						
						
						i++;
					
					}
					System.out.print(rs.next()!=true);
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		
			}
		});
		go2.setForeground(Color.WHITE);
		go2.setBorderPainted(false);
		go2.setBackground(new Color(34, 139, 34));
		go2.setBounds(652, 49, 174, 40);
		contentPane.add(go2);
		
		JMenu mnNewMenu = new JMenu("Profile");
		mnNewMenu.setBounds(1045, 99, 111, 24);
		contentPane.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("View Profile");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("View Applied Jobs");
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Log out");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CandidateLogin login = new CandidateLogin();
				login.setVisible(true);
				setVisible(false);
				
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 17, 101, 22);
		contentPane.add(menuBar);
	}
}
