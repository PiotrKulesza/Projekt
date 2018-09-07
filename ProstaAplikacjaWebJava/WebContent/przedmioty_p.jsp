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
	
	<div class="wraper tlo2">
			<nav class="menu">
				<div class="menu-center">
					<a href="index2.jsp"><img src="images/ikona home.png" alt="Error"></a>
					<a href="przedmioty_p.jsp"><img src="images/ikona sprawozdania.png" alt="Pokaz"></a>
					<a href="przedmioty_p2.jsp"><img src="images/wyslij.png" alt="Error"></a>
					<a href="nauczajlab_p.jsp"><img src="" alt="nauczaj lab"></a>
					<a href="http://www.utp.edu.pl/pl/"><img src="images/ikona utp.png" alt="Error"></a>
					<a href="${str }"><img src="images/ikona help.png" alt="Error"></a>
				</div>

				
			<div class="subjects">
			<a href="${str }"><img src="images/ramka przedmiot.png" alt="Error" width="300px" height="65px"/></a>
			</div>
		</nav>
		
		
		
		<main class="podstrona">
		<div class="menu_grupy">
				
				<h2> Przedmiot </h2>
				</div>		
			<div class="menu_przedmitow">
			<div class ="tabelau2">
			</br></br></br></br></br></br><table align="center" border=2>
			<form action="Szukaj3" method="post">
				 <tr>
				 	<th colspan="3">Kierunek/Przedmiot/Grupa/Rocznik</th>
				  </tr>
				<%
				if(session.getAttribute("username")!=null){
					String x = session.getAttribute("username").toString();
					Pracownik przed = new Pracownik();
					ResultSet przedmiotyWBazie = przed.przedmiotyPrac(x);
					int i = 0;
					while(przedmiotyWBazie.next()){
						String dane = przedmiotyWBazie.getString("kierunek.nazwa")+"/"+
									  przedmiotyWBazie.getString("przedmiot.nazwa")+"/"+
									  przedmiotyWBazie.getString("laborki.grupa")+"/"+
									  przedmiotyWBazie.getString("laborki.rocznik")+"/";
						if(i%3==0){
				%>
					<tr>
						<th><input type="radio" name="dane" value="<%out.print(dane); %>"> <%out.print(dane); %></th>
				<%
						}else if(i%3==1){
				%>
						<th><input type="radio" name="dane" value="<%out.print(dane); %>"> <%out.print(dane); %></th>
				<%
						}else{
				
				%>
						<th><input type="radio" name="dane" value="<%out.print(dane); %>"> <%out.print(dane); %></th>
					</tr>
				<%
				
						}
					i++;
					}
				}
				%>
				<tr><th colspan="3"><input id="Szuk_Btn_1" type="submit" value="Szukaj"></th></tr>
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