<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="loginpage.css">
<title>goldrateupdates</title>
</head>
<body>
<div class="div1" align="center">
<h2 align="center">GOLD RATE UPDATE</h2>
<form action="RateServlet" method="post" >


24 CARAT : <input type="text" name="24rate" placeholder="enter rate value"> <br><br>
22 CARAT : <input type="text" name="22rate" placeholder="enter rate value"> <br><br>
18 CARAT : <input type="text" name="18rate" placeholder="enter rate value"> <br><br>


<center>  <input type="submit" value="UPDATE RATES" ><br> </center>


</form>
</div>
</body>
</html>