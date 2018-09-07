<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
    pageEncoding="ISO-8859-2"
    import="java.sql.ResultSet" 
    import="com.uczen.*"%>
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
				<a href="${str }"><img src="images/ikona home.png" alt=""></a>
				<a href="przedmioty_u.jsp"><img src="images/ikona przedmioty.png" alt=""></a>
				<a href="podejmijlab_u.jsp"><img src="" alt="podjete laborki"></a>
				<a href="http://www.utp.edu.pl/pl/"><img src="images/ikona utp.png" alt=""></a>
				<a href="${str }"><img src="images/ikona help.png" alt=""></a>
				
			</div>
			<div class="subjects">
			<a href="${str }"><img src="images/ramka przedmiot.png" alt="Error" width="300px" height="65px"/></a>
			</div>
		</nav>
		<% 
		if(session.getAttribute("username")!=null){
			String x = session.getAttribute("username").toString();
			Uczen un = new Uczen(); 
			ResultSet dane = un.daneUcznia(x);
			while(dane.next()){
		%>
		<main class="podstrona2">
			
				<h1 class="main-title">Witaj uczniu: <% out.print("\""+dane.getString("imie")+" "+ dane.getString("nazwisko")+"\""); %>  </h1>
			
			
		</main>
		<%
			}
		}
		%>
		<div class="login-button" >
		<form action="Logout">
			<input class="center-block2" type="image" src="images/wylog.png" alt="Wyloguj">
		</form>
		
	</div>
	
	</div>

</body>
</html>