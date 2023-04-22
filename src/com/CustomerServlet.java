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
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.CustomerService;
import com.service.CustomerServiceImpl;

/**
 * Servlet implementation class CustomerServlet
 */
public class CustomerServlet extends HttpServlet {
	
	Connection con;
	
	
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CustomerServlet() {
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
		/*
		 * response.setContentType("text/html"); PrintWriter out = response.getWriter();
		 * 
		 * 
		 * String cname = request.getParameter("cname"); String mobile =
		 * request.getParameter("mobile"); String address =
		 * request.getParameter("address");
		 * 
		 * 
		 * CustomerService cs = new CustomerServiceImpl(); Customer c1 =
		 * cs.addNewCustomer(cname, mobile, address);
		 */
		
		
		/*
		 * try { PreparedStatement pst = con.
		 * prepareStatement("insert into customer_detail values(seq_cust.nextval,?,?,?)"
		 * );
		 * 
		 * pst.setString(1, cname); pst.setString(2, mobile); pst.setString(3, address);
		 * 
		 * int i = pst.executeUpdate();
		 * 
		 * if(i!=0) { out.println("customer Added"); } else {
		 * rd=request.getRequestDispatcher("addCustomer.jsp");
		 * rd.include(request,response); out.println("no cust added"); }
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		
		
		
		
		
	}
	
	@Override protected void service(HttpServletRequest request,
	  HttpServletResponse response) throws ServletException, IOException { 
		// TODO Auto-generated method stub
	  
	  response.setContentType("text/html"); 
	  PrintWriter out = response.getWriter();
	  
	  
	  String cname = request.getParameter("cname"); 
	  String mobile = request.getParameter("mobile"); 
	  String address =request.getParameter("address");
	  
	  
	  CustomerService cs = new CustomerServiceImpl(); 
	  Customer c1 =  cs.addNewCustomer(cname, mobile, address);
	  System.out.println(c1);
	  
		
		/*
		 * if (c1 ) { System.out.println("added " + c1);
		 * out.println("Customer Added Successfully");
		 * 
		 * } else { out.println("error"); }
		 */
	  
	  
	  }
	 
	

}
