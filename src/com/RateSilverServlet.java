package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RateSilverServlet
 */
public class RateSilverServlet extends HttpServlet {
	
	
	Connection con;
	
	private static final long serialVersionUID = 1L;
	
	
	
	
	@Override
    public void init(ServletConfig config) throws ServletException {
    	// TODO Auto-generated method stub
    	super.init(config);
    	
    	ServletContext ctx = config.getServletContext();
   	 	con = (Connection) ctx.getAttribute("mycon");
    	
    	
    	
    }
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RateSilverServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		
		String s1 = request.getParameter("S1");
		String s2 = request.getParameter("S2");
		
		PrintWriter out = response.getWriter();
		 try {
			 	
				
			 
	PreparedStatement pst1 =
			con.prepareStatement("insert into rate_silver values(seq_rate2.nextval,sysdate,?,?,' ')"); 
				  pst1.setString(1, s1);
				  pst1.setString(2, s2);
				  System.out.println(s1+" "+s2+" ");
				  
				  
				  
				  
				  
				  int rs1=pst1.executeUpdate();
				  
				  if(rs1!=0) { 
					  
					  RequestDispatcher rd= request.getRequestDispatcher("ShowRates.jsp");
					  rd.forward(request, response);
					  //out.println("  <h1> Record Inserted Successfully</h1> ");
				  
				  } 
				  
				  else { 
					  out.println("   <h2> FAILED TO INSERT RECORD </h2>  "); 
					  RequestDispatcher rd= request.getRequestDispatcher("RateSilver.jsp");
					  rd.include(request, response);
					  
				  }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
		
		
		
	}

}
