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
			<a href="${str }"><img src="images/ramka przedmiot.png" alt="Error" width="300px" height="65px"/></a>
			</div>
		</nav>
		
		
		
		<main class="podstrona">
		
			
			<div class ="tabela">
			</br></br></br></br></br></br><table align="center" border=2>
				 <tr>
				 	<th>Nr. spr.</th>
				 	<th>Instrukcja</th>
				 	<th>Stan</th>
				 	<th>Sprawozdanie</th>
				 	<th>Pobierz Spr</th>
				 	<th>Komentarz</th>
				 	<th>Ocena</th>
				 	<th>Prześlij</th>
				  </tr>
				  <%
				  	int i=1;
				  	if(session.getAttribute("username")!=null && session.getAttribute("przedmiot")!=null){
				 	String x = session.getAttribute("username").toString();
				 	String y = session.getAttribute("przedmiot").toString();
				 	Uczen un = new Uczen();
					ResultSet laborkaWBazie = un.laborkiUcznia(x,y);
						while(laborkaWBazie.next()){
							String instrukcja=laborkaWBazie.getString("adres_lab_1");
							if(instrukcja!=null){
								String ocena=laborkaWBazie.getString("ocena");
				  %>
				  <tr>
				 	<td><% out.print(i); %></td>
				 	<td>
				 		<form action="PobierzLabUcz">
				 		<input type="hidden" name="przedmiot" value="<%out.print(session.getAttribute("przedmiot").toString());%>">
				 		<input type="hidden" name="username" value="<%out.print(session.getAttribute("username").toString());%>">
				 		<input type="hidden" name="nrlab" value="<%out.print(i);%>">
				 		<input type="image" src="images/download.png" alt="Pobierz">
				 		</form>
				 	</td>
				 	<td><%out.print(laborkaWBazie.getString("stan"));%></td>
				 	<td><%
				 	String z =laborkaWBazie.getString("adres");
				 	out.print(z);
				 	%></td>
				 	<td>
				 	<form action="PobierzSprUcz">
				 		<input type="hidden" name="przedmiot" value="<%out.print(y);%>">
				 		<input type="hidden" name="username" value="<%out.print(x);%>">
				 		<input type="hidden" name="nrlab" value="<%out.print(i);%>">
				 		<% if(z!=null)out.print("<input type=\"image\" src=\"images/download.png\" alt=\"Pobierz\">"); 
				 		else out.print("null");%>
				 		</form>
				 	</td> 
				 	<td><%out.print(laborkaWBazie.getString("komentarz"));%></td>
				 	<td><%if(ocena!=null)out.print(ocena);else out.print("brak");%></td>
				 	<td>
				 		<form action="PrzeslijSprUcz"  method="post" enctype="multipart/form-data">
				 		<input type="hidden" name="nrlab" value="<%out.print(i);%>">
				 		<input type="hidden" name="przedmiot" value="<%out.print(y);%>">
				 		<input type="hidden" name="username" value="<%out.print(x);%>">
				 		<input type="file" name="file_name"><input type="submit" value="Prześlij">
				 		</form>
				 	</td>
				  </tr>
				  <%
							}
							i++;
						}
				  	}if(session.getAttribute("przedmiot")==null && session.getAttribute("username")!=null){
						response.sendRedirect("przedmioty_u.jsp");
					}
				  %>
				  
				 
			
			</table>
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