package com.uczen;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Szukaj")
public class Szukaj extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("ISO-8859-2");
		
		
		String przedmiot = request.getParameter("przedmiot_z_sprawozdaniami");
		
		HttpSession session = request.getSession();
		
		session.setAttribute("przedmiot", przedmiot);
		response.sendRedirect("sprawozdania_u.jsp");
	}

}
