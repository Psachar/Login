package com.praj.test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.praj.bean.EncryptDecrypt;
import com.praj.dao.DBConnection;



/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try{
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out=response.getWriter();
		RequestDispatcher rd = null;
		String uname=request.getParameter("uname");
		String pass=request.getParameter("pass");
		EncryptDecrypt ed= EncryptDecrypt.getInstance();
		String encr=ed.encrypt(pass);
		if(DBConnection.checkUser(uname,pass))
		{
			rd = request.getRequestDispatcher("Welcome");
            rd.forward(request, response);	
        }
		
		else
		{
			rd = request.getRequestDispatcher("index.jsp");
			out.println("Invalid username or password"+"<body style='color:#ffffff;'>");
			rd.include(request, response);
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
