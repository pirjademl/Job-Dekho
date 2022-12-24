package com.jobdekho.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class login {
	private static final String Driver="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/jobdekho";
	private static final String UNAME ="root";
	private static final String PASSWORD="";	Connection con ;
	ResultSet rst;
	PreparedStatement stmt=null;
	Boolean a =false;
	
	
	public boolean checkEmail(String Email ) {
	
		try {
			Connection con= DriverManager.getConnection(URL,UNAME,PASSWORD);
			PreparedStatement ps=con.prepareStatement("select * from employer where Email=?");
			ps.setString(1, Email);
		ResultSet rs =	ps.executeQuery();
		if(rs.next()) {
			a=true;
		}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
		
	}
	public boolean checkLogin(String Username ,String Password ) {
	
		try {
			
			Class.forName(Driver);
			con=DriverManager.getConnection(URL,UNAME,PASSWORD);
			PreparedStatement ps = con.prepareStatement("select * from register_user where Emailid=? and password=?");
			if(con!=null) {
				ps.setString(1, Username);
				ps.setString(2, Password);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					a=true;
				}
				
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
