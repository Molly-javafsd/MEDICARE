<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.*" %>
	<%@page import="com.example.demo.model.*" %>
    <%@page import="com.example.demo.service.*"%>
      <%@page import="java.nio.file.Files" %>
    <%@page import="java.io.File" %>
    <%@page import="java.util.Base64.*" %>
<!DOCTYPE html>
<html>
<head>
<style>
body {
 background-color: #d5f4e6
}
 
div {
  text-align: center;
   font-size:300%;
  background-color: #d5f4e6;
}
h1 {
  text-align: center;
  font-family:verdana;
  font-size:300%;
  color:DarkOliveGreen;
 background-color:hsla(0, 100%, 50%, 0.1);
}
h2 {
  text-align: center;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> <%String path2="D:/img/med.png";
byte[] images2=Files.readAllBytes(new File(path2).toPath());
byte[] encodeBase642 = Base64.getEncoder().encode(images2);
String base64Encoded2 = new String(encodeBase642, "UTF-8");%>
<img alt="img" src="data:image/png;base64,<%=base64Encoded2%>" width="100" height="100"/>

<i><b>Welcome To Medicare</b></i>

<%String path="D:/img/med.png";
byte[] images=Files.readAllBytes(new File(path).toPath());
byte[] encodeBase64 = Base64.getEncoder().encode(images);
String base64Encoded = new String(encodeBase64, "UTF-8");%>
<img alt="img" src="data:image/png;base64,<%=base64Encoded%>" width="100" height="100"/></h1>

<div><a href="adminlogin.jsp">Admin</a></div><br>

<div><a href="userlogin.jsp">User</a></div><br>

<%String path1="D:/img/medicine.jpg";
byte[] images1=Files.readAllBytes(new File(path1).toPath());
byte[] encodeBase641 = Base64.getEncoder().encode(images1);
String base64Encoded1 = new String(encodeBase641, "UTF-8");
%>
<img alt="img" src="data:image/jpg;base64,<%=base64Encoded1%>" width="100%" height="100%"/>

</body>
</html>