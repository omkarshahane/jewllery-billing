<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="loginpage.css">
<title>Search Customer</title>
</head>
<body>
<form action="SearchServlet" method="post" >

Customer Name: <input type="text" name="cname" placeholder="CustomerName" ><br/>
Customer Mobile Number: <input type="text" name="mob" placeholder="Mobile" pattern="[0-9]{10,10}" required maxlength="10" min="10" ><br/>
<input type="submit" value="Search"><br>


<p class="register">Want to Add customer?  <a href="addCustomer.jsp">Add Customer here!</a></p>
</form>
</body>
