package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
//@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet 
{
    private static final long serialVersionUID = 1L;
	
	String driver,url,uname,pwd,dbUname,dbPass,dbmobile;
	Connection con;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() 
    {
        super();
        // TODO Auto-generated constructor stub
    }
    
    
    @Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	
    	ServletContext ctx = config.getServletContext();
   	 	con = (Connection) ctx.getAttribute("mycon");
    	
    	
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try 
		{
			PrintWriter pw = response.getWriter();
			String uname = request.getParameter("uname");
			String pass = request.getParameter("pass");
			String cpass = request.getParameter("cpass");
			String mno = request.getParameter("mno");
			
			pw.println(uname);
			pw.println(pass);
			pw.println(mno);
			/*
			 * Class.forName("oracle.jdbc.driver.OracleDriver"); Connection con
			 * =DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-0GI8HTS:1521:XE","hr"
			 * ,"hr");
			 */
			PreparedStatement pst = con.prepareStatement("insert into adminjeweller values(?,?,?)");
			pst.setString(1, uname);
			pst.setString(2, pass);
			pst.setString(3, mno);
			
			int i = pst.executeUpdate();
			
			if(i!=0)
			{
				//pw.println("Record Inserted");
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.forward(request, response);	
			}
			else
			{
				pw.println("Failed to Insert Record");
			}
		}
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
