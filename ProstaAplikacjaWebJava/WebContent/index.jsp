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
		
		String str;
				
		if(session.getAttribute("username")!=null){
			str="index2.jsp";
			
		}else str="index.jsp";
	
		%>
		<div class="wraper">
			<nav class="menu">
				<div class="menu-center">
					<a href="${str}"><img src="images/ikona home.png" alt="Error"></a>
					<a href="http://www.utp.edu.pl/pl/"><img src="images/ikona utp.png" alt="Error" title="Strona UTP"></a>
					<a href="informacje.jsp"><img src="images/ikona help.png" alt="Error" title="Informacje"></a>
					<a href="https://usosweb.utp.edu.pl/kontroler.php?_action=actionx:news/default()"><img src="images/ikona usos.png" alt="Error" title="Usosweb"></a>
				</div>
				
				
			</nav>
			<div class="content">
				<main>
					<h1 class="main-title">Repozytorium<div>sprawozdań</div></h1>
					<div id="Loguj">
					<form action="Login" method="post">
						<label class="firstlabel">Login<input type="text" name="uname" size="40"></label>
						<label class="firstlabel">Password<input type="password" name="pass" size="30"></label>
						<input id="Zal_Btn" type="submit" value="Zaloguj">
					</form>
				</div>
				</main>
				<div class="login-button" >
				<p1>logowanie</p1>
					<input id="przycisk" class=login-button type="image" src="images/logk.png" alt="Pokaz"title="Wyloguj" >
				</div>
				</div>
			</div>
		
		
		
		
		
	<script type="text/javascript">
	document.getElementById("przycisk").addEventListener("click", schowaj);
	
	function schowaj(){
		if(document.getElementById("Loguj").style.display=="block")
			document.getElementById("Loguj").style.display = "none";	
		else{
			document.getElementById("Loguj").style.display = "block";
		}
	}
	</script>	
</body>
</html>