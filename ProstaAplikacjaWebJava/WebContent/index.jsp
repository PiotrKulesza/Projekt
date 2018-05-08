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
		
		String str;
				
		if(session.getAttribute("username")==null){
			str="index.jsp";
		}else str="index2.jsp";
	
		%>
		<div style="float:right; border: 1px solid black; width: 20%;">
		<div style=" font-size: 18px; border: 1px solid black;"> 
		Twoj dane:
		</div>
		<div style="font-size: 16px; border: 1px solid black;"> 
		<form action="Login" method="post">
			<label id="firstlabel">Login:</label> <input type="text" name="uname" size="25"><br>
			<label id="firstlabel">Password:</label> <input type="password" name="pass" size="25"><br>
			<input class="center-block" type="image" src="images/Zaloguj.jpg" alt="Submit">
		</form>
		</div>
		</div>
		<div style="float:right; border: 1px solid black; width: 100%;">
		
		<div style="float:left; border: 1px solid black; width: 20%;">
		
		
		<a class="center-block" href="${str }"><img src="images/Home.jpg" alt="Error" /></a><br>
		<a class="center-block" href="http://www.utp.edu.pl/pl/"><img src="images/UTP.jpg" alt="Error" /></a><br>
		
		</div>
		
		
		</div>
</body>
</html>