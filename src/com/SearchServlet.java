package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection con;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();

	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		
		ServletContext ctx = config.getServletContext();
   	 	con = (Connection) ctx.getAttribute("mycon");
	}
	
	
	
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		/* int customer_id =Integer.parseInt(request.getParameter("cname")); */
		String c_name = request.getParameter("cname");
		String mob_no = request.getParameter("mob");

		try {

			/*
			 * Class.forName("oracle.jdbc.driver.OracleDriver");
			 * 
			 * Connection con =
			 * DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-0GI8HTS:1521:XE",
			 * "hr", "hr");
			 */
			PreparedStatement pst = con.prepareStatement("select * from Customer_detail where c_name=? or mob_no=? ");
			pst.setString(1, c_name);
			pst.setString(2, mob_no);

			out.print("<table width=75% border=1>");
			out.print("<caption>Customer Details : </caption><br/>");
			ResultSet rs = pst.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();
			int totalColumn = rsmd.getColumnCount();
			out.println("<tr>");
			for (int i = 1; i <= totalColumn; i++) {
				out.print("<th>" + rsmd.getColumnName(i) + "</th>");
			}
			out.print("</tr>");

			boolean test = rs.next();
			while (test) {
				out.print("<tr>" + "<td>" + rs.getInt(1) + "</td>" + "<td>" + rs.getString(2) + "</td>" + "<td>"
						+ rs.getString(3) + "</td>" + "<td>" + rs.getString(4) + "</td>" + "<td>" + "<a href='"
						+ "./generateBill.jsp?id=" + rs.getInt(1) + "&cname=" + rs.getString(2) + "&mob="
						+ rs.getString(3) + "&add=" + rs.getString(4) + "'>Select</a>" + "</td>" + "</tr>");
				test = rs.next();
			}

			out.print("<tr><a href=\"addCustomer.jsp\">ADD NEW CUSTOMER</a></tr></table>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
