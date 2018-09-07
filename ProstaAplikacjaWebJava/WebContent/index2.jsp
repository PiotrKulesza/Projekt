<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
    pageEncoding="ISO-8859-2"
    import="java.sql.ResultSet" 
    import="com.pracownik.*"%>
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
	
	<div class="wraper">
		<nav class="menu">
			<div class="menu-center">
				<a href="${str }"><img src="images/ikona home.png" alt="Error"></a>
				<a href="przedmioty_p.jsp"><img src="images/ikona sprawozdania.png" alt="Pokaz"></a>
				<a href="przedmioty_p2.jsp"><img src="images/wyslij.png" alt="Error"></a>
				<a href="nauczajlab_p.jsp"><img src="" alt="nauczaj lab"></a>
				<a href="http://www.utp.edu.pl/pl/"><img src="images/ikona utp.png" alt="Error"></a>
				<a href="${str }"><img src="images/ikona help.png" alt="Error"></a>
			</div>
		</nav>
		<div class="contentdwa">
			<main class="podstrona2">
				<% 
					if(session.getAttribute("username")!=null){
						String x = session.getAttribute("username").toString();
						Pracownik prac = new Pracownik(); 
						ResultSet dane = prac.danePracownika(x);
						while(dane.next()){
				%>
				<h1 class="main-title3">Witaj pracowniku: <% out.print("\""+dane.getString("imie")+" "+ dane.getString("nazwisko")+"\""); %></h1>
				<%
						}
					}
				
				%>
			</main>
		</div>	
		<div class="login-button" >
			<form action="Logout">
				<input class="center-block2" type="image" src="images/wylog.png" alt="Wyloguj">
			</form>
		</div>
	</div>
	<script type="text/javascript">
	document.getElementsByClassName("przycisk").addEventListener("click", schowaj);
	
	function schowaj(){
		if(document.getElementById("table").style.display=="block")
			document.getElementById("table").style.display = "none";	
		else{
			document.getElementById("table").style.display = "block";
		}
	}
	</script>

</body>
</html>