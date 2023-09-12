package p1;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class login extends HttpServlet
{
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		String username=request.getParameter("username");
		Connection con=null;
		String a=null;
		String ID=null;
		ResultSet res=null;
		PreparedStatement pstmt=null;
		Statement stmt=null;
		
		
			try
			{
				DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
				System.out.println("Driver success");
			}
			catch(Exception e)
			{
				System.out.println("Driver failed");
			}
			try
			{
				con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/XE","system","system");
				System.out.println("Connection success");
			}
			catch(Exception e)
			{
				System.out.println("Connetion failed");
			}
			try
			{
				stmt=con.createStatement();
				pstmt=con.prepareStatement("SELECT * FROM COLLEGE WHERE ID=?");
				pstmt.setString(1,username);
				while(res.next()==true)
				{
					 a=res.getString(1);
				}
				HttpSession session=request.getSession();
				session.setAttribute("username",username);
				session.setAttribute("aa",a);

				response.sendRedirect("2ndpage.jsp");
				
				/*
				if(a.equals("username"))
				{
					HttpSession session=request.getSession();
					session.setAttribute("username",username);
					response.sendRedirect("2ndpage.jsp");
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