package com.praj.test;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.praj.bean.User;
import com.praj.dao.DBConnection;



/**
 * Servlet implementation class Welcome
 */
public class Welcome extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
		
			String userName=request.getParameter("uname");
			DBConnection db=new DBConnection();
			List<User> lstUser=db.ListUser();
			User user=db.CurrentUser(userName);
			request.setAttribute("lstUser", lstUser);
			request.setAttribute("user", user);
			
			PrintWriter o=response.getWriter();
			o.println("Welcome"+" "+userName);
			o.println("<br>");
		 o.println("<br>");
		   o.println("List of registered users");
		   o.println("<br>");
		   o.println("<br>");
		   int i=0;
		   for(int j=0;i<lstUser.size();j++)
		   {
			   i++;
			   o.println("User"+" "+":"+i+" "+"-"+" "+lstUser.get(j).getUname());
			   o.println("<br>");
		   }
		   o.println("<br>");
		   o.println("<br>");
		   o.println("Currently Logged in User Details:");
		   o.println("<br>");
		   o.println("<br>");
		   o.println("User Name"+" "+":"+" "+user.getUname());
		   o.println("<br>");
		   o.println("Age"+" "+":"+" "+user.getAge());
		   o.println("<br>");
		   o.println("Gender"+" "+":"+" "+user.getGender());
		   o.println("<br>");
		   o.println("Contact"+" "+":"+" "+user.getContact());
		  }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		  
	}

}
