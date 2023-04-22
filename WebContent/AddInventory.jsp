<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<% String er=request.getParameter("er");
	if(er==null)
		er=" ";
	%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>AddInventory</title>
<link rel="stylesheet" href="loginpage.css">
<script type="text/javascript">
	function populate() {
		var c1 = document.getElementById('cat').value;

		if (c1 == "GOLD") {
			var array = [ "select carat","C_18", "C_22", "C_24" ];
		} else if (c1 == "SILVER") {
			var array = [ "select ","S1", "S2" ];
		}

		var string = "";
		for (i = 0; i < array.length; i++) {
			string = string + "<option>" + array[i] + "</option>";

		}
		string = "<select name=''>" + string + "</select>";
		document.getElementById('output').innerHTML = string;

	}
</script>

<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>
</head>
<body>
	<h1>INSERT NEW DATA TO INVENTORY</h1>

	<form action="AddItemServlet" method="post" >
	
	<input type="hidden" id="status" value="<%=request.getAttribute("status") %>">
		Enter Item Name : <input type="text" name="pname" required="required"> <br>

		CATEGORY : <select id="cat" onchange="populate()" name="category" required="required">
		   
			<option>Choose Category</option>
			<option>GOLD</option>
			<option>SILVER</option>
		</select> <br> 
		Carat-Category:
		
			<select id="output" name="carat" required="required">
				<option></option>
			</select>
		
		<br> 
		Quantity: <input type="number" name="quanti" > <br>
		Total Weight : <input type="number" name="weight" width="100px" required="required">Gms
		<br> 
		<input type="submit" name="sub" value="Add ITEM"> <br><span><%=er %></span>
	</form>
	
	<script type="text/javascript">var status = document.getElementId("status").value;
	if(status=="success")
		{
		swal("congrats","Inserted Successfully","success");
		}
	
	</script>
</body>
</html>