package com.pracownik;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Szukaj4
 */
@WebServlet("/Szukaj4")
public class Szukaj4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("ISO-8859-2");
		String id_ucznia = new String(request.getParameter("id_ucznia")); 
		HttpSession session = request.getSession();
		session.setAttribute("id_ucznia", id_ucznia);
		response.sendRedirect("sprawozdania_p.jsp");
	}

}
