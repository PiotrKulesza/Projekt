

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
		
		
		
		if(session.getAttribute("username")==null){
			response.sendRedirect("index.jsp");
		}
		
	%>
	
	<div class="wraper tlo2">
		<nav class="menu">
			<div class="menu-center">
					<a href="uczen.jsp"><img src="images/ikona home.png" alt=""title="Katalog domowy ucznia"></a>
				<a href="przedmioty_u.jsp"><img src="images/ikona przedmioty.png" alt=""title="Wysyłanie sprawozdania"></a>
			    <a href="podejmijlab_u.jsp"><img src="images/podejmij.png" alt="podjete laborki"title="Podejmowanie laboratorium "></a>
				<a href="http://www.utp.edu.pl/pl/"><img src="images/ikona utp.png" alt="" title="Strona UTP"></a>
				
			</div>
			<div class="subjects">
			<a href="${str }"><img src="images/ramka laboratoria.png" alt="laboratoria" width="300px" height="65px"/></a>
			</div>
		</nav>
		
		
		
		<main class="podstrona">
		
		
		
			<div class="menu_przedmitow">
				<div class ="tabelau1">
			</br></br></br></br></br></br><table align="center" border=2>
			<form action="Szukaj" method="post">
				 <tr>
				 	<th>Dołącz do laboratoriów:</th>
				  </tr>
				
				
				<th><input id="Szuk_Btn_1" type="submit" value="Podejmij"></th>
				</tr>
				<th><h4>Dołączyłeś do:<br>"nazwa labka" </h4></th>
				</tr>
				</form>
				</table>
			</div>
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