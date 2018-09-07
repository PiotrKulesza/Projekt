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
			<a href="index2.jsp"><img src="images/ikona home.png" alt="Error"></a>
					<a href="przedmioty_p.jsp"><img src="images/ikona sprawozdania.png" alt="Pokaz"></a>
					<a href="przedmioty_p2.jsp"><img src="images/wyslij.png" alt="Error"></a>
					<a href="http://www.utp.edu.pl/pl/"><img src="images/ikona utp.png" alt="Error"></a>
					<a href="${str }"><img src="images/ikona help.png" alt="Error"></a>
				
			</div>
			<div class="subjects">
			<a href="${str }"><img src="" alt="laboratoria" width="300px" height="65px"/></a>
			</div>
		</nav>
		
		
		
		<main class="podstrona">
		
		
		
			<div class="menu_przedmitow">
				<div class ="tabelau1">
			</br></br></br></br></br></br><table align="center" border=2>
			<form action="Szukaj" method="post">
				 <tr>
				 	<th>nauczaj na laboratiorach:</th>
				  </tr>
				
				
				<th><input id="Szuk_Btn_1" type="submit" value="Nauczaj"></th>
				</tr>
				<th><h5>błąd podczas wyboru: "nazwa laborki" </h5></th>
				</tr>
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