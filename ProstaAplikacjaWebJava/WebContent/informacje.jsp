<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
    pageEncoding="ISO-8859-2"
    import="java.sql.ResultSet" 
    import="com.uczen.*"%>
   
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width-device-width, initial-scale=1">
<title>Projekt</title>
<link rel="Stylesheet" type="text/css" href="style.css" />
</head>
<body>


	
	<div class="wraper tlo2">
		<nav class="menu">
			<div class="menu-center">
				<a href="index.jsp"><img src="images/ikona home.png" alt="Error"></a>
					<a href="http://www.utp.edu.pl/pl/"><img src="images/ikona utp.png" alt="Error" title="Strona UTP"></a>
					<a href="${str}"><img src="images/ikona help.png" alt="Error" title="Informacje"></a>
					<a href="https://usosweb.utp.edu.pl/kontroler.php?_action=actionx:news/default()"><img src="images/ikona usos.png" alt="Error" title="Usosweb"></a>
				
				</div>
			</nav>
	<h1>Tworcami strony ,,Repozytorium Sprawozdan" dla Uniwersytetu Technologiczno-przyrodniczego, znajdujacego sie przy ul. Profesora Kaliskiego 7 sa studenci pierwszego roku na kierunku ,,Informatyka Stosowana". Osoby sprawujace piecze nad strona to: Paulina Pacura, Piotr Kulesza, Marcin Knap, Maciej Kortas i Kacper Durol. Prace nad strona rozpoczela sie w lutym i trwala az do sierpnia. Cala strona opiera sie na jezykach programowania takich jak: java, php, css. Strona powstala przy uzyciu środków takich jak: MySql Workbench 6.3 CE, eclipse, paint, docker, github.  </h1>
	
		<div class="login-button" >
		<form action="Logout">
			<input class="center-block2" type="image" src="images/wylog.png" alt="Wyloguj" title="Wyloguj">
		</form>
		</div>
	</div>
	
	

</body>
</html>