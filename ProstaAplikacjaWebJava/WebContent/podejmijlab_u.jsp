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
				<a href="uczen.jsp"><img src="images/ikona home.png" alt=""></a>
				<a href="przedmioty_u.jsp"><img src="images/ikona przedmioty.png" alt=""></a>
				<a href="http://www.utp.edu.pl/pl/"><img src="images/ikona utp.png" alt=""></a>
				<a href="${str }"><img src="images/ikona help.png" alt=""></a>
				
			</div>
			<div class="subjects">
			<a href="${str }"><img src="" alt="laboratoria" width="300px" height="65px"/></a>
			</div>
		</nav>
		
		
		
		<main class="podstrona">
		
		
		
			<div class="menu_przedmitow">
				<div class ="tabelau1">
			</br></br></br></br></br></br><table align="center" border=2>
			<form action="PodejmijLab" method="post">
				 <tr>
				 	<th>nauczaj na laboratiorach:</th>
				  </tr>
				  <% 
				  if(session.getAttribute("username")!=null){
						String x = session.getAttribute("username").toString();
						Uczen przed = new Uczen();
						ResultSet daneLab = przed.daneDoLabUcz(x);
						int i = 0;
						while(daneLab.next()){
							String dane = daneLab.getString("przedmiot.nazwa");
							String dane2=daneLab.getString("laborki.id")+"/"
										+daneLab.getString("laborki.id_pracownika")+"/"
										+daneLab.getString("laborki.id_przedmiotu")+"/";
							if(i%3==0){
				%>
					<tr>
						<th><input type="radio" name="dane" value="<%out.print(dane2); %>"> <%out.print(dane); %></th>
				<%
							}else if(i%3==1){
				%>
						<th><input type="radio" name="dane" value="<%out.print(dane2); %>"> <%out.print(dane); %></th>		
				<%
							}else{
				%>
						<th><input type="radio" name="dane" value="<%out.print(dane2); %>"> <%out.print(dane); %></th>
					</tr>
					
				
				<%
							}
						i++;
					}
				
				%>
				<tr><th>
				<input type="hidden" name="username" value="<%out.print(session.getAttribute("username").toString());%>">
				<input id="Szuk_Btn_1" type="submit" value="Rozpocznij Lab">
				</th></tr>
				</form>
				<%} %>
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