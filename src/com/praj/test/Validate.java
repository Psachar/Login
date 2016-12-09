package com.praj.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.praj.bean.EncryptDecrypt;

public class Validate {
	
	public static boolean checkUser(String uname,String pass)
	{
		boolean st=false;
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
	         Connection con=DriverManager.getConnection
	                        ("jdbc:mysql://localhost:3306/psa","root","root");
	         Statement ps = con.createStatement();
	         EncryptDecrypt ed=EncryptDecrypt.getInstance();
	         String encr=ed.encrypt(pass);
	         String sql = "select * from members where uname='"+uname+"' && pass='"+encr+"'";
	         ResultSet rs=ps.executeQuery(sql);
	         String decr=ed.decrypt(encr);
	         if(rs.next() && decr.equals(pass))
	         {
	        	 st=true;
	         }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return st;
	}

}
