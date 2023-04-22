<%@page import="java.util.Date"%>
<%@page import="java.sql.*"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Rates</title>
</head>
<body>
<% 
			Date d = new Date();
			


%>

<% Class.forName("oracle.jdbc.driver.OracleDriver");

Connection con = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-0GI8HTS:1521:XE", "hr", "hr");
PreparedStatement pst = con.prepareStatement(
		"select C_18, C_22, C_24 from rate_gold where r_date=(select max(r_date) from rate_gold)",
		ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

ResultSet rs = pst.executeQuery();
rs.next();
 %>

<center><h1> Current Rates </h1>	<h3><% out.println(d.toString());%></h3>	</center>

<h2>Gold Rates</h2>
<form action="RateServlet" method="post" >

18 Carat Rate: <input type="number" name="18rate" value=<%= rs.getInt(1) %>><br>
22 Carat Rate: <input type="number" name="22rate" value=<%= rs.getInt(2) %>><br>
24 Carat Rate: <input type="number" name="24rate" value=<%= rs.getInt(3) %>><br>

<input type="submit" value="Change Rates"><br>

</form>

<% 
PreparedStatement pst1 = con.prepareStatement(
		"select s1, s2 from rate_silver where r_date=(select max(r_date) from rate_silver)",
		ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

ResultSet rs1 = pst1.executeQuery();
rs1.next();
 %>
<h2>Silver Rates</h2>
<form action="RateSilverServlet" method="post">

S1 : <input type="number" name="S1" value=<%= rs1.getInt(1) %>><br>
S2 : <input type="number" name="S2" value=<%= rs1.getInt(2) %>><br>


<input type="submit" value="Change Rates">

</form>


</body>
</html>