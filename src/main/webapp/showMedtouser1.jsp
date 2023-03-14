<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
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
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3><b><i><%=request.getAttribute("msg") %></i></b></h3><br><br>
<form action="showMeduser">
<input type="hidden" name="cname" value=<%=request.getAttribute("cname") %>>
<div style="text-align:center">
<button type="submit" class="btn btn-primary">Show Meds</button>
</div>
</form> 
</body>
</html>