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
h3 {
  text-align: center;
  font-family:verdana;
  font-size:250%;
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
<%List<Medicine> e=(List<Medicine>)request.getAttribute("list");%>
<%List<Category> c1=(List<Category>)request.getAttribute("clist");%>

<form action="searchMeduser">
<input class="text-primary" type="text" name="keyword" placeholder="Search by name or type">
<button class="btn btn-success" type="submit">Search Any Medicine</button>
</form>
&nbsp;
<form action="sortListuser">
<select  class="btn btn-info" name="listType">
	<option class="dropdown-item" value="ASC">Price:Low To High</option>
	<option class="dropdown-item" value="DESC">Price:High To Low</option>
</select>
<button type="submit" class="btn btn-success" >Filter By Price</button>
</form>&nbsp;
<form action="filterByCategoryuser">
<select class="btn btn-info" name="categoryName">
<%
for(Category c:c1){
	%>
	<option class="dropdown-item" value="<%=c.getCategoryName()%>"><%=c.getCategoryName() %></option>
	<% } %>
</select>
<button type="submit" class="btn btn-success" >Find By Category</button>
</form><br>
<table class="table table-hover">
<tr><th>Medicine_ID</th><th>Name</th><th>Price</th><th>Category</th><th>Description</th><th>Offers</th><th colspan="2">Action</th></tr>

<%for(Medicine es:e){%>
<tr><td><%=es.getMid()%></td><td><%=es.getMName()%></td><td><%=es.getMPrice()%></td>
<td><%=es.getCategory() %></td>
<td><%=es.getDescription() %></td>
<td><%=es.getOffer() %></td>
<td>
<form action="cart">
<input type="hidden" name="mid" value=<%=es.getMid() %>>

<div style="text-align:center">
<button type="submit" class="btn btn-danger">Add To Cart/Proceed</button>
</div>
</form>
</td>
</tr>
<%}%>
</table>
</body>
</html>