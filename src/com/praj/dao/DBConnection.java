package com.praj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.praj.bean.EncryptDecrypt;
import com.praj.bean.User;

public class DBConnection {
	
	public static Connection dbCon(){
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		 
		try {
			con = DriverManager.getConnection
			               ("jdbc:mysql://localhost:3306/psa","root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public User CurrentUser(String uname){
		Connection con = dbCon();
		User user=new User();
		ResultSet rs=null;
		String s="select uname,pass,age,gender,contact from members where uname='"+uname+"'";
		Statement ps;
		try {
			ps = con.createStatement();
		  	rs=ps.executeQuery(s);
		  	while(rs.next()){
			  	user.setUname(rs.getString("uname"));
			  	user.setAge(rs.getInt("age"));
			  	user.setGender(rs.getString("gender"));
			  	user.setContact(rs.getLong("contact"));
		  	}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	public List<User> ListUser(){
		Connection con = dbCon();
		ResultSet rs=null;
		String sql="select uname from members";
		Statement ps;
		User user=null;
		List<User> lstUser=new ArrayList<User>();
		
		try {
			ps = con.createStatement();
		  	rs=ps.executeQuery(sql);
		  	 while(rs.next())
			   {
		  		 user=new User();
		  		user.setUname(rs.getString("uname"));
		  		lstUser.add(user);
			   }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lstUser;
	}
	
	public static boolean checkUser(String uname,String pass)
	{
		boolean st=false;
		try
		{
			Connection con = dbCon();
	         Statement ps = con.createStatement();
	         
	         EncryptDecrypt ed= EncryptDecrypt.getInstance();
	 		//String encr=ed.encrypt(pass);
	         
	         String sql = "select * from members where uname='"+uname+"'";
	         ResultSet rs=ps.executeQuery(sql);
	         String decr=null;
	        if(rs.next())
	         {
	        	 decr=ed.decrypt(rs.getString("pass"));
	        	 //st=true;
	         }
	         if(decr.equals(pass))
	         {
	        	 st=true;
	         }
	       /*  if(rs.next())
	         {
	        	 st=true;
	         }*/
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return st;
	}


}
