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
		
	
		
		if(session.getAttribute("username")==null){
			response.sendRedirect("index.jsp");
		}
		
	%>
	
	<div class="wraper tlo2">
			<nav class="menu">
				<div class="menu-center">
				<a href="index2.jsp"><img src="images/ikona home.png" alt="Error" title="Katalog domowy pracownika"></a>
				<a href="przedmioty_p.jsp"><img src="images/ikona sprawozdania.png" alt="Pokaz"title="Sprawdz sprawozdanie ucznia"></a>
				<a href="przedmioty_p2.jsp"><img src="images/wyslij.png" alt="Error"title="Wyślij instrukcje"></a>
				<a href="nauczajlab_p.jsp"><img src="images/podejmij.png" title="Ucz laboratoriów"></a>
				<a href="http://www.utp.edu.pl/pl/"><img src="images/ikona utp.png" alt="Error"title="Strona UTP"></a>
				</div>

				
			<div class="subjects">
			<a href="${str }"><img src="images/baner_3.png" alt="Error" width="300px" height="65px"/></a>
			</div>
		</nav>
		
		
		
		<main class="podstrona">
		<div class="menu_grupy">
		
		<div class ="tabela">
			</br></br></br></br></br></br><table align="center" border=2>
				 <tr>
				 	<th>Nr. spr.</th>
				 	<th>Instrukcja</th>
				 	<th>Pobierz</th>
				 	<th>Prześlij</th>
				  </tr>
			<%
					
				  	int i;
					if(session.getAttribute("username")!=null && session.getAttribute("dane")!=null){
				 	String username = session.getAttribute("username").toString();
				 	String dane = session.getAttribute("dane").toString();
				 	
				 	
				 	
				 	Pracownik prac = new Pracownik();
					ResultSet labWBazie = prac.labPrac(username,dane);
						while(labWBazie.next()){
			
							for(i=1;i<=15;i++){
								String lab="adres_lab_"+i;
								String filename=labWBazie.getString(lab);
				  %>
				  <tr>
				  		<th><% out.print(i); %></th>
				 		<th><% out.print(filename); %></th>
				 		<th><form action="PobierzLabPrac">
				 		<input type="hidden" name="dane" value="<%out.print(dane);%>">
				 		<input type="hidden" name="username" value="<%out.print(username);%>">
				 		<input type="hidden" name="nrlab" value="<%out.print(i);%>">
				 		<% if(filename!=null)out.print("<input type=\"image\" src=\"images/download.png\" alt=\"Pobierz\">"); 
				 		else out.print("null");%>
				 		</form>
				 		</th>
				 		<th>
				 		<form action="PrzeslijLabPrac"  method="post" enctype="multipart/form-data">
				 		<input type="hidden" name="nrlab" value="<%out.print(i);%>">
				 		<input type="hidden" name="username" value="<%out.print(session.getAttribute("username").toString());%>">
				 		<input type="hidden" name="dane" value="<%out.print(session.getAttribute("dane").toString());%>">
				 		<input type="file" name="file_name"><input type="submit" value="Prześlij">
				 		</form>
				 		</th>	
				  </tr>
				 <%	
							}
							
						}
					}else if(session.getAttribute("dane")==null && session.getAttribute("username")!=null){
						response.sendRedirect("przedmioty_p.jsp");
					}
				  %>
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