<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
    pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<meta name="viewport" content="width-device-width, initial-scale=1">
<title>Projekt</title>
<link rel="Stylesheet" type="text/css" href="style.css" />
</head>
<body bgcolor="#00FFFF">

	<%
		
		response.setHeader("Cache-Control", "no-cach, no-store, must-revalidate");
		
		response.setHeader("Pragma", "no-cache");
		
		response.setHeader("Expires", "0");
		
		session.setMaxInactiveInterval(600);
		
		if(session.getAttribute("username")==null){
			response.sendRedirect("index.jsp");
		}
	
	%>
	
	
		<div style="float:right; border: 1px solid black; width: 100%;">
		
		<div style="float:left; border: 1px solid black; width: 20%;">
		
		
		<a class="center-block" href="index2.jsp"><img src="images/Home.jpg" alt="Error" /></a><br>
		<a class="center-block" href="http://www.utp.edu.pl/pl/"><img src="images/UTP.jpg" alt="Error" /></a><br>
		
		<form action="Logout">
			<input class="center-block" type="image" src="images/Zaloguj.jpg" alt="Wyloguj">
		</form>
		
		</div>
		
		
		</div>
	
	

</body>
</html>