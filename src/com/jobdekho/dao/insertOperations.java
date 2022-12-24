package com.jobdekho.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class insertOperations{
	private static final String Driver="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/jobdekho";
	private static final String UNAME ="root";
	private static final String PASSWORD="";
	Connection con=null;
	PreparedStatement stmt = null;
	Boolean a =false;

	public void InsertCandidate(String FullName , String MobileNo , String Emailid, String password,String Work_status,String Education,String Course,String University ) {
		try{
			Class.forName(Driver);
	
		con=DriverManager.getConnection(URL,UNAME,PASSWORD);
		stmt=con.prepareStatement("insert into Register_user(FullName,MobileNo,Emailid,password,Work_status,Education,Course,University)values(?,?,?,?,?,?,?,?)");
		
		
		
		if (con!=null) {
			System.out.print("Connnected ");
			stmt.setString(1, FullName);
			stmt.setString(2, MobileNo);
			stmt.setString(3,Emailid);
			stmt.setString(4,password);
			stmt.setString(5,Education);
			stmt.setString(6,Course);
			stmt.setString(7,University);
			
			int rows =stmt.executeUpdate();
			if(rows>0) {
				System.out.println("inserted the   record succesfully");
				

			}else {
				System.out.println("Cannot ");
			}
		}
		}
				
			catch (ClassNotFoundException e) {
	JOptionPane.showMessageDialog(null,"Unknown error ocuurred ");
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
	}
	public void PostJob(String Name , String role,String typejob,int  no,String loc,String qual,String min,String Max ,String gender, String pref,String fee,String type,String skill,String Desc )
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(URL,"root","");
			PreparedStatement ps =con.prepareStatement("insert into  jobs (CompanyName, role, 	typejob, no, loc, qual, min_salry, max_salary, Gender, workPref, feeamount, skillsRequired,type, Descriptiontext)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, Name);
			ps.setString(2, role);
			ps.setString(3, typejob);
			ps.setInt(4, no);
			ps.setString(5, loc);
			ps.setString(6, qual);
			ps.setString(7, min);
			ps.setString(8, Max);
			ps.setString(9, gender);
			ps.setString(10, pref);
			ps.setString(11, fee);
			ps.setString(12, type);
			ps.setString(13, skill);
			ps.setString(14, Desc);
			int i=ps.executeUpdate();
			if(i>0)
			{
				System.out.print("Registered ");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public boolean insertCandi(String ComPname,String Fullname , String mobile , String Email , String status ,String City, String Education, String Course ,String Unvsty) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(URL,"root","");
			PreparedStatement ps =con.prepareStatement("insert into "+ComPname+"(Fullname, mobile,Email,status,education,course,University)values(?,?,?,?,?,?,?)");
			ps.setString(1, Fullname);
			ps.setString(2, mobile);
			ps.setString(3, Email);
			ps.setString(4, status);
			ps.setString(5, City);
			ps.setString(6, Education);
			ps.setString(7, Course);
			ps.setString(7, Unvsty);
			int i=ps.executeUpdate();
			if(i>0)
			{
				a=true;
				System.out.print("Registered ");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
		
	}
}
