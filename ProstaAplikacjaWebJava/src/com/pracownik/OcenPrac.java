package com.pracownik;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/OcenPrac")
public class OcenPrac extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("ISO-8859-2");
		String username=request.getParameter("username");
		String nrlab=request.getParameter("nrlab");
		String ocena=request.getParameter("Ocena");
		String dane=request.getParameter("dane");
		
		
		
		Pracownik prac = new Pracownik();
		prac.zapOcene(username, nrlab, ocena,dane);
		response.sendRedirect("sprawozdania_p.jsp");
	}

}
