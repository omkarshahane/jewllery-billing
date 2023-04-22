package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AddItemServlet
 */
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection con;
	
	
    /**
     * Default constructor. 
     */
    public AddItemServlet() {
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		int num,num1;
		String name = request.getParameter("pname");
		String category = request.getParameter("category");
		String quantity = request.getParameter("quanti");
		String weight = request.getParameter("weight");
		String carat = request.getParameter("carat");
		
		System.out.println(name+" "+category+" "+quantity+" "+weight+" "+carat);
		
		try {
			
			
			
			
			PrintWriter out = response.getWriter();
			
			/*
			 * PreparedStatement pst1=
			 * con.prepareStatement("select max(particular_id) from inventory"); ResultSet
			 * rs1=pst1.executeQuery(); rs1.next(); num=rs1.getInt(1); num1=1+num;
			 */
			
			
			  PreparedStatement pst =
			  con.prepareStatement("insert into inventory values (seq_bill.nextval,?,?,?,?,?)");
			  
			  
				//pst.setInt(1, num);
				pst.setString(1, name);
				pst.setString(2, category);
				pst.setString(3, quantity);
				pst.setString(4, weight);
				pst.setString(5, carat);
			  
				RequestDispatcher rd;
				int i = pst.executeUpdate();
			
				if(i!=0)
				{
					//pw.println("Record Inserted");
					/*
					 * rd = request.getRequestDispatcher("AddInventory.jsp"); rd.forward(request,
					 * response);
					 */
					//rd.include(arg0, arg1);
					/*
					 * rd = request.getRequestDispatcher("AddInventory.jsp"); rd.include(request,
					 * response);
					 */
					
					request.setAttribute("status", "success");
					 response.sendRedirect("AddInventory.jsp?er=inserted successfull");
					 //out.print("inserted successfull");
				}
				else
				{
					request.setAttribute("status", "error");
					
				}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
