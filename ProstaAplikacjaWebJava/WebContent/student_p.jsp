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
			<a href="${str }"><img src="images/baner_4.png" alt="Error" width="300px" height="65px"/></a>
			</div>
		</nav>
		
		
		
		<main class="podstrona">	
			<div class="menu_przedmitow">
			<div class ="tabelau4">
			</br></br></br></br></br></br><table align="center" border=2>
			<form action="Szukaj4" method="post">
				 <tr>
				 	<th colspan="3">Nr indeksu/Imię/Nazwisko</th>
				  </tr>
				<%
				if(session.getAttribute("username")!=null && session.getAttribute("dane")!=null){
				String x = session.getAttribute("username").toString();
				String y = session.getAttribute("dane").toString();
				Pracownik przed = new Pracownik();
				ResultSet uczniowieWBazie = przed.uczniowiePrac(x,y);
				int i = 0;
				while(uczniowieWBazie.next()){
					String id_ucznia = uczniowieWBazie.getString("student.id_studenta");
					if(i%3==0){
					
				%>
					<tr>
						<th><input type="radio" name="id_ucznia" value="<%out.print(id_ucznia); %>"> <%out.print(uczniowieWBazie.getString("student.nr_indeksu")+"/"+
					uczniowieWBazie.getString("student.imie")+"/"+uczniowieWBazie.getString("student.nazwisko")); %></th>
				
				<%
					}else if(i%3==1){
				%>
				<th><input type="radio" name="id_ucznia" value="<%out.print(id_ucznia); %>"> <%out.print(uczniowieWBazie.getString("student.nr_indeksu")+"/"+
					uczniowieWBazie.getString("student.imie")+"/"+uczniowieWBazie.getString("student.nazwisko")); %></th>
				
				<%
					}else{
				%>
						<th><input type="radio" name="id_ucznia" value="<%out.print(id_ucznia); %>"> <%out.print(uczniowieWBazie.getString("student.nr_indeksu")+"/"+
					uczniowieWBazie.getString("student.imie")+"/"+uczniowieWBazie.getString("student.nazwisko")); %></th>
					</tr>
				<%
					
					
					}
				i++;
				}
				}else if(session.getAttribute("dane")==null && session.getAttribute("username")!=null){
					response.sendRedirect("przedmioty_p.jsp");
				}
				%>
					<tr>
						<th colspan="3"><input id="Szuk_Btn_1" type="submit" value="Szukaj"></th>
					</tr>
				</form>
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
		
	
	</div>

</body>
</html>