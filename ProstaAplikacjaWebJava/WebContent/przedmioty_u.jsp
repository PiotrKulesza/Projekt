<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
    pageEncoding="ISO-8859-2"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<meta name="viewport" content="width-device-width, initial-scale=1">
<title>Projekt</title>
<link rel="Stylesheet" type="text/css" href="style.css" />
</head>
<body>

	<%
		
		response.setHeader("Cache-Control", "no-cach, no-store, must-revalidate");
		
		response.setHeader("Pragma", "no-cache");
		
		response.setHeader("Expires", "0");
		
		session.setMaxInactiveInterval(600);
		
		if(session.getAttribute("username")==null){
			response.sendRedirect("index.jsp");
		}
	
	%>
	
	<div class="wraper tlo2">
		<nav class="menu">
			<div class="menu-center">
				<a href="uczen.jsp"><img src="images/ikona home.png" alt=""></a>
				<a href="przedmioty_u.jsp"><img src="images/ikona przedmioty.png" alt=""></a>
				<a href="http://www.utp.edu.pl/pl/"><img src="images/ikona utp.png" alt=""></a>
				<a href="${str }"><img src="images/ikona help.png" alt=""></a>
				
			</div>
			<div class="subjects">
			<a href="${str }"><img src="images/ramka przedmiot.png" alt="Error" width="300px" height="65px"/></a>
			</div>
		</nav>
		
		
		
		<main class="podstrona">
		
			<h1>Przedmioty</h1>
		
			<div class="menu_przedmitow">
				<a href="sprawozdania_u.jsp">Narzędzia programistyczne </a> </br></br>
				<a href="sprawozdania_u.jsp">Podstawy systemow operacyjnych </a> </br>
			
				<p2> Prowadzacy:</br></br>
					 Prowadzący:
				</p2>
			</div>
		</main>
			
		<div class="login-button" >
			<form action="Logout">
				<input class="center-block2" type="image" src="images/wylog.png" alt="Wyloguj">
			</form>
		</div>
		
	
	</div>

</body>
</html>