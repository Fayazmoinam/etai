package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class forgotPassword extends HttpServlet
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		Connection con=null;
		String a=null;
		String ID=null;
		ResultSet res=null;
		PreparedStatement pstmt=null;
		Statement stmt=null;
		HttpSession session=request.getSession();
		String forgotPassword=request.getParameter("forgotPassword");
		try
		{
			stmt=con.createStatement();
			pstmt=con.prepareStatement("SELECT * FROM COLLEGE WHERE mobile=?");
			while(res.next()==true)
			{
				 a=res.getString(1);
			}
			
			/*
			if(a.equals("mobile"))
			{

				response.sendRedirect("newPasword.jsp");
			}
			else
			{
				response.sendRedirect("login.jsp");
				
			}	*/
			
		}
		catch(Exception e)
		{
			
		}
		
		
	}

}