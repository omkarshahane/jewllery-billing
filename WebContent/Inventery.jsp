<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="loginpage.css">
</head>
<body>
<script type="text/javascript">
function update()
{
	
	var gold = ["c_18","c_22","c_24"];
	var silver = ["S1","S2"];
	
	var catagory=document.getElementById("cat");
    var carat=document.getElementById("2");
    var selected=catagory.value;
    var html='<option selected="selected">carat</option>';
    if(selected === "1")
    {
        for(var i=0; i < gold.length; i++)
        {
            html+='<option value="' + gold[i] + '">' + gold[i] + '</option>';
        }
    }
    else if(selected === "2")
    {
        for(var j=0; j < silver.length; j++)
        {
            html+='<option value="' + silver[j] + '">' + silver[j] + '</option>';
        }
    }
    
    carat.innerHTML=html;
	
 }
</script>
</head>
<body>
<form action="\">
<div class = "headingContainer">
	<h1>INSERT NEW DATA TO INVENTORY</h1>
</div>	
	
			<div class="mainContainer">
				<lable for ="item">Enter Item Name : </lable>
				<input type="text" name="pname"> <br>
				<lable for ="catagory">CATEGORY : </lable>
				<select id="cat" onchange="update()">
					<option value = "0">Choose Catagory</option>
					<option value="1">GOLD</option>
					<option value="2">SILVER</option>
				</select> <br> <br>
				<lable for ="carcat">Carat-Category:</lable><%  %>
				<select id = "2">
				<option selected = "selected" ></option>
				</select>
				<!-- <select>
					<option>C_18</option>
					<option>C_22</option>
					<option>C_24</option>
					<option>S1</option>
					<option>S2</option>
				</select>   -->
				<!-- <select>
					<option>S1</option>
					<option>S2</option>
				</select> <br> -->
				<lable for ="quan">Quantity: </lable>
				<input type="text" name="quanti"> <br> 
				<lable for ="totalwt">Total Weight : </lable>
				<input type="text" name="weight" width="100px">Gms <br> <input
					type="submit" name="sub" value="Add ITEM"> <br>
				</div>	
			</form>
		</body>
</html>
</body>
</html>