package com.jobdekho.dao;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class DashboardOperations {
	private static final String URL="jdbc:mysql://localhost:3306/jobdekho";
	private static final String UNAME ="root";
	private static final String PASSWORD="";
	Statement st =null;
	ResultSet rs= null;
	public ArrayList<String> getProfile(String Username){
		ArrayList<String> al = new ArrayList<String >();
		try {java.sql.Connection con =DriverManager.getConnection(URL,UNAME,PASSWORD);
			st =con.createStatement();
			rs=st.executeQuery("SELECT Fullname,Email,Companyname,companywebsite,employeeno,location from employer WHERE Email='"+Username+"'");
			while(rs.next()) {
				al.add(rs.getString("Fullname"));
				al.add(rs.getString("Email"));
				al.add(rs.getString("Companyname"));
				al.add(rs.getString("companywebsite"));
				al.add(rs.getString("employeeno"));
				al.add(rs.getString("location"));
			}}catch (SQLException e) {
			e.printStackTrace();}
		return al;}
	
	public ResultSet getJobsbytype(String role) {
		System.out.println(role);
//		ArrayList<String> al = new ArrayList<String >();
		try {java.sql.Connection con =DriverManager.getConnection(URL,UNAME,PASSWORD);
			st =con.createStatement();
			rs=st.executeQuery("SELECT CompanyName, role,typejob, no, loc, qual, min_salry, max_salary, workPref, skillsRequired from jobs WHERE role='"+role+"'");
			return rs;

		
		}catch(Exception e) {
		System.out.println("Not Connnected ");
		}
		return rs;
	}
	


	public ResultSet getJobs(String type) {
//		ArrayList<String> al = new ArrayList<String >();
		try {java.sql.Connection con =DriverManager.getConnection(URL,UNAME,PASSWORD);
			st =con.createStatement();
			rs=st.executeQuery("SELECT CompanyName, role,typejob, no, loc, qual, min_salry, max_salary, workPref, skillsRequired from jobs WHERE workPref='"+type+"'");
			return rs;
//			while(rs.next()) {
////				System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
//				
////				al.add(rs.getString("CompanyName"));
////				al.add(rs.getString("role"));
////				al.add(rs.getString("typejob"));
////				al.add(rs.getString("no"));
////				al.add(rs.getString("loc"));
////				al.add(rs.getString("qual"));
////				al.add(rs.getString("min_salry"));
////				al.add(rs.getString("max_salary"));
////				al.add(rs.getString("workPref"));
////				al.add(rs.getString("skillsRequired"));
////				System.out.println(al.get(0));
////				System.out.println(al.get(1));
////				System.out.println(al.get(2));
////				System.out.println(al.get(3));
////				System.out.println(al.get(4));
////				System.out.println(al.get(5));
////				System.out.println(al.get(6));
////				System.out.println(al.get(7));
//				
			
		}catch(Exception e) {
		System.out.println("Not Connnected ");
		}
		return rs;
	}public ArrayList<String> getUserProfile(String Username){
		ArrayList<String> al = new ArrayList<String >();
		try {java.sql.Connection con =DriverManager.getConnection(URL,UNAME,PASSWORD);
			st =con.createStatement();
			rs=st.executeQuery("SELECT Fullname,Mobileno,Emailid,workstatus,cityname,Education,course,university from register_user WHERE Emailid='"+Username+"'");
			while(rs.next()) {
				al.add(rs.getString("Fullname"));
				al.add(rs.getString("Mobileno"));
				al.add(rs.getString("Emailid"));
				al.add(rs.getString("workstatus"));
				al.add(rs.getString("cityname"));
				al.add(rs.getString("Education"));
				al.add(rs.getString("course"));
				al.add(rs.getString("university"));
			}}catch (SQLException e) {
			e.printStackTrace();}
		return al;}
	public ArrayList<String> getUser(String Password){
		ArrayList<String> al = new ArrayList<String >();
		try {java.sql.Connection con =DriverManager.getConnection(URL,UNAME,PASSWORD);
			st =con.createStatement();
			rs=st.executeQuery("SELECT Fullname,Mobileno,Emailid,workstatus,cityname,Education,course,university from register_user WHERE password='"+Password+"'");
			while(rs.next()) {
				al.add(rs.getString("Fullname"));
				al.add(rs.getString("Mobileno"));
				al.add(rs.getString("Emailid"));
				al.add(rs.getString("workstatus"));
				al.add(rs.getString("cityname"));
				al.add(rs.getString("Education"));
				al.add(rs.getString("course"));
				al.add(rs.getString("university"));
			}}catch (SQLException e) {
			e.printStackTrace();}
		return al;}
	public ResultSet getwhoApplied(String companyname){
		try {java.sql.Connection con =DriverManager.getConnection(URL,UNAME,PASSWORD);
	st =con.createStatement();
	rs=st.executeQuery("SELECT * from "+companyname);
	if(rs.next()!=true) {
		System.out.println("Not getting the data ");
	}
	return rs;


}catch(Exception e) {
JOptionPane.showMessageDialog(null, "Invalid company name entered ");
}
return rs;
}
}
		
