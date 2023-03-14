<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="java.util.*" %>
	<%@page import="com.example.demo.model.*" %>
    <%@page import="com.example.demo.service.*"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
<style>
h1 {
  text-align: center;
  font-family:verdana;
  font-size:300%;
  color:#006400;
}
body {
 background-color: #d5f4e6;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%int total=0; %>
<h1>Order Summary</h1>
<%List<OrderSummary> or1=(List<OrderSummary>) request.getAttribute("or1"); %>
<table class="table table-hover">
<tr><th>Name</th><th>Price</th></tr>
<%for(OrderSummary es:or1){%>
<tr><td><%=es.getMedName() %></td><td><%=es.getMedPrice()%></td>
<td></td>
</tr>
<%total=total+es.getMedPrice();%>
<%} %>
</table>
<h1>Total Amount to be Paid:<%=total%></h1>
<h4><div style="text-align:center"><a href="buynow.jsp?price=<%=total%>">Proceed To Pay
</a></div></h4>

<form action="showMeduser">
<div style="text-align:center">
<button type="submit" class="btn btn-primary">Add More Medicines</button>
</div>
</form> 
</body>
</html>