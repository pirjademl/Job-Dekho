package com.job.services;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Homepage extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage frame = new Homepage();
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
	public Homepage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1252, 758);
//		setBounds(maximizedBounds)S
	
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 0, 1219, 90);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(245, 245, 220));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Magdum\\Downloads\\jobdekho (1).jpg"));
		lblNewLabel_1.setBounds(0, 0, 299, 93);
		panel.add(lblNewLabel_1);
		
		JButton btnApplyNow_1_1 = new JButton("Employer Login");
		btnApplyNow_1_1.setBounds(921, 28, 202, 52);
		panel.add(btnApplyNow_1_1);
		btnApplyNow_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployerLogin eg = new EmployerLogin();
				eg.setVisible(true);
				setVisible(false);
			}
		});
		btnApplyNow_1_1.setForeground(Color.WHITE);
		btnApplyNow_1_1.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		btnApplyNow_1_1.setBorderPainted(false);
		btnApplyNow_1_1.setBackground(Color.CYAN);
		
		JButton btnApplyNow = new JButton("Apply Now");
		btnApplyNow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CandidateRegistration cgr = new CandidateRegistration();
				cgr.setVisible(true);
				setVisible(false);
				
			}
		});
		btnApplyNow.setBackground(Color.CYAN);
		btnApplyNow.setForeground(Color.WHITE);
		btnApplyNow.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		btnApplyNow.setBorderPainted(false);
		btnApplyNow.setBounds(228, 577, 158, 22);
		contentPane.add(btnApplyNow);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Magdum\\Downloads\\image (1).jpg"));
		lblNewLabel_2.setBounds(721, 362, 502, 180);
		contentPane.add(lblNewLabel_2);
		
		JButton btnPostJobFor = new JButton("Post Job for Free");
		btnPostJobFor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "First register YOurself as a EMployer");
				
			}
		});
		btnPostJobFor.setForeground(Color.WHITE);
		btnPostJobFor.setFont(new Font("Copperplate Gothic Bold", Font.PLAIN, 15));
		btnPostJobFor.setBorderPainted(false);
		btnPostJobFor.setBackground(Color.CYAN);
		btnPostJobFor.setBounds(921, 578, 198, 21);
		contentPane.add(btnPostJobFor);
		
		JCheckBox lblNewLabel = new JCheckBox("");
		lblNewLabel.setBounds(39, 362, 556, 180);
		contentPane.add(lblNewLabel);
		lblNewLabel.setBackground(Color.BLUE);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Magdum\\Downloads\\image.jpg"));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Magdum\\Downloads\\headline.jpg"));
		lblNewLabel_3.setBounds(122, 137, 1046, 186);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\Magdum\\Downloads\\trust.jpg"));
		lblNewLabel_4.setBounds(271, 608, 695, 77);
		contentPane.add(lblNewLabel_4);
		
		JList list = new JList();
		list.setBounds(206, 241, 1, 1);
		contentPane.add(list);
//		setUndecorated(true);
	}

	private void setIcon(String string) {
		// TODO Auto-generated method stub
		
	}
}
