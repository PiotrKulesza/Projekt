package com.pracownik;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/Szukaj3")
public class Szukaj3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("ISO-8859-2");
		String dane = new String(request.getParameter("dane")); 
		HttpSession session = request.getSession();
		session.setAttribute("dane", dane);
		response.sendRedirect("student_p.jsp");
	}

}

