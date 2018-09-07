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
			<a href="${str }"><img src="images/baner_2.png" alt="Error" width="300px" height="65px"/></a>
			</div>
		</nav>
		
		
		
		<main class="podstrona">
			<div class="menu_grupy">
				
				<div class ="tabela">
			</br></br></br></br></br></br><table align="center" border=2>
				 <tr>
				 	<th>Nr. spr.</th>
				 	<th>Sprawozdanie</th>
				 	<th>Pobierz Spr</th>
				 	<th>Komentarz</th>
				 	<th>Dodaj Komentarz</th>
				 	<th>Ocena</th>
				 	<th>Oceń</th>
				 	<th>Stan</th>
				 	<th>Do poprawy</th>
				  </tr>
				  <%
				  	int i=1;
				  	if(session.getAttribute("username")!=null && session.getAttribute("dane")!=null && session.getAttribute("id_ucznia")!=null){
				 	String x = session.getAttribute("username").toString();
				 	String y = session.getAttribute("dane").toString();
				 	String z = session.getAttribute("id_ucznia").toString();
				 	Pracownik prac = new Pracownik();
					ResultSet sprWBazie = prac.sprPrac(z,y);
						while(sprWBazie.next()){
							String instrukcja=sprWBazie.getString("adres_lab_1");
							if(instrukcja!=null){
								String ocena=sprWBazie.getString("ocena");
								String adres=sprWBazie.getString("adres");
				  %>
				  <tr>
				  	<td><% out.print(i); %></td>
				  	<td><% if(adres!=null)out.print(adres);
				  	else out.print("nie_dodane");%></td>
				  	<td>
				 	<form action="PobierzSprPrac">
				 		<input type="hidden" name="username" value="<%out.print(z);%>">
				 		<input type="hidden" name="nrlab" value="<%out.print(i);%>">
				 		<input type="hidden" name="dane" value="<%out.print(y);%>">
				 		<% if(adres!=null)out.print("<input type=\"image\" src=\"images/download.png\" alt=\"Pobierz\">"); 
				 		else out.print("nie_dodane");%>
				 		</form>
				 	</td> 
				 	<td><%if(adres!=null)out.print(sprWBazie.getString("komentarz"));else out.print("nie_dodane");%></td>
				 	<td>
				 	<form action="KomentujPrac" method="post">
				 		<input type="hidden" name="username" value="<%out.print(z);%>">
				 		<input type="hidden" name="nrlab" value="<%out.print(i);%>">
				 		<input type="hidden" name="dane" value="<%out.print(y);%>">
				 		<% if(adres!=null)out.print(
				 		"<input type=\"text\" name=\"komentarz\" value=\"null\">"+
				 		"<input type=\"submit\" value=\"Komentuj\">");
				 		else out.print("nie_dodane");%>
				 		</form>
				 	</td>
				 	<td><%if(adres!=null){if(ocena!=null)out.print(ocena);else out.print("brak");}else out.print("nie_dodane");%></td>
				 	<td><%out.print(sprWBazie.getString("stan"));%></td>
				 	<td><%if(adres!=null){%>
				 		<form action="OcenPrac" method="post">
				 			<input type="hidden" name="username" value="<%out.print(z);%>">
				 			<input type="hidden" name="nrlab" value="<%out.print(i);%>">
				 			<input type="hidden" name="dane" value="<%out.print(y);%>">
							<select name="Ocena">
							  <option value="null">null</option>
							  <option value="2">2</option>
							  <option value="2,5">2,5</option>
							  <option value="3">3</option>
							  <option value="3,5">3,5</option>
							  <option value="4">4</option>
							  <option value="4,5">4,5</option>
							  <option value="5">5</option>
							</select>
							<input type="submit" value="Oceń">
						</form>
						<%}else out.print("nie_dodane");%>
				 	</td>
				 	<td>
				 		<%if(adres!=null){%>
				 		<form action="StanPrac" method="post">
				 		<input type="hidden" name="username" value="<%out.print(z);%>">
				 		<input type="hidden" name="nrlab" value="<%out.print(i);%>">				 			
				 		<input type="hidden" name="dane" value="<%out.print(y);%>">
				 		<select name="Stan">
							  <option value="Nie_sprawdzone">Nie_sprawdzone</option>
							  <option value="Do_poprawy">Do_poprawy</option>
							  <option value="Zaliczone">Zaliczone</option>
							</select>
				 		<input type="submit" value="Zmień stan laboratorów">
				 		</form>
				 		<%}else out.print("nie_dodane");%>
				 	</td>
				  </tr>
				  	<%
							}
							i++;
						}
				  	}if(session.getAttribute("id_ucznia")==null && session.getAttribute("dane")!=null && session.getAttribute("username")!=null){
						response.sendRedirect("student_p.jsp");
					} else if(session.getAttribute("id_ucznia")==null && session.getAttribute("dane")!=null && session.getAttribute("username")!=null){
						response.sendRedirect("przedmioty_p.jsp");
					}
				  %>
					
				 </table>
				 </div>
				
				
				
				
        	</div>
		</main>
			</div>
		<div class="login-button" >
			<form action="Logout">
				<input class="center-block2" type="image" src="images/wylog.png" alt="Wyloguj">
			</form>
		</div>
		
	
	

</body>
</html>