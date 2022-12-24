package com.jobdekho.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class RegisterCandi {
	Connection con ;
	PreparedStatement stmt;
//	private static final String Driver="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/jobdekho";
	private static final String UNAME ="root";
	private static final String PASSWORD="";
	Boolean a =false;
	public boolean     registerCandidate (String Fullname , String MobileNo , String Email, String Password,String workstatus,String City, String Education ,String Course, String University  ) {
		int rowsAffected=0;	
//		String INSERTQUERY="insert into employer values ("+Fullname+"'"+Comapanyname+"'"+web+"'"+empno+");";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection(URL,UNAME,PASSWORD);
			stmt=con.prepareStatement("insert into register_user(Fullname,MobileNo,Emailid,password,workstatus,cityname,Education,Course,university)values(?,?,?,?,?,?,?,?,?);"
					+ "");
			
			
			
			if (con!=null) {
				System.out.print("Connnected ");
				stmt.setString(1, Fullname);
				stmt.setString(2, MobileNo);
				stmt.setString(3,Email);
				stmt.setString(4,Password);
				stmt.setString(5,workstatus);
				stmt.setString(6, City);
				stmt.setString(7, Education);
				stmt.setString(8,Course);
				stmt.setString(9, University);
				
				rowsAffected =stmt.executeUpdate();
				if(rowsAffected>0) {
					
					System.out.println("inserted the   record succesfully");
				a=true;
					

				}else {
					System.out.println("Cannot ");
					
				}
		
			}else {
			System.out.println("Couldnt be registered try again ");
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
