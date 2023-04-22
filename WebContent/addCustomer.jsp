<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="loginpage.css">
<title>ADDCustomer</title>
</head>
<body>

<form action="CustomerServlet" >
<div class="mainContainer">
	<label for="username">Name :</label>
	<input type="text" name="cname" placeholder="EnterName" required="required" size="15"><br>
	<span id="unameError" class="error"></span>
 
 
 	<label for="mno">Mobile Number :</label>
	<input type="text" name="mobile" pattern="[0-9]{10,10}" placeholder="EnterMobileNumber" required maxlength="10" min="10"><br>
	
	<label for="username">Address :</label>
	<input type="text" name="address" placeholder="EnterAddress" required="required"><br>

 	<input type="submit" value="Add Customer"><br>
</div>

</form>

</body>
</html>