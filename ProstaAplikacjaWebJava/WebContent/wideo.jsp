<%@ page language="java" contentType="text/html; charset=ISO-8859-2"
    pageEncoding="ISO-8859-2"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; ISO-8859-2">
<title>Insert title here</title>
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

	<iframe width="560" height="315" src="https://www.youtube.com/embed/NBu9qEcrl0M" frameborder="0"></iframe><br>
	
	<form action="Logout">
			<input type="submit" value="Wyloguj">
	</form>
	
</body>
</html>