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
<%List<Medicine> e=(List<Medicine>)request.getAttribute("list");%>
<table class="table table-hover">
<tr><th>Medicine_ID</th><th>Name</th><th>Price</th><th>Category</th><th>Description</th><th>Status</th><th colspan="2">Action</th></tr>

<%for(Medicine es:e){%>
<tr><td><%=es.getMid()%></td><td><%=es.getMName()%></td><td><%=es.getMPrice()%></td>
<td><%=es.getCategory() %></td>
<td><%=es.getDescription() %></td>
<td><%=es.getStatus() %></td>
<td>
<form action="deletemed">
<input type="hidden" name="mid" value=<%=es.getMid() %>>
<div style="text-align:center">
<button type="submit" class="btn btn-danger">Delete</button>
</div>
</form>
<br>
<form action="editMed">
<input type="hidden" name="mid" value=<%=es.getMid() %>>
<div style="text-align:center">
<button type="submit" class="btn btn-warning">Update</button>
</div>
</form></td>
</tr>
<%}%>
</table>
</body>
</html>