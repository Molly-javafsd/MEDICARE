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
<%List<Status> s=(List<Status>)request.getAttribute("slist");%>
<%List<Category> g=(List<Category>)request.getAttribute("clist");%>
<form action="editMedicine">
<input type="hidden" name="mid" value=<%=request.getAttribute("mid") %>>
<table class="table table-hover">
<tr><td>Medicine name:</td><td><input type="text"name="mname"></td></tr>
<tr><td>Price</td><td><input type="number" name="mprice"></td></tr>
<tr><td>Category:</td><td>
<select name="categoryName">
<%

for(Category c:g){
	%>
	<option value="<%=c.getCategoryName()%>"><%=c.getCategoryName() %></option>
	<% } %>
</select>
</td></tr>
<tr><td>Offer</td><td><input type="text" name="moffer"></td></tr>
<tr><td>Description:</td><td><input type="text" name="mdesc"></td></tr>
<tr><td>Status:</td><td>
<select name="statusName">
<%
for(Status c:s){
	%>
	<option value="<%=c.getCurrentStatus()%>"><%=c.getCurrentStatus() %></option>
	<% } %>
</select>
</td></tr>
<tr><td><div style="text-align:center"><button type="submit" class="btn btn-primary">Edit Now</button></div></td></tr>
</table>
</form>
</body>
</html>