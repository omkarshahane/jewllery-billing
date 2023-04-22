<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="loginpage.css">
<title>SilverRates</title>
</head>
<body>
<div class="div1" align="center">
<h2 align="center">SILVER RATE UPDATE</h2>
<form action="RateSilverServlet" method="post" >


S1 : <input type="text" name="S1" placeholder="enter rate value"> <br><br>
S2 : <input type="text" name="S2" placeholder="enter rate value"> <br><br>


<center>  <input type="submit" value="UPDATE RATES" > <br> </center>


</form>
</div>
</body>
</html>