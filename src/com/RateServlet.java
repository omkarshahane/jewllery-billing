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
 * Servlet implementation class RateGold
 */
public class RateServlet extends HttpServlet {
	
	
	Connection con;
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RateServlet() {
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
		
		String carat1 = request.getParameter("18rate");
		String carat2 = request.getParameter("22rate");
		String carat3 = request.getParameter("24rate");
		
		
		
		System.out.println(carat1+" "+carat2);
		PrintWriter out = response.getWriter();
		
		try {
			PreparedStatement pst =
					  con.prepareStatement("insert into rate_gold values (seq_rate1.nextval,sysdate,?,?,?,' ')");
			
			pst.setString(1, carat1);
			pst.setString(2, carat2);
			pst.setString(3, carat3);
			System.out.println(carat1+" "+carat2+" "+carat3);
			
			
			int rs=pst.executeUpdate();
			
			if(rs!=0) { 
				  
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
