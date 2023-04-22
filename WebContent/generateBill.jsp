<%@page import="java.util.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	String id = request.getParameter("id");
String name = request.getParameter("cname");
String mob = request.getParameter("mob");
String add = request.getParameter("add");
String s = request.getParameter("iid");
String s1 = request.getParameter("pname");
String s2 = request.getParameter("cat");
String s3 = request.getParameter("caunt");
String s4 = request.getParameter("wei");
String s5 = request.getParameter("cara");

Class.forName("oracle.jdbc.driver.OracleDriver");

Connection con = DriverManager.getConnection("jdbc:oracle:thin:@DESKTOP-0GI8HTS:1521:XE", "hr", "hr");
PreparedStatement pst = con.prepareStatement(
		"select particular_id, p_name, carat, category from inventory where CATEGORY=?",
		ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
pst.setString(1, "GOLD");

ResultSet rs = pst.executeQuery();

PreparedStatement pst1 = con.prepareStatement(
		"select particular_id, p_name, carat, category from inventory where CATEGORY=?",
		ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
pst1.setString(1, "SILVER");

ResultSet rs1 = pst1.executeQuery();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Bill page</title>
<script src="jquery.js"></script>

<script>
$(document).ready(function(){
	$('#addbtn').click(function(){
		
		var selected=document.getElementById("pname").value;
		
		
		<%while (rs.next()) {%>
		var isExist = "<%=rs.getString(2)%>";
		if(selected!="" && selected==isExist) {
		var count = $("#billRows > tbody > tr").length;
		var rate;
		<%if(rs.getString(3).equals("C_24")){%>
			rate = $('#24rate').val();
			<%} else if(rs.getString(3).equals("C_22")){ %>
			
			rate = $('#22rate').val();
			
		<%	} else if(rs.getString(3).equals("C_18")){ %>
		
		rate = $('#18rate').val();
		
	<%	}%>
			
$('#billRows tbody').append('<tr><td>'+(count+1)+'</td><td id='+(count+1)+'><%=rs.getString(2)%></td><td><%=rs.getString(4)%></td><td><%=rs.getString(3)%></td><td><input type="text" id=wt_'+(count+1)+'></td><td><input type="text" id=NtWt_'+(count+1)+'></td><td><input type="text" id=rt_'+(count+1)+' value="'+rate+' "></td><td><input type="text" id=gst_'+(count+1)+' value="1.5"></td><td><input type="text" id=making_'+(count+1)+' value="350"></td><td><input type="text" readonly="readonly" id=tot_'+(count+1)+' ></td></tr>');

		/* $('#'+(count+1)).html(selected); */
		
		
		}
		<%}%>
	})
})



$(document).ready(function(){$('#addBtnSilver').click(function(){ 
	var selected=document.getElementById("pnameSilver").value;
	<%while (rs1.next()) {%>
	var isExist1 = "<%=rs1.getString(2)%>";
	if(selected!="" && selected==isExist1) {
	var count = $("#billRows > tbody > tr").length;
	var rateS;
	<% if(rs1.getString(3).equals("S1")){%>
	
	rateS = $('#s1rate').val();
	
	<%}
	else if(rs1.getString(3).equals("S2")){
	%>
	rateS = $('#s2rate').val();
	
	<%}%>
	$('#billRows tbody').append('<tr><td>'+(count+1)+'</td><td><%=rs1.getString(2)%></td><td><%=rs1.getString(4)%></td><td><%=rs1.getString(3)%></td><td><input id=wt_'+(count+1)+' type="text" placeholder="" ></td><td><input type="text" id=NtWt_'+(count+1)+'></td><td><input type="text" id=rt_'+(count+1)+' value="'+rateS+'" ></td><td><input type="text" id=gst_'+(count+1)+' value="1.5"></td><td><input id=making_'+(count+1)+' type="text"></td><td><input type="text" readonly="readonly" id=tot_'+(count+1)+' ></td></tr>');

												/*  $('#'+(count+1)).html(selected);  */
											}
<%}%>
	})
					})
					
	$(document).ready(function(){$('#calBill').click(function(){
			var count = $("#billRows > tbody > tr").length;
			var tot = 0;
			var gTot=0;
			for(i=1; i<=count; i++)
				{
				var rowTotal = ($('#NtWt_'+i).val() * $('#rt_'+i).val()) + ($('#NtWt_'+i).val() * $('#rt_'+i).val() * ($('#gst_'+i).val() /100)) + ($('#making_'+i).val() * $('#NtWt_'+i).val());
				$('#tot_'+i).val(rowTotal);
				tot +=  rowTotal;
				
				}
			$('#subTotal').text(tot);
			gTot= tot-$('#lessAmt').val()
			$('#grandTot').text(gTot)
			
		}
	)})
	
	$(function () {
    //declare function 
    $.fn.saveData = function () {
    	
    	
        return true;
    };
});

</script>
<style>
body {
	background-color: #F6F6F6;
	margin: 0;
	padding: 0;
}

h1, h2, h3, h4, h5, h6 {
	margin: 0;
	padding: 0;
}

p {
	margin: 0;
	padding: 0;
}

.container {
	width: 80%;
	margin-right: auto;
	margin-left: auto;
}

.brand-section {
	background-color: #0d1033;
	padding: 10px 40px;
}

.logo {
	width: 50%;
}

.row {
	display: flex;
	flex-wrap: wrap;
}

.col-6 {
	width: 50%;
	flex: 0 0 auto;
}

.text-white {
	color: #fff;
}

.company-details {
	float: right;
	text-align: right;
}

.body-section {
	padding: 16px;
	border: 1px solid gray;
}

.heading {
	font-size: 20px;
	margin-bottom: 08px;
}

.sub-heading {
	color: #262626;
	margin-bottom: 05px;
}

table {
	background-color: #fff;
	width: 100%;
	border-collapse: collapse;
}

table thead tr {
	border: 1px solid #111;
	background-color: #f2f2f2;
}

table td {
	vertical-align: middle !important;
	text-align: center;
}

table th, table td {
	padding-top: 0px;
	padding-bottom: 0px;
	padding-left: 5px 8px;
}

.table-bordered {
	box-shadow: 0px 0px 5px 0.5px gray;
}

.table-bordered td, .table-bordered th {
	border: 1px solid #dee2e6;
}

.text-right {
	text-align: end;
}

.w-20 {
	width: 20%;
}

.float-right {
	float: right;
}
</style>
<body>

<%PreparedStatement pst2 = con.prepareStatement(
		"select C_18, C_22, C_24 from rate_gold where r_date=(select max(r_date) from rate_gold)",
		ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

ResultSet rs2 = pst2.executeQuery();
rs2.next(); 


PreparedStatement pst3 = con.prepareStatement(
		"select s1, s2 from rate_silver where r_date=(select max(r_date) from rate_silver)",
		ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

ResultSet rs3 = pst3.executeQuery();
rs3.next();

%>
<h4>GOLD RATES</h4>
18 Carat Rate: <input type="number" name="18rate" id="18rate" value=<%= rs2.getInt(1)  %>><br>
22 Carat Rate: <input type="number" name="22rate" id="22rate" value=<%= rs2.getInt(2) %>><br>
24 Carat Rate: <input type="number" name="24rate" id="24rate" value=<%= rs2.getInt(3) %>><br>
<h4>SILVER RATES</h4>
S1 : <input type="number" name="S1" id="s1rate" value=<%= rs3.getInt(1) %>><br>
S2 : <input type="number" name="S2" id="s2rate" value=<%= rs3.getInt(2) %>><br>
<!-- 	<div>

		<table>
			<thead>

				<tr>
					<th>GOLD RATES</th>
				</tr>
				<tr>
					<th>18 CARAT</th>
					<th>22 CARAT</th>
					<th>24 CARAT</th>
				</tr>
				<tr>
					<td></td>
				</tr>
			</thead>

		</table>


	</div> -->


	<div>
		Gold Particulars : <input type="text" list="particularsGold"
			id="pname">
		<datalist id="particularsGold">
			<%
				rs.beforeFirst();
			while (rs.next()) {
				//System.out.println(rs.getString(2));
			%>
			<option value="<%=rs.getString(2)%>"><%=rs.getString(2)%></option>
			<%
				}
			%>
		</datalist>
		<input type="submit" value="add" id="addbtn">
		 Silver Particulars :
		<input type="text" list="particularsSilver" id="pnameSilver">
		<datalist id="particularsSilver">
			<%
				rs1.beforeFirst();
			while (rs1.next()) {
			%>
			<option value="<%=rs1.getString(2)%>"></option>
			<%
				}
			%>
		</datalist>
		<input type="submit" value="add" id="addBtnSilver">
	</div>
<div>
<input type="submit" value="CALCULATE" id="calBill">

</div>


	<div class="container">
		<div class="brand-section">
			<div class="row">
				<div class="col-6">
					<h1 class="text-white">ABC JEWELLERS,Pune</h1>
					<h5 class="text-white"><% 
			Date d = new Date();
					out.println(d.toString());
			%></h5>
				</div>
				<div class="col-6">
					<div class="company-details">
						<p class="text-white">Omkar Shahane</p>
						<p class="text-white">Barshi</p>
						<p class="text-white">+91 9767733031</p>
					</div>
				</div>
			</div>
		</div>

		<div class="body-section">
			<div class="row">
				<div class="col-6">
					<h2 class="heading">Invoice No.: 001</h2>
					<!-- this will be bill no from billing table  -->
					<p class="sub-heading">Date:<% out.println(d.toString()); %> </p>
					<!-- sysdate   -->
					<p class="sub-heading">Email Address:
						omkarshahane8diamond@gmail.com</p>
				</div>
				<div class="col-6">
					<p class="sub-heading">
						Customer id:
						<%=id%>
					</p>
					<p class="sub-heading">
						Customer Name:
						<%=name%>
					</p>
					<p class="sub-heading">
						Mobile Number:
						<%=mob%>
					</p>
					<p class="sub-heading">
						Address:
						<%=add%>
					</p>
				</div>
			</div>
		</div>

		<div class="body-section" style="overflow: scroll">
			<h3 class="heading">Selected Items</h3>
			<br>
			<table class="table-bordered" id="billRows">
				<thead>
					<tr>
						<!-- <th>Jewellery</th> -->
						<th class="w-10">Sr.No</th>

						<th class="w-10">Particular Name</th>

						<th class="w-20">Category</th>

						<th class="w-20">Carat</th>


						<th class="w-20">Weight</th>

						<th class="w-10">Net Weight</th>
						<th class="w-10">Rate</th>
						<th class="w-10">Gst</th>
						<th class="w-20">Making Charges</th>
						<th class="w-20">Total</th>
					</tr>
				</thead>
				<tbody>
			</table>

			<table style="width: 108%;">
				<tr>
					<td colspan="3" class="text-right">Sub Total</td>
					<td id="subTotal">0.00</td>
				</tr>
				<tr>
					<td colspan="3" class="text-right">Discount/Less</td>
					<td> Rs. <input type="number" id="lessAmt"> </td>
				</tr>
				<tr>
					<td colspan="3" class="text-right">Grand Total</td>
					<td id="grandTot">RS. </td>
				</tr>
				</tbody>
			</table>
			<br>
			<h3 class="heading">Payment Status: <input type="text" placeholder="Paid/Unpaid" ></h3>
			<h3 class="heading">Payment Mode: <input type="text"  placeholder="Cash/Online"> </h3>
		</div>

		<div class="body-section">
			<p>
				&copy; Billing Project Omkar. <a href="" class="float-right">jwellers.admin.example.com</a>
			</p>
		</div>
	</div>
	
	<input type="button" onclick=""  value="SAVE and PRINT">

</body>
</html>