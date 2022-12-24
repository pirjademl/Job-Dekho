package com.jobdekho.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class RegisterEmployer {
	private static final String Driver="com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/jobdekho";
	private static final String UNAME ="root";
	private static final String PASSWORD="";
//	private static final String INSERT_QUERY="insert into employer values";
	
	
	Connection con ;
	ResultSet rst;
	PreparedStatement stmt=null;
	Boolean a =false;
	Statement st ;
	Boolean CREATED=false;
	
	
	public boolean  CreateTable(String TableName) {
		System.out.println(TableName);
		try {
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/jobdekho","root","");
			String CREATE_QUERY="CREATE TABLE  "+TableName+" (`Fullname` VARCHAR(50) NOT NULL , `mobile` VARCHAR(50) NOT NULL , `Email` VARCHAR(50) NOT NULL , `status` VARCHAR(50) NOT NULL , `education` VARCHAR(50) NOT NULL , `course` VARCHAR(50) NOT NULL , `University` VARCHAR(50)) ";
	st=con.createStatement();
	boolean a =st.execute(CREATE_QUERY);
	if(a)
	{
		CREATED=true;
	}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return CREATED;
	}
	
//	CREATE TABLE `jobdekho`.`jobdekho` (`Fullname` VARCHAR(50) NOT NULL , `mobile` VARCHAR(50) NOT NULL , `Email` VARCHAR(50) NOT NULL , `status` VARCHAR(50) NOT NULL , `education` VARCHAR(50) NOT NULL , `course` VARCHAR(50) NOT NULL , `University` VARCHAR(50) NOT NULL ) ENGINE = InnoDB;
	
	
	public boolean    registerEmployer (String Fullname , String Email,String Comapanyname , String web, String empno,String no ) {
		int rowsAffected=0;	
//		String INSERTQUERY="insert into employer values ("+Fullname+"'"+Comapanyname+"'"+web+"'"+empno+");";
		try {
			Class.forName(Driver);
			con=DriverManager.getConnection(URL,UNAME,PASSWORD);
			stmt=con.prepareStatement("insert into employer(FullName,Email,Companyname,companywebsite,employeeno,location)values(?,?,?,?,?,?)");
			
			
			
			if (con!=null) {
				System.out.print("Connnected ");
				stmt.setString(1, Fullname);
				stmt.setString(2, Email);
				stmt.setString(3, Comapanyname);
				stmt.setString(4,web);
				stmt.setString(5,empno);
				stmt.setString(6,no);
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


		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Registration Failed");
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return a;
}
}
