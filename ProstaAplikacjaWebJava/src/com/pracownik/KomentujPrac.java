package com.pracownik;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/KomentujPrac")
public class KomentujPrac extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("ISO-8859-2");
		String username=request.getParameter("username");
		String nrlab=request.getParameter("nrlab");
		String komentarz=request.getParameter("komentarz");
		String dane=request.getParameter("dane");
		
		
		Pracownik prac = new Pracownik();
		prac.zapKom(username, nrlab, komentarz,dane);
		response.sendRedirect("sprawozdania_p.jsp");
	}


}
