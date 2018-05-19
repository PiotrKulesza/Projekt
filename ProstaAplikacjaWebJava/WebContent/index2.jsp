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
	
	<div class="wraper">
			<nav class="menu">
				<div class="menu-center">
					<a href="${str }"><img src="images/ikona home.png" alt="Error"></a>
					<a href="${str }"><img src="images/ikona grupy.png" alt="Error"></a>
					<a href="${str }"><img src="images/ikona przedmioty.png" alt="Pokaz"></a>
					<a href="${str }"><img src="images/ikona sprawozdania.png" alt="Error"></a>
					<a href="${str }"><img src="images/ikona studenci.png" alt="Error"></a>
					<a href="http://www.utp.edu.pl/pl/"><img src="images/ikona utp.png" alt="Error"></a>
					<a href="${str }"><img src="images/ikona help.png" alt="Error"></a>
				</div>
				<div class="subjects">
				<a href="${str }"><img src="images/ramka przedmiot.png" alt="Error" width="300px" height="65px"/></a>
				</div>
			</nav>
			<div class="contentdwa">
				<div id="table">
					<a href="${str }"><img src="images/opusc grupe ikona.png" alt="Error" width="60px" height="70px"/></a>
					<a href="${str }"><img src="images/podejmij przedmiot ikona.png" alt="Error" width="80px" height="80px"/></a>
					<a href="${str }"><img src="images/porzuc przedmiot ikona.png" alt="Error" width="80px" height="80px"/></a>
					<a href="${str }"><img src="images/dodaj nowa grupe ikona.png" alt="Error" width="80px" height="80px"/></a>
				</div>	
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