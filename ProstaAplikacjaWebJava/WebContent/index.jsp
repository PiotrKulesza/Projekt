<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
    pageEncoding="ISO-8859-2"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-2">
<meta name="viewport" content="width-device-width, initial-scale=1">
<script type="text/javascript" src="script.js"></script>
<title>Projekt</title>
<link rel="Stylesheet" type="text/css" href="style.css" />
</head>
<body>
	<script>
		
	</script>
		<%
		
		String str;
				
		if(session.getAttribute("username")==null){
			str="index.jsp";
		}else str="index2.jsp";
	
		%>
		<div class="wraper">
			<nav class="menu">
				<div class="menu-center">
					<a href="${str}"><img src="images/ikona home.png" alt="Error" width="80px" height="80px"/></a>
					<a href="http://www.utp.edu.pl/pl/"><img src="images/ikona utp.png" alt="Error" width="80px" height="80px"/></a>
					<a href="${str}"><img src="images/ikona help.png" alt="Error" width="80px" height="80px"/></a>
					<a href="${str}"><img src="images/ikona usos.png" alt="Error" width="80px" height="80px"/></a>
				</div>
			</nav>
			<div class="content">
				<main>
					<h1 class="main-title">Repozytorium<div>sprawozdań</div></h1>
				</main>
				<div class="Logowanie">
				<form action="Login" method="post">
				<label id="firstlabel">Login:</label> <input type="text" name="uname" size="15"><br>
				<label id="firstlabel">Password:</label> <input type="password" name="pass" size="15"><br>
				<input id="Zal_Btn" type="submit" value="Zaloguj">
				</form>
				</div>
				<div class="login-button" >
				<h2>logowanie</h2>
					<img src="images/logk.png" alt="Submit">
				</div>
				</div>
			</div>
		</div>
		
		
		
		
		
		
</body>
</html>